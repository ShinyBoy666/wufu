package cn.xinmeng.web.shop.entity.order;

import java.util.List;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 查询订单确认页面数据
 * @param 
 * @ClassName: S1058RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1058RequestEntity extends RequestBaseEntity {

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
