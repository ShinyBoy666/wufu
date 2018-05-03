package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.xinmeng.api.constant.ConstantSystem;
import cn.xinmeng.api.dao.auto.CustomerRechargeDao;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.enums.ConsumTypeEnum;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.enums.RechargeStateEnum;
import cn.xinmeng.api.enums.ScoreConsumTypeEnum;
import cn.xinmeng.api.service.IAccountService;
import cn.xinmeng.api.service.ICustomerRechargeService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IGetuiMessageService;
import cn.xinmeng.api.service.IOrderProductProfitService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IPaymentService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.IWechatAccountService;
import cn.xinmeng.api.thread.GetuiThread;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;
import cn.xinmeng.web.shop.entity.order.vo.ResponseOrderBiz;

/**
 * 支付服务
 * @param 
 * @ClassName: PaymentServiceImpl 
 * @version V1.0  
 * @date 2016年2月25日 上午11:32:57 
 * @author jiangyong.tan
 * @return 
 *
 */
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private ICustomerRechargeService customerRechargeService;
	@Resource
	private IAccountService accountService;
	@Resource
	private IOrderService orderService;
	@Resource
	private CustomerRechargeDao customerRechargeDao;
	@Resource
	private IOrderProductProfitService orderProductProfitService;
	@Resource
	private TaskExecutor sendMessageThreadPool;
	@Resource
	private IGetuiMessageService getuiMessageService;
	@Resource
	private IQuickOrderService quickOrderService;
	@Resource
	private IWechatAccountService wechatAccountService;
	@Resource
	private IShopInfoService shopInfoService;
	
	/**
	 *  订单支付
	 * @author jiangyong.tan
	 * @date 2016年2月25日 上午11:39:47
	 * @param order
	 */
	public ResponseOrderBiz payOrder(PayOrderBiz payOrderBiz,String source,Integer shopId,String ip){
		
		//返回对象信息
		ResponseOrderBiz biz = new ResponseOrderBiz();
		biz.setOrderId(payOrderBiz.getParentOrderId());
		biz.setTotalAmount(payOrderBiz.getTotalAmount());
		biz.setSource(source);
		if(PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(payOrderBiz.getPayState()+"")){
			return biz;
		}
		/**
		 * 第一步：计算支付金额
		 * 支付金额  == 订单总额 - 优惠券总额 - 订单优惠金额 + 邮费
		 */
		Double noPayment = UtilMoney.getNoPayment(payOrderBiz.getTotalAmount(), payOrderBiz.getPostage(), 
												  payOrderBiz.getDiscountAmount(), payOrderBiz.getCouponPayment(),payOrderBiz.getPaidAccountPayment());
		

		//在线支付方式
		String onlinePayType = String.valueOf(payOrderBiz.getOnlinePayType());
		//是否余额支付
		boolean accountDeduct = payOrderBiz.isAccountDeduct();
		//订单号
		String parentOrderId = payOrderBiz.getParentOrderId();
		
		/**
		 * 第二步：判断那种支付方式
		 */
		if(accountDeduct && (PaymentGatewayEnum.exist(onlinePayType) == false)){
			/**
			 * 第二步：第一种，只有余额支付
			 */
			//扣除余额，分配到不同店主账户
			accountService.accountDeductToShop(payOrderBiz.getParentOrderId(), noPayment,true,0);
			//返回
			biz.setDeductAmount(noPayment);
			return biz;
		}else if((accountDeduct == false) && PaymentGatewayEnum.exist(onlinePayType)){
			/**
			 * 第二步：第二种，只有在线支付
			 */
			//修改订单支付中
			orderService.updateOrderAccountPaymentAndPayState(payOrderBiz.getParentOrderId(), 0.00, PaymentStateEnum.STATE_PAYING,payOrderBiz.getOnlinePayType());
			//返回
			CustomerRecharge recharge = onlinePayRecharge(payOrderBiz, parentOrderId, noPayment);
			biz.setRechargeId(recharge.getRechargeId());
			biz.setPaymentAmount(recharge.getAmount());
			biz.setUrl(recharge.getRechargeType()+"",shopId,ip);
			return biz;
		}else if(accountDeduct && PaymentGatewayEnum.exist(onlinePayType)){
			/**
			 * 第二步：第三种，余额支付和在线一起支付
			 */
			//扣除余额，分配到不同店主账户
			Double deductAmount = accountService.accountDeductToShop(payOrderBiz.getParentOrderId(), noPayment,false,payOrderBiz.getOnlinePayType());
			if(UtilMoney.compareTo(deductAmount, noPayment) == 0){
				//扣除余额，分配到不同店主账户
				biz.setDeductAmount(noPayment);
				return biz;
			}else{
				//现金账户：不够，生成在线支付金额
				Double onlinePay = UtilMoney.subtractToDouble(noPayment, deductAmount);
				CustomerRecharge recharge = onlinePayRecharge(payOrderBiz, parentOrderId, onlinePay);
				biz.setRechargeId(recharge.getRechargeId());
				biz.setPaymentAmount(recharge.getAmount());
				biz.setUrl(recharge.getRechargeType()+"",shopId,ip);
				return biz;
			}
		}
		throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_PAY_WAY);
	}
	
	/**
	 *  生成支付工单 
	 * @author jiangyong.tan
	 * @date 2016年3月2日 下午12:03:21
	 * @param payOrderBiz
	 * @param parentOrderId
	 * @param amount
	 * @return
	 */
	public CustomerRecharge onlinePayRecharge(PayOrderBiz payOrderBiz,String parentOrderId,Double amount){
		List<Integer> stateList = new ArrayList<Integer>();
		stateList.add(1);//有效
		stateList.add(2);//成功
		String fieldList = "recharge_id,amount,state,recharge_type";
		List<CustomerRecharge> list = customerRechargeService.queryCustomerRechargeByOrderId(parentOrderId, stateList, fieldList);
		
		if(list != null && list.size() > 0){
			//支付成功，抛出异常
			for (CustomerRecharge recharge : list) {
				if(RechargeStateEnum.STATE_SUCCESS.key().equals(recharge.getState()+"")){
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_ORDER_YES_PAY); 
				}
			}
			if(!Utils.isEmpty(list.get(0).getRechargeId())
				&& list.get(0).getRechargeType().intValue() == payOrderBiz.getOnlinePayType().intValue() 
				&& UtilMoney.compareTo(list.get(0).getAmount(), amount) == 0){
				return list.get(0);
			}
			
			//价格或支付方式不一样，重置无效
			for (CustomerRecharge recharge : list) {
				//修改支付工单为无效，因为支付价格不一致
				customerRechargeService.updateCustomerRechargeState(recharge.getId(), Integer.valueOf(RechargeStateEnum.STATE_FAILURED.key()));
			}
		}
		return add(payOrderBiz, amount);
	}
	
	/**
	 *  生成支付工单
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午4:00:19
	 * @param order
	 * @param onlinePay
	 * @return
	 */
	private CustomerRecharge add(PayOrderBiz payOrderBiz,Double onlinePay){
		CustomerRecharge recharge = new CustomerRecharge();
		recharge.setAmount(onlinePay);
		recharge.setCustomerId(payOrderBiz.getCustomerId());
		recharge.setCustomerName(customerService.queryCustomerNameById(payOrderBiz.getCustomerId()));
		recharge.setOrderId(payOrderBiz.getParentOrderId());
		recharge.setRechareFrom(payOrderBiz.getOrderFrom());
		recharge.setRechargeId(Utils.getRechargePrefix(payOrderBiz.getParentOrderId()) + Utils.createNumber(recharge.getCustomerId()));
		recharge.setRechargeType(payOrderBiz.getOnlinePayType());
		recharge.setState(Integer.valueOf(RechargeStateEnum.STATE_VALID.key()));
		recharge.setTradeNo("");
		customerRechargeService.add(recharge);
		return recharge;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String payReturn(CustomerRecharge customerRecharge,String tradeNumber,Double amount) {
		String message = null;
		
		boolean flag = false;
		if(amount.doubleValue() == customerRecharge.getAmount().doubleValue()){
			flag = true;
		}
		//更新回执流水号
		CustomerRecharge recharge = new CustomerRecharge();
		recharge.setUpdateTime(new Date());
		recharge.setTradeNo(tradeNumber);
		recharge.setState(Integer.valueOf(RechargeStateEnum.STATE_SUCCESS.key()));
		recharge.setId(customerRecharge.getId());
		recharge.setAmount(amount);
		customerRechargeDao.updateSelectiveByPrimaryKey(recharge);
		
		if(flag){
			//订单充值
			if(!Utils.isEmpty(customerRecharge.getRechargeId()) && 
					customerRecharge.getRechargeId().startsWith(ConstantSystem.PAYMENT_NO_RECHARGE_PREFIX)){//充值
				accountService.accountRecharge(customerRecharge.getCustomerId(), customerRecharge.getAmount(), ConsumTypeEnum.TYPE_56, customerRecharge.getRechargeId());
			}else if(!Utils.isEmpty(customerRecharge.getRechargeId()) && 
					customerRecharge.getRechargeId().startsWith(ConstantSystem.PAYMENT_NO_VIP_PREFIX)){
				//会员充值
				Customer customer = customerService.selectByPrimaryKey(customerRecharge.getCustomerId());
				if(customer == null){
					message = ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS.value();
				}
				Order order = orderService.queryByOrderId(customerRecharge.getOrderId(), null);
				if(order == null){
					message = ExOrderEnum.EX_NOTEXIST_ORDER.value();
				}else{
					if(customerService.isMember(customer)){
						//已经是会员，则把订单钱充值到帐户余额
						message =  ExOrderEnum.EX_ERROR_ORDER_STATE.value();
						//订单所有金额，不只是在线支付金额
						accountService.accountRecharge(customerRecharge.getCustomerId(), order.getPayAmount(), ConsumTypeEnum.TYPE_56, customerRecharge.getOrderId());
					}else{
						//修改订单状态
						//更新订单支付状态信息
						orderService.updatePayStateByOrderId(order.getOrderId(), Integer.parseInt(PaymentStateEnum.STATE_PAY_SUCCESS.key()),customerRecharge.getAmount());
						//支付成功，进行利润拆分
						orderProductProfitService.nemberMerchandiseDistribution(order,customerRecharge.getAmount());
					}
				}
			}else if(!Utils.isEmpty(customerRecharge.getRechargeId()) && 
					customerRecharge.getRechargeId().startsWith(ConstantSystem.PAYMENT_NO_PRODUCT_PREFIX)){
			}else if(!Utils.isEmpty(customerRecharge.getRechargeId()) && 
					customerRecharge.getRechargeId().startsWith(ConstantSystem.PAYMENT_NO_QUICK_PREFIX)) {
				QuickOrder order = quickOrderService.queryByOrderId(customerRecharge.getOrderId());
				if(order != null){
					order.setPayState(Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
					order.setUpdateTime(new Date());
					//更新订单状态
					quickOrderService.updateByPrimaryKey(order);
					
					/** 推送通知 */
					sendMessageThreadPool.execute(new GetuiThread(order, getuiMessageService,accountService,wechatAccountService,shopInfoService));
				}
			}else{//正常订单
				Order order = orderService.queryByOrderId(customerRecharge.getOrderId(), null);
				if(order == null){
					message = ExOrderEnum.EX_NOTEXIST_ORDER.value();
				}else{
					if(!OrderStateEnum.STATE_SUCCESS.key().equals(order.getOrderState()+"") || !PaymentStateEnum.STATE_PAYING.key().equals(order.getPayState()+"")){
						message =  ExOrderEnum.EX_ERROR_ORDER_STATE.value();
						//订单信息异常 钱充值到账户余额
						accountService.accountRecharge(customerRecharge.getCustomerId(), customerRecharge.getAmount(), ConsumTypeEnum.TYPE_56, customerRecharge.getOrderId());
					}else{
						//更新订单支付状态信息
						orderService.updatePayStateByOrderId(order.getOrderId(), Integer.parseInt(PaymentStateEnum.STATE_PAY_SUCCESS.key()),customerRecharge.getAmount());
						//支付成功，订单商品，进行利润拆分
						orderProductProfitService.merchandiseDistribution(order);
						//增加客户积分
						accountService.addScore(order.getCustomerId(), order.getPayAmount().intValue(), ScoreConsumTypeEnum.TYPE_3, order.getOrderId());
						/** 推送通知 */
						sendMessageThreadPool.execute(new GetuiThread(order, getuiMessageService));
					}
				}
			}
		}
		return message;
	}

	@Override
	public ResponseOrderBiz payQuickOrder(QuickOrder order, String source,
			Integer shopId, String ip,Integer customerId) {
		//返回对象信息
		ResponseOrderBiz biz = new ResponseOrderBiz();
		biz.setOrderId(order.getOrderId());
		biz.setTotalAmount(order.getTotalAmount());
		biz.setSource(source);
		String payState = order.getPayState()+"";
		if(PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(payState)){
			/** 推送通知 */
			sendMessageThreadPool.execute(new GetuiThread(order, getuiMessageService,accountService,wechatAccountService,shopInfoService));
			return biz;
		}
		if(order.getPayType() == 1){//余额支付 
			//账户扣款
			accountService.completeAccountDeduct(customerId, order.getPayAmount(), ConsumTypeEnum.TYPE_56, order.getOrderId());
			//返回
			biz.setDeductAmount(order.getPayAmount());
			
			order.setPayState(Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
			order.setUpdateTime(new Date());
			//更新订单状态
			quickOrderService.updateSelectiveByPrimaryKey(order);
			
			/** 推送通知 */
			sendMessageThreadPool.execute(new GetuiThread(order, getuiMessageService,accountService,wechatAccountService,shopInfoService));
			return biz;
		}else{
			int onlinePayType = order.getPayType()-1;
			if(PaymentGatewayEnum.exist(onlinePayType+"")){
				//返回
				CustomerRecharge recharge = new CustomerRecharge();
				recharge.setAmount(order.getPayAmount());
				recharge.setCustomerId(0);
				recharge.setCustomerName("");
				recharge.setOrderId(order.getOrderId());
				recharge.setRechareFrom(order.getOrderFrom());
				recharge.setRechargeId(Utils.getRechargePrefix(order.getOrderId()) + Utils.createNumber(recharge.getCustomerId()));
				recharge.setRechargeType(onlinePayType);
				recharge.setState(Integer.valueOf(RechargeStateEnum.STATE_VALID.key()));
				recharge.setTradeNo("");
				customerRechargeService.add(recharge);
				
				biz.setRechargeId(recharge.getRechargeId());
				biz.setPaymentAmount(recharge.getAmount());
				biz.setUrl(recharge.getRechargeType()+"",shopId,ip);
				return biz;
			}
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_PAYMENT_TYPE);
		}
	}

}
