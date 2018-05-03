package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单模块错误提示
 * @param 
 * @ClassName: ExFindActivityEnum 
 * @version V1.0  
 * @date 2015年12月8日 上午9:14:17 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum ExFindActivityEnum implements IEnum {
	EX_ACTIVITYPURCHASE("EX_ACTIVITYPURCHASE","您已经参与活动..."),
	EX_NULL_ACTIVITYID("EX_NULL_ACTIVITYID","活动ID为空..."),
	EX_NULL_ACTIVITYTYPE("EX_NULL_ACTIVITYTYPE","活动类型为空..."),
	EX_EXISTS_ACTIVITY("EX_EXISTS_ACTIVITY","活动不存在..."),
	EX_ACTIVITY_OVERDUE("EX_ACTIVITY_OVERDUE","活动过期..."),
	EX_ACTIVITY_NOT_START("EX_ACTIVITY_NOT_START","活动未开始..."),
	;
	private ExFindActivityEnum(String key,String value){
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
