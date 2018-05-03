package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户报表统计
 * @author jiangyong.tan
 * @date 2016-11-17 20:43:21
 */
public class CustomerReport implements IEntity{

    private static final long serialVersionUID = 964863507954049521L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private String customerName; //客户姓名
    private Integer recommendCustomerId; //推荐人编号
    private String headSculpture; //客户头像
    private Integer teamNumber; //团队人数
    private java.util.Date lastUpdateTime; //最后更新时间

	
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
	
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
	
    public void setRecommendCustomerId(Integer recommendCustomerId) {
        this.recommendCustomerId = recommendCustomerId;
    }
    
    public Integer getRecommendCustomerId() {
        return this.recommendCustomerId;
    }
	
    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }
    
    public String getHeadSculpture() {
        return this.headSculpture;
    }
	
    public void setTeamNumber(Integer teamNumber) {
        this.teamNumber = teamNumber;
    }
    
    public Integer getTeamNumber() {
        return this.teamNumber;
    }
	
    public void setLastUpdateTime(java.util.Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    
    public java.util.Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
}