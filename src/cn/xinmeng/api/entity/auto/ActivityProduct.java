package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：活动商品表
 * @author jiangyong.tan
 * @date 2016-10-26 10:25:20
 */
public class ActivityProduct implements IEntity{

    private static final long serialVersionUID = 325146163897648285L;

    private Integer id; //主键
    private Integer activityId; //活动编号
    private Integer productId; //商品编号
    private Integer activityType; //活动类型1、秒杀2、团购3、砍价4、一元购
    private Integer productPriceId; //商品编号
    private Double productActivityPrice; //商品价格
    private Double productPrice; //商品原价格
    private Integer productNumber; //商品数量
    private Integer soldNumber; //已售数量
    private Integer maxBuy; //每人限购数量0表示不限购
    private Integer state; //1、无效2、有效
    private java.util.Date createTime; //创建时间
    private java.util.Date updateTime; //修改时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
    
    public Integer getActivityId() {
        return this.activityId;
    }
	
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
	
    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }
    
    public Integer getActivityType() {
        return this.activityType;
    }
	
    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }
    
    public Integer getProductPriceId() {
        return this.productPriceId;
    }
	
    public void setProductActivityPrice(Double productActivityPrice) {
        this.productActivityPrice = productActivityPrice;
    }
    
    public Double getProductActivityPrice() {
        return this.productActivityPrice;
    }
	
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    
    public Double getProductPrice() {
        return this.productPrice;
    }
	
    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
    
    public Integer getProductNumber() {
        return this.productNumber;
    }
	
    public void setSoldNumber(Integer soldNumber) {
        this.soldNumber = soldNumber;
    }
    
    public Integer getSoldNumber() {
        return this.soldNumber;
    }
	
    public void setMaxBuy(Integer maxBuy) {
        this.maxBuy = maxBuy;
    }
    
    public Integer getMaxBuy() {
        return this.maxBuy;
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
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
}