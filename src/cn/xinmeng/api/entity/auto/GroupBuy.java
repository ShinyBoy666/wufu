package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：团购活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:06
 */
public class GroupBuy implements IEntity{

    private static final long serialVersionUID = 135250913958941641L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private String title; //活动标题
    private String description; //活动描述
    private String imageUrl; //活动图片
    private Integer groupLmt; //每个团购限制人数
    private java.util.Date showTime; //展示时间
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer sort; //排序
    private Integer isFreePostage; //是否包邮1、不包邮2、包邮
    private Double postage; //邮费
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
	
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
	
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
	
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return this.imageUrl;
    }
	
    public void setGroupLmt(Integer groupLmt) {
        this.groupLmt = groupLmt;
    }
    
    public Integer getGroupLmt() {
        return this.groupLmt;
    }
	
    public void setShowTime(java.util.Date showTime) {
        this.showTime = showTime;
    }
    
    public java.util.Date getShowTime() {
        return this.showTime;
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
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
    }
	
    public void setIsFreePostage(Integer isFreePostage) {
        this.isFreePostage = isFreePostage;
    }
    
    public Integer getIsFreePostage() {
        return this.isFreePostage;
    }
	
    public void setPostage(Double postage) {
        this.postage = postage;
    }
    
    public Double getPostage() {
        return this.postage;
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