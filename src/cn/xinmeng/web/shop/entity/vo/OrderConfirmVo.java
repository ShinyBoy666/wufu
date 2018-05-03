package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.List;

public class OrderConfirmVo implements Serializable{

	private static final long serialVersionUID = 276803916103086879L;

	private int shopId;								//店铺ID
	private String shopName;						//店铺名称
	private String shopLogo;						//店铺logo
	private Double postage;							//邮费
	private boolean isDelivery = true;				//是否需要发货
	private boolean isRealyname = false;			//是否需要填写身份证
	private List<OrderCouponVo> usableCoupons;		//可使用优惠券
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public Double getPostage() {
		return postage;
	}
	public void setPostage(Double postage) {
		this.postage = postage;
	}
	public boolean getIsDelivery() {
		return isDelivery;
	}
	public void setDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}
	public boolean getIsRealyname() {
		return isRealyname;
	}
	public void setRealyname(boolean isRealyname) {
		this.isRealyname = isRealyname;
	}
	public List<OrderCouponVo> getUsableCoupons() {
		return usableCoupons;
	}
	public void setUsableCoupons(List<OrderCouponVo> usableCoupons) {
		this.usableCoupons = usableCoupons;
	}
	
}
