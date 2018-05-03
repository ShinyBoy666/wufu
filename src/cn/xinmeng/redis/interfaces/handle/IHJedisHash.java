package cn.xinmeng.redis.interfaces.handle;

import java.util.Map;

import cn.xinmeng.common.interfaces.IPCallable;
import cn.xinmeng.redis.interfaces.IHBase;
import cn.xinmeng.redis.interfaces.IHHash;
import cn.xinmeng.redis.interfaces.pipes.IHPipeHash;

public interface IHJedisHash extends IHHash,IHBase{
	
	void exec(IPCallable<IHPipeHash> callable);
	
	Map<String, String> hgetAll(String key);
	
	String hget(String key,String field);
}
