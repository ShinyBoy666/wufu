package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单模块错误提示
 * @param 
 * @ClassName: ShowOrderStateEnum 
 * @version V1.0  
 * @date 2015年12月8日 上午9:14:17 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum ExCouponEnum implements IEnum {
	EX_NULL_COUPONID("EX_NULL_COUPONID","优惠券ID为空..."),
	EX_NOTEXISTS_COUPONID("EX_NOTEXISTS_COUPONID","优惠券信息不存在..."),
	EX_NULL_COUPONAPPLYID("EX_NULL_COUPONAPPLYID","优惠券申请ID为空..."),
	EX_NECK_NOTHAVE("EX_NECK_NOTHAVE","优惠券已领完..."),
	EX_OVER("EX_OVER","优惠券已过期..."),
	EX_MAX_HAVE("EX_MAX_HAVE","已领取限制张数..."),
	EX_NECK_USE("EX_NECK_USE","优惠券已被领用..."),
	;
	private ExCouponEnum(String key,String value){
		this.key = key;
		this.value = value;
	}
	private String key;
	private String value;
	
	@Override
	public String value() {
		return this.value;
	}

	@Override
	public String key() {
		return this.key;
	}

	@Override
	public IEnum parseValue(Object... params) {
		return setValue(MessageFormat.format(value, params));
	}

	@Override
	public IEnum setValue(String value) {
		this.value = value;
		return this;
	}

}
