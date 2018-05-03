package cn.xinmeng.redis.utils;

import cn.xinmeng.common.exceptions.RedisException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.redis.enums.ExRedisEnum;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class HJedisPool{
	private static JedisPool pool;
	
	private String host;			//主机IP
	private String password;		//密码
	private int port;				//端口号
	private int minIdle;			//最小空闲连接数
	private int maxIdle;			//最大空闲连接数
	private int maxTotal;			//最大连接数
	private long maxWaitMillis;		//最大阻塞时间，单位毫秒
	private boolean testOnBorrow;	//设置得到的redis实例是否都可用，true 均可用，false 随机的
	
	/** 
     * initPoolConfig 
     * @return 
     */  
    private JedisPoolConfig initPoolConfig() {  
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();  
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxIdle(maxIdle);  
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(1000);
        jedisPoolConfig.setTestOnReturn(true);  
        return jedisPoolConfig;  
    }  
    
	/**
	 * 初始化 redis 连接配置
	 */
	private void inintPool(){
		try {
			if(password == null || password.trim().length() == 0){
				pool = new JedisPool(initPoolConfig(),host,port,1000,null);
			}else{
				pool = new JedisPool(initPoolConfig(),host,port,1000,password);
			}
		} catch (Exception e) {
			throw new RedisException(LogManager.getLogger(this.getClass()), ExRedisEnum.ININT_POOL_FAILD);
		}
	}
	
	/**
	 * 释放 jedis 资源
	 * @param jedis
	 */
	public void returnResource(final Jedis jedis){
		pool.returnResourceObject(jedis);
	}
	/**
	 * 获取 Jedis
	 * @return Jedis
	 */
	public Jedis getJedis(){
		if(pool == null){
			synchronized(HJedisPool.class){
				inintPool();
				return pool.getResource();
			}
		}
		return pool.getResource();
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public static void setPool(JedisPool pool) {
		HJedisPool.pool = pool;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	
	
}
