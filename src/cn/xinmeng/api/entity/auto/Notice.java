package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：消息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:22
 */
public class Notice implements IEntity{

    private static final long serialVersionUID = 593296317160995822L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private String coverImg; //封面图片
    private String title; //标题
    private String description; //描述
    private String content; //内容
    private Integer noticeType; //消息类型1、官方消息2、店铺消息
    private Integer linkType; //链接类型1、详细2、外网
    private String linkUrl; //链接地址
    private Integer readCount; //阅读数
    private Integer sort; //排序
    private Integer isTop; //置顶
    private Integer receive; //接收对象1、所有用户2、指定用户
    private Integer customerId; //用户编号
    private Integer state; //状态1、无效2、有效
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
	
    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }
    
    public String getCoverImg() {
        return Utils.getImageUrl(this.coverImg);
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
	
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return this.content;
    }
	
    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }
    
    public Integer getNoticeType() {
        return this.noticeType;
    }
	
    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }
    
    public Integer getLinkType() {
        return this.linkType;
    }
	
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
    }
	
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
    
    public Integer getReadCount() {
        return this.readCount;
    }
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
    }
	
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
    
    public Integer getIsTop() {
        return this.isTop;
    }
	
    public void setReceive(Integer receive) {
        this.receive = receive;
    }
    
    public Integer getReceive() {
        return this.receive;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
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