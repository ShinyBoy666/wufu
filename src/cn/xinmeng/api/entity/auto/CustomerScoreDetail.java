package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：积分帐户流水表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:52
 */
public class CustomerScoreDetail implements IEntity{

    private static final long serialVersionUID = 670951221162408094L;

    private Integer id; //主键
    private String orderId; //此次消费可能关联的订单编号
    private Integer customerId; //客户编号
    private String customerName; //客户名称
    private Integer paymentType; //收支类型（支出或者收入）1收入2支出
    private Integer consumType; //消费类型后台充值=1,推荐奖励=2,销售奖励=3,后台扣款=50,积分消费=51,销售奖励取消=52
    private Integer oldScore; //上传结余分数
    private Integer score; //消费金额，不区别正负，消费100，该值就是100
    private Integer nowScore; //本次结余分数
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
	
    public void setOldScore(Integer oldScore) {
        this.oldScore = oldScore;
    }
    
    public Integer getOldScore() {
        return this.oldScore;
    }
	
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Integer getScore() {
        return this.score;
    }
	
    public void setNowScore(Integer nowScore) {
        this.nowScore = nowScore;
    }
    
    public Integer getNowScore() {
        return this.nowScore;
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