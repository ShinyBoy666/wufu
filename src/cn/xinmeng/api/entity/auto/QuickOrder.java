package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：优惠买单订单表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:12
 */
public class QuickOrder implements IEntity{

    private static final long serialVersionUID = 695988512205338953L;

    private Integer id; //主键，自增长
    private String orderId; //订单编号
    private Integer shopId; //店铺编号
    private String openId; //客户openId
    private Integer orderType; //订单类型1、随机立减2、满减3、折扣买单4、优惠券买单
    private String couponCode; //多张优惠券用"|"线隔开
    private Double totalAmount; //订单总金额
    private Double discountAmount; //订单优惠金额
    private Double payAmount; //实际成交金额
    private Integer payType; //支付方式1、账户支付2、支付宝3、微信4、银联
    private Double receiveCouponAmount; //优惠券领取金额
    private String remark; //备注
    private Integer orderFrom; //订单来源1、IOS2、安卓3、WAP
    private Integer payState; //1、未支付2、支付中3、支付成功4、支付失败
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
	
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    public String getOpenId() {
        return this.openId;
    }
	
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
    
    public Integer getOrderType() {
        return this.orderType;
    }
	
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
    
    public String getCouponCode() {
        return this.couponCode;
    }
	
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public Double getTotalAmount() {
        return this.totalAmount;
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
	
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
    public Integer getPayType() {
        return this.payType;
    }
	
    public void setReceiveCouponAmount(Double receiveCouponAmount) {
        this.receiveCouponAmount = receiveCouponAmount;
    }
    
    public Double getReceiveCouponAmount() {
        return this.receiveCouponAmount;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
	
    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }
    
    public Integer getOrderFrom() {
        return this.orderFrom;
    }
	
    public void setPayState(Integer payState) {
        this.payState = payState;
    }
    
    public Integer getPayState() {
        return this.payState;
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