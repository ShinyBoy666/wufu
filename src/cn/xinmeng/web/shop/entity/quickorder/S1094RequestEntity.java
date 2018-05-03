package cn.xinmeng.web.shop.entity.quickorder;

import cn.xinmeng.web.base.entity.RequestBaseEntity;


/**
 * 
 * @author Administrator
 *
 */
public class S1094RequestEntity extends RequestBaseEntity{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3050999557506479252L;
	
    private String rechargeId; //支付单号

	public String getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(String rechargeId) {
		this.rechargeId = rechargeId;
	}
}
