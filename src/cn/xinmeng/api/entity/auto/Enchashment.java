package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户提现记录表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:00
 */
public class Enchashment implements IEntity{

    private static final long serialVersionUID = 329864704594971587L;

    private Integer id; //主键
    private Integer accountType; //1、用户2、店铺3、代理商
    private Integer customerId; //客户编号
    private Integer enchashmentType; //1：支付宝2：微信3：银联
    private Double amount; //提现金额
    private String cellphone; //真实姓名
    private String realname; //真实姓名
    private String identityCard; //身份证号码
    private String bankCard; //银行卡号
    private String bankName; //银行名称
    private String bankBranch; //开户支行
    private String alipay; //支付宝账号
    private String wechat; //微信账号
    private String remark; //备注
    private Integer state; //1、审核中、2、审核通过 3、审核拒绝、4、打款失败 5、打款完成
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
	
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
    
    public Integer getAccountType() {
        return this.accountType;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setEnchashmentType(Integer enchashmentType) {
        this.enchashmentType = enchashmentType;
    }
    
    public Integer getEnchashmentType() {
        return this.enchashmentType;
    }
	
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getAmount() {
        return this.amount;
    }
	
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    
    public String getCellphone() {
        return this.cellphone;
    }
	
    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    public String getRealname() {
        return this.realname;
    }
	
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
    
    public String getIdentityCard() {
        return this.identityCard;
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
	
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    
    public String getWechat() {
        return this.wechat;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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