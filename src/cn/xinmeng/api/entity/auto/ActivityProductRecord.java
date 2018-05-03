package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：活动商品数量流水表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:04
 */
public class ActivityProductRecord implements IEntity{

    private static final long serialVersionUID = 452515643667591013L;

    private Integer id; //主键
    private Integer activityProductId; //活动商品表编号
    private String orderId; //订单编号
    private Integer oldNumber; //原数量
    private Integer soldNumber; //已售数量
    private Integer nowNumber; //剩余数量
    private String remark; //备注
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setActivityProductId(Integer activityProductId) {
        this.activityProductId = activityProductId;
    }
    
    public Integer getActivityProductId() {
        return this.activityProductId;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setOldNumber(Integer oldNumber) {
        this.oldNumber = oldNumber;
    }
    
    public Integer getOldNumber() {
        return this.oldNumber;
    }
	
    public void setSoldNumber(Integer soldNumber) {
        this.soldNumber = soldNumber;
    }
    
    public Integer getSoldNumber() {
        return this.soldNumber;
    }
	
    public void setNowNumber(Integer nowNumber) {
        this.nowNumber = nowNumber;
    }
    
    public Integer getNowNumber() {
        return this.nowNumber;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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