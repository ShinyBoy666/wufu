package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.constant.ConstantSystem;
import cn.xinmeng.api.dao.auto.OrderDao;
import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerRewardConfig;
import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.OrderProduct;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.ShopActivityConfig;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.entity.auto.biz.CartLine;
import cn.xinmeng.api.entity.auto.example.ProductPriceExample;
import cn.xinmeng.api.entity.auto.example.QuickOrderExample;
import cn.xinmeng.api.enums.ActivityTypeEnum;
import cn.xinmeng.api.enums.OrderProductStateEnum;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.enums.OrderTypeEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.enums.ProductStateEnum;
import cn.xinmeng.api.enums.QuantityChangeTypeEnum;
import cn.xinmeng.api.enums.QuickOrderTypeEnum;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICategoryService;
import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerDetailService;
import cn.xinmeng.api.service.ICustomerRewardConfigService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IGetuiMessageService;
import cn.xinmeng.api.service.IOrderProductProfitService;
import cn.xinmeng.api.service.IOrderProductService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IOrderSubimtService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IProductStockManager;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopActivityConfigService;
import cn.xinmeng.api.service.IShopPostageConfigService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.api.thread.GetuiThread;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.customer.S1067RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1021RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1022RequestEntity;
import cn.xinmeng.web.shop.entity.order.vo.OrderCartVo;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;
import cn.xinmeng.web.shop.entity.quickorder.S1093RequestEntity;
import cn.xinmeng.web.thread.SendSmsThread;

/**
 * 订单提交
 * @param 
 * @ClassName: OrderSubimtServiceImpl 
 * @version V1.0  
 * @date 2016年2月24日 上午11:34:23 
 * @author jiangyong.tan
 * @return 
 *
 */
@Service("orderSubimtService")
public class OrderSubimtServiceImpl implements IOrderSubimtService {

	@Resource
	private OrderDao orderDao;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IProductPriceService productPriceService;
	@Resource
	private IOrderProductService orderProductService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private ICommonAddressService commonAddressService;
	@Resource
	private ICustomerDetailService customerDetailService;
	@Resource
	private ICartService cartService;
	@Resource
	private IProductStockManager productStockManager;

	@Resource
	private ICouponService couponService;
	@Resource
	private ICouponApplyService couponApplyService;
	@Resource
	private ICategoryService categoryService;
	@Resource
	private IOrderService orderService;
	@Resource
	private ICustomerRewardConfigService customerRewardConfigService;
	@Resource
	private IRedisService redisService;

	@Resource
	private IQuickOrderService quickOrderService;
	
	@Resource
	private IShopActivityConfigService shopActivityConfigService;
	@Resource
	private ISmsService smsService;
	@Resource
	private TaskExecutor sendMessageThreadPool;
	@Resource
	private IShopPostageConfigService shopPostageConfigService;
	@Resource
	private IOrderProductProfitService orderProductProfitService;
	@Resource
	private IGetuiMessageService getuiMessageService;
	
