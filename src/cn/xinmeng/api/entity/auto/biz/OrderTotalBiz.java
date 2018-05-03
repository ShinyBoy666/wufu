package cn.xinmeng.api.entity.auto.biz;

import cn.xinmeng.common.entity.IEntity;

public class OrderTotalBiz implements IEntity{

	private static final long serialVersionUID = 2110387343703815190L;
	
	private Integer orderCount;//订单总数
	private Double totalAmount;//总金额
	private Double cachAmount;//现金支付金额
	
	//set get
	
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getCachAmount() {
		return cachAmount;
	}
	public void setCachAmount(Double cachAmount) {
		this.cachAmount = cachAmount;
	}
}
