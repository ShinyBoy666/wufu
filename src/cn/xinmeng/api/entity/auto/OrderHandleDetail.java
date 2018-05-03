package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：订单处理记录表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:15
 */
public class OrderHandleDetail implements IEntity{

    private static final long serialVersionUID = 790207991019218853L;

    private Integer id; //主键
    private String orderId; //订单编号
    private Integer pegLevel; //标记等级
    private Integer pegType; //标记类型:1为公共，2为私有
    private String remark; //备注
    private String createUserName; //备注人姓名
    private String createUser; //创建者
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setPegLevel(Integer pegLevel) {
        this.pegLevel = pegLevel;
    }
    
    public Integer getPegLevel() {
        return this.pegLevel;
    }
	
    public void setPegType(Integer pegType) {
        this.pegType = pegType;
    }
    
    public Integer getPegType() {
        return this.pegType;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
	
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
    
    public String getCreateUserName() {
        return this.createUserName;
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