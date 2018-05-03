package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.PageSearchEntity;

/**
 * 我的优惠券列表
 * @param 
 * @ClassName: S1031RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1031RequestEntity extends PageSearchEntity {

	private static final long serialVersionUID = -5691191558892166896L;
	
	private int couponState;	//优惠券状态1-未使用，2-已过期，3-已使用

	public int getCouponState() {
		return couponState;
	}

	public void setCouponState(int couponState) {
		this.couponState = couponState;
	}
	
	
}
