package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：系统异常日志表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:29
 */
public class SystemErrorLog implements IEntity{

    private static final long serialVersionUID = 566063312173904739L;

    private Integer id; //主键
    private String description; //异常描述，如：支付宝回调异常
    private Integer pri; //优先级，范围（0~10），默认为5，数字越大，优先级越高例如：普通异常为5，支付回调异常为10
    private Integer platform; //发生平台，1=WAP，2=Job任务，3=后台管理系统，4=店铺系统
    private String createUser; //操作者，如果是管理中心人为操作，记录操作者名称，如果是job操作，记录job名称，如果是api报错，直接写API
    private String ip; //IP地址
    private Integer actionType; //1、添加，2、修改，3、删除，4、其他
    private String errorInformation; //错误详细:系统捕捉的异常信息。
    private String runCommand; //执行命令:如sql语句:updatedeleteinsert，或调用接口的方法:WebApi.GetProductInfo(1)
    private Integer informed; //是否发送过通知1、未发送2、已发送
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
	
    public void setPri(Integer pri) {
        this.pri = pri;
    }
    
    public Integer getPri() {
        return this.pri;
    }
	
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }
    
    public Integer getPlatform() {
        return this.platform;
    }
	
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
	
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public String getIp() {
        return this.ip;
    }
	
    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }
    
    public Integer getActionType() {
        return this.actionType;
    }
	
    public void setErrorInformation(String errorInformation) {
        this.errorInformation = errorInformation;
    }
    
    public String getErrorInformation() {
        return this.errorInformation;
    }
	
    public void setRunCommand(String runCommand) {
        this.runCommand = runCommand;
    }
    
    public String getRunCommand() {
        return this.runCommand;
    }
	
    public void setInformed(Integer informed) {
        this.informed = informed;
    }
    
    public Integer getInformed() {
        return this.informed;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}