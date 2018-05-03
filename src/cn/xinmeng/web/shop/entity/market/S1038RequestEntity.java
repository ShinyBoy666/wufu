package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.PageSearchEntity;

public class S1038RequestEntity extends PageSearchEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4848846568572551577L;
	
	private String type;		//类型
	private String shopName;	//店铺名称
	//set get
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
}
