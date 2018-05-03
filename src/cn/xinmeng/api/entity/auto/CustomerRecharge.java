package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户充值记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:51
 */
public class CustomerRecharge implements IEntity{

    private static final long serialVersionUID = 696016871475296275L;

    private Integer id; //主键
    private String rechargeId; //支付单号：商品订单Z开头，店铺申请充值S开头
    private String orderId; //订单编号。如果和订单无关，则默认值为0
    private Integer rechargeType; //充值类型1：支付宝2：微信3：银联
    private Integer rechareFrom; //充值来源1：苹果2：安卓3：WAP
    private String tradeNo; //回调流水号
    private Integer customerId; //用户编号
    private String customerName; //用户姓名
    private Double amount; //充值金额
    private Integer state; //充值状态1，有效；2，成功；3，失效；4，异常，5，订单无效已还款到账户
    private String remark; //备注
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
	
    public void setRechargeId(String rechargeId) {
        this.rechargeId = rechargeId;
    }
    
    public String getRechargeId() {
        return this.rechargeId;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setRechargeType(Integer rechargeType) {
        this.rechargeType = rechargeType;
    }
    
    public Integer getRechargeType() {
        return this.rechargeType;
    }
	
    public void setRechareFrom(Integer rechareFrom) {
        this.rechareFrom = rechareFrom;
    }
    
    public Integer getRechareFrom() {
        return this.rechareFrom;
    }
	
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    
    public String getTradeNo() {
        return this.tradeNo;
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
	
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getAmount() {
        return this.amount;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
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