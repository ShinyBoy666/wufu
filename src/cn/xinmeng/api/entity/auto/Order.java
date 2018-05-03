package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：订单表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:08
 */
public class Order implements IEntity{

    private static final long serialVersionUID = 336386539436088787L;

    private Integer id; //主键，自增长
    private String orderId; //订单编号
    private Integer shopId; //店铺编号
    private Integer customerId; //客户编号
    private String recipientName; //收件人姓名
    private String recipientPhone; //收件人电话
    private String recipientIdentityCard; //收件人身份证
    private String recipientAddress; //收件人地址
    private String zipCode; //邮政编码
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private Integer town; //乡镇
    private Double totalAmount; //订单总金额
    private Double accountPayment; //账户支付金额
    private Double onlinePayment; //在线支付金额
    private Integer onlinePayType; //在线支付方式1、支付宝2、微信3、银联
    private Double couponPayment; //优惠券支付金额
    private String couponCode; //优惠券编号
    private Double discountAmount; //订单优惠金额
    private Double payAmount; //实际成交金额（在线支付金额+账户支付金额-退货金额）
    private Double postage; //邮费
    private String remark; //备注
    private Integer orderType; //1、普通订单2、会员订单、3、团购4、砍价5、秒杀6、特价7、积分订单
    private Integer activityId; //活动编号
    private Integer orderFrom; //订单来源1、IOS2、安卓3、WAP
    private Integer orderState; //1、提交成功2、已超时3、已取消4、已删除5、待出库6、配送中7、已完成
    private Integer payState; //1、未支付2、支付中3、支付成功4、支付失败5、已退款
    private String logisticsName; //物流公司名称
    private String logisticsNumber; //物流单号
    private java.util.Date deliveryTime; //发货时间
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人
    private java.util.Date updateTime; //修改时间
    private String updateUser; //修改人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    
    public String getRecipientName() {
        return this.recipientName;
    }
	
    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }
    
    public String getRecipientPhone() {
        return this.recipientPhone;
    }
	
    public void setRecipientIdentityCard(String recipientIdentityCard) {
        this.recipientIdentityCard = recipientIdentityCard;
    }
    
    public String getRecipientIdentityCard() {
        return this.recipientIdentityCard;
    }
	
    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }
    
    public String getRecipientAddress() {
        return this.recipientAddress;
    }
	
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public String getZipCode() {
        return this.zipCode;
    }
	
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    
    public Integer getProvinceId() {
        return this.provinceId;
    }
	
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    
    public Integer getCityId() {
        return this.cityId;
    }
	
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
    
    public Integer getDistrictId() {
        return this.districtId;
    }
	
    public void setTown(Integer town) {
        this.town = town;
    }
    
    public Integer getTown() {
        return this.town;
    }
	
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public Double getTotalAmount() {
        return this.totalAmount;
    }
	
    public void setAccountPayment(Double accountPayment) {
        this.accountPayment = accountPayment;
    }
    
    public Double getAccountPayment() {
        return this.accountPayment;
    }
	
    public void setOnlinePayment(Double onlinePayment) {
        this.onlinePayment = onlinePayment;
    }
    
    public Double getOnlinePayment() {
        return this.onlinePayment;
    }
	
    public void setOnlinePayType(Integer onlinePayType) {
        this.onlinePayType = onlinePayType;
    }
    
    public Integer getOnlinePayType() {
        return this.onlinePayType;
    }
	
    public void setCouponPayment(Double couponPayment) {
        this.couponPayment = couponPayment;
    }
    
    public Double getCouponPayment() {
        return this.couponPayment;
    }
	
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
    
    public String getCouponCode() {
        return this.couponCode;
    }
	
    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    public Double getDiscountAmount() {
        return this.discountAmount;
    }
	
    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }
    
    public Double getPayAmount() {
        return this.payAmount;
    }
	
    public void setPostage(Double postage) {
        this.postage = postage;
    }
    
    public Double getPostage() {
        return this.postage;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
	
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
    
    public Integer getOrderType() {
        return this.orderType;
    }
	
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
    
    public Integer getActivityId() {
        return this.activityId;
    }
	
    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }
    
    public Integer getOrderFrom() {
        return this.orderFrom;
    }
	
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
    
    public Integer getOrderState() {
        return this.orderState;
    }
	
    public void setPayState(Integer payState) {
        this.payState = payState;
    }
    
    public Integer getPayState() {
        return this.payState;
    }
	
    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }
    
    public String getLogisticsName() {
        return this.logisticsName;
    }
	
    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }
    
    public String getLogisticsNumber() {
        return this.logisticsNumber;
    }
	
    public void setDeliveryTime(java.util.Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    public java.util.Date getDeliveryTime() {
        return this.deliveryTime;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
	
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
	
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
}