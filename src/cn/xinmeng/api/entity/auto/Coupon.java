package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：优惠券表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:59
 */
public class Coupon implements IEntity{

    private static final long serialVersionUID = 991797501795899011L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private Integer couponType; //1、纸质优惠券2、电子优惠券3、优惠卡4、现金券
    private Integer couponApplyId; //优惠券申请编号
    private String couponCode; //优惠券编号
    private Double couponMoney; //优惠券金额
    private Double orderMoney; //订单金额，满多少才能使用
    private Integer customerId; //用户编号
    private java.util.Date addTime; //添加时间
    private java.util.Date useTime; //使用时间
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer state; //1、未领用；2、已领用，3、已使用4、无效
    private java.util.Date createTime; //创建时间

	
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
	
    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }
    
    public Integer getCouponType() {
        return this.couponType;
    }
	
    public void setCouponApplyId(Integer couponApplyId) {
        this.couponApplyId = couponApplyId;
    }
    
    public Integer getCouponApplyId() {
        return this.couponApplyId;
    }
	
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
    
    public String getCouponCode() {
        return this.couponCode;
    }
	
    public void setCouponMoney(Double couponMoney) {
        this.couponMoney = couponMoney;
    }
    
    public Double getCouponMoney() {
        return this.couponMoney;
    }
	
    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }
    
    public Double getOrderMoney() {
        return this.orderMoney;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setAddTime(java.util.Date addTime) {
        this.addTime = addTime;
    }
    
    public java.util.Date getAddTime() {
        return this.addTime;
    }
	
    public void setUseTime(java.util.Date useTime) {
        this.useTime = useTime;
    }
    
    public java.util.Date getUseTime() {
        return this.useTime;
    }
	
    public void setBeginTime(java.util.Date beginTime) {
        this.beginTime = beginTime;
    }
    
    public java.util.Date getBeginTime() {
        return this.beginTime;
    }
	
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    
    public java.util.Date getEndTime() {
        return this.endTime;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}