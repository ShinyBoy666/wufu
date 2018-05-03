package cn.xinmeng.web.shop.entity.order.vo;

import java.util.List;

public class OrderCartVo {

	private Integer shopId;			//店铺ID
	private String couponCode;		//优惠券编码
	private List<Integer> cartIds;	//购物车id集合
	
	//set get
	
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public List<Integer> getCartIds() {
		return cartIds;
	}
	public void setCartIds(List<Integer> cartIds) {
		this.cartIds = cartIds;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
}
