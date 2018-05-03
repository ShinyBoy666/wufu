package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：会员开通记录表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:59
 */
public class CustomerVipRecord implements IEntity{

    private static final long serialVersionUID = 804891561199621904L;

    private Integer id; //主键
    private String orderId; //订单编号。如果和订单无关，则默认值为0
    private Integer customerId; //客户编号
    private Integer shopId; //店铺编号
    private Double money; //交费金额
    private Integer state; //1、有效2、失败3、成功
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
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
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setMoney(Double money) {
        this.money = money;
    }
    
    public Double getMoney() {
        return this.money;
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
}