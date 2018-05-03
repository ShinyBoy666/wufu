package cn.xinmeng.web.shop.entity.order;

import cn.xinmeng.web.base.entity.PageSearchEntity;


/**
 * 我的订单查询
 * @param 
 * @ClassName: S1018RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1018RequestEntity extends PageSearchEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private int orderState;	//状态 0 1-待付款，2-进行中，3，已完成

	
	//set get
	
	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	
	
}
