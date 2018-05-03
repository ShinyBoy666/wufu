package cn.xinmeng.web.shop.entity.order;

import cn.xinmeng.web.base.entity.RequestBaseEntity;


/**
 * 快速下单
 * @param 
 * @ClassName: S1022RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1022RequestEntity extends RequestBaseEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private Integer orderFrom;				//订单来源
	private Integer addressId;				//收货地址id
	private Integer onlinePayType;			//在线支付方式：1：支付宝2：微信3：银联
	private boolean accountDeduct;			//是否账户扣款

	private String couponCode;				//优惠券编码
	private Integer productId;				//商品id
    private Integer productPriceId; 			//商品编号
	private String sku;						//sku
	private Integer productNumber;			//商品数量
	private Integer activityId;				//活动订单
	private Integer activityType;			//活动类型
	private String recipientIdentityCard;	//收件人身份证
	private String realyname;				//身份证名称
	private String seatNumber; //座位号
	
	//set get
	
	public Integer getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getOnlinePayType() {
		return onlinePayType;
	}

	public void setOnlinePayType(Integer onlinePayType) {
		this.onlinePayType = onlinePayType;
	}

	public boolean isAccountDeduct() {
		return accountDeduct;
	}

	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getActivityType() {
		return activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

	public Integer getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}

	public String getRecipientIdentityCard() {
		return recipientIdentityCard;
	}

	public void setRecipientIdentityCard(String recipientIdentityCard) {
		this.recipientIdentityCard = recipientIdentityCard;
	}

	public String getRealyname() {
		return realyname;
	}

	public void setRealyname(String realyname) {
		this.realyname = realyname;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
}
