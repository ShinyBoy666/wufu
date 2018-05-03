package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：主页配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:04
 */
public class HomepageSetting implements IEntity{

    private static final long serialVersionUID = 858430997847813853L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private Integer modelId; //模板编号
    private String title; //模块标题
    private Integer type; //1、活动2、商品
    private String linkUrl; //链接地址
    private String imgUrl; //图片
    private Integer parentId; //父模块
    private Integer showType; //展现形式1、1张图片2、2张图片3、3张图片4、4张图片5、5张图片6、横排图片7、竖排图片
    private Integer sort; //排序
    private Integer state; //1=无效，2=有效
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
	
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
    
    public Integer getModelId() {
        return this.modelId;
    }
	
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
	
    public void setType(Integer type) {
        this.type = type;
    }
    
    public Integer getType() {
        return this.type;
    }
	
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
    }
	
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    public String getImgUrl() {
        return Utils.getImageUrl(this.imgUrl);
    }
	
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public Integer getParentId() {
        return this.parentId;
    }
	
    public void setShowType(Integer showType) {
        this.showType = showType;
    }
    
    public Integer getShowType() {
        return this.showType;
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