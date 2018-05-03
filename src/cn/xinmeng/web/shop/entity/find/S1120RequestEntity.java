package cn.xinmeng.web.shop.entity.find;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

public class S1120RequestEntity extends RequestBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2821482379344086159L;
	
	private Integer type; //类型：1-会员；2-发现会员；3-小组

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
