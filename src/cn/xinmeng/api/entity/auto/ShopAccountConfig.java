package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：店铺账户配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:25
 */
public class ShopAccountConfig implements IEntity{

    private static final long serialVersionUID = 509386205031253143L;

    private Integer id; //主键、自增长
    private Integer shopId; //店铺编号
    private String wechatpayAppId; //公众号id
    private String wechatpaySignType; //微信签名方式
    private String wechatpaySign; //微信签名
    private String alipayPid; //支付宝PID
    private String alipayKey; //支付宝Key
    private String alipayAccount; //企业支付宝账号
    private String getuiAccount; //个推账号
    private String getuiPassword; //个推密码
    private String shareAccount; //分享账号
    private String sharePassword; //分享密码
    private Integer state; //状态1、无效3、有效
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
	
    public void setWechatpayAppId(String wechatpayAppId) {
        this.wechatpayAppId = wechatpayAppId;
    }
    
    public String getWechatpayAppId() {
        return this.wechatpayAppId;
    }
	
    public void setWechatpaySignType(String wechatpaySignType) {
        this.wechatpaySignType = wechatpaySignType;
    }
    
    public String getWechatpaySignType() {
        return this.wechatpaySignType;
    }
	
    public void setWechatpaySign(String wechatpaySign) {
        this.wechatpaySign = wechatpaySign;
    }
    
    public String getWechatpaySign() {
        return this.wechatpaySign;
    }
	
    public void setAlipayPid(String alipayPid) {
        this.alipayPid = alipayPid;
    }
    
    public String getAlipayPid() {
        return this.alipayPid;
    }
	
    public void setAlipayKey(String alipayKey) {
        this.alipayKey = alipayKey;
    }
    
    public String getAlipayKey() {
        return this.alipayKey;
    }
	
    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }
    
    public String getAlipayAccount() {
        return this.alipayAccount;
    }
	
    public void setGetuiAccount(String getuiAccount) {
        this.getuiAccount = getuiAccount;
    }
    
    public String getGetuiAccount() {
        return this.getuiAccount;
    }
	
    public void setGetuiPassword(String getuiPassword) {
        this.getuiPassword = getuiPassword;
    }
    
    public String getGetuiPassword() {
        return this.getuiPassword;
    }
	
    public void setShareAccount(String shareAccount) {
        this.shareAccount = shareAccount;
    }
    
    public String getShareAccount() {
        return this.shareAccount;
    }
	
    public void setSharePassword(String sharePassword) {
        this.sharePassword = sharePassword;
    }
    
    public String getSharePassword() {
        return this.sharePassword;
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