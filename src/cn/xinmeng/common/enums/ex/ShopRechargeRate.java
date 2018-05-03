package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import cn.xinmeng.common.util.UtilMoney;

public class ShopRechargeRate {
	
	public static List<ShopRechargeRate> list;
	
	static{
		list = new ArrayList<ShopRechargeRate>();
		list.add(new ShopRechargeRate(0, 6.0));
		list.add(new ShopRechargeRate(1, 10, 50.0));
		list.add(new ShopRechargeRate(2, 30, 120.0));
		list.add(new ShopRechargeRate(3, 60, 180.0));
		list.add(new ShopRechargeRate(4, 120, 240.0));
		list.add(new ShopRechargeRate(5, 360, 360.0));
	}
	
	public ShopRechargeRate(Integer type,Double dayAmount){
		this.type = type;
		this.dayAmount = dayAmount;
		this.remark = MessageFormat.format("输入您想要充值的天数({0}元/天)", dayAmount);
	}
	
	public ShopRechargeRate(Integer type,Integer days,Double amount){
		this.type = type;
		this.days = days;
		this.amount = amount;
		double dayAmount = UtilMoney.roundToDouble(UtilMoney.divideToDouble(amount, days), 2);
		this.dayAmount = dayAmount;
		this.remark = MessageFormat.format("您已选择{0}天会员套餐，相当于{1}元/天，需支付{2}元", days,dayAmount,amount);
	}
	
	private Integer type;//类型
	private Integer days;//天数
	private Double dayAmount;//每天金额
	private Double amount;//金额
	private String remark;//备注
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Double getDayAmount() {
		return dayAmount;
	}
	public void setDayAmount(Double dayAmount) {
		this.dayAmount = dayAmount;
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
