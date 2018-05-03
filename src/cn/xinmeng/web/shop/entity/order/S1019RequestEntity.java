package cn.xinmeng.web.shop.entity.order;

import cn.xinmeng.web.base.entity.PageSearchEntity;


/**
 * 我的订单详情
 * @param 
 * @ClassName: S1019RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1019RequestEntity extends PageSearchEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private String parentOrderId;	//订单ID
	private String childOrderId;//子订单ID

	
	//set get
	
	public String getParentOrderId() {
		return parentOrderId;
	}
	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	public String getChildOrderId() {
		return childOrderId;
	}
	public void setChildOrderId(String childOrderId) {
		this.childOrderId = childOrderId;
	}
}
