package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 会员充值
 * @param 
 * @ClassName: S1067RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1067RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private Integer orderFrom;				//订单来源
	private Integer onlinePayType;			//在线支付方式
	private boolean accountDeduct;			//是否账户扣款
	private Double amount;					//充值金额
	private int type;					//类型
	
	//set get
	
	public Integer getOrderFrom() {
		return orderFrom;
	}
	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}
	public Integer getOnlinePayType() {
		return onlinePayType;
	}
	public void setOnlinePayType(Integer onlinePayType) {
		this.onlinePayType = onlinePayType;
	}
	public boolean isAccountDeduct() {
		return accountDeduct;
	}
	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
