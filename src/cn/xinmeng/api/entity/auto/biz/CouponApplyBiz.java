package cn.xinmeng.api.entity.auto.biz;

import cn.xinmeng.common.entity.IEntity;

/**
 * 优惠券
 * @param 
 * @ClassName: CouponApplyBiz 
 * @version V1.0  
 * @date 2016年2月23日 下午2:32:43 
 * @author jiangyong.tan
 * @return 
 *
 */
public class CouponApplyBiz implements IEntity{

    private static final long serialVersionUID = 954232087746595554L;
    
    private Integer id; //主键
    private Integer shopId; //店铺编号
    private Integer useShopId; //使用店铺编号
    private String couponName; //优惠券名称
    private String couponDesc; //优惠券描述
    private Integer couponType; //1、纸质优惠券2、电子优惠券3、优惠卡4、现金券
    private Integer categoryId; //分类id
    private Double couponMoney; //优惠券金额
    private Integer couponNumber; //优惠券数量
    private Integer couponReceiveNumber; //优惠券已领用数量
    private Double orderMoney; //订单金额，满多少才能使用
    private Integer expiresModel; //有效期模式1、固定有效期2、领取日开始计算
    private Integer expiresDays; //有效期天数
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer isCreate; //是否预生成1、否2、是
    private String remark; //备注
    private Integer state; //状态1、无效2、待确认3、已拒绝4、有效5、已生成
    
    //set get
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getUseShopId() {
		return useShopId;
	}
	public void setUseShopId(Integer useShopId) {
		this.useShopId = useShopId;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCouponDesc() {
		return couponDesc;
	}
	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public Integer getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Integer couponNumber) {
		this.couponNumber = couponNumber;
	}
	public Integer getCouponReceiveNumber() {
		return couponReceiveNumber;
	}
	public void setCouponReceiveNumber(Integer couponReceiveNumber) {
		this.couponReceiveNumber = couponReceiveNumber;
	}
	public Double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public Integer getExpiresModel() {
		return expiresModel;
	}
	public void setExpiresModel(Integer expiresModel) {
		this.expiresModel = expiresModel;
	}
	public Integer getExpiresDays() {
		return expiresDays;
	}
	public void setExpiresDays(Integer expiresDays) {
		this.expiresDays = expiresDays;
	}
	public java.util.Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	public Integer getIsCreate() {
		return isCreate;
	}
	public void setIsCreate(Integer isCreate) {
		this.isCreate = isCreate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

    
}