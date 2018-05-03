package cn.xinmeng.redis.handle.pipes;

import redis.clients.jedis.Pipeline;
import cn.xinmeng.redis.interfaces.HBaseImpl;
import cn.xinmeng.redis.interfaces.pipes.IHPipeBase;

public class HPipelineBase extends HBaseImpl implements IHPipeBase {
	
	protected Pipeline pipeline;
	
	public HPipelineBase(Pipeline pipeline){
		this.pipeline = pipeline;
	}
	
	/**
	 * 从 jedis 对象获取 Pipeline(jedis 批处理)
	 * 
	 * @return Pipeline
	 */
	protected Pipeline getPipeline() {
		return pipeline;
	}

	@Override
	public void sync() {
		pipeline.sync();
	}
}
