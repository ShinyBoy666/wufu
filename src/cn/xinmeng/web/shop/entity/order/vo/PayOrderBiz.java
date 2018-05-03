package cn.xinmeng.web.shop.entity.order.vo;

import cn.xinmeng.api.constant.ConstantSystem;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 订单费用实体
 * @param 
 * @ClassName: PayOrderVo 
 * @version V1.0  
 * @date 2016年3月1日 下午2:09:43 
 * @author jiangyong.tan
 * @return 
 *
 */
public class PayOrderBiz extends ResponseBaseEntity {
	private static final long serialVersionUID = -2031980179646157787L;
	
//	pay_amount = account_payment（账户支付） + online_payment（在线支付）;
	
//	pay_amount = total_amount（订单总额） + postage（邮费） - discount_amount（折扣） - coupon_amount（优惠券）;
	
	private Integer orderFrom;				//订单来源标志
	private Integer customerId;				//客户ID
	private Integer onlinePayType;			//在线支付方式
	
	private String parentOrderId;		//订单编号
	private double paymentAmount;		//支付金额  = 订单总金额 + 邮费 - 折扣金额 - 优惠券金额
	private double onlinePayment;		//在线支付金额
    private double accountPayment; 		//账户支付金额
    
    
	private double totalAmount;			//订单总金额
	private double discountAmount;		//折扣金额
	private double couponPayment;		//优惠券金额
	private double postage;				//邮费


	private boolean accountDeduct;		//是否账户扣款
	private double paidAccountPayment;	//已经账户支付金额
	
	private String rechargePrefix;	//充值前缀单号
	
	private Integer payState;// 订单支付状态
	
	//set get
	
	public double getPaymentAmount() {
		return paymentAmount;
	}

	public Integer getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getOnlinePayType() {
		return onlinePayType;
	}

	public void setOnlinePayType(Integer onlinePayType) {
		this.onlinePayType = onlinePayType;
	}

	public String getParentOrderId() {
		return parentOrderId;
	}

	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}

	public double getOnlinePayment() {
		return onlinePayment;
	}

	public void setOnlinePayment(double onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public double getAccountPayment() {
		return accountPayment;
	}

	public void setAccountPayment(double accountPayment) {
		this.accountPayment = accountPayment;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getCouponPayment() {
		return couponPayment;
	}

	public void setCouponPayment(double couponPayment) {
		this.couponPayment = couponPayment;
	}

	public double getPostage() {
		return postage;
	}

	public void setPostage(double postage) {
		this.postage = postage;
	}

	public boolean isAccountDeduct() {
		return accountDeduct;
	}

	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}

	public double getPaidAccountPayment() {
		return paidAccountPayment;
	}

	public void setPaidAccountPayment(double paidAccountPayment) {
		this.paidAccountPayment = paidAccountPayment;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getRechargePrefix() {
		if(Utils.isEmpty(rechargePrefix)){
			return ConstantSystem.PAYMENT_NO_GENERAL_PREFIX;
		}
		return rechargePrefix;
	}

	public void setRechargePrefix(String rechargePrefix) {
		this.rechargePrefix = rechargePrefix;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}
}
