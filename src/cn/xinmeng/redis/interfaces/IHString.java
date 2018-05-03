package cn.xinmeng.redis.interfaces;

import java.util.List;
import java.util.Set;

public interface IHString {
	
	/**
	 * redis => 数据结构 => String
	 * set 数据
	 * @param key
	 * @param value
	 */
	void set(String key,String value);
	
	/**
	 * redis => 数据结构 => String
	 * set 数据
	 * @param key
	 * @param expireTime 过期时间，单位秒
	 * @param value
	 */
	void set(String key,int expireTime,String value);
	
	/**
	 * redis => 数据结构 => String
	 * get 数据
	 * @param key
	 */
	String get(String key);
	
	/**
	 * redis => 数据结构 => String
	 * 多个 key 获取多个value
	 * @param keys key 数组
	 */
	List<String> mget(String... keys);
	
	/**
	 * redis => 数据结构 => String
	 * 多个 key 获取多个value
	 * @param keys key 数组
	 */
	List<String> mget(List<String> keys);
	/**
	 * redis => 数据结构 => String
	 * 向指定的 key 的 value 追加字符串
	 * @param key
	 * @param value 追加字符串
	 */
	void append(String key,String value);
	
	/**
	 * redis => 数据结构 => String
	 * 删除指定 key
	 * @param key
	 */
	void del(String key);
	
	/**
	 * 根据key，对数据的减
	 * 默认减，负值加
	 * @param key
	 * @param integer
	 * @return
	 */
	long decrBy(String key,int integer);
	
	/**
	 * 查询模糊匹配的key
	 * @param key
	 * @return
	 */
	Set<String> getKeys(String key);
	
	

	/**
	 * 往数据右边set值
	 * @param key
	 * @param value
	 * @return
	 */
	public Long rightPush(String key,String value);

	/**
	 * 往数据左边set值
	 * @param key
	 * @param value
	 * @return
	 */
	public Long leftPush(String key,String value);
	/**
	 * 往数据右边跟get值
	 * @param key
	 * @return
	 */
	public String rightPop(String key);

	/**
	 * 往数据左边get值
	 * @param key
	 * @return
	 */
	public String leftPop(String key);
	
	/**
	 * 往数据左边get值集合
	 * @param key
	 * @return
	 */
	public List<String> leftPops(String key,long start,long end);
}
