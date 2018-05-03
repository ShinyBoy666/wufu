package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 分利级别
 * 1、一级2、二级3、三级4、货款
 * @param 
 * @ClassName: ProfitLevelEnum 
 * @version V1.0  
 * @date 2015年12月13日 下午6:53:00 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum ProfitLevelEnum implements IEnum{
	profit_frist("1","一级利润"),
	profit_second("2","二级利润"),
	profit_third("3","三级利润"),
	profit_shop("4","货款"),
	;
	
	private ProfitLevelEnum(String key,String value){
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
		for (ProfitLevelEnum type : ProfitLevelEnum.values()) {
			if(type.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static String keyToValue(String key){
		for (ProfitLevelEnum item : ProfitLevelEnum.values()) {
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
		for (ProfitLevelEnum item : ProfitLevelEnum.values()) {
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
		for (ProfitLevelEnum item : ProfitLevelEnum.values()) {
			if(item.toString().equals(enumValue)){
				return item.value();
			}
		}
		return "";
	}
}
