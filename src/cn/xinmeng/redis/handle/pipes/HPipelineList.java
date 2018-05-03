package cn.xinmeng.redis.handle.pipes;

import redis.clients.jedis.Pipeline;
import cn.xinmeng.redis.interfaces.pipes.IHPipeList;

public class HPipelineList extends HPipelineBase implements IHPipeList{

	public HPipelineList(Pipeline pipeline) {
		super(pipeline);
	}

}
