package cn.xinmeng.web.shop.entity.cart;

import cn.xinmeng.web.base.entity.RequestBaseEntity;


/**
 * 修改购物车商品数量
 * @param 
 * @ClassName: S1009RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:09:15 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1009RequestEntity extends RequestBaseEntity {

	private static final long serialVersionUID = 183342262548121208L;

	private Integer productNumber;//商品数量
	
	
	
	//set get
	
	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	
	
}
