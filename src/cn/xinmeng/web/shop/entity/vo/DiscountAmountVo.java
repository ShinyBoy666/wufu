package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.List;

public class DiscountAmountVo implements Serializable{
	private static final long serialVersionUID = 1443358261246898403L;
	
	private Integer one;//1元
	private Integer five;//5元
	private Integer ten;//10元
	private Integer twenty;//20元
	private Integer fifty;//50元
	private Integer oneHundred;//100元
	
	private List<Double> amountList;//金额集合
	
	
	public Integer getOne() {
		return one;
	}
	public void setOne(Integer one) {
		this.one = one;
	}
	public Integer getFive() {
		return five;
	}
	public void setFive(Integer five) {
		this.five = five;
	}
	public Integer getTen() {
		return ten;
	}
	public void setTen(Integer ten) {
		this.ten = ten;
	}
	public Integer getTwenty() {
		return twenty;
	}
	public void setTwenty(Integer twenty) {
		this.twenty = twenty;
	}
	public Integer getFifty() {
		return fifty;
	}
	public void setFifty(Integer fifty) {
		this.fifty = fifty;
	}
	public Integer getOneHundred() {
		return oneHundred;
	}
	public void setOneHundred(Integer oneHundred) {
		this.oneHundred = oneHundred;
	}
	public List<Double> getAmountList() {
		return amountList;
	}
	public void setAmountList(List<Double> amountList) {
		this.amountList = amountList;
	}
	
}
