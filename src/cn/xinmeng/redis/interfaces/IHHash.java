package cn.xinmeng.redis.interfaces;

import java.util.Map;

public interface IHHash{
	/**
	 * redis => 数据结构 => String
	 * hset 数据
	 * @param key
	 * @param value
	 */
	void hset(String key,String field,String value);
	
	/**
	 * redis => 数据结构 => String
	 * hset 数据
	 * @param key
	 * @param expireTime 过期时间-单位秒
	 * @param value
	 */
	void hset(String key,int expireTime,String field,String value);
	
	/**
	 * 添加 Map
	 * @param key 
	 * @param map
	 */
	void hset(String key,Map<String,String> map);
	
	/**
	 * 添加 Map
	 * @param key 
	 * @param expireTime 过期时间-单位秒
	 * @param map
	 */
	void hset(String key,int expireTime,Map<String,String> map);
	
	/**
	 * 删除Map，指定key
	 * @param key
	 * @param field
	 * @param value
	 */
	long hdel(String key);

	/**
	 * 删除Map，指定key，field
	 * @param key
	 * @param field
	 * @param value
	 */
	long hdel(String key,String ...field);
	

	/**
	 * 值＋1
	 * @param key
	 * @param field
	 * @param value
	 */
	public long hincrBy(String key,String field,long value);
}
