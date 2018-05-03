package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：购物车表
 * @author jiangyong.tan
 * @date 2016-04-13 20:12:26
 */
public class Cart implements IEntity{

    private static final long serialVersionUID = 580836980826699902L;

    private Integer id; //主键、自增长
    private Integer shopId; //店铺编号
    private Integer customerId; //用户编号
    private Integer productId; //商品编号
    private String sku; //SKU
    private Integer productNumber; //商品数量
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
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
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
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
	
    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
    
    public Integer getProductNumber() {
        return this.productNumber;
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