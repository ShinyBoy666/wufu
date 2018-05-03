package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：砍价活动记录表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:08
 */
public class HaggleRecord implements IEntity{

    private static final long serialVersionUID = 870801652242239030L;

    private Integer id; //主键
    private Integer haggleId; //砍价活动编号
    private Integer fromCustomerId; //砍价发起人编号
    private Integer customerId; //用户编号
    private String customerNickname; //用户昵称
    private String headSculpture; //用户头像
    private Double hagglePrice; //砍掉的价格
    private String orderId; //订单编号
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setHaggleId(Integer haggleId) {
        this.haggleId = haggleId;
    }
    
    public Integer getHaggleId() {
        return this.haggleId;
    }
	
    public void setFromCustomerId(Integer fromCustomerId) {
        this.fromCustomerId = fromCustomerId;
    }
    
    public Integer getFromCustomerId() {
        return this.fromCustomerId;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setCustomerNickname(String customerNickname) {
        this.customerNickname = customerNickname;
    }
    
    public String getCustomerNickname() {
        return this.customerNickname;
    }
	
    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }
    
    public String getHeadSculpture() {
        return this.headSculpture;
    }
	
    public void setHagglePrice(Double hagglePrice) {
        this.hagglePrice = hagglePrice;
    }
    
    public Double getHagglePrice() {
        return this.hagglePrice;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}