package cn.xinmeng.redis.handle.pipes;

import java.util.Map;

import cn.xinmeng.common.exceptions.RedisException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.redis.enums.ExRedisEnum;
import cn.xinmeng.redis.interfaces.pipes.IHPipeHash;
import redis.clients.jedis.Pipeline;

public class HPipelineHash extends HPipelineBase implements IHPipeHash{

	public HPipelineHash(Pipeline pipeline) {
		super(pipeline);
	}

	@Override
	public void hset(String key, int expireTime, String field, String value) {
		// 保存数据
		pipeline.hset(key, field, value);
		// 设置过期时间
		pipeline.expire(key, expireTime);
	}

	@Override
	public void hset(String key, String field, String value) {
		// 保存数据
		pipeline.hset(key, field, value);
	}
	
	@Override
	public void hset(String key, Map<String, String> map) {
		pipeline.hmset(key, map);
	}
	@Override
	public void hset(String key, int expireTime, Map<String, String> map) {
		// 保存数据
		hset(key, map);
		// 设置过期时间
		pipeline.expire(key, expireTime);
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
		return pipeline.hdel(key).get();
	
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
		return pipeline.hdel(key, field).get();
	}

	@Override
	public long hincrBy(String key, String field, long value) {
		// TODO Auto-generated method stub
		return 0;
	}
}
