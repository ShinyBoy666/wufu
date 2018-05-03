package cn.xinmeng.redis.handle;

import java.util.Map;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import cn.xinmeng.common.exceptions.RedisException;
import cn.xinmeng.common.interfaces.IPCallable;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.redis.enums.ExRedisEnum;
import cn.xinmeng.redis.handle.pipes.HPipelineHash;
import cn.xinmeng.redis.interfaces.handle.IHJedisHash;
import cn.xinmeng.redis.interfaces.pipes.IHPipeHash;

@Service("jedisHash")
public class HJedisHash extends HJedisBase implements IHJedisHash {

	@Override
	public void hset(String key, String field, String value) {
		/*
		 * 校验数据
		 */
		verify(key, field, value);
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.hset(key, field, value);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * redis => 数据结构 => String set 数据
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 *            过期时间，单位秒
	 */
	@Override
	public void hset(final String key, final int expireTime, final String field, final String value) {
		/*
		 * 校验数据
		 */
		verify(key, field, value);
		exec(new IPCallable<IHPipeHash>() {
			@Override
			public void exec(IHPipeHash hr) {
				hr.hset(key, expireTime, field, value);
			}
		});
	}

	/**
	 * redis => 数据结构 => String
	 * 
	 * @param callable
	 */
	@Override
	public void exec(IPCallable<IHPipeHash> callable) {
		if (callable == null) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.CALLABLE_IPCALL_NULL);
		}
		Jedis jedis = null;
		try {
			jedis = getJedis();
			IHPipeHash pipeHash = new HPipelineHash(jedis.pipelined());
			/*
			 * 批量操作回调
			 */
			callable.exec(pipeHash);
			/*
			 * 批量提交
			 */
			pipeHash.sync();
		} finally {
			returnResource(jedis);
		}
	}

	@Override
	public void hset(final String key, final Map<String, String> map) {
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		if (Utils.isEmpty(map)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.CALLABLE_IPCALL_NULL);
		}

		exec(new IPCallable<IHPipeHash>() {

			@Override
			public void exec(IHPipeHash pipeHash) {
				pipeHash.hset(key, map);
			}
		});
	}

	@Override
	public void hset(final String key, final int expireTime, final Map<String, String> map) {
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		if (Utils.isEmpty(map)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.CALLABLE_IPCALL_NULL);
		}
		exec(new IPCallable<IHPipeHash>() {

			@Override
			public void exec(IHPipeHash pipeHash) {
				pipeHash.hset(key, expireTime, map);
			}
		});
	}

	@Override
	public Map<String, String> hgetAll(String key) {
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.hgetAll(key);
			} finally {
				returnResource(jedis);
			}
		}
	}

	@Override
	public String hget(String key, String field) {
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		if (Utils.isEmpty(field)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.HSET_FIELD_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.hget(key, field);
			} finally {
				returnResource(jedis);
			}
		}
	}

	/**
	 * 删除Map，指定key
	 * @param key
	 * @param field
	 * @param value
	 */
	public long hdel(String key){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.hdel(key);
			} finally {
				returnResource(jedis);
			}
		}
	
	}

	/**
	 * 删除Map，指定key，field
	 * @param key
	 * @param field
	 * @param value
	 */
	public long hdel(String key,String ...field){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		if (Utils.isEmpty(field)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.HSET_FIELD_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.hdel(key, field);
			} finally {
				returnResource(jedis);
			}
		}
	}
	
	/**
	 * 值＋1
	 * @param key
	 * @param field
	 * @param value
	 */
	public long hincrBy(String key,String field,long value){
		if (Utils.isEmpty(key)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.SET_KEY_NULL);
		}
		if (Utils.isEmpty(field)) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.HSET_FIELD_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.hincrBy(key, field, value);
			} finally {
				returnResource(jedis);
			}
		}
	
	}
}
