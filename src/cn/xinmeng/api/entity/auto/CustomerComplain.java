package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：用户投诉
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:52
 */
public class CustomerComplain implements IEntity{

    private static final long serialVersionUID = 223726988067761146L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private Integer complainType; //投诉类型1、投诉服务人2、投诉平台
    private String complainCustomerId; //投诉对象Id：服务人为服务人编号，投诉平台存空
    private String content; //投诉内容
    private String remark; //备注
    private Integer state; //状态1、未处理2、已处理
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人
    private java.util.Date updateTime; //修改时间
    private String updateUser; //修改人

	
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
	
    public void setComplainType(Integer complainType) {
        this.complainType = complainType;
    }
    
    public Integer getComplainType() {
        return this.complainType;
    }
	
    public void setComplainCustomerId(String complainCustomerId) {
        this.complainCustomerId = complainCustomerId;
    }
    
    public String getComplainCustomerId() {
        return this.complainCustomerId;
    }
	
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return this.content;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
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
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
	
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
}