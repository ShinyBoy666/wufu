package cn.xinmeng.common.enums;

import java.text.MessageFormat;

/**
 * 订单来源枚举
 * @author jiangyong.tan
 * 1 - IOS；2 - 安卓；3 - WAP
 */
public enum RequestSourceEnum implements IEnum{
	SOURCE_FROM_IOS("1","IOS"),
	SOURCE_FROM_ANDROID("2","安卓"),
	SOURCE_FROM_WAP("3","WAP"),
	;
	private RequestSourceEnum(String key,String value){
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
		for (RequestSourceEnum source : RequestSourceEnum.values()) {
			if(source.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
}
