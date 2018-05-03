package cn.xinmeng.web.shop.entity.vo;

import java.util.List;


public class ProductInfoDetailVo extends ProductInfoVo{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月25日 下午1:50:17
	 */ 
	private static final long serialVersionUID = 984652110014635833L;
	
    private String productIntroduction; //商品简介
    private Integer commentCount; //商品评论数量
    private String shopName;	//店铺名称
    private String productDetailUrl;//商品图文详情
    private Integer cartCount;	//购物车商品数量
    private String description = ""; //商品图文详情内容
    private String shareUrl = ""; //商品分享wap地址
	private Integer productState;	//商品状态3－上架
	private String productStateValue;//商品状态值3－上架
//    private Integer viewCount; //浏览量
//    private Integer praiseCount; //点赞次数
    private List<ProductPriceVo> productPriceList;//商品价格集合
    
	public String getProductIntroduction() {
		return productIntroduction;
	}
	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public List<ProductPriceVo> getProductPriceList() {
		return productPriceList;
	}
	public void setProductPriceList(List<ProductPriceVo> productPriceList) {
		this.productPriceList = productPriceList;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getProductDetailUrl() {
		return productDetailUrl;
	}
	public void setProductDetailUrl(String productDetailUrl) {
		this.productDetailUrl = productDetailUrl;
	}
	public Integer getCartCount() {
		return cartCount;
	}
	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShareUrl() {
		return shareUrl;
	}
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	public Integer getProductState() {
		return productState;
	}
	public void setProductState(Integer productState) {
		this.productState = productState;
	}
	public String getProductStateValue() {
		return productStateValue;
	}
	public void setProductStateValue(String productStateValue) {
		this.productStateValue = productStateValue;
	}
}
