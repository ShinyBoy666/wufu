package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.OrderProductProfitDao;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerRewardConfig;
import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.OrderProduct;
import cn.xinmeng.api.entity.auto.OrderProductProfit;
import cn.xinmeng.api.entity.auto.OrderRemind;
import cn.xinmeng.api.entity.auto.example.OrderProductExample;
import cn.xinmeng.api.entity.auto.example.OrderProductProfitExample;
import cn.xinmeng.api.enums.ConsumTypeEnum;
import cn.xinmeng.api.enums.CustomerCategoryEnum;
import cn.xinmeng.api.enums.OrderProductProfitLevelEnum;
import cn.xinmeng.api.enums.OrderProductProfitStateEnum;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.service.IAccountService;
import cn.xinmeng.api.service.ICustomerRewardConfigService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IOrderProductProfitService;
import cn.xinmeng.api.service.IOrderProductService;
import cn.xinmeng.api.service.IOrderRemindService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：OrderProductProfitServiceImpl
 * 描述：订单商品利润分配信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:11
 */
@Service("orderProductProfitService")
public class OrderProductProfitServiceImpl implements IOrderProductProfitService {

    @Resource
	private OrderProductProfitDao orderProductProfitDao;
    @Resource
    private ICustomerService customerService;
    @Resource
    private IOrderProductService orderProductService;
    @Resource
    private IOrderService orderService;
    @Resource
    private IAccountService accountService;
    @Resource
    private IOrderRemindService orderRemindService;
    @Resource
    private ICustomerRewardConfigService customerRewardConfigService;
    
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderProductProfit record){
    	return orderProductProfitDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return orderProductProfitDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderProductProfit record){
		return orderProductProfitDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderProductProfit selectByPrimaryKey(Integer id){
    	return orderProductProfitDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(OrderProductProfitExample example){
		return orderProductProfitDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderProductProfit> selectByExample(OrderProductProfitExample example){
    	return orderProductProfitDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<OrderProductProfit> selectByExample(int currentPage, int limit,OrderProductProfitExample example){
        return orderProductProfitDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    /**
     * 确认收货，修改订单商品利润状态
     * @param childOrderId
     */
    public void updateOrderProfitState(String childOrderId){
    	OrderProductProfitExample example = new OrderProductProfitExample();
    	OrderProductProfitExample.Criteria criteria = example.createCriteria();
    	criteria.andOrderIdEqualTo(childOrderId);
    	OrderProductProfit profit = new OrderProductProfit();
    	profit.setHandleState(Integer.valueOf(OrderProductProfitStateEnum.YET_SETTLED.key()));
    	orderProductProfitDao.updateByExampleSelective(profit, example);
    }
    
	/**
	 * 订单商品分利
	 * @param customerId
	 * @param order
	 */
	public void merchandiseDistribution(Order order){
		Integer customerId = order.getCustomerId();
		//订单提交店铺
		Integer shopId = order.getShopId();
		String orderId = order.getOrderId();
		//订单提醒纪录
		OrderRemind remind = new OrderRemind();
		remind.setCreateTime(new Date());
		remind.setOrderId(orderId);
		remind.setShopId(shopId);
		//订单提醒
		orderRemindService.add(remind);
		
		Customer customer = customerService.selectByPrimaryKey(customerId);
		if(customer == null){
			LogManager.infoProfit("添加订单商品分利，未查找客户信息：customerId:"+customerId+"  orderId"+orderId);
			return ;
		}
		
		Integer profitFirstCustomerId = 0; //一级利润
		Integer profitSecondCustomerId = 0; //二级利润
		Integer profitThirdCustomerId = 0; //三级利润
		boolean isMember = customerService.isMember(customer);
		/**
		 * 获取分利人id
		 */
		String fieldList = "id,recommend_customer_id";
		if(!Utils.isEmpty(customer.getRecommendCustomerId())){
			//一级分利
			Customer firstCustomer = customerService.queryCustomerById(customer.getRecommendCustomerId(), fieldList);
			if(firstCustomer != null){
				profitFirstCustomerId = firstCustomer.getId();
				if(!Utils.isEmpty(firstCustomer.getRecommendCustomerId())){
					//二级分利
					Customer secondCustomer = customerService.queryCustomerById(firstCustomer.getRecommendCustomerId(), fieldList);
					if(secondCustomer != null){
						profitSecondCustomerId = secondCustomer.getId();
						//三级分利
						if(!Utils.isEmpty(secondCustomer.getRecommendCustomerId()) && !isMember){
							Customer thirdCustomer = customerService.queryCustomerById(secondCustomer.getRecommendCustomerId(), fieldList);
							if(thirdCustomer != null){
								profitThirdCustomerId = thirdCustomer.getId();
							}
						}
					}
				}
			}
		}
		
		//查询订单商品
		OrderProductExample example = new OrderProductExample();
		OrderProductExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrderProduct> listOrderProduct = orderProductService.selectByExample(example);
		
		List<OrderProductProfit> listProfit = new ArrayList<OrderProductProfit>();
		
		for (OrderProduct orderProduct : listOrderProduct) {
			Double profitFirst = orderProduct.getProfitFirst(); //一级利润
			Double profitSecond =orderProduct.getProfitSecond(); //二级利润
			Double profitThird = orderProduct.getProfitThird(); //三级利润
			
			Double shopAmount = orderProduct.getProductPayMoney();//店铺总应收货款，默认用户支付金额

			/**
			 * 无推荐人
			 */
			if(profitFirstCustomerId == 0){
				if(isMember){
					//会员享有一级分利，店铺应收货款 ＝ 用户支付金额 － 一级分利
					shopAmount = UtilMoney.subtractToDouble(shopAmount, profitFirst);
					
					//自己享受一级分利（金额上冻结）
					addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.FIRST,customerId, profitFirst,1);
				}
				//发货店铺，应收货款
				addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.SHOP, shopId, shopAmount,2);
			}else{
				/**
				 * 有推荐人
				 */
				if(isMember){
					//会员享有一级分利，店铺应收货款 ＝ 用户支付金额 － 一级分利
					shopAmount = UtilMoney.subtractToDouble(shopAmount, profitFirst);
					//自己享受一级分利（金额上冻结）
					addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.FIRST,customerId, profitFirst,1);
					
					//会员一级推荐人享有二级分利，店铺应收货款 ＝ 用户支付金额 － 二级分利
					shopAmount = UtilMoney.subtractToDouble(shopAmount, profitSecond);
					//二级分利，会员一级推荐人享有二级分利
					addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.SECOND, profitFirstCustomerId, profitSecond,1);
					
					if(profitSecondCustomerId > 0){
						//会员二级推荐人享有三级分利，店铺应收货款 ＝ 用户支付金额 － 三级分利
						shopAmount = UtilMoney.subtractToDouble(shopAmount, profitThird);
						//三级分利，会员二级推荐人，享受三级分利
						addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.THIRD, profitSecondCustomerId, profitThird,1);
					}
				}else{
					//一级推荐人享有一级分利，店铺应收货款 ＝ 用户支付金额 － 一级分利
					shopAmount = UtilMoney.subtractToDouble(shopAmount, profitFirst);
					//一级分利，一级推荐人享有一级分利
					addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.FIRST, profitFirstCustomerId, profitFirst,1);
					if(profitSecondCustomerId > 0){
						//二级推荐人享有二级分利，店铺应收货款 ＝ 用户支付金额 － 二级分利
						shopAmount = UtilMoney.subtractToDouble(shopAmount, profitSecond);
						//二级分利，二级推荐人享有二级分利
						addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.SECOND, profitSecondCustomerId, profitSecond,1);
						if(profitThirdCustomerId > 0){
							//三级推荐人享有三级分利，店铺应收货款 ＝ 用户支付金额 － 三级分利
							shopAmount = UtilMoney.subtractToDouble(shopAmount, profitThird);
							//三级分利，三级推荐人享有三级分利
							addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.THIRD, profitThirdCustomerId, profitThird,1);
						}
					}
				}
				//发货店铺，应收货款
				addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.SHOP, shopId, shopAmount,2);
			}
		}
		LogManager.info(this.getClass(),FastJsonUtils.bean2Json(listProfit));
		//订单分利，支付流水
		for (OrderProductProfit orderProductProfit : listProfit) {
			add(orderProductProfit);
		}
		//给推荐用户，推荐店铺，货款店铺加金额
		accountService.orderProductProfit(listProfit);
	}
    
    /**
	 * 订单商品分利(自己永远享受分利)，支付成功调用
	 * @param customerId
	 * @param order
	 */
	public void newMerchandiseDistribution(Order order){
//		Integer customerId = order.getCustomerId();
//		//订单提交店铺
//		Integer shopId = order.getShopId();
//		String orderId = order.getOrderId();
//		//订单提醒纪录
//		OrderRemind remind = new OrderRemind();
//		remind.setCreateTime(new Date());
//		remind.setOrderId(orderId);
//		remind.setShopId(shopId);
//		
//		Customer customer = customerService.selectByPrimaryKey(customerId);
//		if(customer == null){
//			LogManager.infoProfit("添加订单商品分利，未查找客户信息：customerId:"+customerId+"  orderId"+orderId);
//			return ;
//		}
//		
//		Integer profitFirstCustomerId = 0; //一级利润
//		Integer profitSecondCustomerId = 0; //二级利润
//		/**
//		 * 获取分利人id
//		 */
//		String fieldList = "id,recommend_customer_id";
//		if(!Utils.isEmpty(customer.getRecommendCustomerId())){
//			//一级分利
//			Customer firstCustomer = customerService.queryCustomerById(customer.getRecommendCustomerId(), fieldList);
//			if(firstCustomer != null){
//				profitFirstCustomerId = firstCustomer.getId();
//				if(!Utils.isEmpty(firstCustomer.getRecommendCustomerId())){
//					//二级分利
//					Customer secondCustomer = customerService.queryCustomerById(firstCustomer.getRecommendCustomerId(), fieldList);
//					if(secondCustomer != null){
//						profitSecondCustomerId = secondCustomer.getId();
//						//三级分利
//					}
//				}
//			}
//		}
//		//查询订单商品
//		OrderProductExample example = new OrderProductExample();
//		OrderProductExample.Criteria criteria = example.createCriteria();
//		criteria.andOrderIdEqualTo(orderId);
//		List<OrderProduct> listOrderProduct = orderProductService.selectByExample(example);
//		
//		List<OrderProductProfit> listProfit = new ArrayList<OrderProductProfit>();
//		
//		for (OrderProduct orderProduct : listOrderProduct) {
//			Double profitFirst = orderProduct.getProfitFirst(); //一级利润
//			Double profitSecond =orderProduct.getProfitSecond(); //二级利润
//			Double profitThird = orderProduct.getProfitThird(); //三级利润
//			
//			Double shopAmount = orderProduct.getProductPayMoney();//店铺总应收货款，默认用户支付金额
//			
//			/***
//			 * 第一步：判断三否跨店铺
//			 * 第二步：判断有无推荐人
//			 * 第三步：判断是否会员
//			 * 第四步：插入推荐奖励（推荐人，推荐店铺），货款（发货店铺）
//			 */
//
//			/**
//			 * 无推荐人
//			 */
//			if(profitFirstCustomerId == 0){
//				//自己享受一级分利，会员，购买商品，已经扣减分利
//				shopAmount = UtilMoney.subtractToDouble(shopAmount, profitFirst);
//				//自己享受一级分利（金额上冻结）
//				addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.FIRST,customerId, profitFirst,1);
//				//发货店铺，应收货款
//				addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.SHOP, shopId, shopAmount,2);
//			}else{
//				/**
//				 * 有推荐人
//				 */
//				//自己享受一级分利，会员，购买商品，已经扣减分利
//				shopAmount = UtilMoney.subtractToDouble(shopAmount, profitFirst);
//				//自己享受一级分利（金额上冻结）
//				addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.FIRST,customerId, profitFirst,1);
//				
//				//二级分利，一级推荐人享有
//				shopAmount = UtilMoney.subtractToDouble(shopAmount, profitSecond);
//				//二级分利，一级推荐人享有
//				addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.SECOND, profitFirstCustomerId, profitSecond,1);
//				
//				if(profitSecondCustomerId > 0){
//					//三级分利，二级推荐人享有
//					shopAmount = UtilMoney.subtractToDouble(shopAmount, profitThird);
//					//三级分利，二级推荐人享有
//					addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.THIRD, profitSecondCustomerId, profitThird,1);
//				}
//				
//				//发货店铺，应收货款
//				addOrderProductProfit(listProfit,orderProduct, OrderProductProfitLevelEnum.SHOP, shopId, shopAmount,2);
//			}
//		}
//		LogManager.info(this.getClass(),FastJsonUtils.bean2Json(listProfit));
//		//订单分利，支付流水
//		for (OrderProductProfit orderProductProfit : listProfit) {
//			add(orderProductProfit);
//		}
//		//订单提醒
//		orderRemindService.add(remind);
//		
//		//给推荐用户，推荐店铺，货款店铺加金额
//		accountService.orderProductProfit(listProfit);
	}
	
	/**
	 * 获取店铺冻结金额
	 * @param shopId
	 * @return
	 */
	public Double getFreezeAmount(Integer shopId){
		OrderProductProfitExample example = new OrderProductProfitExample();
		example.setFieldList("sum(customer_Award * product_number) customer_Award");
		OrderProductProfitExample.Criteria criteria = example.createCriteria();
		criteria.andAccountTypeEqualTo(2);//店铺
		criteria.andCustomerIdEqualTo(shopId);
		criteria.andHandleStateIn(Arrays.asList(new Integer[]{1,4}));//未结算,待结算
		List<OrderProductProfit> list = orderProductProfitDao.selectByExample(example);
		if(!Utils.isEmpty(list) && !Utils.isEmpty(list.get(0))){
			return list.get(0).getCustomerAward();
		}
		return 0.00;
	}
	
    /**
	 * 会员充值分利
	 * @param customerId
	 * @param order
	 */
	public void nemberMerchandiseDistribution(Order order,Double onlinePayment){
		Integer customerId = order.getCustomerId();
		String orderId = order.getOrderId();
		Integer shopId = order.getShopId();
		//订单提醒纪录
		OrderRemind remind = new OrderRemind();
		remind.setCreateTime(new Date());
		remind.setOrderId(orderId);
		remind.setShopId(shopId);
		
		Customer customer = customerService.selectByPrimaryKey(customerId);
		if(customer == null){
			LogManager.infoProfit("添加订单商品分利，未查找客户信息：customerId:"+customerId+"  orderId"+orderId);
			return ;
		}
		//如果已经是会员，则把订单金额充值到帐户
		if(customerService.isMember(customer)){
			accountService.accountRecharge(customerId, order.getPayAmount(), ConsumTypeEnum.TYPE_56, orderId);
			LogManager.infoProfit("会员充值分利，客户已经是会员，订单金额充值到帐户： orderId"+orderId);
			return ;
		}
		customer.setCustomerCategory(CustomerCategoryEnum.FEEPAY.key());
		Date date = new Date();
		customer.setOpenTime(date);
		customer.setEndTime(DateUtil.addYear(date, 1));
		customer.setCustomerCategory(CustomerCategoryEnum.FEEPAY.key());
		customerService.updateSelectiveByPrimaryKey(customer);
		
		Integer profitFirstCustomerId = 0; //一级利润
		Integer profitSecondCustomerId = 0; //二级利润
		Integer profitThirdCustomerId = 0; //三级利润

		/**
		 * 获取分利人id
		 */
		String fieldList = "id,recommend_customer_id";
		if(!Utils.isEmpty(customer.getRecommendCustomerId())){
			//一级分利
			Customer firstCustomer = customerService.queryCustomerById(customer.getRecommendCustomerId(), fieldList);
			if(firstCustomer != null){
				profitFirstCustomerId = firstCustomer.getId();
				if(!Utils.isEmpty(firstCustomer.getRecommendCustomerId())){
					//二级分利
					Customer secondCustomer = customerService.queryCustomerById(firstCustomer.getRecommendCustomerId(), fieldList);
					if(secondCustomer != null){
						profitSecondCustomerId = secondCustomer.getId();
						//三级分利
						if(!Utils.isEmpty(secondCustomer.getRecommendCustomerId())){
							Customer thirdCustomer = customerService.queryCustomerById(secondCustomer.getRecommendCustomerId(), fieldList);
							if(thirdCustomer != null){
								profitThirdCustomerId = thirdCustomer.getId();
							}
						}
					}
				}
			}
		}
		
		CustomerRewardConfig config = customerRewardConfigService.queryVipFeeCustomerRewardConfig(shopId);
		if(config == null){
			return ;
		}
		Double firstAmount = config.getFirstLevel();
		Double secondAmount = config.getSecondLevel();
		Double thirdAmount = config.getThirdLevel();
		Double shopAmount = config.getShop();
		
		//自订单，父订单一样
		Integer orderProductId = orderProductService.getOrderProductId(orderId);
		
		List<OrderProductProfit> listProfit = new ArrayList<OrderProductProfit>();
		
		//一级
		if(!Utils.isEmpty(profitFirstCustomerId)){
			addOrderProductProfit(listProfit, orderId, OrderProductProfitLevelEnum.FIRST, profitFirstCustomerId, firstAmount, 1);
		}
		
		//二级
		if(!Utils.isEmpty(profitSecondCustomerId)){
			addOrderProductProfit(listProfit, orderId, OrderProductProfitLevelEnum.SECOND, profitSecondCustomerId, secondAmount, 1);
		}
		//三级
		if(!Utils.isEmpty(profitThirdCustomerId)){
			addOrderProductProfit(listProfit, orderId, OrderProductProfitLevelEnum.THIRD, profitThirdCustomerId, thirdAmount, 1);
		}
		//店铺
		if(!Utils.isEmpty(shopId)){
			addOrderProductProfit(listProfit, orderId, OrderProductProfitLevelEnum.SHOP, shopId, shopAmount, 2);
		}
		
		//订单分利，支付流水
		for (OrderProductProfit orderProductProfit : listProfit) {
			orderProductProfit.setOrderProductId(orderProductId);
			add(orderProductProfit);
		}
		
		//订单提醒
		orderRemindService.add(remind);
		
		//给推荐用户，推荐店铺，货款店铺加金额
		accountService.orderProductProfit(listProfit);
		
		//确认收货
		orderService.confirmReceipt(orderId, Integer.valueOf(OrderStateEnum.STATE_FINISH.key()),onlinePayment);
	}
	
	/**
	 * 添加订单分利
	 * @param orderProduct
	 * @param profitLevel
	 * @param customerId  店铺或客户id
	 * @param profit	  分利金额
	 * @param subShopId	  发货店铺
	 * @param accountType 1-用户，2-店铺
	 */
	private void addOrderProductProfit(List<OrderProductProfit> listProfit,OrderProduct orderProduct,OrderProductProfitLevelEnum profitLevel,Integer id,double profit,Integer accountType){
		if(UtilMoney.compareTo(profit, 0.00) > 0){
			Date now = new Date();
			OrderProductProfit productProfit = new OrderProductProfit();
			productProfit.setCancelTime(now);
			productProfit.setCreateTime(now);
			productProfit.setCreateUser("api");
			productProfit.setAccountType(accountType);
			productProfit.setCustomerAward(profit);
			productProfit.setCustomerId(id);
			productProfit.setHandleState(Integer.valueOf(OrderProductProfitStateEnum.NOT_SETTLED.key()));
			productProfit.setOrderId(orderProduct.getOrderId());
			productProfit.setOrderProductId(orderProduct.getId());
			productProfit.setProductNumber(orderProduct.getProductNumber());
			productProfit.setProfitLevel(Integer.valueOf(profitLevel.key()));
			productProfit.setProfitTime(now);
			productProfit.setUpdateTime(now);
			productProfit.setUpdateUser("api");
			listProfit.add(productProfit);
		}else{
			LogManager.infoProfit("分利金额为0：profitLevel="+profitLevel.value()+" profit="+profit);
		}
	}

	/**
	 * 添加订单分利
	 * @param orderProduct
	 * @param profitLevel
	 * @param customerId  店铺或客户id
	 * @param profit	  分利金额
	 * @param subShopId	  发货店铺
	 * @param accountType 1-用户，2-店铺
	 */
	private void addOrderProductProfit(List<OrderProductProfit> listProfit,String orderId,OrderProductProfitLevelEnum profitLevel,Integer id,double profit,Integer accountType){
		if(UtilMoney.compareTo(profit, 0.00) > 0){
			Date now = new Date();
			OrderProductProfit productProfit = new OrderProductProfit();
			productProfit.setCancelTime(now);
			productProfit.setCreateTime(now);
			productProfit.setCreateUser("api");
			productProfit.setAccountType(accountType);
			productProfit.setCustomerAward(profit);
			productProfit.setCustomerId(id);
			productProfit.setHandleState(Integer.valueOf(OrderProductProfitStateEnum.NOT_SETTLED.key()));
			productProfit.setOrderId(orderId);
			productProfit.setOrderProductId(0);
			productProfit.setProductNumber(1);
			productProfit.setProfitLevel(Integer.valueOf(profitLevel.key()));
			productProfit.setProfitTime(now);
			productProfit.setUpdateTime(now);
			productProfit.setUpdateUser("api");
			listProfit.add(productProfit);
		}else{
			LogManager.infoProfit("分利金额为0：profitLevel="+profitLevel.value()+" profit="+profit);
		}
	}
}