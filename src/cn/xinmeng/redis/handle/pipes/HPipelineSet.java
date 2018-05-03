package cn.xinmeng.redis.handle.pipes;

import redis.clients.jedis.Pipeline;
import cn.xinmeng.redis.interfaces.pipes.IHPipeSet;

public class HPipelineSet extends HPipelineBase implements IHPipeSet{

	public HPipelineSet(Pipeline pipeline) {
		super(pipeline);
	}
}
