package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：任务信息列表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:03
 */
public class JobHistory implements IEntity{

    private static final long serialVersionUID = 326013394477325568L;

    private Integer id; //主键
    private Integer jobId; //任务ID
    private Integer planId; //计划ID
    private String jobName; //任务名称
    private java.util.Date beginExecutionTime; //开始执行时间
    private java.util.Date endExecutionTime; //结束执行时间
    private Long executionLong; //执行时长，毫秒数
    private Integer executionState; //执行状态1=执行中，2=执行成功，3=执行失败
    private String executionInfo; //执行信息
    private String executionUser; //执行者
    private java.util.Date updateTime; //修改时间
    private String createUser; //创建用户
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    
    public Integer getJobId() {
        return this.jobId;
    }
	
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    
    public Integer getPlanId() {
        return this.planId;
    }
	
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
    public String getJobName() {
        return this.jobName;
    }
	
    public void setBeginExecutionTime(java.util.Date beginExecutionTime) {
        this.beginExecutionTime = beginExecutionTime;
    }
    
    public java.util.Date getBeginExecutionTime() {
        return this.beginExecutionTime;
    }
	
    public void setEndExecutionTime(java.util.Date endExecutionTime) {
        this.endExecutionTime = endExecutionTime;
    }
    
    public java.util.Date getEndExecutionTime() {
        return this.endExecutionTime;
    }
	
    public void setExecutionLong(Long executionLong) {
        this.executionLong = executionLong;
    }
    
    public Long getExecutionLong() {
        return this.executionLong;
    }
	
    public void setExecutionState(Integer executionState) {
        this.executionState = executionState;
    }
    
    public Integer getExecutionState() {
        return this.executionState;
    }
	
    public void setExecutionInfo(String executionInfo) {
        this.executionInfo = executionInfo;
    }
    
    public String getExecutionInfo() {
        return this.executionInfo;
    }
	
    public void setExecutionUser(String executionUser) {
        this.executionUser = executionUser;
    }
    
    public String getExecutionUser() {
        return this.executionUser;
    }
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
	
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}