package cn.xinmeng.web.shop.entity.customer;

import java.util.List;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCustCouponVo;

/**
 * 店铺可用优惠券
 * @param 
 * @ClassName: S1011ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1033ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = 276803916103086879L;
	
	private int shopId;								//店铺ID
	private String shopName;						//店铺名称
	private String shopLogo;						//店铺logo
	private Double postage;							//邮费
	private boolean isDelivery = true;				//是否需要发货
	private boolean isRealyname = false;			//是否需要填写身份证
	private List<ShopCustCouponVo> usableCoupons;	//可使用优惠券
	
	
	//set get
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public List<ShopCustCouponVo> getUsableCoupons() {
		return usableCoupons;
	}
	public void setUsableCoupons(List<ShopCustCouponVo> usableCoupons) {
		this.usableCoupons = usableCoupons;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Double getPostage() {
		return postage;
	}
	public void setPostage(Double postage) {
		this.postage = postage;
	}
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
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
	
}
