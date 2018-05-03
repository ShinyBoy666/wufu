package cn.xinmeng.web.shop.entity.product;


import cn.xinmeng.web.base.entity.RequestBaseEntity;

public class S1050RequestEntity extends RequestBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4385389850673963346L;
	
	private Integer productCategoryLevel; //商品类别层级1、一级2、二级3、三级

	public Integer getProductCategoryLevel() {
		return productCategoryLevel;
	}

	public void setProductCategoryLevel(Integer productCategoryLevel) {
		this.productCategoryLevel = productCategoryLevel;
	}
	
}
