package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：门店信息表
 * @author jiangyong.tan
 * @date 2016-10-26 10:24:56
 */
public class ShopInfo implements IEntity{

    private static final long serialVersionUID = 839730589549281628L;

    private Integer id; //主键、自增长
    private String shopLogo; //店铺Logo
    private String shopName; //店铺名称
    private String shopDescription; //店铺描述
    private String shopPhone; //联系电话
    private String serverPhone; //客服电话
    private Integer agentId; //代理商编号
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private String shopAddress; //详细地址
    private Integer state; //状态1、待审核2、审核通过3、无效4、已到期
    private String shortUrl; //短链接
    private String qrCode; //二维码
    private String wxCode; //微信二维码
    private Double longitude; //经度
    private Integer supportGetui; //是否支持个推1、否2、是
    private Integer payType; //店铺支付支持方式1、不支持2、微信3、支付宝4、两者都支持
    private Double latitude; //纬度
    private String geoCode; //geo编码
    private Double cashAmount; //现金账户
    private Integer shopType; //店铺类别1、普通版2、微信版3、APP版
    private Integer productCategoryLevel; //商品类别层级1、一级2、二级3、三级
    private java.util.Date openTime; //开店时间
    private java.util.Date endTime; //到期时间
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
	
    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }
    
    public String getShopLogo() {
        return Utils.getImageUrl(this.shopLogo);
    }
	
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    
    public String getShopName() {
        return this.shopName;
    }
	
    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }
    
    public String getShopDescription() {
        return this.shopDescription;
    }
	
    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }
    
    public String getShopPhone() {
        return this.shopPhone;
    }
	
    public void setServerPhone(String serverPhone) {
        this.serverPhone = serverPhone;
    }
    
    public String getServerPhone() {
        return this.serverPhone;
    }
	
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }
    
    public Integer getAgentId() {
        return this.agentId;
    }
	
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    
    public Integer getProvinceId() {
        return this.provinceId;
    }
	
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    
    public Integer getCityId() {
        return this.cityId;
    }
	
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
    
    public Integer getDistrictId() {
        return this.districtId;
    }
	
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
    
    public String getShopAddress() {
        return this.shopAddress;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    
    public String getShortUrl() {
        return this.shortUrl;
    }
	
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    
    public String getQrCode() {
        return this.qrCode;
    }
	
    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }
    
    public String getWxCode() {
        return this.wxCode;
    }
	
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public Double getLongitude() {
        return this.longitude;
    }
	
    public void setSupportGetui(Integer supportGetui) {
        this.supportGetui = supportGetui;
    }
    
    public Integer getSupportGetui() {
        return this.supportGetui;
    }
	
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
    public Integer getPayType() {
        return this.payType;
    }
	
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    public Double getLatitude() {
        return this.latitude;
    }
	
    public void setGeoCode(String geoCode) {
        this.geoCode = geoCode;
    }
    
    public String getGeoCode() {
        return this.geoCode;
    }
	
    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }
    
    public Double getCashAmount() {
        return this.cashAmount;
    }
	
    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }
    
    public Integer getShopType() {
        return this.shopType;
    }
	
    public void setProductCategoryLevel(Integer productCategoryLevel) {
        this.productCategoryLevel = productCategoryLevel;
    }
    
    public Integer getProductCategoryLevel() {
        return this.productCategoryLevel;
    }
	
    public void setOpenTime(java.util.Date openTime) {
        this.openTime = openTime;
    }
    
    public java.util.Date getOpenTime() {
        return this.openTime;
    }
	
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    
    public java.util.Date getEndTime() {
        return this.endTime;
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