package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 秒杀商品列表
 * @param 
 * @ClassName: S1070RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1091RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String orderId;
	private Double amount;

	//set get

	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
