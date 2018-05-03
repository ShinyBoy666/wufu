package cn.xinmeng.web.shop.entity.cart;

import java.util.Date;
import java.util.List;

import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;

/**
 * 购物车列表 
 * @param 
 * @ClassName: S1011ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1011ResponseEntity extends ResponseBaseEntity {
	
	private static final long serialVersionUID = -5348933895744384738L;

    private String shopLogo; 				//店铺Logo
	private Integer shopId;					//店铺ID
	private String shopName;				//店铺名称
	private Date endAddCartTime;			//店铺最后一个商品添加购物车的时间
	List<ShopCartVo> shopCarts;				//店铺购物车商品
	
	//set get
	
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public List<ShopCartVo> getShopCarts() {
		return shopCarts;
	}
	public void setShopCarts(List<ShopCartVo> shopCarts) {
		this.shopCarts = shopCarts;
	}
	public Date getEndAddCartTime() {
		return endAddCartTime;
	}
	public void setEndAddCartTime(Date endAddCartTime) {
		this.endAddCartTime = endAddCartTime;
	}
	public String getShopLogo() {
		if(Utils.isEmpty(shopLogo)){
			return HelperPropertie.getValue("jipinhui.logo");
		}
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	
}
