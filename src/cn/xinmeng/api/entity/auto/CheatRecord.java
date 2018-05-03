package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：优惠买单作弊记录表
 * @author jiangyong.tan
 * @date 2016-08-16 10:49:55
 */
public class CheatRecord implements IEntity{

    private static final long serialVersionUID = 769200969886805191L;

    private Integer id; //主键，自增长
    private Integer shopId; //店铺编号
    private String openId; //客户openId
    private Integer quantity; //作弊单数
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    public String getOpenId() {
        return this.openId;
    }
	
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Integer getQuantity() {
        return this.quantity;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}