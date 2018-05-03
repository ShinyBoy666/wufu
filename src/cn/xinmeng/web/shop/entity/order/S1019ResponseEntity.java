package cn.xinmeng.web.shop.entity.order;

import java.util.Date;
import java.util.List;

import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.order.vo.OrderProductVO;


/**
 * 我的订单详情
 * @param 
 * @ClassName: S1019ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午3:24:12 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1019ResponseEntity extends ResponseBaseEntity {
	
	private static final long serialVersionUID = 4038552910872488148L;
	

	private Integer customerId; //客户编号
    private String recipientName; //收件人姓名
    private String recipientPhone; //收件人电话
    private String recipientAddress; //收件人地址
    private String recipientProvinceName; //收件人省
    private String recipientCityName; //收件人市
    private String recipientDistrictName; //区
    private String parentOrderId; //父订单编号
    private Integer targetShopId; //所属店铺编号
	private String shopName = "舜凯云商";	//
	private String shopLogo;	//店铺图标
	private String childOrderId;//子订单编号
	private List<OrderProductVO> productList;	//商品List
    private Double discountAmount; //订单优惠金额
    private Double postage; //邮费
    private Double accountPayment; //账户支付金额
    private Double couponPayment; //优惠券支付金额
    private Double payAmount;	//实付金额
	private Double alreadyPaid;//已付款
    private String logisticsNumber;//物流单号
    private Double totalAmount; //订单总金额
    private Date createTime;//订单创建时间
	private int state;	//状态 1-待支付，2-待收货，3-已完成，4-已取消
	private String stateValue;	//状态值 1-待支付，2-待收货，3-已完成，4-已取消
	private boolean accountDeduct;//余额支付
    
    
	//set get
    
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getRecipientProvinceName() {
		return recipientProvinceName;
	}
	public void setRecipientProvinceName(String recipientProvinceName) {
		this.recipientProvinceName = recipientProvinceName;
	}
	public String getRecipientCityName() {
		return recipientCityName;
	}
	public void setRecipientCityName(String recipientCityName) {
		this.recipientCityName = recipientCityName;
	}
	public String getRecipientDistrictName() {
		return recipientDistrictName;
	}
	public void setRecipientDistrictName(String recipientDistrictName) {
		this.recipientDistrictName = recipientDistrictName;
	}
	public String getParentOrderId() {
		return parentOrderId;
	}
	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	public Integer getTargetShopId() {
		return targetShopId;
	}
	public void setTargetShopId(Integer targetShopId) {
		this.targetShopId = targetShopId;
	}
	public String getChildOrderId() {
		return childOrderId;
	}
	public void setChildOrderId(String childOrderId) {
		this.childOrderId = childOrderId;
	}
	public List<OrderProductVO> getProductList() {
		return productList;
	}
	public void setProductList(List<OrderProductVO> productList) {
		this.productList = productList;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Double getPostage() {
		return postage;
	}
	public void setPostage(Double postage) {
		this.postage = postage;
	}
	public Double getAccountPayment() {
		return accountPayment;
	}
	public void setAccountPayment(Double accountPayment) {
		this.accountPayment = accountPayment;
	}
	public Double getCouponPayment() {
		if(!Utils.isEmpty(discountAmount)){
			return UtilMoney.addToDouble(UtilMoney.doubleToZero(couponPayment), discountAmount);
		}
		return couponPayment;
	}
	public void setCouponPayment(Double couponPayment) {
		this.couponPayment = couponPayment;
	}
	public String getLogisticsNumber() {
		return logisticsNumber;
	}
	public void setLogisticsNumber(String logisticsNumber) {
		this.logisticsNumber = logisticsNumber;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateValue() {
		return stateValue;
	}
	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopLogo() {
		if(Utils.isEmpty(shopLogo)){
			return HelperPropertie.getValue("jipinhui.logo");
		}
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public Double getAlreadyPaid() {
		return UtilMoney.doubleToZero(accountPayment);
	}
	public void setAlreadyPaid(Double alreadyPaid) {
		this.alreadyPaid = alreadyPaid;
	}
	public boolean isAccountDeduct() {
		return accountDeduct;
	}
	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}
	
}
