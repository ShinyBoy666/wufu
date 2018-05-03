package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

public class S1028ResponseEntity extends ResponseBaseEntity{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月29日 下午2:14:23
	 */ 
	private static final long serialVersionUID = -349844112195721722L;
	
	private Double cashAmount;//账户余额
	private Double cashing; //提现中金额
	private boolean cusotmerWithdrawals;//是否能提现
	private boolean accountDeduct;//余额支付
	private Double vipAmount;//vip会员金额
	
	public Double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public Double getCashing() {
		return cashing;
	}
	public void setCashing(Double cashing) {
		this.cashing = cashing;
	}
	public boolean isCusotmerWithdrawals() {
		return cusotmerWithdrawals;
	}
	public void setCusotmerWithdrawals(boolean cusotmerWithdrawals) {
		this.cusotmerWithdrawals = cusotmerWithdrawals;
	}
	public boolean isAccountDeduct() {
		return accountDeduct;
	}
	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}
	public Double getVipAmount() {
		return vipAmount;
	}
	public void setVipAmount(Double vipAmount) {
		this.vipAmount = vipAmount;
	}
	
}
