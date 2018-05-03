package cn.xinmeng.redis.handle;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import cn.xinmeng.common.exceptions.RedisException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.redis.enums.ExRedisEnum;
import cn.xinmeng.redis.interfaces.handle.IHJedisSet;

@Service("jedisSet")
public class HJedisSet extends HJedisBase implements IHJedisSet{

	/**
	 * redis => 数据结构 => String
	 * set 数据
	 * @param key
	 * @param value
	 */
	public void set(String key,String value){
		/*
		 *校验数据 
		 */
		verify(key, value);
		getJedis().set(key, value);
	}
	
	/**
	 * redis => 数据结构 => String
	 * set 数据
	 * @param key
	 * @param value
	 * @param expireTime 过期时间，单位秒
	 */
	public void set(String key,String value,int expireTime){
		/*
		 *校验数据 
		 */
		verify(key, value);
		
	}
	
	
	/**
	 * redis => 数据结构 => String
	 * get 数据
	 * @param key
	 */
	public void get(String key){
		if(Utils.isEmpty(key)){
			throw new RedisException(LogManager.getLogger(this.getClass()),ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				jedis.get(key);
			} finally {
				returnResource(jedis);
			}
		}
	}
}
