package cn.xinmeng.api.service.impl;

import java.text.MessageFormat;
import java.util.List;

import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.redis.interfaces.handle.IHJedisHash;
import cn.xinmeng.redis.interfaces.handle.IHJedisList;
import cn.xinmeng.redis.interfaces.handle.IHJedisString;
import cn.xinmeng.redis.utils.HJRedisUtil;

public abstract class RedisBase {

	/**
	 * JSON转实体
	 * @param <T>
	 * @param json
	 * @param cls
	 * @return
	 */
	protected <T> T json2Bean(String json,Class<T> cls){
		try {
			return FastJsonUtils.json2Bean(json, cls);
		} catch (Exception ex) {
			throw new BusinessException("请求参数有误...",ex);
		}
	}
	
	protected <T> List<T> json2List(String listJson,Class<T> clazz){
		try {
			return FastJsonUtils.json2List(listJson, clazz);
		} catch (Exception ex) {
			throw new BusinessException("请求参数有误...",ex);
		}
	}
	
	/**
	 * 实体转JSON
	 * @param obj
	 * @return
	 */
	protected String beanToJSON(Object obj){
		return FastJsonUtils.bean2Json(obj);
	}
	
	/**
	 * 验证是否开启缓存查询
	 * @return
	 */
	protected boolean isUseRedisCacheQuery(){
		if("true".equals(HelperPropertie.getValue("redis.query.cache")) == false){
			LogManager.info(this.getClass(),"【RedisBase】未配置加载缓存...");
			return false;
		}
		return true;
	}
	
	/**
	 * 获取redis
	 * @return
	 */
	protected IHJedisString getJedisString(){
		IHJedisString redisString = HJRedisUtil.JedisString();
		if(redisString == null){
			throw new NullException("【获取IHJedisString】redis对象为空。redisString:"+redisString);
		}
		return redisString;
	}

	/**
	 * 获取redis
	 * @return
	 */
	protected IHJedisHash getJedisHash(){
		IHJedisHash jedisHash = HJRedisUtil.JedisHash();
		if(jedisHash == null){
			throw new NullException("【获取IHJedisHash】redis对象为空。redisString:"+jedisHash);
		}
		return jedisHash;
	}
	
	/**
	 * 
	 * @return
	 */
	protected IHJedisList getJedisList(){
		IHJedisList jedisList = HJRedisUtil.JedisList();
		if(jedisList == null){
			throw new NullException("【获取HJRedisUtil】redis对象为空。jedisList:"+jedisList);
		}
		return jedisList;
	}
	
	/**
	 * 获取rediskey
	 * @param pattern
	 * @param arguments
	 * @return
	 */
	protected String getRedisKey(String pattern,Object ...arguments) {
		return MessageFormat.format(pattern, arguments);
	}
}
