package cn.xinmeng.redis.handle.pipes;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Pipeline;
import cn.xinmeng.redis.interfaces.pipes.IHPipeString;

public class HPipelineString extends HPipelineBase implements IHPipeString{

	public HPipelineString(Pipeline pipeline) {
		super(pipeline);
	}

	@Override
	public void set(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(String key, int expireTime, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> mget(String... keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> mget(List<String> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void append(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void del(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long decrBy(String key, int integer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<String> getKeys(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long rightPush(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long leftPush(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rightPop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leftPop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> leftPops(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}
}
