package cn.xinmeng.web.shop.entity.customer;

import java.util.List;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 兑换优惠券
 * @param 
 * @ClassName: S1053RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1053RequestEntity extends RequestBaseEntity {

	private static final long serialVersionUID = -5691191558892166896L;
	
	private String couponCode;		//优惠券编码


	//set get
	
	
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
}
