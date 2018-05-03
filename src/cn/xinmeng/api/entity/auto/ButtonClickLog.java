package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：按钮点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:19
 */
public class ButtonClickLog implements IEntity{

    private static final long serialVersionUID = 517586295727867615L;

    private Integer id; //主键
    private String pageName; //页面名称
    private String buttonName; //按钮名称
    private String imei; //IMEI
    private Integer fromType; //1、安卓2、IOS3、WAP
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public String getPageName() {
        return this.pageName;
    }
	
    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }
    
    public String getButtonName() {
        return this.buttonName;
    }
	
    public void setImei(String imei) {
        this.imei = imei;
    }
    
    public String getImei() {
        return this.imei;
    }
	
    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }
    
    public Integer getFromType() {
        return this.fromType;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}