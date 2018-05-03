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
import cn.xinmeng.api.dao.ex.ExAccountDao;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerAmountDetail;
import cn.xinmeng.api.entity.auto.CustomerScoreDetail;
import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.OrderProductProfit;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.enums.AccountTypeEnum;
import cn.xinmeng.api.enums.ConsumTypeEnum;
import cn.xinmeng.api.enums.ExpendIncomeEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.enums.ProfitLevelEnum;
import cn.xinmeng.api.enums.ScoreConsumTypeEnum;
import cn.xinmeng.api.service.IAccountService;
import cn.xinmeng.api.service.ICustomerAmountDetailService;
import cn.xinmeng.api.service.ICustomerScoreDetailService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IGetuiMessageService;
import cn.xinmeng.api.service.IOrderProductProfitService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.ISystemErrorLogService;
import cn.xinmeng.api.thread.AccountAmountDetailThread;
import cn.xinmeng.api.thread.AccountScoreDetailThread;
import cn.xinmeng.api.thread.GetuiThread;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;


@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Resource
	private ICustomerService customerService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private ExAccountDao exAccountDao;
	@Resource
	private ICustomerAmountDetailService customerAmountDetailService;
	@Resource
	private ICustomerScoreDetailService customerScoreDetailService;
	@Resource
	private TaskExecutor amountDetailThreadPool;
	@Resource
	private TaskExecutor scoreDetailThreadPool;
	@Resource
	private IOrderProductProfitService orderProductProfitService;
	@Resource
	private ISystemErrorLogService systemErrorLogService;
	@Resource
	private TaskExecutor orderProductProfitThreadPool;
	@Resource
	private TaskExecutor sendMessageThreadPool;
	@Resource
	private IGetuiMessageService getuiMessageService;

	/**
	 *  账户扣款，均分到店铺账户
	 * @author jiangyong.tan
	 * @date 2016年3月1日 下午4:18:18
	 * @param parentOrderId
	 * @param changeAmount
	 */
	public Double accountDeductToShop(String orderId,Double orderPayAmount,boolean fullPayment,Integer onlinePayType){
		if(UtilMoney.compareTo(orderPayAmount, 0.00) == 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_CHANGE_AMOUNT_ZERO);
		}
		String orderFieldList = "customer_id,order_id,shop_id,total_amount,coupon_payment,discount_amount,postage,pay_amount";
		Order order = orderService.queryByOrderId(orderId, orderFieldList);
		if(order == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
		}
		//客户编号
		Integer customerId = order.getCustomerId();
		//用户资金流水
		List<CustomerAmountDetail> list = new ArrayList<CustomerAmountDetail>();
		/**
		 * 查询客户信息
		 */
		String fieldList = "id,nickname,cash_amount";
		Customer customer = customerService.queryCustomerById(customerId, fieldList);
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		
		//帐户扣款金额
		Double deductAmount = orderPayAmount;
		/**
		 * 第一步：客户帐户扣款
		 */
		if(fullPayment){//全额支付
			//余额不足
			if(UtilMoney.compareTo(customer.getCashAmount(), orderPayAmount) < 0){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_CASH);
			}
			//客户现金账户扣款
			int rows = exAccountDao.custAccountSub(customerId, orderPayAmount);
			if(rows == 0){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_CASH);
			}
		}else{
			if(Utils.isEmpty(customer.getCashAmount())){//余额为0 
				deductAmount = 0.0;
				orderService.updateOrderAccountPaymentAndPayState(orderId, deductAmount, PaymentStateEnum.STATE_PAYING,onlinePayType);
				return deductAmount;
			}
			//帐户扣款，有多少口多少
			if(UtilMoney.compareTo(customer.getCashAmount(), orderPayAmount) < 0){
				deductAmount = customer.getCashAmount();
			}
			//客户现金账户扣款
			int rows = exAccountDao.custAccountSub(customerId, deductAmount);
			if(rows == 0){
				throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_CASH);
			}
		}

		PaymentStateEnum payState = null;//支付状态
		if(UtilMoney.compareTo(deductAmount, orderPayAmount) == 0){
			//全额支付
			payState = PaymentStateEnum.STATE_PAY_SUCCESS;
		}else{
			//部分支付
			payState = PaymentStateEnum.STATE_PAYING;
		}
		
		Date currDate = new Date();
		
		//客户（支出）：客户流水记录
		CustomerAmountDetail cust = new CustomerAmountDetail();
		cust.setAccountType(Integer.valueOf(AccountTypeEnum.USER.key()));//用户
		cust.setAmount(deductAmount);
		cust.setConsumType(Integer.valueOf(ConsumTypeEnum.TYPE_56.key()));
		cust.setCreateTime(currDate);
		cust.setCreateUser(Utils.createUser);
		cust.setCustomerId(customerId);
		cust.setCustomerName(customer.getNickname());
		cust.setNowMoney(UtilMoney.subtractToDouble(customer.getCashAmount(), deductAmount));
		cust.setOldMoney(customer.getCashAmount());
		cust.setOrderId(orderId);
		cust.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_EXPEND.key()));//支出
		String remark = (orderId != null) ? "-订单编号："+orderId:"";
		cust.setRemark(ConsumTypeEnum.TYPE_56.value()+remark);
		list.add(cust);
		
		orderService.updateOrderAccountPaymentAndPayState(orderId, deductAmount, payState,onlinePayType);
		
		//线程添加
		amountDetailThreadPool.execute(new AccountAmountDetailThread(customerAmountDetailService, list));
		if(PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(payState.key())){
			//支付成功，订单商品，进行利润拆分
			if(orderId.startsWith(ConstantSystem.PAYMENT_NO_VIP_PREFIX)){
				//会员
				orderProductProfitService.nemberMerchandiseDistribution(order,null);
			}else{
				//普通商品
				orderProductProfitService.merchandiseDistribution(order);
				
				//增加客户积分
				addScore(customerId, order.getPayAmount().intValue(), ScoreConsumTypeEnum.TYPE_3, orderId);
			}
			/** 推送通知 */
			sendMessageThreadPool.execute(new GetuiThread(order, getuiMessageService));
		}
		
		return deductAmount;
	}
	
	/**
	 * 
	 * <p class="detail"> 账户扣款 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月1日 下午2:34:04
	 * @param customerId
	 * @param changeAmount
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void completeAccountDeduct(Integer customerId,Double changeAmount,ConsumTypeEnum consumTypeEnum,String orderId){
		//只有余额支付
		String fieldList = "id,nickname,cash_amount";
		Customer customer = customerService.queryCustomerById(customerId, fieldList);
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		
		//余额不足
		if(UtilMoney.compareTo(customer.getCashAmount(), changeAmount) < 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_CASH);
		}
		
		//客户现金账户扣款
		int rows = exAccountDao.custAccountSub(customerId, changeAmount);
		if(rows == 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_CASH);
		}
		
		Date currDate = new Date();
		String optUser = "API";
		
		//客户（支出）：客户流水记录
		CustomerAmountDetail cust = new CustomerAmountDetail();
		cust.setAccountType(Integer.valueOf(AccountTypeEnum.USER.key()));//用户
		cust.setAmount(changeAmount);
		cust.setConsumType(Integer.valueOf(consumTypeEnum.key()));
		cust.setCreateTime(currDate);
		cust.setCreateUser(optUser);
		cust.setCustomerId(customerId);
		cust.setCustomerName(customer.getNickname());
		cust.setNowMoney(UtilMoney.subtractToDouble(customer.getCashAmount(), changeAmount));
		cust.setOldMoney(customer.getCashAmount());
		cust.setOrderId(orderId);
		cust.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_EXPEND.key()));//支出
		String remark = (orderId != null) ? "-订单编号："+orderId:"";
		cust.setRemark(consumTypeEnum.value()+remark);
		
		//资金流水集合
		List<CustomerAmountDetail> list = new ArrayList<CustomerAmountDetail>();
		list.add(cust);
		
		//线程添加
		amountDetailThreadPool.execute(new AccountAmountDetailThread(customerAmountDetailService, list));
	}
	
	/**
	 * 店铺扣减
	 * @param shopId
	 * @param changeAmount
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void shopCompleteAccountDeduct(Integer shopId, Double changeAmount,ConsumTypeEnum consumTypeEnum, String orderId) {
		ShopInfo shopInfo = shopInfoService.queryShopInfoById(shopId, "id,shop_name,cash_amount");
		if(shopInfo == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExShopEnum.EX_NOTEXISTS_SHOP);
		}
		//店铺账户充值
		int rows = exAccountDao.shopAccountSub(shopId, changeAmount);
		if(rows == 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_RECHARE);
		}
		
		Date currDate = new Date();
		String optUser = "API";
		
		CustomerAmountDetail shopAmount = new CustomerAmountDetail();
		shopAmount.setAccountType(Integer.valueOf(AccountTypeEnum.SHOP.key()));//店铺
		shopAmount.setAmount(changeAmount);
		shopAmount.setCreateTime(currDate);
		shopAmount.setCreateUser(optUser);
		shopAmount.setCustomerId(shopInfo.getId());
		shopAmount.setCustomerName(shopInfo.getShopName());
		shopAmount.setNowMoney(UtilMoney.subtractToDouble(shopInfo.getCashAmount(), changeAmount));
		shopAmount.setOldMoney(shopInfo.getCashAmount());
		shopAmount.setOrderId(orderId);
		shopAmount.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_EXPEND.key()));//
		shopAmount.setConsumType(Integer.valueOf(consumTypeEnum.key()));
		String remark = (orderId != null) ? "-订单编号："+orderId:"";
		shopAmount.setRemark(consumTypeEnum.value()+remark);

		//资金流水集合
		List<CustomerAmountDetail> list = new ArrayList<CustomerAmountDetail>();
		list.add(shopAmount);
		
		//线程添加
		amountDetailThreadPool.execute(new AccountAmountDetailThread(customerAmountDetailService, list));
	}
	
	/**
	 * 
	 * <p class="detail"> 充值</p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月10日 上午11:29:06
	 * @param customerId
	 * @param changeAmount
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void accountRecharge(Integer customerId,Double changeAmount,ConsumTypeEnum consumTypeEnum,String orderId){
		//只有余额支付
		String fieldList = "id,nickname,cash_amount";
		Customer customer = customerService.queryCustomerById(customerId, fieldList);
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		//客户现金账户充值
		int rows = exAccountDao.custAccountAdd(customerId, changeAmount);
		if(rows == 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_RECHARE);
		}
		
		Date currDate = new Date();
		String optUser = "API";
		
		//客户（收入）：客户流水记录
		CustomerAmountDetail cust = new CustomerAmountDetail();
		cust.setAccountType(Integer.valueOf(AccountTypeEnum.USER.key()));//用户
		cust.setAmount(changeAmount);
		cust.setConsumType(Integer.valueOf(consumTypeEnum.key()));
		cust.setCreateTime(currDate);
		cust.setCreateUser(optUser);
		cust.setCustomerId(customerId);
		cust.setCustomerName(customer.getNickname());
		cust.setNowMoney(UtilMoney.addToDouble(customer.getCashAmount(), changeAmount));
		cust.setOldMoney(customer.getCashAmount());
		cust.setOrderId(orderId);
		cust.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_INCOME.key()));//收入
		String remark = (orderId != null) ? "-订单编号："+orderId:"";
		cust.setRemark(consumTypeEnum.value()+remark);
		
		//资金流水集合
		List<CustomerAmountDetail> list = new ArrayList<CustomerAmountDetail>();
		list.add(cust);
		
		//线程添加
		amountDetailThreadPool.execute(new AccountAmountDetailThread(customerAmountDetailService, list));
	}

	
			
	/**
	 * 给推荐用户，推荐店铺，货款店铺加金额
	 * @param listProfit
	 */
	public void orderProductProfit(List<OrderProductProfit> listProfit){
		if(listProfit == null || listProfit.size() == 0){
			return ;
		}
		List<CustomerAmountDetail> list = new ArrayList<CustomerAmountDetail>();

		//添加店铺流水
		Date currDate = new Date();
		for (OrderProductProfit orderProductProfit : listProfit) {
			if(orderProductProfit.getAccountType() == 2){
				//店铺
				Integer shopId = orderProductProfit.getCustomerId();
				Double amount = UtilMoney.multiplyToDouble(orderProductProfit.getCustomerAward(), orderProductProfit.getProductNumber());
				int rows = exAccountDao.shopAccountAdd(shopId, amount);
				if(rows == 0){
					throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_SHOP_ACCOUNT_DEDUCT);
				}

				//店铺货款/推荐奖励
				ShopInfo subShopInfo = shopInfoService.queryShopInfoById(shopId, "id,shop_name,cash_amount");
				if(subShopInfo == null){
					throw new BusinessException(LogManager.getLogger(this.getClass()), ExShopEnum.EX_NOTEXISTS_SHOP);
				}
				
				String optUser = "API";
				CustomerAmountDetail shopAmount = new CustomerAmountDetail();
				shopAmount.setAccountType(Integer.valueOf(AccountTypeEnum.SHOP.key()));//店铺
				shopAmount.setAmount(amount);
				shopAmount.setCreateTime(currDate);
				shopAmount.setCreateUser(optUser);
				shopAmount.setCustomerId(subShopInfo.getId());
				shopAmount.setCustomerName(subShopInfo.getShopName());
				shopAmount.setNowMoney(subShopInfo.getCashAmount());
				shopAmount.setOldMoney(UtilMoney.subtractToDouble(subShopInfo.getCashAmount(), amount));
				shopAmount.setOrderId(orderProductProfit.getOrderId());
				shopAmount.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_INCOME.key()));//
				if(ProfitLevelEnum.profit_shop.key().equals(orderProductProfit.getProfitLevel()+"")){
					shopAmount.setConsumType(Integer.valueOf(ConsumTypeEnum.TYPE_2.key()));
					shopAmount.setRemark(ConsumTypeEnum.TYPE_2.value()+"-订单编号："+orderProductProfit.getOrderId());
				}else{
					shopAmount.setConsumType(Integer.valueOf(ConsumTypeEnum.TYPE_9.key()));
					shopAmount.setRemark(ConsumTypeEnum.TYPE_9.value()+"-订单编号："+orderProductProfit.getOrderId());
				}
				list.add(shopAmount);
				
			}else{
				//用户
				Integer customerId = orderProductProfit.getCustomerId();
				Double amount = UtilMoney.multiplyToDouble(orderProductProfit.getCustomerAward(), orderProductProfit.getProductNumber());
				int rows = exAccountDao.custAccountAdd(customerId, amount);
				if(rows == 0){
					throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_CASH);
				}

				//享有分利用户
				String fieldList = "id,nickname,cash_amount";
				Customer customer = customerService.queryCustomerById(customerId, fieldList);
				if(customer == null){
					throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
				}

				//客户（收入）：客户流水记录
				CustomerAmountDetail cust = new CustomerAmountDetail();
				cust.setAccountType(Integer.valueOf(AccountTypeEnum.USER.key()));//用户
				cust.setAmount(amount);
				cust.setConsumType(Integer.valueOf(ConsumTypeEnum.TYPE_4.key()));
				cust.setCreateTime(currDate);
				cust.setCreateUser("API");
				cust.setCustomerId(customerId);
				cust.setOrderId(orderProductProfit.getOrderId());
				cust.setCustomerName(customer.getNickname());
				cust.setNowMoney(customer.getCashAmount());
				cust.setOldMoney(UtilMoney.subtractToDouble(customer.getCashAmount(), amount));
				cust.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_INCOME.key()));//收入
				cust.setRemark(ConsumTypeEnum.TYPE_4.value()+"-订单编号："+orderProductProfit.getOrderId());
				list.add(cust);
			}
		}
		//线程添加
		amountDetailThreadPool.execute(new AccountAmountDetailThread(customerAmountDetailService, list));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void shopRecharge(Integer shopId, Double changeAmount,ConsumTypeEnum consumTypeEnum, String orderId) {
		ShopInfo shopInfo = shopInfoService.queryShopInfoById(shopId, "id,shop_name,cash_amount");
		if(shopInfo == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExShopEnum.EX_NOTEXISTS_SHOP);
		}
		//店铺账户充值
		int rows = exAccountDao.shopAccountAdd(shopId, changeAmount);
		if(rows == 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_RECHARE);
		}
		
		Date currDate = new Date();
		String optUser = "API";
		
		CustomerAmountDetail shopAmount = new CustomerAmountDetail();
		shopAmount.setAccountType(Integer.valueOf(AccountTypeEnum.SHOP.key()));//店铺
		shopAmount.setAmount(changeAmount);
		shopAmount.setCreateTime(currDate);
		shopAmount.setCreateUser(optUser);
		shopAmount.setCustomerId(shopInfo.getId());
		shopAmount.setCustomerName(shopInfo.getShopName());
		shopAmount.setNowMoney(UtilMoney.addToDouble(shopInfo.getCashAmount(), changeAmount));
		shopAmount.setOldMoney(shopInfo.getCashAmount());
		shopAmount.setOrderId(orderId);
		shopAmount.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_INCOME.key()));//
		shopAmount.setConsumType(Integer.valueOf(consumTypeEnum.key()));
		shopAmount.setRemark(consumTypeEnum.value()+"-订单编号："+orderId);
		
		/**
		 * 资金流水
		 * ##必须保证和金额同时变更,快速买单没有别的地方记录订单是否处理过##
		 */
		customerAmountDetailService.add(shopAmount);
	}

	@Override
	public void addScore(Integer customerId, Integer score,
			ScoreConsumTypeEnum consumTypeEnum, String orderId) {
		if(Utils.isEmpty(score)){
			return;
		}
		String fieldList = "id,nickname,score_amount";
		Customer customer = customerService.queryCustomerById(customerId, fieldList);
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		//增加客户积分
		int rows = exAccountDao.addScore(customerId, score);
		if(rows == 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_SCORE_RECHARE);
		}
		
		Date currDate = new Date();
		//客户积分（收入）：客户流水记录
		CustomerScoreDetail cust = new CustomerScoreDetail();
		cust.setScore(score);
		cust.setConsumType(Integer.valueOf(consumTypeEnum.key()));
		cust.setCreateTime(currDate);
		cust.setCreateUser(Utils.createUser);
		cust.setCustomerId(customerId);
		cust.setCustomerName(customer.getNickname());
		cust.setNowScore(customer.getScoreAmount()+score);
		cust.setOldScore(customer.getScoreAmount());
		cust.setOrderId(orderId);
		cust.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_INCOME.key()));//收入
		String remark = (orderId != null) ? "-订单编号："+orderId:"";
		cust.setRemark(consumTypeEnum.value()+remark);
		//资金流水集合
		List<CustomerScoreDetail> list = new ArrayList<CustomerScoreDetail>();
		list.add(cust);
		
		//线程添加
		scoreDetailThreadPool.execute(new AccountScoreDetailThread(customerScoreDetailService, list));
	}

	@Override
	public void subScore(Integer customerId, Integer score,
			ScoreConsumTypeEnum consumTypeEnum, String orderId) {
		if(Utils.isEmpty(score)){
			return;
		}
		String fieldList = "id,nickname,score_amount";
		Customer customer = customerService.queryCustomerById(customerId, fieldList);
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		//积分不足
		if(customer.getScoreAmount() < score){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_SCORE);
		}
		//减少客户积分
		int rows = exAccountDao.subScore(customerId, score);
		if(rows == 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExPaymentEnum.EX_ERROR_EXTRACT_SCORE);
		}
		
		Date currDate = new Date();
		//客户积分（收入）：客户流水记录
		CustomerScoreDetail cust = new CustomerScoreDetail();
		cust.setScore(score);
		cust.setConsumType(Integer.valueOf(consumTypeEnum.key()));
		cust.setCreateTime(currDate);
		cust.setCreateUser(Utils.createUser);
		cust.setCustomerId(customerId);
		cust.setCustomerName(customer.getNickname());
		cust.setNowScore(customer.getScoreAmount()-score);
		cust.setOldScore(customer.getScoreAmount());
		cust.setOrderId(orderId);
		cust.setPaymentType(Integer.valueOf(ExpendIncomeEnum.IE_EXPEND.key()));//收入
		String remark = (orderId != null) ? "-订单编号："+orderId:"";
		cust.setRemark(consumTypeEnum.value()+remark);
		//资金流水集合
		List<CustomerScoreDetail> list = new ArrayList<CustomerScoreDetail>();
		list.add(cust);
		
		//线程添加
		scoreDetailThreadPool.execute(new AccountScoreDetailThread(customerScoreDetailService, list));
	}
}
