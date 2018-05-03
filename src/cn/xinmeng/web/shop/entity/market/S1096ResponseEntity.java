package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 活动详情
 * @author Administrator
 *
 */
public class S1096ResponseEntity extends ResponseBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3377033445923854504L;
	
	private Integer shopId;			//店铺id
	private String shopLogo; 		//店铺Logo
    private String shopName; 		//店铺名称
    private String shopAddress; 	//详细地址
    private String remark;
    
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
