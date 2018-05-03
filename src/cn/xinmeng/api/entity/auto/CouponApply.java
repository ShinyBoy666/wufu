package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：优惠券申请表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:00
 */
public class CouponApply implements IEntity{

    private static final long serialVersionUID = 495758280340642078L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private String couponName; //优惠券名称
    private String couponDesc; //优惠券描述
    private Integer couponType; //1、纸质优惠券2、电子优惠券3、优惠卡4、现金券
    private Integer firstId; //第一级ID
    private Integer secondId; //第二级ID
    private Integer thridId; //第三级ID
    private Double couponMoney; //优惠券金额
    private Integer couponNumber; //优惠券数量
    private Integer couponReceiveNumber; //优惠券已领用数量
    private Integer maxGetNumber; //每人可领张数
    private Integer maxUseNumber; //每次可使用张数
    private Double orderMoney; //订单金额，满多少才能使用
    private String canUseDay; //每个星期哪几天才能使用，用"|"线隔开
    private String canUseHour; //每天几点到几点才能使用，开始时间结束时间直接用"|"线隔开
    private Integer expiresModel; //有效期模式1、固定有效期2、领取日开始计算
    private Integer expiresDays; //有效期天数
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer isCreate; //是否预生成1、否2、是
    private String remark; //备注
    private Integer state; //状态1、无效2、有效3、已生成
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
	
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
    
    public String getCouponName() {
        return this.couponName;
    }
	
    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc;
    }
    
    public String getCouponDesc() {
        return this.couponDesc;
    }
	
    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }
    
    public Integer getCouponType() {
        return this.couponType;
    }
	
    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }
    
    public Integer getFirstId() {
        return this.firstId;
    }
	
    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }
    
    public Integer getSecondId() {
        return this.secondId;
    }
	
    public void setThridId(Integer thridId) {
        this.thridId = thridId;
    }
    
    public Integer getThridId() {
        return this.thridId;
    }
	
    public void setCouponMoney(Double couponMoney) {
        this.couponMoney = couponMoney;
    }
    
    public Double getCouponMoney() {
        return this.couponMoney;
    }
	
    public void setCouponNumber(Integer couponNumber) {
        this.couponNumber = couponNumber;
    }
    
    public Integer getCouponNumber() {
        return this.couponNumber;
    }
	
    public void setCouponReceiveNumber(Integer couponReceiveNumber) {
        this.couponReceiveNumber = couponReceiveNumber;
    }
    
    public Integer getCouponReceiveNumber() {
        return this.couponReceiveNumber;
    }
	
    public void setMaxGetNumber(Integer maxGetNumber) {
        this.maxGetNumber = maxGetNumber;
    }
    
    public Integer getMaxGetNumber() {
        return this.maxGetNumber;
    }
	
    public void setMaxUseNumber(Integer maxUseNumber) {
        this.maxUseNumber = maxUseNumber;
    }
    
    public Integer getMaxUseNumber() {
        return this.maxUseNumber;
    }
	
    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }
    
    public Double getOrderMoney() {
        return this.orderMoney;
    }
	
    public void setCanUseDay(String canUseDay) {
        this.canUseDay = canUseDay;
    }
    
    public String getCanUseDay() {
        return this.canUseDay;
    }
	
    public void setCanUseHour(String canUseHour) {
        this.canUseHour = canUseHour;
    }
    
    public String getCanUseHour() {
        return this.canUseHour;
    }
	
    public void setExpiresModel(Integer expiresModel) {
        this.expiresModel = expiresModel;
    }
    
    public Integer getExpiresModel() {
        return this.expiresModel;
    }
	
    public void setExpiresDays(Integer expiresDays) {
        this.expiresDays = expiresDays;
    }
    
    public Integer getExpiresDays() {
        return this.expiresDays;
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
	
    public void setIsCreate(Integer isCreate) {
        this.isCreate = isCreate;
    }
    
    public Integer getIsCreate() {
        return this.isCreate;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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