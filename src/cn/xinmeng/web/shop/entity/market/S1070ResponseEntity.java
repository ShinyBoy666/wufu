package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 秒杀商品列表
 * @param 
 * @ClassName: S1070ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1070ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = 276803916103086879L;


    private Integer activityId;				//活动编号
    private Integer activityType; 			//活动类型1、秒杀2、团购3、砍价4、一元购
    private Integer productPriceId; 		//商品编号
    private Integer maxBuy; 				//每人限购数量0表示不限购
    private Integer productNumber; 			//商品数量
    private Integer soldNumber; 			//已售数量
	
    
    private Integer productId; //商品编号
    private String productName; //产品名称
    private Double marketPrice; //市场上的价格，只是用来显示，界面用横线画掉。
    private Double retailPrice; //普通商品的售卖价格
    private String imageUrl; //默认图片地址
	
	//set get 
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
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
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Integer getActivityType() {
		return activityType;
	}
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}
	public Integer getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}
	public Integer getMaxBuy() {
		return maxBuy;
	}
	public void setMaxBuy(Integer maxBuy) {
		this.maxBuy = maxBuy;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	public Integer getSoldNumber() {
		return soldNumber;
	}
	public void setSoldNumber(Integer soldNumber) {
		this.soldNumber = soldNumber;
	}
}
