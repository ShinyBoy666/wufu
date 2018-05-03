package cn.xinmeng.web.shop.entity.cart.vo;

import java.util.Date;

/**
 * 我在店铺可用优惠券
 * @param 
 * @ClassName: ShopCustCouponVo 
 * @version V1.0  
 * @date 2016年2月19日 下午4:56:53 
 * @author jiangyong.tan
 * @return 
 *
 */
public class ShopCustCouponVo {
	
	private int shopId;					//领取店铺ID
	private int useShopId;				//使用店铺id
	private String useShopName;			//使用店铺名称
	private String useShopLogo;			//使用店铺logo
	private int customerId;				//客户编号
	private double couponMoney;			//优惠券金额
	private String couponCode;			//优惠券编码
	private String couponName;			//优惠券名称
	private String description;			//描述
	private Date beginTime;				//开始时间
	private Date endTime;				//结束时间
	private int state;					//状态，1-未使用，2－已使用，3-已过期
	private String stateValue;			//状态，1-未使用，2－已使用，3-已过期
	
	
	//set get
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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
	public int getUseShopId() {
		return useShopId;
	}
	public void setUseShopId(int useShopId) {
		this.useShopId = useShopId;
	}
	public String getUseShopName() {
		return useShopName;
	}
	public void setUseShopName(String useShopName) {
		this.useShopName = useShopName;
	}
	public String getUseShopLogo() {
		return useShopLogo;
	}
	public void setUseShopLogo(String useShopLogo) {
		this.useShopLogo = useShopLogo;
	}
	
	
	
}