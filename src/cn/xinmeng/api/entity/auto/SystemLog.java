package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：系统操作日志表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:35
 */
public class SystemLog implements IEntity{

    private static final long serialVersionUID = 563118036336407363L;

    private Integer id; //主键
    private Integer platform; //发生平台，1=WAP，2=Job任务，3=后台管理系统，4=供应商系统
    private String employeeId; //员工编号
    private String employeeName; //员工姓名
    private String moduleName; //模块名称
    private String pageName; //页面名称
    private String pageUrl; //页面地址
    private Integer actionType; //1、添加，2、修改，3、删除
    private String ip; //IP地址
    private String remark; //备注
    private String historyRecord; //历史数据记录
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }
    
    public Integer getPlatform() {
        return this.platform;
    }
	
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getEmployeeId() {
        return this.employeeId;
    }
	
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    public String getEmployeeName() {
        return this.employeeName;
    }
	
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public String getModuleName() {
        return this.moduleName;
    }
	
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public String getPageName() {
        return this.pageName;
    }
	
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    
    public String getPageUrl() {
        return this.pageUrl;
    }
	
    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }
    
    public Integer getActionType() {
        return this.actionType;
    }
	
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public String getIp() {
        return this.ip;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
	
    public void setHistoryRecord(String historyRecord) {
        this.historyRecord = historyRecord;
    }
    
    public String getHistoryRecord() {
        return this.historyRecord;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}