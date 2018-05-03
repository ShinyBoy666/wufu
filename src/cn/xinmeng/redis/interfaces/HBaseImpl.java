package cn.xinmeng.redis.interfaces;

import cn.xinmeng.common.exceptions.RedisException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.redis.enums.ExRedisEnum;

public class HBaseImpl {

	/**
	 * 校验数据
	 * @param key
	 * @param value
	 */
	protected void verify(String key,String value){
		if(Utils.isEmpty(key)){
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		if(Utils.isEmpty(value)){
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_value_NULL);
		}
	}
	
	/**
	 * 校验数据
	 * @param key
	 * @param value
	 */
	protected void verify(String key,String field,String value){
		if(Utils.isEmpty(key)){
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		if(Utils.isEmpty(field)){
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.HSET_FIELD_NULL);
		}
		if(Utils.isEmpty(value)){
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_value_NULL);
		}
	}
	
}
