package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 账户流水收支类型枚举
 * @author 侯斌飞
 *
 */
public enum ExSmsEnum implements IEnum{
	EX_SMS_FAILD("EX_SMS_FAILD","验证吗发送失败..."),
	EX_BLACK_PHONE("EX_BLACK_PHONE","手机号码为黑名单..."),
	EX_PHONE_CHECK("EX_PHONE_CHECK","检测手机失败..."),
	
	;
	private ExSmsEnum(String key,String value){
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
