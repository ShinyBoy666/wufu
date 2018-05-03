package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：商品价格表
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:01
 */
public class ProductPrice implements IEntity{

    private static final long serialVersionUID = 936007774946298833L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private Integer productId; //商品编号
    private String sku; //商品SKU
    private String barCode; //条形码
    private Double marketPrice; //市场价
    private Double retailPrice; //零售价
    private Double purchasePrice; //采购价（不对外显示）
    private Double profitFirst; //一级利润
    private Double profitSecond; //二级利润
    private Double profitThird; //三级利润
    private Integer score; //积分数量
    private Double weight; //重量
    private Integer quantity; //库存
    private Integer state; //1：无效、2：有效
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
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
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
	
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    
    public String getBarCode() {
        return this.barCode;
    }
	
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }
    
    public Double getMarketPrice() {
        return this.marketPrice;
    }
	
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }
    
    public Double getRetailPrice() {
        return this.retailPrice;
    }
	
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    public Double getPurchasePrice() {
        return this.purchasePrice;
    }
	
    public void setProfitFirst(Double profitFirst) {
        this.profitFirst = profitFirst;
    }
    
    public Double getProfitFirst() {
        return this.profitFirst;
    }
	
    public void setProfitSecond(Double profitSecond) {
        this.profitSecond = profitSecond;
    }
    
    public Double getProfitSecond() {
        return this.profitSecond;
    }
	
    public void setProfitThird(Double profitThird) {
        this.profitThird = profitThird;
    }
    
    public Double getProfitThird() {
        return this.profitThird;
    }
	
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Integer getScore() {
        return this.score;
    }
	
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public Double getWeight() {
        return this.weight;
    }
	
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Integer getQuantity() {
        return this.quantity;
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