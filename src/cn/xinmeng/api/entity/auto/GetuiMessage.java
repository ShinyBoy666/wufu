package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：推送消息表
 * @author jiangyong.tan
 * @date 2016-06-17 19:55:06
 */
public class GetuiMessage implements IEntity{

    private static final long serialVersionUID = 423175008535209785L;

    private Integer id; //主键
    private String title; //标题
    private String description; //描述
    private Integer showType; //1、APP打开2、弹框3、页面跳转
    private Integer sendType; //1、普通订单推送，2、优惠买单订单推送3、消息推送
    private String urlLink; //链接地址
    private Integer receiveType; //1、普通用户2、店铺管理员
    private String receiveObject; //接收对象
    private Integer whetherSend; //1、即时推送2、定时推送
    private java.util.Date sendTime; //推送时间
    private Integer sendStatus; //1、待审核，2、审核通过，3、审核拒绝，4、已推送，5、推送失败
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
	
    public void setShowType(Integer showType) {
        this.showType = showType;
    }
    
    public Integer getShowType() {
        return this.showType;
    }
	
    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }
    
    public Integer getSendType() {
        return this.sendType;
    }
	
    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }
    
    public String getUrlLink() {
        return this.urlLink;
    }
	
    public void setReceiveType(Integer receiveType) {
        this.receiveType = receiveType;
    }
    
    public Integer getReceiveType() {
        return this.receiveType;
    }
	
    public void setReceiveObject(String receiveObject) {
        this.receiveObject = receiveObject;
    }
    
    public String getReceiveObject() {
        return this.receiveObject;
    }
	
    public void setWhetherSend(Integer whetherSend) {
        this.whetherSend = whetherSend;
    }
    
    public Integer getWhetherSend() {
        return this.whetherSend;
    }
	
    public void setSendTime(java.util.Date sendTime) {
        this.sendTime = sendTime;
    }
    
    public java.util.Date getSendTime() {
        return this.sendTime;
    }
	
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
    
    public Integer getSendStatus() {
        return this.sendStatus;
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