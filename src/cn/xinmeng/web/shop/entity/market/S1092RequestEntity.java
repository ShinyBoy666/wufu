package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 优惠买单，订单确认页，优惠券列表选择
 * @param 
 * @ClassName: S1089RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1092RequestEntity extends RequestBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6035737297525955418L;
	
	private Double orderMoney;

	//set get


	public Double getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	
}
