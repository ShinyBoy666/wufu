package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 账户流水收支类型枚举
 */
public enum ExpendIncomeEnum implements IEnum{
	IE_INCOME("1","收入"),
	IE_EXPEND("2","支出"),
	;
	private ExpendIncomeEnum(String key,String value){
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
		for (ExpendIncomeEnum item : ExpendIncomeEnum.values()) {
			if(item.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static String keyToValue(String key){
		for (ExpendIncomeEnum item : ExpendIncomeEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(ExpendIncomeEnum.exist("1"));
	}
}
