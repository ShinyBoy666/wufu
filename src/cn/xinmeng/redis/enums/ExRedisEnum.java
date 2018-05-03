package cn.xinmeng.redis.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

public enum ExRedisEnum implements IEnum{
	SET_KEY_NULL("set_key_null","set key is null..."),
	SET_value_NULL("set_velue_null","set velue is null..."),
	HSET_FIELD_NULL("hset_field_null","hset field is null..."),
	CALLABLE_IPCALL_NULL("callable_ipcall_null","IPCallable is null..."),
	PIPELINE_NULL("Pipeline_null","Pipeline is null..."),
	ININT_POOL_FAILD("inintPool_faild","inint Pool faild..."),
	;
	
	private ExRedisEnum(String key,String value){
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
