package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.api.entity.auto.Coupon;

/**
 * 配额后：优惠券领取
 * @param 
 * @ClassName: S1086RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1099RequestEntity extends Coupon {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5812494986650172123L;
	
	private String orderId;

	//set get

	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
