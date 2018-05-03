package cn.xinmeng.common.enums;

public interface IEnum {
	/**
	 * 返回 value
	 * @return
	 */
	String value();
	
	/**
	 * 返回 key
	 * @return
	 */
	String key();
	
	
	/**
	 * 解析枚举 value
	 * @param params
	 * @return
	 */
	IEnum setValue(String value);
	
	/**
	 * 解析枚举 value
	 * @param params
	 * @return
	 */
	IEnum parseValue(Object... params);
	
}
