package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.OrderDao;
import cn.xinmeng.api.dao.ex.ExAccountDao;
import cn.xinmeng.api.dao.ex.ExOrderDao;
import cn.xinmeng.api.entity.auto.Coupon;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerAmountDetail;
import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.OrderProduct;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.biz.OrderTotalBiz;
import cn.xinmeng.api.entity.auto.biz.ProductBasicInfo;
import cn.xinmeng.api.entity.auto.example.OrderExample;
import cn.xinmeng.api.entity.auto.example.OrderProductExample;
import cn.xinmeng.api.enums.AccountTypeEnum;
import cn.xinmeng.api.enums.ConsumTypeEnum;
import cn.xinmeng.api.enums.CouponStateEnum;
import cn.xinmeng.api.enums.ExpendIncomeEnum;
import cn.xinmeng.api.enums.OrderProductStateEnum;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.enums.OrderTypeEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.enums.QuantityChangeTypeEnum;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerAmountDetailService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IOrderProductProfitService;
import cn.xinmeng.api.service.IOrderProductService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IOrderStateService;
import cn.xinmeng.api.service.IProductImageService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IProductStockManager;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.thread.AccountAmountDetailThread;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.interfaces.IOCallable;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;


@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	@Resource
	private OrderDao orderDao;
	@Resource
	private ExOrderDao exOrderDao;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IProductPriceService productPriceService;
	@Resource
	private IOrderProductService orderProductService;
	@Resource
	private IOrderStateService orderStateService;
	@Resource
	private IProductStockManager productStockManager;
	@Resource
	private IOrderProductProfitService orderProductProfitService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private ExAccountDao exAccountDao;
	@Resource
	private TaskExecutor amountDetailThreadPool;
	@Resource
	private ICustomerAmountDetailService customerAmountDetailService;
	@Resource
	private ICouponService couponService;
	@Resource
	private IProductImageService productImageService;
	@Resource
	private IRedisService redisService;
	
	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	public int add(Order record){
		if(record != null){
			Double payAmount = UtilMoney.getNoPayment(record.getTotalAmount(), record.getPostage(), 
													  record.getDiscountAmount(), record.getCouponPayment(), 0.00);
			record.setPayAmount(payAmount);//实际成交金额
		}
		return orderDao.insert(record);
	}

	/**
	 * 按主键删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id){
		return orderDao.deleteByPrimaryKey(id);
	}

	/**
	 * 按主键修改（全新替换每一个字段数据）
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(Order record){
		return orderDao.updateByPrimaryKey(record);
	}

	/**
	 * 按主键查询
	 * @param id
	 * @return
	 */
	public Order selectByPrimaryKey(Integer id){
		return orderDao.selectByPrimaryKey(id);
	}

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(OrderExample example){
		return orderDao.countByExample(example);
	}

	/**
	 * 按条件查询
	 * @param example
	 * @return
	 */
	public List<Order> selectByExample(OrderExample example){
		return orderDao.selectByExample(example);
	}

	/**
	 * 按条件查询（分页）
	 * @param pageNo
	 * @param pageSize
	 * @param example
	 * @return
	 */
	public List<Order> selectByExample(int currentPage, int limit,OrderExample example){
		return orderDao.selectByExample(new RowBounds(currentPage, limit),example);
	}

	/**
	 *  修改订单支付金额
	 * @author jiangyong.tan
	 * @date 2016年2月26日 上午10:12:38
	 * @param orderId
	 * @param accountPayment
	 * @param payState
	 */
	public void updateOrderAccountPaymentAndPayState(String orderId,Double accountPayment,PaymentStateEnum payState,Integer onlinePayType){
		if(Utils.isEmpty(accountPayment)){
			accountPayment = 0.00;
		}
		Integer payStateInt = Integer.valueOf(payState.key());

		//子订单
		exOrderDao.updateOrderAccountPayment(orderId, accountPayment, payStateInt,onlinePayType);

		orderStateService.addOrderPayStateHis(orderId, payStateInt);
		//查询子订单
	}

    /**
     *  查询订单
     * @author jiangyong.tan
     * @date 2016年3月1日 下午4:30:14
     * @param childOrderId
     * @param fieldList
     * @return
     */
    public Order queryByOrderId(String orderId,String fieldList){
    	if(Utils.isEmpty(orderId)){
			return null;
		}
		OrderExample orderExample = new OrderExample();
		if(!Utils.isEmpty(fieldList)){
			orderExample.setFieldList(fieldList);
		}
		orderExample.setOrderByClause("id desc");
		OrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andOrderIdEqualTo(orderId);
		List<Order> listOrder = orderDao.selectByExample(orderExample);
		if(!Utils.isEmpty(listOrder)){
			return listOrder.get(0);
		}
		return null;
	}

	/**
	 *  查询商品名称图片：键：商品名称，值：商品图片列表
	 * @author jiangyong.tan
	 * @date 2016年2月29日 下午3:11:15
	 * @param parentOrderId
	 * @return
	 */
	public Map<String,List<String>> queryProductImage(String orderId){
		OrderProductExample orderProductExample = new OrderProductExample();
		orderProductExample.setFieldList(" product_price_id, product_id ");
		OrderProductExample.Criteria orderProductCriteria = orderProductExample.createCriteria();
		orderProductCriteria.andOrderIdEqualTo(orderId);

		List<OrderProduct> listOrderProduct = orderProductService.selectByExample(orderProductExample);
		if(listOrderProduct == null || listOrderProduct.size() == 0){
			return null;
		}

		Map<Integer,List<Integer>> productIdMap = new HashMap<Integer, List<Integer>>();//键：商品id，值，商品价格集合
		for (OrderProduct orderProduct : listOrderProduct) {
			Integer productId = orderProduct.getProductId();
			Integer priceId = orderProduct.getProductPriceId();
			if(productIdMap.containsKey(productId)){
				List<Integer> list = productIdMap.get(productId);
				list.add(priceId);
				productIdMap.put(productId, list);
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(priceId);
				productIdMap.put(productId, list);
			}
		}
		Map<String,List<String>> result = new HashMap<String, List<String>>();
		Iterator<Integer> itr = productIdMap.keySet().iterator();
		while(itr.hasNext()){
			Integer productId = itr.next();
			List<Integer> listPriceId = productIdMap.get(productId);
			ProductInfo productInfo = productInfoService.queryProductInfoByProductId(productId,"product_name");
			if(productInfo == null){
				continue;
			}
			String productName = productInfo.getProductName();
			result.put(productName, productImageService.queryProductImage(listPriceId));
		}
		return result;
	}


	/**
	 * 根据订单编号，修改订单状态
	 * @param orderId
	 * @param orderState
	 * @return
	 */
	public boolean updateOrderStateByOrderId(String orderId,Integer orderState,String remark){
		if(Utils.isEmpty(orderId)){
			return false;
		}
		if(orderState == null || OrderStateEnum.exist(String.valueOf(orderState)) ==  false){
			return false;
		}
		//修改订单状态

		Order order = new Order();
		order.setOrderState(orderState);
		order.setUpdateTime(new Date());
		if(!Utils.isEmpty(remark)){
			order.setRemark(remark);
		}

		OrderExample orderExample = new OrderExample();
		OrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andOrderIdEqualTo(orderId);

		int rows = orderDao.updateByExampleSelective(order, orderExample);
		//添加订单状态变更记录
		orderStateService.addOrderStateHis(orderId, orderState);
		if(rows > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据订单编号，修改订单支付状态
	 * @param orderId
	 * @param orderState
	 * @return
	 */
	public boolean updatePayStateByOrderId(String orderId,Integer payState,Double onlinePayment){
		if(Utils.isEmpty(orderId)){
			return false;
		}
		if(payState == null || !PaymentStateEnum.exist(String.valueOf(payState))){
			return false;
		}
		//修改订单金额与状态
		Order order = new Order();
		order.setPayState(payState);
		order.setUpdateTime(new Date());
		order.setOnlinePayment(onlinePayment);

		OrderExample orderExample = new OrderExample();
		OrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andOrderIdEqualTo(orderId);
		orderDao.updateByExampleSelective(order, orderExample);
		//添加订单支付状态变更记录
		orderStateService.addOrderPayStateHis(orderId, payState);
		return true;
	}
	
	/**
	 * 确认收货
	 * @param orderId
	 * @param orderState
	 * @return
	 */
	public boolean confirmReceipt(String orderId,Integer orderState,Double onlinePayment){
		if(Utils.isEmpty(orderId)){
			return false;
		}
		if(orderState == null || OrderStateEnum.exist(String.valueOf(orderState)) ==  false){
			return false;
		}
		//修改订单状态

		Order order = new Order();
		order.setOrderState(orderState);
		order.setUpdateTime(new Date());
		if(!Utils.isEmpty(onlinePayment)){
			order.setOnlinePayment(onlinePayment);
		}

		OrderExample orderExample = new OrderExample();
		OrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andOrderIdEqualTo(orderId);

		int rows = orderDao.updateByExampleSelective(order, orderExample);
		//添加订单状态变更记录
		orderStateService.addOrderStateHis(orderId, orderState);
		
		//修改订单商品状态
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setProductState(Integer.valueOf(OrderProductStateEnum.RECEIVED_GOODS.key()));
		
		OrderProductExample example = new OrderProductExample();
		OrderProductExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		orderProductService.updateByExampleSelective(orderProduct, example);
		
		//修改订单商品状态
		orderProductProfitService.updateOrderProfitState(orderId);
		if(rows > 0){
			return true;
		}
		return false;
	}
	

	/**
	 * 取消订单
	 * @param orderId
	 * @return
	 */
	public boolean cancelOrderByOrderId(String orderId,OrderStateEnum orderStateEnum,String cancelRemark){
		if(Utils.isEmpty(orderId)){
			return false;
		}
		boolean flag = false;
		String fieldList = "order_id,coupon_code,account_payment,customer_id,order_state,pay_state,order_type,activity_id";
		
		Order order = queryByOrderId(orderId, fieldList);
		if(order == null){
			return false;
		}
		
		Date currDate = new Date();
		String optUser = "API";
		
		if(OrderStateEnum.STATE_CANCEL.key().equals(order.getOrderState()+"")){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ORDER_YES_CANCEL);
		}
		if(!(PaymentStateEnum.STATE_PAY_NOT.key().equals(order.getPayState()+"") 
				|| PaymentStateEnum.STATE_PAYING.key().equals(order.getPayState()+""))){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_NOT_ORDER_CANCEL);
		}
		//有优惠券还原优惠券
		if(!Utils.isEmpty(order.getCouponCode())){
			Coupon coupon = couponService.queryCouponByCouponCode(order.getCouponCode());
			coupon.setState(Integer.valueOf(CouponStateEnum.USED_POINT.key()));
			couponService.updateByPrimaryKey(coupon);
		}
		
		Integer customerId = order.getCustomerId();
		fieldList = "id,nickname,cash_amount";
		Customer customer = customerService.queryCustomerById(customerId, fieldList);
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		flag = updateOrderStateByOrderId(order.getOrderId(),Integer.valueOf(orderStateEnum.key()),cancelRemark);
		
		if(UtilMoney.compareTo(order.getAccountPayment(), 0.00) > 0){
			//用户资金流水
			List<CustomerAmountDetail> list = new ArrayList<CustomerAmountDetail>();
			
			//客户（支出）：客户流水记录
			CustomerAmountDetail cust = new CustomerAmountDetail();
			cust.setAccountType(Integer.valueOf(AccountTypeEnum.USER.key()));//用户
			cust.setAmount(order.getAccountPayment());
			cust.setConsumType(Integer.valueOf(ConsumTypeEnum.TYPE_56.key()));
			cust.setCreateTime(currDate);
			cust.setCreateUser(optUser);
			cust.setCustomerId(customerId);
			cust.setCustomerName(customer.getNickname());
			cust.setNowMoney(UtilMoney.addToDouble(customer.getCashAmount(), order.getAccountPayment()));
			cust.setOldMoney(customer.getCashAmount());
			cust.setOrderId(order.getOrderId());
			cust.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_INCOME.key()));//支出
			String remark = (order.getOrderId() != null) ? "-订单编号："+order.getOrderId():"";
			cust.setRemark(ConsumTypeEnum.TYPE_52.value()+remark);
			list.add(cust);

			//客户现金账户充值
			int rows = exAccountDao.custAccountAdd(customerId, order.getAccountPayment());
			if(rows == 0){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_CASH);
			}
			orderStateService.addOrderStateHis(order.getOrderId(), Integer.valueOf(orderStateEnum.key()));
			//线程添加
			amountDetailThreadPool.execute(new AccountAmountDetailThread(customerAmountDetailService, list));
		}

		
		if(flag){
			if(order.getOrderType() > 2){
				OrderProduct orderProduct = orderProductService.getOrderProduct(order.getOrderId(), "product_price_id,product_id,product_number");
				if(Utils.isEmpty(orderProduct)){
					throw new BusinessException(LogManager.getLogger(this.getClass()), ExOrderEnum.EX_NOT_EXIST_ORDER_PRODUCT);
				}
				Integer activityId = order.getActivityId();
				Integer activityType = OrderTypeEnum.orderTypeToActivityType(order.getOrderType());
				Integer productNumber = orderProduct.getProductNumber();
				Integer priceId = orderProduct.getProductPriceId();
				Integer productId = orderProduct.getProductId();
				redisService.delActivityPurchase(activityId, activityType, customerId,productId,priceId, productNumber);
				//活动订单，不需要还原库存，只需修改销售数量
				redisService.updateActvityProductSoldNumber(activityId,activityType, productId,priceId, -productNumber);
				return true;
			}else{
				//还原库存 
				List<OrderProduct> orderproductList = orderProductService.queryOrderProductByOrderId(order.getOrderId());
				List<ProductBasicInfo>  productBasicInfos = Utils.converList(orderproductList,
						new IOCallable<OrderProduct, ProductBasicInfo>() {
					@Override
					public ProductBasicInfo exec(OrderProduct orderProduct) {
						ProductBasicInfo prod = new ProductBasicInfo();
						prod.setOperateType(1); // 加库存
						prod.setPriceId(orderProduct.getProductPriceId());
						prod.setProductId(orderProduct.getProductId());
						prod.setActualProductNumber(orderProduct.getProductNumber());
						prod.setCanSoldProductNumber(orderProduct.getProductNumber());
						prod.setSku(orderProduct.getSku());
						prod.setOrderId(orderProduct.getOrderId());
						prod.setRemark("取消订单 加库存，数量："+orderProduct.getProductNumber());
						prod.setChangeType(Integer.valueOf(QuantityChangeTypeEnum.ADD.key())); //用户下单减库存
						return prod;
					}
				});
	
				productStockManager.addAndSubStock(productBasicInfos);
				return true;
			}
		}
		throw new BusinessException(LogManager.getLogger(getClass()),ExOrderEnum.EX_FAID_CANCEL_ORDER);
	}
	
	/**
	 * 删除订单状态
	 * @param orderId
	 * @return
	 */
	public boolean deleteOrder(Integer id,String orderId){
		Order order = new Order();
		order.setOrderState(Integer.valueOf(OrderStateEnum.STATE_DELETE.key()));
		order.setId(id);
		if(orderDao.updateSelectiveByPrimaryKey(order) > 0){
			orderStateService.addOrderStateHis(orderId, Integer.valueOf(OrderStateEnum.STATE_DELETE.key()));
			return true;
		}
		return false;
	}
	
	@Override
	public int countOrderByShopId(Integer shopId, String type,OrderExample example) {
		if(example == null){
			example = new OrderExample();
		}
		OrderExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(shopId);
		if("2".equals(type)){//待发货订单
			criteria.andOrderStateEqualTo(Integer.parseInt(OrderStateEnum.STATE_SUCCESS.key()));
			criteria.andPayStateEqualTo(Integer.parseInt(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
		}else{
			List<Integer> payStates = new ArrayList<Integer>();
			payStates.add(Integer.parseInt(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
			payStates.add(Integer.parseInt(PaymentStateEnum.STATE_REFUNDED.key()));
			criteria.andPayStateIn(payStates);
			if("1".equals(type)){//今日订单
				criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.parseDate(new Date()));
			}else if ("3".equals(type)) {//已发货订单
				criteria.andOrderStateNotEqualTo(Integer.parseInt(OrderStateEnum.STATE_SUCCESS.key()));
			}
		}
		return orderDao.countByExample(example);
	}
	
	@Override
	public boolean updateLogisticsNumber(String logisticsName,
			String logisticsNumber, String orderId) {
		Order order = new Order();
		order.setLogisticsName(logisticsName);
		order.setLogisticsNumber(logisticsNumber);
		order.setOrderState(Integer.parseInt(OrderStateEnum.STATE_DISTRIBUTION.key()));
		
		OrderExample example = new OrderExample();
		OrderExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		criteria.andPayStateEqualTo(Integer.parseInt(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
		criteria.andOrderStateEqualTo(Integer.parseInt(OrderStateEnum.STATE_SUCCESS.key()));
		if(orderDao.updateByExampleSelective(order, example) > 1){
			orderStateService.addOrderStateHis(orderId, Integer.parseInt(OrderStateEnum.STATE_DISTRIBUTION.key()));
			return true;
		}
		return false;
	}

	
	/**
	 * 查询普订单统计
	 * @param shopId
	 * @param payTime
	 * @return
	 */
	public OrderTotalBiz queryOrderTotal(Integer shopId,Date payTime){
		return exOrderDao.queryOrderTotal(shopId, payTime);
	}
	
}