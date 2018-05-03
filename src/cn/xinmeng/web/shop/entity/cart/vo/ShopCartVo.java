package cn.xinmeng.web.shop.entity.cart.vo;

import java.util.Date;


/**
 * 购物车信息
 * @param 
 * @ClassName: ShopCartVo 
 * @version V1.0  
 * @date 2016年2月19日 下午4:41:24 
 * @author jiangyong.tan
 * @return 
 *
 */
public class ShopCartVo {
	
	private Integer id;             //购物车id
	private Integer shopId;			//店铺ID
	private Integer productId;		//商品id
	private String productName;		//商品名称
	private Integer productNumber;	//商品数量
	private Double retailPrice;		//商品价格
	private String imageUrl;		//商品图片 
	private Integer productState;	//商品状态1-上架，2-下架，3-无货
	private String productStateValue;//商品状态值1-上架，2-下架，3-无货
	private Integer quantity;		//商品库存
	private String sku;				//sku
	private Integer productPriceId;	//商品价格id
	private Integer activityType;
	private Integer activityId;
	private Date addCartTime;		//添加购物时间
	
	
	//set get
	
	public Integer getProductId() {
		return productId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductState() {
		return productState;
	}
	public void setProductState(Integer productState) {
		this.productState = productState;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProductStateValue() {
		return productStateValue;
	}
	public void setProductStateValue(String productStateValue) {
		this.productStateValue = productStateValue;
	}
	public Date getAddCartTime() {
		return addCartTime;
	}
	public void setAddCartTime(Date addCartTime) {
		this.addCartTime = addCartTime;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}
	public Integer getActivityType() {
		return activityType;
	}
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	
}
