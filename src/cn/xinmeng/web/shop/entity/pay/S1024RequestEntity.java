package cn.xinmeng.web.shop.entity.pay;

import java.util.Date;

import cn.xinmeng.web.base.entity.PageSearchEntity;


/**
 * 支付明细
 * @param 
 * @ClassName: S1024RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1024RequestEntity extends PageSearchEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private int paymentType;	//支付类型 1：收入，2：支出
	private Date beginTime;		//支付明细开始时间
	private Date endTime;		//支付明细结束时间
	
	//set get
	
	
	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
