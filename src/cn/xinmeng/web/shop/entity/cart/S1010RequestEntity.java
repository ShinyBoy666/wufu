package cn.xinmeng.web.shop.entity.cart;

import java.util.List;

import cn.xinmeng.web.base.entity.RequestBaseEntity;


/**
 * 删除购物车信息
 * @param 
 * @ClassName: S1010RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:09:15 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1010RequestEntity extends RequestBaseEntity {

	private static final long serialVersionUID = 183342262548121208L;

	private List<Integer> cartIds;//购物车ID集合

	
	//set get
	
	
	public List<Integer> getCartIds() {
		return cartIds;
	}

	public void setCartIds(List<Integer> cartIds) {
		this.cartIds = cartIds;
	}
	
	
}
