package cn.xinmeng.redis.handle;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import cn.xinmeng.common.exceptions.RedisException;
import cn.xinmeng.common.interfaces.IPCallable;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.redis.enums.ExRedisEnum;
import cn.xinmeng.redis.handle.pipes.HPipelineString;
import cn.xinmeng.redis.interfaces.handle.IHJedisString;
import cn.xinmeng.redis.interfaces.pipes.IHPipeString;

@Service("jedisString")
public class HJedisString extends HJedisBase implements IHJedisString {

	/**
	 * redis => 数据结构 => String set 数据
	 * 
	 * @param key
	 * @param value
	 */
	@Override
	public void set(String key, String value) {
		/*
		 * 校验数据
		 */
		verify(key, value);
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				jedis.set(key, value);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * redis => 数据结构 => String set 数据
	 * 
	 * @param key
	 * @param expireTime
	 *            过期时间，单位秒
	 * @param value
	 */
	@Override
	public void set(String key, int expireTime, String value) {
		/*
		 * 校验数据
		 */
		verify(key, value);
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				jedis.setex(key, expireTime, value);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * redis => 数据结构 => String get 数据
	 * 
	 * @param key
	 */
	@Override
	public String get(String key) {
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.get(key);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * redis => 数据结构 => String 多个 key 获取多个value
	 * 
	 * @param keys
	 *            key 数组
	 */
	@Override
	public List<String> mget(String... keys) {
		if (Utils.isEmpty(keys)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (keys) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.mget(keys);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * redis => 数据结构 => String 向指定的 key 的 value 追加字符串
	 * 
	 * @param key
	 * @param value
	 *            追加字符串
	 */
	@Override
	public void append(String key, String value) {
		/*
		 * 校验数据
		 */
		verify(key, value);

		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				jedis.append(key, value);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * redis => 数据结构 => String 多个 key 获取多个value
	 * 
	 * @param keys
	 *            key 数组
	 */
	@Override
	public List<String> mget(List<String> keys) {
		if (Utils.isEmpty(keys)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		/*-------------数据类型格式转换 begin --------------*/
		String[] _keys = new String[keys.size()];
		for (String key : _keys) {
			_keys[_keys.length] = key;
		}
		/*-------------数据类型格式转换 end ----------------*/

		return mget(_keys);
	}

	/**
	 * redis => 数据结构 => String
	 * 
	 * @param callable
	 */
	@Override
	public void exec(IPCallable<IHPipeString> callable) {
		if (callable == null) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.CALLABLE_IPCALL_NULL);
		}
		synchronized (callable) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				IHPipeString pipeString = new HPipelineString(jedis.pipelined());
				/*
				 * 批量操作回调
				 */
				callable.exec(pipeString);
				/*
				 * 批量提交
				 */
				pipeString.sync();
			} finally {
				returnResource(jedis);
			}
		}
	}

	@Override
	public void del(String key) {
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				jedis.del(key);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * 根据key，对数据的减
	 * 默认减，负值加
	 * @param key
	 * @param integer
	 * @return
	 */
	public long decrBy(String key,int integer){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.decrBy(key, integer);
			} finally {
				returnResource(jedis);
			}
		}
	}
	/**
	 * 查询模糊匹配的key
	 * @param key
	 * @return
	 */
	public Set<String> getKeys(String key){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.keys(key);
			} finally {
				returnResource(jedis);
			}
		}
	}
	
	/**
	 * 往数据右边set值
	 * @param key
	 * @param value
	 * @return
	 */
	public Long rightPush(String key,String value){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.rpush(key,value);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * 往数据左边set值
	 * @param key
	 * @param value
	 * @return
	 */
	public Long leftPush(String key,String value){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.lpush(key,value);
			} finally {
				returnResource(jedis);
			}
		}
	}
	/**
	 * 往数据右边跟get值
	 * @param key
	 * @return
	 */
	public String rightPop(String key){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.rpop(key);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * 往数据左边get值
	 * @param key
	 * @return
	 */
	public String leftPop(String key){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.lpop(key);
			} finally {
				returnResource(jedis);
			}
		}
	}
	
	/**
	 * 往数据左边get值集合
	 * @param key
	 * @return
	 */
	public List<String> leftPops(String key,long start,long end){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.lrange(key, start, end);
			} finally {
				returnResource(jedis);
			}
		}
	}
}
