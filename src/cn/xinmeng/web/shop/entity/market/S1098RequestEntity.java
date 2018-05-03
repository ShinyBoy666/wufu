package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.PageSearchEntity;

public class S1098RequestEntity extends PageSearchEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6273967720106657019L;
	
	private Integer distanceType;				//距离：0-远距离在前，1-近距离在前
	private Integer popularityType;				//人气：0-人气高在前，1-低人气在后
	private Double couponMoney;				//金额
	private String orderId;					//订单id
	private Double longitude; 				//经度
    private Double latitude; 				//纬度
    private int distance = 5000000; 		//距离 单位：米
    private double orderMoney;
	public Integer getDistanceType() {
		return distanceType;
	}
	public void setDistanceType(Integer distanceType) {
		this.distanceType = distanceType;
	}
	public Integer getPopularityType() {
		return popularityType;
	}
	public void setPopularityType(Integer popularityType) {
		this.popularityType = popularityType;
	}
	public Double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	} 

    
}
