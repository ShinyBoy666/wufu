package cn.xinmeng.web.shop.entity.quickorder;

import java.util.List;
import java.util.Map;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;

/**
 * 
 * @author Administrator
 *
 */
public class S1092ResponseEntity extends ResponseBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1815585107949135946L;
	
	private double amount;//余额
	
	private List<Map<String, Object>> list;
	
	private int customerId;//客户编号
	
	private CustomerUser customer;
	
	private int orderCount;//今日已优惠订单数
	
	private String adContent = "优惠买单，随机立减";
	
	private String randomDesc = "";

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public CustomerUser getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerUser customer) {
		this.customer = customer;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	public String getRandomDesc() {
		return randomDesc;
	}

	public void setRandomDesc(String randomDesc) {
		this.randomDesc = randomDesc;
	}

}
