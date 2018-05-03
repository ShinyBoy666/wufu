package cn.xinmeng.redis.interfaces.handle;

import cn.xinmeng.common.interfaces.IPCallable;
import cn.xinmeng.redis.interfaces.IHBase;
import cn.xinmeng.redis.interfaces.IHString;
import cn.xinmeng.redis.interfaces.pipes.IHPipeString;

public interface IHJedisString extends IHString,IHBase{
	
	/**
	 * redis => 数据结构 => String
	 * @param callable
	 */
	void exec(IPCallable<IHPipeString> callable);
}
