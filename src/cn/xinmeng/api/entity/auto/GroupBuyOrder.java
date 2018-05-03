package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：团购订单表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
public class GroupBuyOrder implements IEntity{

    private static final long serialVersionUID = 251887922000606224L;

    private Integer id; //主键，自增长
    private Integer shopId; //店铺编号
    private String orderId; //订单编号
    private Integer activityId; //团购发起人编号
    private Integer originCustomerId; //团购发起人编号
    private Integer customerId; //客户编号
    private String recipientName; //收件人姓名
    private String recipientPhone; //收件人电话
    private String recipientAddress; //收件人地址
    private String zipCode; //邮政编码
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private Double totalAmount; //订单总金额
    private Double accountPayment; //账户支付金额
    private Double onlinePayment; //在线支付金额
    private Integer onlinePayType; //在线支付方式1、账户支付2、支付宝3、微信4、银联
    private String remark; //备注
    private Integer orderState; //1、未处理2、已处理
    private Integer payState; //1、未支付2、支付中3、已支付4、退款成功5、订单取消
    private Integer orderFrom; //订单来源1、IOS2、安卓3、WAP4、后台
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
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
    
    public Integer getActivityId() {
        return this.activityId;
    }
	
    public void setOriginCustomerId(Integer originCustomerId) {
        this.originCustomerId = originCustomerId;
    }
    
    public Integer getOriginCustomerId() {
        return this.originCustomerId;
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
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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
	
    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }
    
    public Integer getOrderFrom() {
        return this.orderFrom;
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