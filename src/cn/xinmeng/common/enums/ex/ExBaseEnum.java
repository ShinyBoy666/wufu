package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 账户流水收支类型枚举
 * @author 侯斌飞
 *
 */
public enum ExBaseEnum implements IEnum{
	EX_NULL_SMS_CODE("E_GENERAL_BASE","验证码为空..."),
	EX_NOTEXIS_SMS_CODE("E_GENERAL_BASE","验证码不存在..."),
	EX_ERROR_SMS_CODE("E_GENERAL_BASE","验证码已失效..."),
	
	EX_NULL_KEYWORD("E_GENERAL_BASE","关键词为空..."),
	EX_ERROR_UPLOAD_IMAGE("E_GENERAL_BASE","图片上传失败..."),
	EX_NULL_UPLOAD_IMAGE("E_GENERAL_BASE","上传图片为空..."),
	
	EX_NULL_TYPE("E_GENERAL_BASE","类型为空..."),
	EX_NULL_BASE64("E_GENERAL_BASE","加密串为空..."),
	
	EX_NULL_RECEIVE_TYPE("E_GENERAL_BASE","结束类型编号..."),
	EX_NULL_NOTICE_ID("E_GENERAL_BASE","消息编号为空..."),
	EX_NULL_NOTICE_TYPE("E_GENERAL_BASE","消息类别为空..."),
	EX_NOTEXIS_NOTICE_TYPE("E_GENERAL_BASE","消息类别不存在..."),
	EX_UNKNOWN("EX_UNKNOWN","未知异常..."),
	
	;
	private ExBaseEnum(String key,String value){
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
