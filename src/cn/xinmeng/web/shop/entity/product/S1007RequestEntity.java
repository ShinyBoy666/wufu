package cn.xinmeng.web.shop.entity.product;


import cn.xinmeng.web.base.entity.RequestBaseEntity;

public class S1007RequestEntity extends RequestBaseEntity{

	
	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月25日 下午2:47:28
	 */ 
	private static final long serialVersionUID = -1716896845751930014L;
	
	private Integer productId;//商品编号

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
}
