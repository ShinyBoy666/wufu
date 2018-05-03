package cn.xinmeng.web.shop.entity.cart.vo;

import java.util.Date;

/**
 * 店铺优惠券
 * @param 
 * @ClassName: ShopCouponVo 
 * @version V1.0  
 * @date 2016年2月19日 下午4:56:53 
 * @author jiangyong.tan
 * @return 
 *
 */
public class ShopCouponVo {
    
	private int id;				//
	private int shopId;			//店铺ID
	private double couponMoney;	//优惠券金额
	private String couponName;	//优惠券名称
	private String description;	//描述
	private Date beginTime;		//开始时间
	private Date endTime;		//结束时间
	
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
