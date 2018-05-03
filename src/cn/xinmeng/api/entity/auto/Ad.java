package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：广告管理
 * @author jiangyong.tan
 * @date 2016-05-25 12:11:11
 */
public class Ad implements IEntity{

    private static final long serialVersionUID = 919116362767916683L;

    private Integer id; //编号
    private Integer provinceId; //省份编号
    private Integer shopId; //广告所属店铺id，0为全部app
    private Integer cityId; //城市编号
    private String adTitle; //标题
    private String imageUrl; //图片地址
    private String linkUrl; //链接地址
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer holdTime; //持续时间
    private Integer runInterval; //间隔
    private Integer deviceType; //0、全部1、IOS2、安卓
    private Integer sort; //排序
    private Integer state; //1、无效2、有效
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
	
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    
    public Integer getProvinceId() {
        return this.provinceId;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    
    public Integer getCityId() {
        return this.cityId;
    }
	
    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }
    
    public String getAdTitle() {
        return this.adTitle;
    }
	
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return Utils.getImageUrl(this.imageUrl);
    }
	
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
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
	
    public void setHoldTime(Integer holdTime) {
        this.holdTime = holdTime;
    }
    
    public Integer getHoldTime() {
        return this.holdTime;
    }
	
    public void setRunInterval(Integer runInterval) {
        this.runInterval = runInterval;
    }
    
    public Integer getRunInterval() {
        return this.runInterval;
    }
	
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }
    
    public Integer getDeviceType() {
        return this.deviceType;
    }
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
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