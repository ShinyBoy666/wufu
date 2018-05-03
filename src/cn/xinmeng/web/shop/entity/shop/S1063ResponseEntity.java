package cn.xinmeng.web.shop.entity.shop;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 附近店铺首页
 * @author tanjiangyong
 *
 */
public class S1063ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = 3434907141246448415L;
	
	private String shopName;	//店铺名称
	private String shopLogo;	//店铺logo
	private String shopImage;	//店铺图片
	
	//set get 
	
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
	public String getShopImage() {
		return shopImage;
	}
	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}
}
