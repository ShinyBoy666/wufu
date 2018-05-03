package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单类型
 * @param 
 * @ClassName: OrderTypeEnum 
 * @version V1.0  
 * @date 2015年12月13日 下午6:53:00 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum OrderTypeEnum implements IEnum{
	//1、普通订单 2、会员订单、3、团购 4、砍价 5、秒杀 6、特价 7、积分订单
	GENERAL("1","普通订单"),
	MEMBER("2","会员订单"),
	GROUP("3","团购"),
	BARGAIN("4","砍价"),
	SECKILL("5","秒杀"),
	SPECIAL("6","特价"),
	INTEGRAL("7","积分订单"),
	SERVICE("8","增值服务"),
	;
	
	private OrderTypeEnum(String key,String value){
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
	/**
	 * 校验是否存在
	 * @param value
	 * @return
	 */
	public static boolean exist(String value){
		boolean exist = false;
		for (OrderTypeEnum type : OrderTypeEnum.values()) {
			if(type.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static Integer activityTypeToOrderType(Integer activityType){
		String value = ActivityTypeEnum.keyToValue(activityType+"");
		for (OrderTypeEnum item : OrderTypeEnum.values()) {
			if(item.value().equals(value)){
				return Integer.valueOf(item.key);
			}
		}
		return 0;
	}

	public static Integer orderTypeToActivityType(Integer orderType){
		String value = keyToValue(orderType+"");
		for (ActivityTypeEnum item : ActivityTypeEnum.values()) {
			if(item.value().equals(value)){
				return Integer.valueOf(item.key());
			}
		}
		return 0;
	}
	
	public static String keyToValue(String key){
		for (OrderTypeEnum item : OrderTypeEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
	
	/**
	 * 通过枚举字符查找key
	 * 枚举项 => toString
	 * @param key
	 * @return
	 */
	public static String enumToKey(String enumValue){
		for (OrderTypeEnum item : OrderTypeEnum.values()) {
			if(item.toString().equals(enumValue)){
				return item.key();
			}
		}
		return "";
	}
	
	/**
	 * 通过枚举字符查找value
	 * 枚举项 => toString
	 * @param key
	 * @return
	 */
	public static String enumToValue(String enumValue){
		for (OrderTypeEnum item : OrderTypeEnum.values()) {
			if(item.toString().equals(enumValue)){
				return item.value();
			}
		}
		return "";
	}
}