	/**
	 * 提交订单，主方法
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午11:29:43
	 * @param entity
	 * @return
	 */
	public PayOrderBiz submitOrderMain(S1021RequestEntity entity,Integer sourceShopId,Integer loginShopId){
		if(Utils.isEmpty(entity.getShopCarts())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ORDER_EXCEPTION);
		}
		/**
		 * 第一步：组装下单需要的数据
		 */
		OrderCartVo orderCartVo = entity.getShopCarts().get(0);
		String orderId = Utils.createOrderNumber(ConstantSystem.PAYMENT_NO_GENERAL_PREFIX,entity.getCustomerId());//生成订单号
		//查询购物车商品信息
		List<CartLine> listCartLine = cartService.selectCartByIds(orderCartVo.getCartIds(),entity.getCustomerId(), true, true);
		//购物车为空
		if(Utils.isEmpty(listCartLine)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_PRODUCT_STATE);
		}
		//判断商品上否商家状态
		List<Integer> productIdList = new ArrayList<Integer>();//商品id集合
		for (CartLine cartLine : listCartLine) {
			productIdList.add(cartLine.getProductId());
			cartLine.setRemark("创建订单");
			cartLine.setOrderId(orderId);
			if(!ProductStateEnum.STATE_SHELVE.key().equals(cartLine.getProductState()+"")){
				//商品不是上架状态
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCT_SOLD_OUT);
			}
		}
		//判断商品是否需要发货，填写实名制
		boolean isDelivery = productInfoService.queryProductInfoIsDelivery(productIdList);				//是否需要发货
		boolean realyname = productInfoService.queryProductInfoRealyname(productIdList);			//是否需要填写身份证
		if(isDelivery && Utils.isEmpty(entity.getAddressId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_ADDRESS_ID);
		}
		if(realyname && (Utils.isEmpty(entity.getRecipientIdentityCard()) || Utils.isEmpty(entity.getRealyname()))){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_REALYNAME);
		}
		/**
		 * 第二步：减库存
		 */
		productStockManager.subStock(listCartLine, Integer.valueOf(QuantityChangeTypeEnum.SUB.key()));
		try {
			/**
			 * 第三步：查询相关订单信息所要数据（客户与客户地址）
			 */
			Customer customer = customerService.selectByPrimaryKey(entity.getCustomerId());
			if(customer == null){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
			}
			Order publicOrder = new Order();
			publicOrder.setOrderId(orderId);
			publicOrder.setShopId(loginShopId);//操作店铺
			publicOrder.setOnlinePayType(entity.getOnlinePayType());
			publicOrder.setOrderType(Integer.valueOf(OrderTypeEnum.GENERAL.key()));
			CommonAddress commonAddress = null;
			if(!Utils.isEmpty(entity.getAddressId())){
				commonAddress = commonAddressService.selectByPrimaryKey(entity.getAddressId());
				if(Utils.isEmpty(commonAddress)){
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NOTEXISTS_CUSTOMER_ADDRESS);
				}
				publicOrder.setCityId(commonAddress.getCityId());
				publicOrder.setCustomerId(commonAddress.getCustomerId());
				publicOrder.setDistrictId(commonAddress.getDistrictId());
				publicOrder.setProvinceId(commonAddress.getProvinceId());
				publicOrder.setRecipientAddress(commonAddress.getRecipientAddress());
				publicOrder.setRecipientIdentityCard(commonAddress.getRecipientIdentityCard());
				publicOrder.setRecipientName(commonAddress.getRecipientName());
				publicOrder.setRecipientPhone(commonAddress.getRecipientPhone());
				publicOrder.setTown(commonAddress.getTown());
			}else{
				publicOrder.setCustomerId(customer.getId());
				publicOrder.setRecipientPhone(customer.getCellphone());
				publicOrder.setRecipientName(customer.getNickname());
			}
			if(!Utils.isEmpty(entity.getRealyname())){
				publicOrder.setRecipientName(entity.getRealyname());
			}
			if(!Utils.isEmpty(entity.getRecipientIdentityCard())){
				publicOrder.setRecipientIdentityCard(entity.getRecipientIdentityCard());
				customerDetailService.updateCustomerDetail(entity.getCustomerId(), entity.getRealyname(), entity.getRecipientIdentityCard());
			}

			/**
			 * 第四步：提交订单信息（一个订单，多个订单）
			 */
			//商品所属店铺
			Integer shopId = orderCartVo.getShopId();
			//店铺优惠券
			String couponCode = orderCartVo.getCouponCode();
			//克隆订单公共字段（计算）
			Order order = getOrder(publicOrder,orderId,entity.getOrderFrom(),shopId,couponCode,listCartLine,null);
			//查询邮费
			order.setPostage(shopPostageConfigService.queryPostage(shopId, commonAddress, order.getTotalAmount()));
			//添加订单与订单商品
			addOrder(listCartLine, order);
			//删除购物车信息
			cartService.deleteByIds(orderCartVo.getCartIds());
			//组装返回值
			PayOrderBiz payOrderBiz = new PayOrderBiz();
			payOrderBiz.setParentOrderId(order.getOrderId());
			payOrderBiz.setTotalAmount(order.getTotalAmount());
			payOrderBiz.setDiscountAmount(order.getDiscountAmount());
			payOrderBiz.setCouponPayment(order.getCouponPayment());
			payOrderBiz.setPostage(order.getPostage());
			payOrderBiz.setOrderFrom(order.getOrderFrom());
			payOrderBiz.setOnlinePayType(order.getOnlinePayType());
			payOrderBiz.setCustomerId(order.getCustomerId());
			payOrderBiz.setAccountDeduct(entity.isAccountDeduct());
			payOrderBiz.setPayState(order.getPayState());
			return payOrderBiz;
		} catch (Exception e) {
			productStockManager.addStock(listCartLine, Integer.valueOf(QuantityChangeTypeEnum.ADD.key()));
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_ORDER_SUBMIT,e);
		}
	}

	/**
	 *  订单通用信息
	 * @author jiangyong.tan
	 * @date 2016年2月25日 上午10:31:27
	 * @param orderId
	 * @param orderFrom
	 * @return
	 */
	public Order getOrder(Order order,String orderId,Integer orderFrom,Integer targetShopId,String couponCode,List<CartLine> cartList,Double totalAmount){
		Date currDate = new Date();
		order.setAccountPayment(0.00);
		order.setOrderId(orderId);
		order.setCreateTime(currDate);
		order.setCreateUser(Utils.createUser);
		order.setLogisticsName("");
		order.setLogisticsNumber("");
		order.setOrderFrom(orderFrom);
		order.setOrderState(Integer.valueOf(OrderStateEnum.STATE_SUCCESS.key()));
		order.setPayState(Integer.valueOf(PaymentStateEnum.STATE_PAY_NOT.key()));
		order.setPostage(0.00);
		order.setRemark("创建订单");
		order.setUpdateTime(currDate);
		order.setUpdateUser(Utils.createUser);
		order.setZipCode("");
		order.setPayAmount(0.00);
		order.setDiscountAmount(0.00);
		order.setCouponPayment(0.00);
		order.setShopId(targetShopId);//商品店铺
		order.setCouponCode(couponCode);

		if(Utils.isEmpty(totalAmount)){
			if(cartList == null || cartList.size() == 0){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_ORDER_SUBMIT);
			}
			totalAmount = 0.00;
			for (CartLine cartLine : cartList) {
				Double cartAmount = UtilMoney.multiplyToDouble(cartLine.getBuyPrice(), cartLine.getProductNumber());
				totalAmount = UtilMoney.addToDouble(totalAmount, cartAmount);
			}
		}
		order.setTotalAmount(totalAmount);
		return order;
	}

	/**
	 * 添加订单与订单商品
	 */
	public void addOrder(List<CartLine> cartList,Order order){

		//订单商品集合
		List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();


		if(Utils.isEmpty(order.getCouponCode())){
			//没有优惠券
			for (CartLine cartLine : cartList) {
				OrderProduct orderProduct = new OrderProduct();
				orderProduct.setOrderId(order.getOrderId());
				orderProduct.setCreateTime(order.getCreateTime());
				orderProduct.setCreateUser(order.getCreateUser());
				orderProduct.setIsDelivery(cartLine.getIsDelivery());//需要发货
				orderProduct.setProductId(cartLine.getProductId());
				orderProduct.setSku(cartLine.getSku());
				orderProduct.setProductNumber(cartLine.getProductNumber());
				orderProduct.setProductPrice(cartLine.getBuyPrice());
				orderProduct.setProductPriceId(cartLine.getPriceId());
				orderProduct.setProductState(Integer.valueOf(OrderProductStateEnum.TO_BE_SHIPPED.key()));
				orderProduct.setProfitFirst(cartLine.getProfitFirst());
				orderProduct.setProfitSecond(cartLine.getProfitSecond());
				orderProduct.setProfitThird(cartLine.getProfitThird());
				orderProduct.setProductPayMoney(cartLine.getBuyPrice());
				orderProduct.setProductDiscountMoney(0.00);
				orderProduct.setIsComment(0);
				orderProduct.setUpdateTime(order.getCreateTime());
				orderProduct.setUpdateUser(order.getCreateUser());
				orderProduct.setRemark("");
				orderProduct.setDeliveryTime(order.getCreateTime());
				orderProduct.setActivityProductId(0);
				orderProductList.add(orderProduct);
			}
		}else {
			
			//使用优惠卷
			double couponPayment = couponService.useCoupon(order.getCouponCode(), order.getCustomerId(), order.getTotalAmount(), order.getShopId());
			/**
			 * 组装订单商品
			 */
			for (CartLine cartLine : cartList) {
				OrderProduct orderProduct = new OrderProduct();
				orderProduct.setOrderId(order.getOrderId());
				orderProduct.setCreateTime(order.getCreateTime());
				orderProduct.setCreateUser(order.getCreateUser());
				orderProduct.setIsDelivery(cartLine.getIsDelivery());//需要发货
				orderProduct.setProductId(cartLine.getProductId());
				orderProduct.setSku(cartLine.getSku());
				orderProduct.setProductNumber(cartLine.getProductNumber());
				orderProduct.setProductPrice(cartLine.getBuyPrice());
				orderProduct.setProductPriceId(cartLine.getPriceId());
				orderProduct.setProductState(Integer.valueOf(OrderProductStateEnum.TO_BE_SHIPPED.key()));
				orderProduct.setProfitFirst(cartLine.getProfitFirst());
				orderProduct.setProfitSecond(cartLine.getProfitSecond());
				orderProduct.setProfitThird(cartLine.getProfitThird());
				orderProduct.setProductDiscountMoney(0.00);
				orderProduct.setIsComment(0);
				orderProduct.setUpdateTime(order.getCreateTime());
				orderProduct.setUpdateUser(order.getCreateUser());
				orderProduct.setRemark("");
				orderProduct.setDeliveryTime(order.getCreateTime());
				orderProduct.setActivityProductId(0);


				if(couponPayment < order.getTotalAmount()){
					//优惠的金额 = 商品单价/满足优惠劵使用条件的商品总金额*优惠劵的面额
					double couponAmount = UtilMoney.multiplyToDouble(UtilMoney.divideToDouble(cartLine.getBuyPrice(), order.getTotalAmount()), couponPayment);
					//实际支付金额 = 商品单价 - 优惠的金额
					orderProduct.setProductPayMoney(UtilMoney.subtractToDouble(cartLine.getBuyPrice(),couponAmount));
				}else{
					orderProduct.setProductPayMoney(cartLine.getBuyPrice());
				}
				orderProduct.setProductDiscountMoney(orderProduct.getProductPrice() - orderProduct.getProductPayMoney());
				orderProductList.add(orderProduct);
			}
			if(UtilMoney.compareTo(order.getTotalAmount(), couponPayment) == 1){
				order.setCouponPayment(couponPayment);
			}else{
				order.setCouponPayment(order.getTotalAmount());
				if(Utils.isEmpty(order.getPostage())){
					//如果 满足使用条件的商品总金额 等于 订单总金额 且 邮费的金额为0 订单直接支付成功
					order.setPayState(Integer.parseInt(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
				}
			}
		}

		//添加订单
		orderService.add(order);

		//添加订单商品
		orderProductService.addAll(orderProductList);
		
		if(PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(order.getPayState()+"")){
			//支付成功，订单商品，进行利润拆分
			orderProductProfitService.merchandiseDistribution(order);
			/** 推送通知 */
			sendMessageThreadPool.execute(new GetuiThread(order, getuiMessageService));
		}
	}
	
	/**
	 * 快速下单：普通订单 
	 * @param entity
	 * @param sourceShopId
	 * @param loginShopId
	 * @return
	 */
	private PayOrderBiz createGeneralOrder(S1022RequestEntity entity,Integer sourceShopId,Integer loginShopId){
		Integer productId = entity.getProductId();
    	Integer productNumber = entity.getProductNumber();
    	Integer customerId = entity.getCustomerId();
    	String sku = entity.getSku();
		//普通立即购买
    	List<CartLine> listCart = cartService.selectCartByProductId(productId, sku, customerId, productNumber);
		/**
		 * 第二步：减库存
		 */
		productStockManager.subStock(listCart, Integer.valueOf(QuantityChangeTypeEnum.SUB.key()));
		try {
			/**
			 * 第三步：查询相关订单信息所要数据（客户与客户地址）
			 */
			Customer customer = customerService.selectByPrimaryKey(entity.getCustomerId());
			if(customer == null){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
			}
			CommonAddress commonAddress = commonAddressService.selectByPrimaryKey(entity.getAddressId());
			if(commonAddress == null){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_NOTEXISTS_CUSTOMER_ADDRESS);
			}
			String orderId = Utils.createOrderNumber(ConstantSystem.PAYMENT_NO_GENERAL_PREFIX,entity.getCustomerId());			//生成主订单号
			Order publicOrder = new Order();
			publicOrder.setOrderId(orderId);
			publicOrder.setCityId(commonAddress.getCityId());
			publicOrder.setCustomerId(commonAddress.getCustomerId());
			publicOrder.setDistrictId(commonAddress.getDistrictId());
			publicOrder.setProvinceId(commonAddress.getProvinceId());
			publicOrder.setRecipientAddress(commonAddress.getRecipientAddress());
			publicOrder.setRecipientIdentityCard(commonAddress.getRecipientIdentityCard());
			publicOrder.setRecipientName(commonAddress.getRecipientName());
			publicOrder.setRecipientPhone(commonAddress.getRecipientPhone());
			publicOrder.setTown(commonAddress.getTown());
			publicOrder.setShopId(loginShopId);//操作店铺
			publicOrder.setOnlinePayType(entity.getOnlinePayType());
			publicOrder.setOrderType(Integer.valueOf(OrderTypeEnum.GENERAL.key()));
			//店铺优惠券
			String couponCode = entity.getCouponCode();
			Order order = getOrder(publicOrder,orderId,entity.getOrderFrom(),entity.getShopId(),couponCode,listCart,null);
			//查询邮费
			order.setPostage(shopPostageConfigService.queryPostage(entity.getShopId(), commonAddress, order.getTotalAmount()));
			//添加订单与订单商品
			addOrder(listCart, order);
			//组装返回值
			PayOrderBiz payOrderBiz = new PayOrderBiz();
			payOrderBiz.setParentOrderId(order.getOrderId());
			payOrderBiz.setTotalAmount(order.getTotalAmount());
			payOrderBiz.setDiscountAmount(order.getDiscountAmount());
			payOrderBiz.setCouponPayment(order.getCouponPayment());
			payOrderBiz.setPostage(order.getPostage());
			payOrderBiz.setOrderFrom(order.getOrderFrom());
			payOrderBiz.setOnlinePayType(order.getOnlinePayType());
			payOrderBiz.setCustomerId(order.getCustomerId());
			payOrderBiz.setAccountDeduct(entity.isAccountDeduct());
			payOrderBiz.setPayState(order.getPayState());
			return payOrderBiz;
		} catch (Exception e) {
			productStockManager.addStock(listCart, Integer.valueOf(QuantityChangeTypeEnum.ADD.key()));
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_ORDER_SUBMIT,e);
		}
	}

	/**
	 * 快速下单：秒杀下单
	 * @param entity
	 * @param loginShopId
	 * @return
	 */
	private PayOrderBiz createSeckillOrder(S1022RequestEntity entity,Integer sourceShopId,Integer loginShopId){
		Integer productId = entity.getProductId();
    	Integer productNumber = entity.getProductNumber();
    	Integer customerId = entity.getCustomerId();
    	Integer activityId = entity.getActivityId();
    	Integer activityType = entity.getActivityType();
    	Integer addressId = entity.getAddressId();
    	Date curr = new Date();
    	//是否已经参与活动
		if(redisService.existsActivityPurchase(activityId, activityType, customerId,entity.getProductId(),entity.getProductPriceId())){
    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_ACTIVITYPURCHASE);
		}
		try {
			/**
			 * 修改已售数量：即减库存
			 */
			redisService.updateActvityProductSoldNumber(activityId, activityType, productId,entity.getProductPriceId(), productNumber);
			//获取活动信息
	    	ActvityProductInfoBiz activityProduct = redisService.getActvityProductInfoBiz(activityId, activityType, productId,entity.getProductPriceId());
	    	if(Utils.isEmpty(activityProduct)){
	    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_PRODUCT);
	    	}
	    	//商品已经下架
	    	if(!ProductStateEnum.STATE_SHELVE.key().equals(activityProduct.getProductState()+"")){
				//商品不是上架状态
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCT_SOLD_OUT);
			}
	    	//库存不够
	    	if(activityProduct.getQuantity() == null || activityProduct.getQuantity() < 0){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCT_LOW_STOCKS);
	    	}
	    	//有库存，判断是否限购
	    	if(!Utils.isEmpty(activityProduct.getMaxBuy()) && productNumber > activityProduct.getMaxBuy()){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.MAX_BUY);
	    	}
	    	//活动时间是否过期
	    	if(DateUtil.compareDate(activityProduct.getBeginTime(),curr) 
	    			|| DateUtil.compareDate(curr,activityProduct.getEndTime())){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.ACTIVITY_EXPIRED);
	    	}
	    	//组装订单商品需要的信息
			String orderId = Utils.createOrderNumber(ConstantSystem.PAYMENT_NO_SECKILL_PREFIX,entity.getCustomerId());			//生成主订单号
	    	//获取订单地址相关信息
	    	CommonAddress commonAddress = redisService.getCommonAddress(addressId);
			if(commonAddress == null){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_NOTEXISTS_CUSTOMER_ADDRESS);
			}
			Order publicOrder = new Order();
			publicOrder.setOrderId(orderId);
			publicOrder.setCityId(commonAddress.getCityId());
			publicOrder.setCustomerId(commonAddress.getCustomerId());
			publicOrder.setDistrictId(commonAddress.getDistrictId());
			publicOrder.setProvinceId(commonAddress.getProvinceId());
			publicOrder.setRecipientAddress(commonAddress.getRecipientAddress());
			publicOrder.setRecipientIdentityCard(commonAddress.getRecipientIdentityCard());
			publicOrder.setRecipientName(commonAddress.getRecipientName());
			publicOrder.setRecipientPhone(commonAddress.getRecipientPhone());
			publicOrder.setTown(commonAddress.getTown());
			publicOrder.setShopId(loginShopId);//操作店铺
			publicOrder.setOnlinePayType(entity.getOnlinePayType());
			publicOrder.setOrderType(Integer.valueOf(OrderTypeEnum.SECKILL.key()));
			publicOrder.setActivityId(entity.getActivityId());
			publicOrder.setRecipientIdentityCard(entity.getRecipientIdentityCard());
			if(!Utils.isEmpty(entity.getRealyname())){
				publicOrder.setRecipientName(entity.getRealyname());
			}
			//店铺优惠券
			String couponCode = entity.getCouponCode();
			//克隆订单公共字段（计算）
			Order order = getOrder(publicOrder,orderId,entity.getOrderFrom(),entity.getShopId(),couponCode,null,UtilMoney.multiplyToDouble(productNumber, activityProduct.getMarketPrice()));
			//查询邮费
			order.setPostage(shopPostageConfigService.queryPostage(entity.getShopId(), commonAddress, order.getTotalAmount()));
			order.setDiscountAmount(UtilMoney.multiplyToDouble(productNumber,UtilMoney.subtractToDouble(activityProduct.getMarketPrice(), activityProduct.getRetailPrice())));
			//添加订单与订单商品
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setOrderId(order.getOrderId());
			orderProduct.setCreateTime(order.getCreateTime());
			orderProduct.setCreateUser(order.getCreateUser());
			orderProduct.setIsDelivery(activityProduct.getIsDelivery());//需要发货
			orderProduct.setProductId(productId);
			orderProduct.setSku(activityProduct.getSku());
			orderProduct.setProductNumber(productNumber);
			orderProduct.setProductPrice(activityProduct.getRetailPrice());
			orderProduct.setProductPriceId(activityProduct.getProductPriceId());
			orderProduct.setProductState(Integer.valueOf(OrderProductStateEnum.TO_BE_SHIPPED.key()));
			orderProduct.setProfitFirst(0.00);
			orderProduct.setProfitSecond(0.00);
			orderProduct.setProfitThird(0.00);
			orderProduct.setProductPayMoney(activityProduct.getRetailPrice());
			orderProduct.setProductDiscountMoney(0.00);
			orderProduct.setIsComment(0);
			orderProduct.setUpdateTime(order.getCreateTime());
			orderProduct.setUpdateUser(order.getCreateUser());
			orderProduct.setRemark("");
			orderProduct.setDeliveryTime(order.getCreateTime());
			orderProduct.setActivityProductId(activityProduct.getId());
			//添加订单
			orderService.add(order);
			//添加订单商品
			orderProductService.add(orderProduct);
			//设置参与活动
			redisService.activityPurchase(activityId, activityType, customerId,activityProduct.getProductId(),activityProduct.getProductPriceId(), productNumber, activityProduct.getEndTime());
			//组装返回值
			PayOrderBiz payOrderBiz = new PayOrderBiz();
			payOrderBiz.setParentOrderId(order.getOrderId());
			payOrderBiz.setTotalAmount(order.getTotalAmount());
			payOrderBiz.setDiscountAmount(order.getDiscountAmount());
			payOrderBiz.setCouponPayment(order.getCouponPayment());
			payOrderBiz.setPostage(order.getPostage());
			payOrderBiz.setOrderFrom(order.getOrderFrom());
			payOrderBiz.setOnlinePayType(order.getOnlinePayType());
			payOrderBiz.setCustomerId(order.getCustomerId());
			payOrderBiz.setAccountDeduct(entity.isAccountDeduct());
			return payOrderBiz;
		} catch (Exception e) {
			redisService.updateActvityProductSoldNumber(activityId, activityType, productId,entity.getProductPriceId(), -productNumber);
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_ORDER_SUBMIT,e);
		}
	}
	
	
    /**
     * 立即购买（快速下单）提交订单，主方法
     * @author jiangyong.tan
     * @date 2016年2月24日 上午11:29:43
     * @param entity
     * @return
     */
    public PayOrderBiz fastSubmitOrderMain(S1022RequestEntity entity,Integer sourceShopId,Integer loginShopId){
    	Integer activityId = entity.getActivityId();
    	Integer activityType = entity.getActivityType();
    	
    	if(!Utils.isEmpty(activityId) && !Utils.isEmpty(activityType)){
    		//活动订单：立即购买
    		ActivityTypeEnum type = ActivityTypeEnum.keyToEnum(activityType+"");
    		if(Utils.isEmpty(type)){
        		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_TYPE);
    		}
    		
    		//活动订单处理（秒杀，团购，砍价，一元购）
    		switch (type) {
				case SECKILL:
					return createSeckillOrder(entity, sourceShopId, loginShopId);
				default:
		    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NOT_ACTIVITY);
			}
    	}else{
    		//普通订单，立即购买
    		return createGeneralOrder(entity, sourceShopId, loginShopId);
    	}
    }
    

    /**
     * 会员充值
     * @author jiangyong.tan
     * @date 2016年2月24日 上午11:29:43
     * @param entity
     * @return
     */
    public PayOrderBiz vipSubmitOrder(S1067RequestEntity entity,Integer sourceShopId,Integer loginShopId){
    	double [] profit = new double[3];
		CustomerRewardConfig config = customerRewardConfigService.queryVipFeeCustomerRewardConfig(loginShopId);
		if(Utils.isEmpty(config)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOT_VIP_FEE);
		}
		Double totalAmount = config.getVipFee();
		String orderPrefix = ConstantSystem.PAYMENT_NO_VIP_PREFIX;
		OrderTypeEnum typeEnum = OrderTypeEnum.MEMBER;
		String remark = "充值会员";
		profit[0] = config.getFirstLevel();
		profit[1] = config.getSecondLevel();
		profit[2] = config.getThirdLevel();
		
    	String orderId = Utils.createOrderNumber(orderPrefix,entity.getCustomerId()); 
		Order order = new Order();Date currDate = new Date();
		order.setOrderId(orderId);
		order.setCityId(0);
		order.setCustomerId(entity.getCustomerId());
		order.setDistrictId(0);
		order.setProvinceId(0);
		Customer customer = customerService.selectByPrimaryKey(entity.getCustomerId());
		if(!Utils.isEmpty(customer)){
			order.setRecipientName(customer.getNickname());
			order.setRecipientPhone(customer.getCellphone());
		}
		order.setRecipientAddress("");
		order.setRecipientIdentityCard("");
		order.setTown(0);
		order.setShopId(loginShopId);
		order.setOnlinePayType(entity.getOnlinePayType());
		String optUser = "API";
		order.setAccountPayment(0.00);
		order.setCreateTime(currDate);
		order.setCreateUser(optUser);
		order.setLogisticsName("");
		order.setLogisticsNumber("");
		order.setOrderFrom(entity.getOrderFrom());
		order.setOrderState(Integer.valueOf(OrderStateEnum.STATE_SUCCESS.key()));
		order.setPayState(Integer.valueOf(PaymentStateEnum.STATE_PAY_NOT.key()));
		order.setPostage(0.00);
		order.setRemark(remark);
		order.setUpdateTime(currDate);
		order.setUpdateUser(optUser);
		order.setZipCode("");
		order.setPayAmount(0.00);
		order.setDiscountAmount(0.00);
		order.setCouponPayment(0.00);
		order.setCouponCode("");
		order.setTotalAmount(totalAmount);
		order.setOrderType(Integer.valueOf(typeEnum.key()));
		orderService.add(order);
		
		ProductPriceExample example = new ProductPriceExample();
		ProductPriceExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(1);//会员充值商品
		List<ProductPrice> listPrice = productPriceService.selectByExample(1, 1, example);
		//未维护商品价格
		if(Utils.isEmpty(listPrice)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOT_VIP_PRODUCT);
		}
		
		ProductPrice price = listPrice.get(0);
		
		//订单商品
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setOrderId(order.getOrderId());
		orderProduct.setCreateTime(order.getCreateTime());
		orderProduct.setCreateUser(order.getCreateUser());
		orderProduct.setIsDelivery(1);//不需要发货
		orderProduct.setProductId(price.getProductId());
		orderProduct.setSku(price.getSku());
		orderProduct.setProductNumber(1);
		orderProduct.setProductPrice(totalAmount);
		orderProduct.setProductPriceId(price.getId());
		orderProduct.setProductState(Integer.valueOf(OrderProductStateEnum.TO_BE_SHIPPED.key()));
		orderProduct.setProfitFirst(profit[0]);
		orderProduct.setProfitSecond(profit[1]);
		orderProduct.setProfitThird(profit[2]);
		orderProduct.setProductPayMoney(totalAmount);
		orderProduct.setProductDiscountMoney(0.00);
		orderProduct.setIsComment(0);
		orderProduct.setUpdateTime(order.getCreateTime());
		orderProduct.setUpdateUser(order.getCreateUser());
		orderProduct.setRemark("");
		orderProduct.setDeliveryTime(order.getCreateTime());
		orderProduct.setActivityProductId(0);
		orderProductService.add(orderProduct);

		//返回 
		PayOrderBiz payOrderBiz = new PayOrderBiz();
		payOrderBiz.setParentOrderId(order.getOrderId());
		payOrderBiz.setTotalAmount(order.getTotalAmount());
		payOrderBiz.setDiscountAmount(order.getDiscountAmount());
		payOrderBiz.setCouponPayment(order.getCouponPayment());
		payOrderBiz.setPostage(order.getPostage());
		payOrderBiz.setOrderFrom(order.getOrderFrom());
		payOrderBiz.setOnlinePayType(order.getOnlinePayType());
		payOrderBiz.setCustomerId(order.getCustomerId());
		payOrderBiz.setAccountDeduct(entity.isAccountDeduct());
		payOrderBiz.setRechargePrefix(orderPrefix);//vip充值
		return payOrderBiz;
    }

	@Override
	public QuickOrder quickOrderSumbit(S1093RequestEntity entity) {
		
		QuickOrderExample example = new QuickOrderExample();
		QuickOrderExample.Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(entity.getOpenId());
		criteria.andShopIdEqualTo(entity.getShopId());
		criteria.andPayStateEqualTo(Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
//		criteria.andDiscountAmountGreaterThan(0.00);
		criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getStandardDate(DateUtil.customDateToStr(new Date(), "yyyy-MM-dd 00:00:00"), "yyyy-MM-dd HH:mm:ss"));
		
		Integer count = quickOrderService.countByExample(example);
		if(count >= 5 && !Utils.isEmpty(entity.getOpenId())){
			Customer customer = customerService.queryCustomerByOpenId(entity.getOpenId(), "");
			if(customer != null){
				String smsContent = "系统检查到您的账户存在刷单嫌疑，经核实刷单情况属实后，系统将自动停用该账户。";
				sendMessageThreadPool.execute(new SendSmsThread(smsService, customer.getCellphone(), smsContent, "", entity.getShopId(), customer.getId()));
			}
		}
		if(count >= 10){
			throw new BusinessException(LogManager.getLogger(this.getClass()),"您今天在该店铺的优惠次数已使用完毕...");
		}
		
		double totalAmount = entity.getTotalAmount(); //总金额
		double discountAmount = entity.getDiscountAmount(); //折扣金额
		double payAmount = entity.getTotalAmount();
		boolean flag = false; 
		String orderType = entity.getOrderType()+""; //订单类型
		if(discountAmount > 0){
			ShopActivityConfig config = shopActivityConfigService.queryByShopId(entity.getShopId());
			if(config != null){
				double randomAmount = Utils.randomAmount;
				if(orderType.equals(QuickOrderTypeEnum.RANDOM.key())){
					if(UtilMoney.compareTo(totalAmount, randomAmount) < 0){
						throw new BusinessException(LogManager.getLogger(this.getClass()),"消费金额满"+randomAmount+"元才能享受优惠...");
					}
					if(config.getCanRandom() == 1 && discountAmount > 0 && discountAmount <= config.getMaxMoney() ){
						payAmount = UtilMoney.subtractToDouble(totalAmount, discountAmount);
						flag = true;
					}
				}else if(orderType.equals(QuickOrderTypeEnum.FULLREDUCE.key())){
					if(config.getCanFullReduce() == 1 && !Utils.isEmpty(config.getReduceMoney()) && !Utils.isEmpty(config.getFullMoney())){
						String [] reduceMoneys = config.getReduceMoney().split("\\|");
						String[] fullMoneys = config.getFullMoney().split("\\|");
						if(reduceMoneys.length > 0 && fullMoneys.length == reduceMoneys.length){
							Integer index = null;
							for (int i = 0; i < fullMoneys.length; i++) {
								if(UtilMoney.compareTo(totalAmount, new Double(fullMoneys[i])) >= 0){
									index = i;
								}else{
									break;
								}
							}
							if(index != null && UtilMoney.compareTo(discountAmount, new Double(reduceMoneys[index])) == 0){
								payAmount = UtilMoney.subtractToDouble(totalAmount, discountAmount);
								flag = true;
							}
						}
					}
				}else if(orderType.equals(QuickOrderTypeEnum.SALE.key())){
					if(config.getCanSale() == 1 && config.getSale() > 0 && config.getSale() < 100){
						payAmount = UtilMoney.roundToDouble(UtilMoney.multiplyToDouble(totalAmount, UtilMoney.divideToDouble(config.getSale(), 100)), 2); //实付金额
						if(UtilMoney.compareTo(discountAmount, UtilMoney.subtractToDouble(totalAmount, payAmount)) == 0){
							flag = true;
						}
					}
				}else if(orderType.equals(QuickOrderTypeEnum.COUPON.key()) && !Utils.isEmpty(entity.getCouponCode())){
					double couponAmount = couponService.useCoupon(entity.getCouponCode(), entity.getCustomerId(), entity.getTotalAmount(), entity.getShopId());//优惠金额
					if(UtilMoney.compareTo(discountAmount, couponAmount) == 0){
						payAmount = UtilMoney.subtractToDouble(totalAmount, discountAmount);
						flag = true;
					}
				}else{
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_ERROR);
				}
			}else{
				throw new BusinessException(LogManager.getLogger(this.getClass()),"商家暂不支持优惠买单方式...");
			}
		}else{
			flag = true;
		}
		if(flag){
			Integer payState;
			if(payAmount <= 0){
				payAmount = 0;
				payState = Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key());
			}else{
				payState = Integer.valueOf(PaymentStateEnum.STATE_PAYING.key());
			}
			
			QuickOrder order = new QuickOrder();
		    order.setOrderId(Utils.createChildOrderId(ConstantSystem.PAYMENT_NO_QUICK_PREFIX));
		    order.setShopId(entity.getShopId());
			order.setOpenId(entity.getOpenId());
			order.setOrderType(entity.getOrderType());
			if(orderType.equals(QuickOrderTypeEnum.COUPON.key())){
				order.setCouponCode(entity.getCouponCode());
			}
			order.setTotalAmount(totalAmount);
			order.setDiscountAmount(discountAmount);
			order.setPayAmount(payAmount);
			order.setPayType(entity.getPayType());
			order.setOrderFrom(entity.getOrderFrom());
			order.setPayState(payState);
			if(quickOrderService.add(order) > 0){
				return order;
			}
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ORDER_EXCEPTION);
		}else{
			throw new BusinessException(LogManager.getLogger(this.getClass()),"信息已过期...");
		}
	}
	
}
