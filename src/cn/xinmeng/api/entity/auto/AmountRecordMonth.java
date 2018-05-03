package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户账户金额记录表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:48
 */
public class AmountRecordMonth implements IEntity{

    private static final long serialVersionUID = 561080853465809598L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private Double amount; //现金金额
    private Integer score; //积分
    private java.util.Date recordDate; //记录日期
    private java.util.Date createTime; //创建时间

	
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
	
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getAmount() {
        return this.amount;
    }
	
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Integer getScore() {
        return this.score;
    }
	
    public void setRecordDate(java.util.Date recordDate) {
        this.recordDate = recordDate;
    }
    
    public java.util.Date getRecordDate() {
        return this.recordDate;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}