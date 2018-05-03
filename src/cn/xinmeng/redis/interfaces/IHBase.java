package cn.xinmeng.redis.interfaces;

public interface IHBase {
	/**
	 * 验证 当前 key 在 redis 中是否存在
	 * @param key
	 */
	boolean exists(String key);
}
