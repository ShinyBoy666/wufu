package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;

import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;

public class ProductInfoVo implements Serializable{
	
	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午4:32:59
	 */ 
	private static final long serialVersionUID = 3191200438375561975L;
	
	private Integer id; //主键
    private Integer productId; //商品编号
    private String productName; //产品名称
    private Double marketPrice; //市场上的价格，只是用来显示，界面用横线画掉。
    private Double retailPrice; //普通商品的售卖价格
    private Double vipPrice; //会员价
    private Double profitFirst; //一级利润
    private String imageUrl; //默认图片地址
    private Integer isNew; //新品1、否2、是
    private Integer hot; //热销1、否2、是
    private Integer buyCount; //购买量
    private Integer buyVirtualCount; //虚拟购买量
    private boolean isCollection; //是否收藏
	
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
	public Double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(Double vipPrice) {
		this.vipPrice = vipPrice;
	}
	public String getImageUrl() {
        return Utils.getImageUrl(this.imageUrl);
    }
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean getIsCollection() {
		return isCollection;
	}
	public void setIsCollection(boolean isCollection) {
		this.isCollection = isCollection;
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
	public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
    
    public Integer getIsNew() {
        return this.isNew;
    }
	
    public void setHot(Integer hot) {
        this.hot = hot;
    }
    
    public Integer getHot() {
        return this.hot;
    }
    public Integer getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
	public Integer getBuyVirtualCount() {
		return buyVirtualCount;
	}
	public void setBuyVirtualCount(Integer buyVirtualCount) {
		this.buyVirtualCount = buyVirtualCount;
	}
}
