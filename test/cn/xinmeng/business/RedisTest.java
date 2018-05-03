package cn.xinmeng.business;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import cn.xinmeng.api.constant.RedisConstant;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.base.BaseTest;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.redis.interfaces.handle.IHJedisHash;
import cn.xinmeng.redis.interfaces.handle.IHJedisString;
import cn.xinmeng.redis.utils.HJRedisUtil;

public class RedisTest extends BaseTest {
	
	@Resource
	private ICustomerService customerService;
	
	@Test
	public void jedisStr() throws BusinessException {
		long start = System.currentTimeMillis();
		String ss ="100002字符串100002";
		IHJedisString jedis = HJRedisUtil.JedisString();
		for (int j = 0; j < 1; j++) { 
			jedis.set(j+"字符串"+j, "{\"cashAmount\":25.72,\"cellphone\":\"18612100102\",\"cityId\":0,\"createTime\":1460691436000,\"createUser\":\"\",\"customerCategory\":\"2\",\"districtId\":0,\"endTime\":1492271722000,\"headSculpture\":\"http://img.51shunkai.com//201604/oripath/40771b60-aa4f-4a3a-859e-34ff8bdba880.jpg\",\"id\":1,\"nickname\":\"JL\",\"openTime\":1460735722000,\"password\":\"224cf2b695a5e8ecaecfb9015161fa4b\",\"provinceId\":0,\"recommendCode\":\"NMGQQ3\",\"recommendCustomerId\":0,\"scoreAmount\":0,\"sex\":1,\"state\":2,\"token\":\"e65d05aedd43462a89205b5459adf66e\",\"updateTime\":1460691436000}"+j);
		}
//		jedis.get(ss);
		System.out.println("时间："+(System.currentTimeMillis()-start));
		System.out.println("完成－－－");
	}

	@Test
	public void jedisHash() throws BusinessException {
		long start = System.currentTimeMillis();
		String ss ="100002字符串100002";
		IHJedisHash jedis = HJRedisUtil.JedisHash();
		for (int j = 0; j < 1000000; j++) {
			jedis.hset(j+"字符串"+j,"data", "{\"cashAmount\":25.72,\"cellphone\":\"18612100102\",\"cityId\":0,\"createTime\":1460691436000,\"createUser\":\"\",\"customerCategory\":\"2\",\"districtId\":0,\"endTime\":1492271722000,\"headSculpture\":\"http://img.51shunkai.com//201604/oripath/40771b60-aa4f-4a3a-859e-34ff8bdba880.jpg\",\"id\":1,\"nickname\":\"JL\",\"openTime\":1460735722000,\"password\":\"224cf2b695a5e8ecaecfb9015161fa4b\",\"provinceId\":0,\"recommendCode\":\"NMGQQ3\",\"recommendCustomerId\":0,\"scoreAmount\":0,\"sex\":1,\"state\":2,\"token\":\"e65d05aedd43462a89205b5459adf66e\",\"updateTime\":1460691436000}"+j);
		}
		System.out.println("时间："+(System.currentTimeMillis()-start));
		System.out.println("完成－－－");
	}
	
	@Test
	public void test1() throws BusinessException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			IHJedisHash jedis = HJRedisUtil.JedisHash();
			ActvityProductInfoBiz biz = new ActvityProductInfoBiz();
			biz.setActivityId(2);
			biz.setActivityType(3);
			List<String> imageUrlList = new ArrayList<String>();
			imageUrlList.add("JPH/201604/oripath/08caacf5-71c1-479b-9849-f382956cfacb.jpg");
			imageUrlList.add("JPH/201604/oripath/08caacf5-71c1-479b-9849-f382956cfacb.jpg");
			biz.setImageUrlList(imageUrlList);
			biz.setIsDelivery(2);
			biz.setMaxBuy(3);
			biz.setPostage(9.00);
			biz.setRetailPrice(9.99);
			biz.setProductId(111111);
			biz.setProductNumber(100);
			biz.setMarketPrice(19.99);
			biz.setProductPriceId(1);
			biz.setQuantity(2);
			biz.setShopId(1);
			biz.setSku("|默认|");
			biz.setSoldNumber(1);
			String redisKey = MessageFormat.format(RedisConstant.activity_product_desc, 2,3,i);
			jedis.hset(redisKey, "biz", FastJsonUtils.bean2Json(biz));
		}
		System.out.println("时间："+(System.currentTimeMillis()-start));
	}

	@Test
	public void test2() throws BusinessException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			IHJedisHash jedis = HJRedisUtil.JedisHash();
			ActvityProductInfoBiz biz = new ActvityProductInfoBiz();
			biz.setActivityId(2);
			biz.setActivityType(3);
			List<String> imageUrlList = new ArrayList<String>();
			imageUrlList.add("JPH/201604/oripath/08caacf5-71c1-479b-9849-f382956cfacb.jpg");
			imageUrlList.add("JPH/201604/oripath/08caacf5-71c1-479b-9849-f382956cfacb.jpg");
			biz.setImageUrlList(imageUrlList);
			biz.setIsDelivery(2);
			biz.setMaxBuy(3);
			biz.setPostage(9.00);
			biz.setRetailPrice(9.99);
			biz.setProductId(111111);
			biz.setProductNumber(100);
			biz.setMarketPrice(19.99);
			biz.setProductPriceId(1);
			biz.setQuantity(2);
			biz.setShopId(1);
			biz.setSku("|默认|");
			biz.setSoldNumber(1);
			String redisKey = MessageFormat.format(RedisConstant.activity_product_desc, 2,3,i);
			jedis.hset(redisKey, "quantity",i+"");
			jedis.hset(redisKey, "productNumber",i+"");
			jedis.hset(redisKey, "soldNumber",i+"");
			biz.setQuantity(null);
			biz.setProductNumber(null);
			biz.setSoldNumber(null);
			jedis.hset(redisKey, "biz",FastJsonUtils.bean2Json(biz));
		}
		System.out.println("时间："+(System.currentTimeMillis()-start));
	}

	@Test
	public void test3() throws BusinessException {
		String redisKey = MessageFormat.format(RedisConstant.activity_product_desc, 2,3,100);
		IHJedisHash jedis = HJRedisUtil.JedisHash();
		String biz = jedis.hget(redisKey,"biz");
		System.out.println(biz);
	}
}
