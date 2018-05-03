package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户详细信息表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:53
 */
public class CustomerDetail implements IEntity{

    private static final long serialVersionUID = 901135736543210155L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private String realname; //真实姓名
    private String email; //邮箱
    private String wechat; //微信号
    private String identityCard; //身份证号码
    private String qq; //QQ
    private String weibo; //微博
    private Integer deviceType; //1、未知2、苹果3、安卓4、WAP
    private Integer channelType; //默认为0
    private Integer channelId; //默认为0
    private String registerVersion; //注册版本号
    private java.util.Date lastLoginTime; //最后登录时间
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
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    public String getRealname() {
        return this.realname;
    }
	
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
	
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    
    public String getWechat() {
        return this.wechat;
    }
	
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
    
    public String getIdentityCard() {
        return this.identityCard;
    }
	
    public void setQq(String qq) {
        this.qq = qq;
    }
    
    public String getQq() {
        return this.qq;
    }
	
    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }
    
    public String getWeibo() {
        return this.weibo;
    }
	
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }
    
    public Integer getDeviceType() {
        return this.deviceType;
    }
	
    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }
    
    public Integer getChannelType() {
        return this.channelType;
    }
	
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
    
    public Integer getChannelId() {
        return this.channelId;
    }
	
    public void setRegisterVersion(String registerVersion) {
        this.registerVersion = registerVersion;
    }
    
    public String getRegisterVersion() {
        return this.registerVersion;
    }
	
    public void setLastLoginTime(java.util.Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public java.util.Date getLastLoginTime() {
        return this.lastLoginTime;
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