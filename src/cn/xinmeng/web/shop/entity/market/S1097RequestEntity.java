package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 秒杀商品列表
 * @param 
 * @ClassName: S1070RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1097RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String orderId;
	private Double longitude; 				//经度
    private Double latitude; 				//纬度
    private int distance = 5000000; 		//距离 单位：米

	//set get

	
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
	
}
