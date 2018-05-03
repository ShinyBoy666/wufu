package cn.xinmeng.web.shop.entity.order;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;


public class S1085ResponseEntity extends ResponseBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1392125299434669379L;
	
	private Double postage;				//邮费
	private Double postageFree;			//满多少免邮费
	
	public Double getPostage() {
		return postage;
	}
	public void setPostage(Double postage) {
		this.postage = postage;
	}
	public Double getPostageFree() {
		return postageFree;
	}
	public void setPostageFree(Double postageFree) {
		this.postageFree = postageFree;
	}
	
}
