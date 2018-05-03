package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.List;

import cn.xinmeng.common.util.Utils;

public class ShopInfoVo implements Serializable{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午6:29:53
	 */ 
	private static final long serialVersionUID = 2561419911167581433L;
	
	private Integer id; //主键、自增长
    private String shopName; //店铺名称
    private String shopDescription; //店铺描述
    private String shopPhone; //联系电话
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private String shopAddress; //详细地址
    private String shortUrl; //短链接
    private String qrCode; //二维码
    private Double longitude; //经度
    private Double latitude; //纬度
    private Double distance;//距离 单位:m
    private String logo; //logo
    private String shopImage = ""; //店铺形象照
    private String bossImage = ""; //老板形象照
    private List<String> categoryList; //店铺经营种类名称集合
    private List<ProductInfoVo> productInfoList;//商品集合
    private String wifiName; //wifi用户名
    private String wifiPassword; //wifi密码
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopDescription() {
		return shopDescription;
	}
	public void setShopDescription(String shopDescription) {
		this.shopDescription = shopDescription;
	}
	public String getShopPhone() {
		return shopPhone;
	}
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
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
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getLogo() {
		return Utils.getImageUrl(logo);
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	public List<ProductInfoVo> getProductInfoList() {
		return productInfoList;
	}
	public void setProductInfoList(List<ProductInfoVo> productInfoList) {
		this.productInfoList = productInfoList;
	}
	public String getShopImage() {
		return shopImage;
	}
	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}
	public String getBossImage() {
		return bossImage;
	}
	public void setBossImage(String bossImage) {
		this.bossImage = bossImage;
	}
	public String getWifiName() {
		return wifiName;
	}
	public void setWifiName(String wifiName) {
		this.wifiName = wifiName;
	}
	public String getWifiPassword() {
		return wifiPassword;
	}
	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}
}
