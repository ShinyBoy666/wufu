package cn.xinmeng.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.UnknownException;

public class HttpClientUtils {
	public static void close(CloseableHttpClient client) {
		if (client != null) {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	


	private static String get_request(String url) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return EntityUtils.toString(entity);
			}
		} finally {
			close(client);
		}
		return "";
	}


	private static String post_request(String url, Map<String, String> param) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			HttpPost post = new HttpPost(url);
			if (Utils.isEmpty(param) == false) {
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> item : param.entrySet()) {
					nvps.add(new BasicNameValuePair(item.getKey(), item.getValue()));
				}
				post.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			}
			CloseableHttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return EntityUtils.toString(entity);
			}
		} finally {
			close(client);
		}
		return "";
	}

	/**
	 * post 请求
	 * 
	 * @param url请求地址
	 * @param param
	 *            请求参数
	 */
	public static String postRequest(String url, Map<String, String> param) {
		try {
			return post_request(url, param);
		} catch (BusinessException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new UnknownException("未知异常", ex);
		}

	}

	public static Map<String, String> getParam(String code, Map<String, Object> data) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("source", "PC");
		param.put("code", code);
		param.put("imei", "864181027234767");
		param.put("data", FastJsonUtils.bean2Json(data));
		param.put("token", "12345");
		param.put("timestamp", "0");

		StringBuffer sb = new StringBuffer();
		sb.append("2015com"); // 公共秘钥
		sb.append(param.get("code")); // 服务号
		sb.append(param.get("imei")); // 手机串号
		sb.append(param.get("data")); // 请求数据
		sb.append(param.get("source")); //　请求来源
		sb.append(param.get("token")); //　token
		sb.append(param.get("timestamp")); //　时间戳  毫秒
		param.put("mak", UtilMD5.MD5(sb));
		return param;
	}

	@SuppressWarnings("unchecked")
	public static List<Integer> customerList(int num){
		HashMap<String, Object> custData = new HashMap<String, Object>();
		custData.put("limit", num);
		String custs = HttpClientUtils.postRequest("http://"+host+"/api/api.htm",
				getParam("test1001", custData));
		Map<String, Object> map1 = FastJsonUtils.json2Bean(custs, Map.class);
		System.out.println(map1);
		if (((Integer) map1.get("success")) == 1) {
			return FastJsonUtils.json2List(map1.get("data").toString(), Integer.class);
		}
		return new ArrayList<Integer>();
	}
	//	public static void main(String[] args) {
	//		for (int i = 0; i < 2; i++) {
	//			System.out.println(customerList(20));
	//		}
	//	}
	//http://baishan.51shunkai.com/asset/test.txt


	//	public static void testThread() throws InterruptedException{
	//
	//		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
	//		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
	//		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");
	//		final AtomicInteger countTrue = new AtomicInteger(0);
	//		final AtomicInteger countFalse = new AtomicInteger(0);
	//
	//		final AtomicInteger countParallel = new AtomicInteger(0);
	//
	//		final AtomicInteger countCurrent = new AtomicInteger(0);
	//
	//		final HashMap<String, Object> data = new HashMap<String, Object>();
	//		data.put("customerId", "708");
	//		data.put("orderProvinceId", 2);
	//		data.put("orderCityId", 1);
	//		data.put("addressId", 46);
	//		data.put("accountDeduct", false);
	//		data.put("orderFrom", 1);
	//		data.put("onlinePayType", 1);
	//		// data.put("activityType", 3);
	//		// data.put("activityId", 7);
	//
	//		data.put("productNumber", 1);
	//		data.put("productId", "103819");
	//		data.put("skuValuesText", "|默认|");
	//		
	//		final int size = 2;
	//
	////		final IHJedisString jedisString = HJRedisUtil.JedisString();
	//		List<Thread> listThread = new ArrayList<Thread>();
	//		final AtomicLong start = new AtomicLong(System.currentTimeMillis());
	//		long threadTime = System.currentTimeMillis();
	//		for (final Integer cust : customerList(size)) {
	//			listThread.add(new Thread(new Runnable() {
	//				@SuppressWarnings("unchecked")
	//				@Override
	//				public void run() {
	//					 Map<String, Object>  temoData = CloneUtils.cloneMap(data);
	//					 temoData.put("customerId", cust);
	//					
	//					
	//					 countCurrent.addAndGet(1);
	//					
	//					 if(countParallel.intValue() > countCurrent.intValue()){
	//					 countParallel.set(countCurrent.intValue());
	//					 }else{
	//					 countParallel.addAndGet(1);
	//					 }
	//						HashMap<String, Object> custData = new HashMap<String, Object>();
	//						custData.put("limit", 2);
	//					 String response =
	//					 HttpClientUtils.postRequest("http://"+host+"/api/api.htm",
	////					 getParam("test1001", custData));
	//					 getParam("test1000", temoData));
	//					 countCurrent.addAndGet(-1);
	////					 System.out.println(response);
	//					 Map<String, Object> result = FastJsonUtils.json2Bean(response, Map.class);
	//					 System.out.println(result);
	//					 if (((Integer) result.get("success")) == 0) {
	//					 countFalse.addAndGet(1);
	//					 } else {
	//					 countTrue.addAndGet(1);
	//					 }
	////					 System.out.println(MessageFormat.format("线程编号：{0},成功次数：{1}，失败次数：{2},并发数：{3},当前：{4}",
	////					 Thread.currentThread().getId(), countTrue.intValue(),
	////					 countFalse.intValue(),countParallel.intValue(),countCurrent.intValue()
	////					 ));
	//					 if((countTrue.intValue()+countFalse.intValue()) == size){
	//							System.out.println((System.currentTimeMillis() - start.longValue())+"毫秒");
	//					 }
	//				}
	//			}));
	//		}
	//		System.out.println("创建线程时间："+(System.currentTimeMillis() - threadTime)+"毫秒");
	//		for (int i = 0; i < size; i++) {
	//			listThread.get(i).start();
	//			if(i % 200 == 0){
	//				Thread.sleep(1000);
	//				System.out.println("---------------------------------");
	//			}
	//		}
	//	
	//	}

	//	public static void main(String[] args) {
	//		Map<String, String> param = new HashMap<String, String>();
	//		param.put("_format_", "json");
	//		param.put("page", "2");
	//		param.put("keyword", "棉麻连衣裙");
	//		try {
	//			System.out.println(post_request("http://m.jd.com/ware/searchList.action",param));
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		
	//	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");
		final AtomicInteger countTrue = new AtomicInteger(0);
		final AtomicInteger countFalse = new AtomicInteger(0);

		final AtomicInteger countParallel = new AtomicInteger(0);

		final AtomicInteger countCurrent = new AtomicInteger(0);

		final int size = 20000;

		List<Thread> listThread = new ArrayList<Thread>();
		final AtomicLong start = new AtomicLong(System.currentTimeMillis());
		long threadTime = System.currentTimeMillis();
		for (int i = 0 ;i < size ; i++) {
			listThread.add(new Thread(new Runnable() {
				@Override
				public void run() {
					countCurrent.addAndGet(1);
					if(countParallel.intValue() > countCurrent.intValue()){
						countParallel.set(countCurrent.intValue());
					}else{
						countParallel.addAndGet(1);
					}
					try {
						String response = HttpClientUtils.get_request("http://localhost:8080/h5/test.htm?id="+Math.random());
						countCurrent.addAndGet(-1);
						if ("test".equals(response)) {
							countFalse.addAndGet(1);
						} else {
							countTrue.addAndGet(1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if((countTrue.intValue()+countFalse.intValue()) == size){
						System.out.println((System.currentTimeMillis() - start.longValue())+"毫秒");
					}
				}
			}));
		}
		System.out.println("创建线程时间："+(System.currentTimeMillis() - threadTime)+"毫秒");
		for (int i = 0; i < size; i++) {
			listThread.get(i).start();
			if(i % 200 == 0){
				Thread.sleep(1000);
			}
		}
	}

	//	static final String host = "www.xinmeng.com:8888";
	//	static final String host = "120.26.124.234:10009";
	//	static final String host = "47.88.162.144:9001";//80
	static final String host = "localhost:8080";//200
}