package cn.xinmeng.web.shop.entity.order;

import java.util.List;

import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.shop.entity.order.vo.OrderCartVo;


/**
 * 查询购物车优惠券邮费相关信息
 * @param 
 * @ClassName: S1044RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1044RequestEntity extends RequestBaseEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private List<OrderCartVo> orderCarts;
	
	//set get
	
	public List<OrderCartVo> getOrderCarts() {
		return orderCarts;
	}

	public void setOrderCarts(List<OrderCartVo> orderCarts) {
		this.orderCarts = orderCarts;
	}
	
	
}
