package cn.xinmeng.web.shop.entity.customer;

import java.util.List;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 下单，查询可用优惠券
 * @param 
 * @ClassName: S1033RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1033RequestEntity extends RequestBaseEntity {

	private static final long serialVersionUID = -5691191558892166896L;
	
	private List<Integer> cartIds;		//购物车ID

	//set get
	
	public List<Integer> getCartIds() {
		return cartIds;
	}

	public void setCartIds(List<Integer> cartIds) {
		this.cartIds = cartIds;
	}
	
	
	
}
