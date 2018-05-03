package cn.xinmeng.common.enums;

import java.text.MessageFormat;

/**
 * 动态数据源 枚举类
 * @author jiangyong.tan
 *
 */
public enum EnumDataBase implements IEnum{
	DB_BUSINESS_RW("masterDataSource","主业务库"),
	DB_BUSINESS_R("slaveDataSource","从业务库"),
	DB_PRIVILEGE_RW("privilegeSource","权限库"),
	;
		
	private EnumDataBase(String key,String value){
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
		for (EnumDataBase item : EnumDataBase.values()) {
			if(item.key().equals(value)){
				exist = true;  break;
			}
		}
		return exist;
	}
}
