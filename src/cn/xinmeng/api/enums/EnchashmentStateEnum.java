package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 体现记录状态
 * @param 
 * @ClassName: EnchashmentStateEnum 
 * @version V1.0  
 * @date 2015年12月13日 下午6:53:00 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum EnchashmentStateEnum implements IEnum{

	////1审核中、2、审核通过3、审核拒绝、4、打款失败5、打款完成
//	UNTREATED("1","未处理"),
	AUDIT("1","审核中"),
	AUDIT_PASS("2","审核通过"),
	AUDIT_REJECT("3","审核拒绝"),
	FAILURE_TO_PLAY("4","打款失败"),
	COMPLETION_OF_THE_PLAY("5","打款完成"),
	;
	
	private EnchashmentStateEnum(String key,String value){
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
		for (EnchashmentStateEnum type : EnchashmentStateEnum.values()) {
			if(type.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static String keyToValue(String key){
		for (EnchashmentStateEnum item : EnchashmentStateEnum.values()) {
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
		for (EnchashmentStateEnum item : EnchashmentStateEnum.values()) {
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
		for (EnchashmentStateEnum item : EnchashmentStateEnum.values()) {
			if(item.toString().equals(enumValue)){
				return item.value();
			}
		}
		return "";
	}
}
