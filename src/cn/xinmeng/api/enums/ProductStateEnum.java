package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 商品状态枚举
 * @author 谭江勇
 */
public enum ProductStateEnum implements IEnum{
	//1：无效、2：有效、3：上架、4：下架
	STATE_FAILURE("1","无效"),
	STATE_VALID("2","有效"),
	STATE_SHELVE("3","上架"),
	STATE_UNSHELVE_PLATForm("4","下架"),
	;

	private ProductStateEnum(String key,String value){
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
		for (ProductStateEnum state : ProductStateEnum.values()) {
			if(state.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	public static String keyToValue(String key){
		for (ProductStateEnum item : ProductStateEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
	
	@Override
	public String toString() {
		return "aaa";
	}
}
