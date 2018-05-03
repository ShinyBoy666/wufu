package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：轮播图表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:05
 */
public class Banner implements IEntity{

    private static final long serialVersionUID = 235639253107980816L;

    private Integer id; //编号
    private Integer shopId; //店铺编号
    private Integer provinceId; //省份编号
    private Integer cityId; //城市编号
    private String title; //标题
    private String imageUrl; //图片地址
    private Integer showArea; //显示位置1、首页顶部
    private Integer showType; //1、商品详情2、H5页面
    private String objectId; //如果是详情则为商品ID，如果活动则为活动ID
    private String linkUrl; //链接地址
    private Integer sort; //排序（越大越靠前）
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
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
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
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
	
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
	
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return Utils.getImageUrl(this.imageUrl);
    }
	
    public void setShowArea(Integer showArea) {
        this.showArea = showArea;
    }
    
    public Integer getShowArea() {
        return this.showArea;
    }
	
    public void setShowType(Integer showType) {
        this.showType = showType;
    }
    
    public Integer getShowType() {
        return this.showType;
    }
	
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
    
    public String getObjectId() {
        return this.objectId;
    }
	
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
    }
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
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