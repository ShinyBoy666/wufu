package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：短信表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:33
 */
public class Sms implements IEntity{

    private static final long serialVersionUID = 849074995066074642L;

    private Integer id; //主键
    private String shopId; //店铺编号
    private Integer customerId; //客户编号
    private String receivePhone; //接收手机号
    private String smsCode; //如发送短信验证码，短信代码就是短信验证码
    private String smsContent; //短信内容
    private Integer fromType; //短信来源1、API2、后台3、Windows服务
    private Integer state; //1、未发送2、已发送3、发送失败
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
    
    public String getShopId() {
        return this.shopId;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }
    
    public String getReceivePhone() {
        return this.receivePhone;
    }
	
    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
    
    public String getSmsCode() {
        return this.smsCode;
    }
	
    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }
    
    public String getSmsContent() {
        return this.smsContent;
    }
	
    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }
    
    public Integer getFromType() {
        return this.fromType;
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
}