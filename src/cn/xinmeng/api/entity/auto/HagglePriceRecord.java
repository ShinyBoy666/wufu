package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：砍价活动价格记录表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
public class HagglePriceRecord implements IEntity{

    private static final long serialVersionUID = 985923430351125842L;

    private Integer id; //主键
    private Integer haggleId; //砍价活动编号
    private Integer fromCustomerId; //砍价发起人编号
    private Double currentPrice; //当前价格
    private String orderId; //订单编号
    private java.util.Date updateTime; //更新时间

	
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
	
    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
    
    public Double getCurrentPrice() {
        return this.currentPrice;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
}