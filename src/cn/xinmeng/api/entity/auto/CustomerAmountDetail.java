package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：现金账户金额流水表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:48
 */
public class CustomerAmountDetail implements IEntity{

    private static final long serialVersionUID = 947430543405127294L;

    private Integer id; //主键
    private Integer accountType; //1、用户2、店铺3、代理商
    private String orderId; //此次消费可能关联的订单编号
    private Integer customerId; //客户编号
    private String customerName; //客户名称
    private Integer paymentType; //收支类型1：收入，2：支出
    private Integer consumType; //后台充值=1,销售收入=2,推荐奖励=3,销售奖励=4,提现拒绝=5,打款失败=6,铺给客户充值=7,代理商给店铺充值=8,跨店铺销售收入=9,增值服务=10，后台扣款=50,用户提现=51,订单退款=52,销售奖励取消=53,店铺给客户充值扣款=54,代理商给店铺充值扣款=55,订单支付=56，代理商添加店铺向平台缴商户入驻费=57
    private Double oldMoney; //上次结余
    private Double amount; //消费金额，不区别正负，消费100，该值就是100
    private Double nowMoney; //本次结余
    private String remark; //备注
    private java.util.Date createTime; //创建时间
    private String createUser; //创建者

	
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
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
	
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
    
    public Integer getPaymentType() {
        return this.paymentType;
    }
	
    public void setConsumType(Integer consumType) {
        this.consumType = consumType;
    }
    
    public Integer getConsumType() {
        return this.consumType;
    }
	
    public void setOldMoney(Double oldMoney) {
        this.oldMoney = oldMoney;
    }
    
    public Double getOldMoney() {
        return this.oldMoney;
    }
	
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getAmount() {
        return this.amount;
    }
	
    public void setNowMoney(Double nowMoney) {
        this.nowMoney = nowMoney;
    }
    
    public Double getNowMoney() {
        return this.nowMoney;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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