package cn.xinmeng.redis.handle;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;
import cn.xinmeng.common.exceptions.RedisException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.redis.enums.ExRedisEnum;
import cn.xinmeng.redis.interfaces.HBaseImpl;
import cn.xinmeng.redis.interfaces.IHBase;
import cn.xinmeng.redis.utils.HJedisPool;

public class HJedisBase extends HBaseImpl implements IHBase{
	@Resource
	protected HJedisPool jedisPool;
	/**
	 * 从 对象池 获取 jedis 对象
	 * 
	 * @return Jedis
	 */
	protected Jedis getJedis() {
		return jedisPool.getJedis();
	}

	/**
	 * redis => 数据结构 => String
	 * 设置过期时间 => 单位秒
	 * @param key
	 * @param expireTime 过期时间
	 */
	public void expire(String key,int expireTime){
		if(Utils.isEmpty(key)){
			throw new RedisException(LogManager.getLogger(this.getClass()),ExRedisEnum.SET_KEY_NULL);
		}
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				getJedis().expire(key, expireTime);
			} finally {
				returnResource(jedis);
			}
		}
	}

	@Override
	public boolean exists(String key) {
		synchronized (key) {
			Jedis jedis = null;
			try {
				jedis = getJedis();
				return jedis.exists(key);
			} finally {
				returnResource(jedis);
			}
		}
	}
	
	protected void returnResource(final Jedis jedis){
		if(null == jedis){ return;}
		jedisPool.returnResource(jedis);
	}
}
