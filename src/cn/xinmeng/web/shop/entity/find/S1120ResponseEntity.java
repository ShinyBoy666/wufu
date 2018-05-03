package cn.xinmeng.web.shop.entity.find;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

public class S1120ResponseEntity extends ResponseBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8323762599918055780L;
	
	private Double cashAmount;//账户余额
	private boolean accountDeduct;//余额支付
	private Integer type; //类型
	private Double amount; //金额
	private String remark; 
	
	public Double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public boolean isAccountDeduct() {
		return accountDeduct;
	}
	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
