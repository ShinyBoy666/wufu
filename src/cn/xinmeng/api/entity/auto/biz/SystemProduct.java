package cn.xinmeng.api.entity.auto.biz;

import java.util.List;

public class SystemProduct {
	
	private List<ProductVersion> systemProduct;

	//活动产品
	private List<ProductVersion> activityProduct;

	
	public List<ProductVersion> getSystemProduct() {
		return systemProduct;
	}

	public void setSystemProduct(List<ProductVersion> systemProduct) {
		this.systemProduct = systemProduct;
	}

	public List<ProductVersion> getActivityProduct() {
		return activityProduct;
	}

	public void setActivityProduct(List<ProductVersion> activityProduct) {
		this.activityProduct = activityProduct;
	}
	
	
}
