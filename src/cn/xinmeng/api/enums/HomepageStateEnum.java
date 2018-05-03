package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 首页模块状态
 * @author Administrator
 *
 */
public enum HomepageStateEnum implements IEnum{
	
	NOT_EFFECTION("1","无效"),
	WAIT_RELEASE("2","待上架"),
	EFFECTION("3","有效"),
	;
	
	private HomepageStateEnum(String key,String value){
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
		for (HomepageStateEnum type : HomepageStateEnum.values()) {
			if(type.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static String keyToValue(String key){
		for (HomepageStateEnum item : HomepageStateEnum.values()) {
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
		for (HomepageStateEnum item : HomepageStateEnum.values()) {
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
		for (HomepageStateEnum item : HomepageStateEnum.values()) {
			if(item.toString().equals(enumValue)){
				return item.value();
			}
		}
		return "";
	}
}
