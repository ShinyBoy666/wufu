package cn.xinmeng.web.shop.entity.order;

import cn.xinmeng.web.base.entity.RequestBaseEntity;


/**
 * 取消、确认订单
 * @param 
 * @ClassName: S1020RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1020RequestEntity extends RequestBaseEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private String parentOrderId;	//父订单ID
	private String childOrderId;	//子订单ID
	private Integer state;	//确认/取消： 1-确认收货，2-取消订单，3-删除订单，4-后台超时取消
	private String remark;//备注
	
	//set get
	
	public String getParentOrderId() {
		return parentOrderId;
	}
	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getChildOrderId() {
		return childOrderId;
	}
	public void setChildOrderId(String childOrderId) {
		this.childOrderId = childOrderId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
