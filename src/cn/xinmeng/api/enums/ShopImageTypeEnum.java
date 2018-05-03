package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 1、logo 2、店铺形象照 3、老板形象照
 * @param 
 * @ClassName: ShopImageTypeEnum 
 * @version V1.0  
 * @date 2015年12月13日 下午6:53:00 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum ShopImageTypeEnum implements IEnum{
	//1、logo 2、店铺形象照 3、老板形象照
	LOGO("1","logo"),
	SHOP("2","店铺形象照"),
	BOSS("3","老板形象照"),
	;
	
	private ShopImageTypeEnum(String key,String value){
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
		for (ShopImageTypeEnum type : ShopImageTypeEnum.values()) {
			if(type.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static String keyToValue(String key){
		for (ShopImageTypeEnum item : ShopImageTypeEnum.values()) {
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
		for (ShopImageTypeEnum item : ShopImageTypeEnum.values()) {
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
		for (ShopImageTypeEnum item : ShopImageTypeEnum.values()) {
			if(item.toString().equals(enumValue)){
				return item.value();
			}
		}
		return "";
	}
}
