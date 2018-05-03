package cn.xinmeng.common.mail;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 动态数据源 枚举类
 * @author jiangyong.tan
 *
 */
public enum MailEnum implements IEnum{
	LOG_STAT("/vm/LogStat.vm","系统访问日志统计"),
	;
		
	private MailEnum(String key,String value){
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
		for (MailEnum item : MailEnum.values()) {
			if(item.key().equals(value)){
				exist = true;  break;
			}
		}
		return exist;
	}
}
