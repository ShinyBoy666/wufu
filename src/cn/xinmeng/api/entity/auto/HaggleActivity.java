package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：砍价活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
public class HaggleActivity implements IEntity{

    private static final long serialVersionUID = 306746683138379863L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private String title; //活动标题
    private String description; //活动描述
    private String imageUrl; //活动图片
    private java.util.Date showTime; //展示时间
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer isFreePostage; //是否包邮1、不包邮2、包邮
    private Double postage; //邮费
    private Integer state; //1、无效2、有效
    private Integer sort; //排序
    private Double highPrice; //随机最高价
    private Double lowPrice; //随机最低价
    private Integer haggleNumber; //每人可参与次数
    private Double degression; //每次降低比例
    private Integer pattern; //发起人购买模式=1,参与人购买模式=2
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
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
    }
	
    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }
    
    public Double getHighPrice() {
        return this.highPrice;
    }
	
    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }
    
    public Double getLowPrice() {
        return this.lowPrice;
    }
	
    public void setHaggleNumber(Integer haggleNumber) {
        this.haggleNumber = haggleNumber;
    }
    
    public Integer getHaggleNumber() {
        return this.haggleNumber;
    }
	
    public void setDegression(Double degression) {
        this.degression = degression;
    }
    
    public Double getDegression() {
        return this.degression;
    }
	
    public void setPattern(Integer pattern) {
        this.pattern = pattern;
    }
    
    public Integer getPattern() {
        return this.pattern;
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