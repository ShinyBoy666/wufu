package cn.xinmeng.web.shop.entity.pay;


import java.util.Date;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 我的支付明细
 * @param 
 * @ClassName: S1024ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午3:44:54 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1024ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = 3212581273611791210L;
	
    public double amount;	//金额
    public int paymentType;	//1.收入；2.支出
    public Date createTime;	//创建时间
    public String remark;	//备注
    private Double nowMoney; //本次结余
    
    //set get
    
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Double getNowMoney() {
		return nowMoney;
	}
	public void setNowMoney(Double nowMoney) {
		this.nowMoney = nowMoney;
	}
 
}
