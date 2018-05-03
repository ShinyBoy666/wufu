package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.List;

import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;

public class ProductPriceVo implements Serializable{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月25日 下午2:00:29
	 */ 
	private static final long serialVersionUID = 1666256572493674221L;
    
	private Integer id; //主键
    private Integer productId; //商品编号
    private String sku; //商品SKU
    private Double marketPrice; //市场价
    private Double retailPrice; //零售价
    private Double vipPrice; //会员价
    private Double profitFirst; //一级利润
    private Integer quantity; //库存
    private List<String> imageUrlList; //图片集合
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(Double vipPrice) {
		this.vipPrice = vipPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public List<String> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	public Double getProfitFirst() {
		if(!Utils.isEmpty(retailPrice) && !Utils.isEmpty(vipPrice) && retailPrice > vipPrice){
			return UtilMoney.subtractToDouble(retailPrice, vipPrice);
		}
		return 0.0;
	}
	public void setProfitFirst(Double profitFirst) {
		this.profitFirst = profitFirst;
	}
}
