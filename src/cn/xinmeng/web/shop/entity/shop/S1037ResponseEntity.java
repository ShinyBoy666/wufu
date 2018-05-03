package cn.xinmeng.web.shop.entity.shop;


import java.util.ArrayList;
import java.util.List;

import cn.xinmeng.common.util.H5Utils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.vo.BannerVo;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingParentVo;
import cn.xinmeng.web.shop.entity.vo.IcoSettingVo;

public class S1037ResponseEntity extends ResponseBaseEntity{

	
	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午5:56:41
	 */ 
	private static final long serialVersionUID = -1050373687115968721L;
	
	private List<IcoSettingVo> topMenu;//首页顶部菜单
	
	private String shopLogo; //店铺Logo
	
	private String shopName; //店铺名称
	
	private String shopPhone; //联系电话
	
	private String serverPhone; //客服电话
	
	private int noticeCount;//消息未读数量
	
	private Integer cartCount;	//购物车商品数量
	
	private List<BannerVo> bannerList;//轮播图
	
	private List<HomepageSettingParentVo> modulList;//模块集合
	
	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	
	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getServerPhone() {
		return serverPhone;
	}

	public void setServerPhone(String serverPhone) {
		this.serverPhone = serverPhone;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public List<BannerVo> getBannerList() {
		return bannerList;
	}

	public void setBannerList(List<BannerVo> bannerList) {
		this.bannerList = bannerList;
	}

	public List<HomepageSettingParentVo> getModulList() {
		return modulList;
	}

	public void setModulList(List<HomepageSettingParentVo> modulList) {
		this.modulList = modulList;
	}

	public Integer getCartCount() {
		return cartCount;
	}
	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}

	public List<IcoSettingVo> getTopMenu() {
		if(Utils.isEmpty(topMenu)){
			topMenu = new ArrayList<IcoSettingVo>();
			topMenu.add(new IcoSettingVo("联系商家",H5Utils.getLoaclUrl("statics/img/page/contactShop-icon.jpg"),""));
			topMenu.add(new IcoSettingVo("领取优惠券",H5Utils.getLoaclUrl("statics/img/page/coupon-icon.jpg"),""));
			topMenu.add(new IcoSettingVo("收藏商品",H5Utils.getLoaclUrl("statics/img/page/collection-icon.jpg"),""));
			topMenu.add(new IcoSettingVo("附近店铺",H5Utils.getLoaclUrl("statics/img/page/near-icon.jpg"),""));
		}
		return topMenu;
	}

	public void setTopMenu(List<IcoSettingVo> topMenu) {
		this.topMenu = topMenu;
	}
	
}
