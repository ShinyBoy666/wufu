package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 消息列表
 * @param 
 * @ClassName: S1052ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1052ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = 276803916103086879L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private String coverImg; //封面图片
    private String title; //标题
    private String description; //描述
    private Integer noticeType; //消息类型1、官方消息2、店铺消息3、订单消息
    private Integer linkType; //链接类型1、详细2、外网
    private String linkUrl; //链接地址
    private Integer readCount; //阅读数
    private Integer receive; //接收对象1、所有用户2、指定用户
    private Integer customerId; //用户编号
    private Integer state; //状态1、无效2、有效
    private java.util.Date createTime; //创建时间
    private String createUser;
    
    

	
	//set get
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	public Integer getLinkType() {
		return linkType;
	}
	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	public Integer getReceive() {
		return receive;
	}
	public void setReceive(Integer receive) {
		this.receive = receive;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
}
