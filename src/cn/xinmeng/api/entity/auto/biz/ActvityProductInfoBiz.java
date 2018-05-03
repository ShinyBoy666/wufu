package cn.xinmeng.api.entity.auto.biz;

import java.util.Date;
import java.util.List;

import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;

/**
 * 活动商品详情信息
 * @author tanjiangyong
 *
 */
public class ActvityProductInfoBiz implements IEntity{

	private static final long serialVersionUID = 4142014530758276828L;


	//活动信息表
	private String title; 						//活动标题
    private Integer shopId;						//店铺id
    private String shopName;					//店铺名称
    private Integer maxBuy;						//最大购买数量
    private String activityImage;				//活动图片
    private java.util.Date showTime; 			//展示时间
    private java.util.Date beginTime; 			//开始时间
    private java.util.Date endTime; 			//结束时间
    private boolean alreadyBuy;					//已经购买
    
    
    //商品基础信息表
	private String shareUrl = "";				//商品分享wap地址
	private String productName;					//商品名称
    private String productDetailUrl;			//商品图文详情
    private String productIntroduction; 		//商品简介
    private String sku;							//sku
    private Integer productState;				//商品状态:3上架
    private Double postage = 0.00; 				//邮费
    private Integer isDelivery = 2;				//是否需要发货,1-不需要，2-需要
    private Integer isHaveSeat; 				//1、不需要2、需要
    private List<String> imageUrlList;			//商品价格集合

    //活动商品信息表
    private Integer id;							//活动商品主键
    private Integer activityId; 				//活动编号
    private Integer productId; 					//商品编号
    private Integer activityType; 				//活动类型1、秒杀2、团购3、砍价4、一元购
    private Integer productPriceId; 			//商品编号
    private Double marketPrice; 				//市场上的价格，只是用来显示，界面用横线画掉。
    private Double retailPrice; 				//普通商品的售卖价格
//    private Double productActivityPrice; 		//商品价格
//    private Double productPrice; 				//商品原价格
    private Integer productNumber; 				//商品数量
    private Integer soldNumber; 				//已售数量
    private Integer quantity; 					//库存
    private String productDetail;				//商品详情
    
    //set get

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getProductDetailUrl() {
		return productDetailUrl;
	}

	public void setProductDetailUrl(String productDetailUrl) {
		this.productDetailUrl = productDetailUrl;
	}

	public String getProductIntroduction() {
		return productIntroduction;
	}

	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
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

	public List<String> getImageUrlList() {
		return imageUrlList;
	}

	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Double getPostage() {
		return postage;
	}

	public void setPostage(Double postage) {
		this.postage = postage;
	}

	public Integer getIsDelivery() {
		return isDelivery;
	}

	public void setIsDelivery(Integer isDelivery) {
		this.isDelivery = isDelivery;
	}

	public Integer getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
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

	public Integer getQuantity() {
		if(!Utils.isEmpty(productNumber)){
			return productNumber - UtilMoney.integerToZero(soldNumber);
		}
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMaxBuy() {
		if(Utils.isEmpty(maxBuy)){
			return productNumber;
		}
		return maxBuy;
	}

	public void setMaxBuy(Integer maxBuy) {
		this.maxBuy = maxBuy;
	}

	public java.util.Date getShowTime() {
		return showTime;
	}

	public void setShowTime(java.util.Date showTime) {
		this.showTime = showTime;
	}

	public java.util.Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	
    public Integer getProductState() {
		return productState;
	}

	public void setProductState(Integer productState) {
		this.productState = productState;
	}

	public boolean isAlreadyBuy() {
		return alreadyBuy;
	}

	public void setAlreadyBuy(boolean alreadyBuy) {
		this.alreadyBuy = alreadyBuy;
	}

	/**
     * 活动描述
     * @return
     */
	public String getActivityDetail() {
		Double price = UtilMoney.subtractToDouble(UtilMoney.doubleToZero(marketPrice), UtilMoney.doubleToZero(retailPrice));
		return "比普通购买省"+price+"元，每人限购"+maxBuy+"件";
	}
	

	public String getActivityImage() {
		return activityImage;
	}

	public void setActivityImage(String activityImage) {
		this.activityImage = activityImage;
	}

	/**
	 * 分享图片
	 * @return
	 */
	public String getShareImageUrl() {
		if(!Utils.isEmpty(imageUrlList)){
			return Utils.getImageUrl(imageUrlList.get(0), "?100_100");
		}
		return "";
	}

	/**
	 * 活动时间：1=还未开始，2=正在进行，3=已经结束
	 * @return
	 */
	public Integer getActivityState() {
		Date now = new Date();
		if(Utils.isEmpty(beginTime) || Utils.isEmpty(endTime)){
			return 0;
		}else if(DateUtil.compareDate(beginTime, now)){
			return 1;
		}else if(DateUtil.compareDate(now, endTime)){
			return 3;
		}else if(DateUtil.compareDate(now, beginTime) && DateUtil.compareDate(endTime, now)){
			return 2;
		}
		return 0;
	}

	/**
	 * 活动时间：当活动状态=1时表示距离开始时间，2时表示距离结束时间，3时可以返回0
	 * @return
	 */
	public long getActivityTime() {
		Date now = new Date();
		Integer activityState = getActivityState();
		if(activityState == 1){
			return DateUtil.dateSubDate(beginTime, now);
		}else if(activityState == 2){
			return DateUtil.dateSubDate(endTime, now);
		}
		return 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public Integer getIsHaveSeat() {
		return isHaveSeat;
	}

	public void setIsHaveSeat(Integer isHaveSeat) {
		this.isHaveSeat = isHaveSeat;
	}
}
