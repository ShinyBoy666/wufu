package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：任务信息列表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:04
 */
public class JobInfo implements IEntity{

    private static final long serialVersionUID = 375742133697330556L;

    private Integer id; //主键
    private String jobName; //任务名称
    private String jobServiceUrl; //任务请求地址
    private Integer jobServiceNo; //任务服务号
    private String jobDescription; //任务简介
    private java.util.Date lastExecutionTime; //最后执行时间
    private Integer state; //任务状态：1=无效，2=有效，3=执行中
    private Integer executionCount; //执行次数
    private Integer failedCount; //
    private Integer jobType; //任务类型：1=报表数据抽取任务，2=业务需求任务，3=其他任务
    private String updateUser; //修改人
    private java.util.Date updateTime; //修改时间
    private java.util.Date createTime; //创建时间
    private String createUser; //创建用户

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
    public String getJobName() {
        return this.jobName;
    }
	
    public void setJobServiceUrl(String jobServiceUrl) {
        this.jobServiceUrl = jobServiceUrl;
    }
    
    public String getJobServiceUrl() {
        return this.jobServiceUrl;
    }
	
    public void setJobServiceNo(Integer jobServiceNo) {
        this.jobServiceNo = jobServiceNo;
    }
    
    public Integer getJobServiceNo() {
        return this.jobServiceNo;
    }
	
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    public String getJobDescription() {
        return this.jobDescription;
    }
	
    public void setLastExecutionTime(java.util.Date lastExecutionTime) {
        this.lastExecutionTime = lastExecutionTime;
    }
    
    public java.util.Date getLastExecutionTime() {
        return this.lastExecutionTime;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setExecutionCount(Integer executionCount) {
        this.executionCount = executionCount;
    }
    
    public Integer getExecutionCount() {
        return this.executionCount;
    }
	
    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }
    
    public Integer getFailedCount() {
        return this.failedCount;
    }
	
    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }
    
    public Integer getJobType() {
        return this.jobType;
    }
	
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
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