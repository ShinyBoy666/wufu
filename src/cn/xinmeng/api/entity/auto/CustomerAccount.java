package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户账户信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:48
 */
public class CustomerAccount implements IEntity{

    private static final long serialVersionUID = 478651477834711268L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private Integer accountType; //1、用户2、店铺
    private String realname; //真实姓名
    private String bankCard; //银行卡号
    private String bankName; //银行名称
    private String bankBranch; //开户支行
    private String alipay; //支付宝账号
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
	
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
    
    public Integer getAccountType() {
        return this.accountType;
    }
	
    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    public String getRealname() {
        return this.realname;
    }
	
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }
    
    public String getBankCard() {
        return this.bankCard;
    }
	
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public String getBankName() {
        return this.bankName;
    }
	
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }
    
    public String getBankBranch() {
        return this.bankBranch;
    }
	
    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }
    
    public String getAlipay() {
        return this.alipay;
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