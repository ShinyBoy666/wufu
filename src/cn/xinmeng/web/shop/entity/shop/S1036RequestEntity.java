package cn.xinmeng.web.shop.entity.shop;


import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.PageSearchEntity;

public class S1036RequestEntity extends PageSearchEntity{

	
	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午3:59:12
	 */ 
	private static final long serialVersionUID = 2100647678153538511L;
	
    private Double longitude; //经度
    private Double latitude; //纬度
    private int sortType; //排序类型   0:距离由近到远   1:距离（近到远）  2:销量（高到低）   3:入住时间（近到远）   
    private Integer distance = 5000000; //距离 单位：米
    private Integer currentShopId; //登录店铺id
    
    private String shopName;//店铺名称
    
	public Double getLongitude() {
		//以海创基地为中心
		if(Utils.isEmpty(longitude)){
			return 120.219558;
		}
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		//以海创基地为中心
		if(Utils.isEmpty(latitude)){
			return 30.259929;
		}
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public int getSortType() {
		return sortType;
	}
	public void setSortType(int sortType) {
		this.sortType = sortType;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getCurrentShopId() {
		return currentShopId;
	}
	public void setCurrentShopId(Integer currentShopId) {
		this.currentShopId = currentShopId;
	}
}
