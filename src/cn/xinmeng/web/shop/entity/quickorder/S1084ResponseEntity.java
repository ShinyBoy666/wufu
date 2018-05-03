package cn.xinmeng.web.shop.entity.quickorder;

import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.enums.QuickOrderTypeEnum;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;


/**
 * 我的订单查询
 * @param 
 * @ClassName: S1018ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:59:44 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1084ResponseEntity extends ResponseBaseEntity {

	private static final long serialVersionUID = 5262480240079496315L;

	private String orderId; //订单编号
	private String openId; //客户openId
	private Integer shopId; //店铺编号
	private String shopName;//店铺名称
	private String shopLogo;//店铺logo
	private String nickname;
	private String heardImage;
	private Integer orderType; //订单类型1、随机立减2、满减3、折扣买单4、优惠券买单
	private String orderTypeValue;//订单类型1、随机立减2、满减3、折扣买单4、优惠券买单
	private String couponCode; //多张优惠券用"|"线隔开
	private Double totalAmount; //订单总金额
	private Double discountAmount; //订单优惠金额
	private Double payAmount; //实际成交金额
	private Integer payType; //支付方式1、账户支付2、支付宝3、微信4、银联
	private String remark; //备注
	private Integer payState; //1、未支付2、支付中3、支付成功4、支付失败
	private String payStateValue; //1、未支付2、支付中3、支付成功4、支付失败
	private java.util.Date createTime; //创建时间
	


	//set get

	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getPayState() {
		return payState;
	}
	public void setPayState(Integer payState) {
		this.payState = payState;
	}
	public String getPayStateValue() {
		return PaymentStateEnum.keyToValue(payState+"");
	}
	public void setPayStateValue(String payStateValue) {
		this.payStateValue = payStateValue;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public String getOrderTypeValue() {
		return QuickOrderTypeEnum.keyToValue(orderType+"");
	}
	public void setOrderTypeValue(String orderTypeValue) {
		this.orderTypeValue = orderTypeValue;
	}
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeardImage() {
		return heardImage;
	}
	public void setHeardImage(String heardImage) {
		this.heardImage = heardImage;
	}
	
}
