package cn.xinmeng.web.shop.entity.quickorder;

import cn.xinmeng.web.base.entity.RequestBaseEntity;


/**
 * 
 * @author Administrator
 *
 */
public class S1093RequestEntity extends RequestBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5705706828825229013L;
	
    private int orderType; //订单类型1、随机立减2、满减3、折扣买单4、优惠券买单
    private String couponCode; //多张优惠券用"|"线隔开
    private double totalAmount; //订单总金额
    private double discountAmount; //订单优惠金额
    private int payType;                //支付方式1、账户支付2、支付宝3、微信4、银联
    private int orderFrom;          //订单来源1、IOS2、安卓3、WAP
    
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public int getOrderFrom() {
		return orderFrom;
	}
	public void setOrderFrom(int orderFrom) {
		this.orderFrom = orderFrom;
	}
}
