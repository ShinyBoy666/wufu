package cn.xinmeng.redis.utils;

import cn.xinmeng.common.context.HelperSpringWeb;
import cn.xinmeng.redis.handle.HJedisString;
import cn.xinmeng.redis.interfaces.handle.IHJedisHash;
import cn.xinmeng.redis.interfaces.handle.IHJedisList;
import cn.xinmeng.redis.interfaces.handle.IHJedisSet;
import cn.xinmeng.redis.interfaces.handle.IHJedisString;

public final class HJRedisUtil {
	private static IHJedisString jedisString;
	private static IHJedisHash jedisHash;
	private static IHJedisList jedisList;
	private static IHJedisSet jedisSet;
	
	private HJRedisUtil() {
	}

	private static <T> T getBean(Class<T> clazz) {
		return HelperSpringWeb.getBean(clazz);
	}

	private static void initIHJedisString() {
		jedisString = getBean(HJedisString.class);
	}

	private static void initIHJedisHash() {
		jedisHash = getBean(IHJedisHash.class);
	}

	private static void initIHJedisList() {
		jedisList = getBean(IHJedisList.class);
	}

	private static void initIHJedisSet() {
		jedisSet = getBean(IHJedisSet.class);
	}

	public static IHJedisString JedisString() {
		if (jedisString == null) {
			synchronized (IHJedisString.class) {
				if (jedisString == null) {
					initIHJedisString();
				}
				return jedisString;
			}
		}
		return jedisString;
	}

	public static IHJedisHash JedisHash() {
		if (jedisHash == null) {
			synchronized (IHJedisHash.class) {
				if (jedisHash == null) {
					initIHJedisHash();
				}
				return jedisHash;
			}
		}
		return jedisHash;
	}

	public static IHJedisList JedisList() {
		if (jedisList == null) {
			synchronized (IHJedisList.class) {
				if (jedisList == null) {
					initIHJedisList();
				}
				return jedisList;
			}
		}
		return jedisList;
	}

	public static IHJedisSet JedisSet() {
		if (jedisSet == null) {
			synchronized (IHJedisSet.class) {
				if (jedisSet == null) {
					initIHJedisSet();
				}
				return jedisSet;
			}
		}
		return jedisSet;
	}

	public static void main(String[] args) {
		IHJedisHash hash = HJRedisUtil.JedisHash();

		hash.hset("user",100, "name", "zhangsan");

		System.out.println("IHJedisHash => "+hash.hget("user", "name"));
		
		
		IHJedisString string = HJRedisUtil.JedisString();
		
		string.set("hpf",100,"15829669905");
		string.del("hpf");
		System.out.println("IHJedisString => "+string.get("hpf"));
	}
}
