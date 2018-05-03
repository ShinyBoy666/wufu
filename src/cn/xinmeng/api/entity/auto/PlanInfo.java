package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：计划信息列表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:05
 */
public class PlanInfo implements IEntity{

    private static final long serialVersionUID = 205779864874644012L;

    private Integer id; //主键
    private String token; //任务名称
    private Integer jobServiceNo; //任务服务号
    private Integer planType; //计划类型0=间隔，1=每日，2=每周，3=每月
    private Integer planValue; //计划值：当然计划类型为时间间隔时，该值为时间间隔的秒数。当计划类型为每日时，该值无效。当计划类型为每周时，该值1~7，代表周一至周日。当该值是每月时，该值为1~28分别代表，每月的1日至28日，-1代表每月最后一天，-1代表，每月的倒数第二天，-3代表每月的倒数第3天。
    private java.util.Date beginTime; //开始执行时间，注意：只有时间值有效，日期值无效。
    private String remark; //备注
    private Integer maxRepeatCount; //执行失败后尝试重复执行次数，直到连续失败次数大于该值时，计划将停止执行
    private Integer failedCount; //执行出错次数
    private java.util.Date createTime; //创建时间
    private String createUser; //创建用户

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getToken() {
        return this.token;
    }
	
    public void setJobServiceNo(Integer jobServiceNo) {
        this.jobServiceNo = jobServiceNo;
    }
    
    public Integer getJobServiceNo() {
        return this.jobServiceNo;
    }
	
    public void setPlanType(Integer planType) {
        this.planType = planType;
    }
    
    public Integer getPlanType() {
        return this.planType;
    }
	
    public void setPlanValue(Integer planValue) {
        this.planValue = planValue;
    }
    
    public Integer getPlanValue() {
        return this.planValue;
    }
	
    public void setBeginTime(java.util.Date beginTime) {
        this.beginTime = beginTime;
    }
    
    public java.util.Date getBeginTime() {
        return this.beginTime;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
	
    public void setMaxRepeatCount(Integer maxRepeatCount) {
        this.maxRepeatCount = maxRepeatCount;
    }
    
    public Integer getMaxRepeatCount() {
        return this.maxRepeatCount;
    }
	
    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }
    
    public Integer getFailedCount() {
        return this.failedCount;
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