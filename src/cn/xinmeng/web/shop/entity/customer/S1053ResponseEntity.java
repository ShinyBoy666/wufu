package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 兑换优惠券
 * @param 
 * @ClassName: S1053ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1053ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = 276803916103086879L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private Integer useShopId; //使用店铺编号
    private Integer couponType; //1、纸质优惠券2、电子优惠券3、优惠卡4、现金券
    private Integer couponApplyId; //优惠券申请编号
    private String couponCode; //优惠券编号
    private Double couponMoney; //优惠券金额
    private Double orderMoney; //订单金额，满多少才能使用
    private Integer customerId; //用户编号
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    
    
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
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public Integer getCouponApplyId() {
		return couponApplyId;
	}
	public void setCouponApplyId(Integer couponApplyId) {
		this.couponApplyId = couponApplyId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public Double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
    
    
}
