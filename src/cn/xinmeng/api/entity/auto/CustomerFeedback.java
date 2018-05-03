package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户意见反馈表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:54
 */
public class CustomerFeedback implements IEntity{

    private static final long serialVersionUID = 405382656302389782L;

    private Integer id; //主键
    private Integer fromType; //反馈来源1：未知，2：苹果，3：安卓，4：Wap
    private Integer customerId; //客户编号
    private String cellphone; //手机号码
    private String phoneType; //手机名称
    private String imei; //手机串号
    private Double lng; //经度
    private Double lat; //纬度
    private Integer appDesigned; //1、喜欢2、还行3、不喜欢
    private Integer state; //状态1、未处理2、已处理
    private String appVeision; //APP版本号
    private String systemVersion; //系统版本号
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }
    
    public Integer getFromType() {
        return this.fromType;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    
    public String getCellphone() {
        return this.cellphone;
    }
	
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
    
    public String getPhoneType() {
        return this.phoneType;
    }
	
    public void setImei(String imei) {
        this.imei = imei;
    }
    
    public String getImei() {
        return this.imei;
    }
	
    public void setLng(Double lng) {
        this.lng = lng;
    }
    
    public Double getLng() {
        return this.lng;
    }
	
    public void setLat(Double lat) {
        this.lat = lat;
    }
    
    public Double getLat() {
        return this.lat;
    }
	
    public void setAppDesigned(Integer appDesigned) {
        this.appDesigned = appDesigned;
    }
    
    public Integer getAppDesigned() {
        return this.appDesigned;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setAppVeision(String appVeision) {
        this.appVeision = appVeision;
    }
    
    public String getAppVeision() {
        return this.appVeision;
    }
	
    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }
    
    public String getSystemVersion() {
        return this.systemVersion;
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