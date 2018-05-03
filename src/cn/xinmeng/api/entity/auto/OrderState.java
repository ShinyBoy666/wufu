package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：订单状态表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:19
 */
public class OrderState implements IEntity{

    private static final long serialVersionUID = 532147234302848142L;

    private Integer id; //主键
    private String orderId; //订单编号
    private Integer orderProductId; //订单商品ID
    private Integer stateType; //状态类型：1=订单状态，2=支付状态，3=商品状态
    private Integer state; //订单状态：根据状态类型，与订单表的状态值对应
    private String stateText; //订单状态描述
    private String remark; //备注
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
	
    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }
    
    public Integer getOrderProductId() {
        return this.orderProductId;
    }
	
    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }
    
    public Integer getStateType() {
        return this.stateType;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setStateText(String stateText) {
        this.stateText = stateText;
    }
    
    public String getStateText() {
        return this.stateText;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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