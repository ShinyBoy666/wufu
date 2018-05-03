package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：商品数量流水记录
 * @author jiangyong.tan
 * @date 2016-04-21 21:58:49
 */
public class ProductQuantityRecord implements IEntity{

    private static final long serialVersionUID = 909320304400182725L;

    private Integer id; //主键
    private Integer productPriceId; //商品价格表编号
    private Integer productId; //商品编号
    private String sku; //商品SKU
    private String orderId; //订单编号(仅当与订单相关的操作时有值)
    private String remark; //备注
    private Integer changeType; //变动类型:1、增加2、减少
    private Integer oldActualQuantity; //原实际库存数量
    private Integer changeActualQuantity; //更改的实际库存量
    private Integer nowActualQuantity; //更改后的实际库存量
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }
    
    public Integer getProductPriceId() {
        return this.productPriceId;
    }
	
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
	
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getSku() {
        return this.sku;
    }
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
	
    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }
    
    public Integer getChangeType() {
        return this.changeType;
    }
	
    public void setOldActualQuantity(Integer oldActualQuantity) {
        this.oldActualQuantity = oldActualQuantity;
    }
    
    public Integer getOldActualQuantity() {
        return this.oldActualQuantity;
    }
	
    public void setChangeActualQuantity(Integer changeActualQuantity) {
        this.changeActualQuantity = changeActualQuantity;
    }
    
    public Integer getChangeActualQuantity() {
        return this.changeActualQuantity;
    }
	
    public void setNowActualQuantity(Integer nowActualQuantity) {
        this.nowActualQuantity = nowActualQuantity;
    }
    
    public Integer getNowActualQuantity() {
        return this.nowActualQuantity;
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