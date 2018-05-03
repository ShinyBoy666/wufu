package cn.xinmeng.web.base.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RequestBaseEntity implements Serializable{
	
	private int id;	//主键
	private int customerId;	//客户ID
	private int shopId;	//店铺ID
	private String openId;//微信openId
	
	//set get
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
