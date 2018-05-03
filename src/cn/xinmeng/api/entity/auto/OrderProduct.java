package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：订单商品表
 * @author jiangyong.tan
 * @date 2016-10-26 10:31:44
 */
public class OrderProduct implements IEntity{

    private static final long serialVersionUID = 183662927228805892L;

    private Integer id; //主键、自增长
    private String orderId; //订单编号
    private Integer productId; //商品编号
    private Integer productPriceId; //商品价格表ID
    private String sku; //商品SKU
    private Integer productNumber; //商品数量
    private Double profitFirst; //一级利润
    private Double profitSecond; //二级利润
    private Double profitThird; //三级利润
    private Double productPrice; //商品零售价
    private Double productDiscountMoney; //优惠金额
    private Double productPayMoney; //支付金额
    private Integer productState; //1=待发货,2=已发货,3=已收货,4=申请退货,5=退货成功,6=退货失败
    private Integer isDelivery; //1、不需要2、需要
    private Integer isComment; //是否评论1、未评论、2、已评论
    private java.util.Date deliveryTime; //收货时间
    private Integer activityProductId; //活动商品表编号
    private String remark; //备注
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
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
	
    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }
    
    public Integer getProductPriceId() {
        return this.productPriceId;
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
	
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    
    public Double getProductPrice() {
        return this.productPrice;
    }
	
    public void setProductDiscountMoney(Double productDiscountMoney) {
        this.productDiscountMoney = productDiscountMoney;
    }
    
    public Double getProductDiscountMoney() {
        return this.productDiscountMoney;
    }
	
    public void setProductPayMoney(Double productPayMoney) {
        this.productPayMoney = productPayMoney;
    }
    
    public Double getProductPayMoney() {
        return this.productPayMoney;
    }
	
    public void setProductState(Integer productState) {
        this.productState = productState;
    }
    
    public Integer getProductState() {
        return this.productState;
    }
	
    public void setIsDelivery(Integer isDelivery) {
        this.isDelivery = isDelivery;
    }
    
    public Integer getIsDelivery() {
        return this.isDelivery;
    }
	
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }
    
    public Integer getIsComment() {
        return this.isComment;
    }
	
    public void setDeliveryTime(java.util.Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    public java.util.Date getDeliveryTime() {
        return this.deliveryTime;
    }
	
    public void setActivityProductId(Integer activityProductId) {
        this.activityProductId = activityProductId;
    }
    
    public Integer getActivityProductId() {
        return this.activityProductId;
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