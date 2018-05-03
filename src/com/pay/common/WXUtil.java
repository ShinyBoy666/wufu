package com.pay.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.xinmeng.common.exceptions.BusinessException;

import com.pay.config.WXConfig;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class WXUtil {
	
//	 //表示请求器是否已经做了初始化工作
//    private static boolean hasInit = false;
//
//    //请求器的配置
//    private static RequestConfig requestConfig;
//
//    //HTTP请求器
//    private static CloseableHttpClient httpClient;
	
	private static Logger logger = LoggerFactory.getLogger("payReturnLog");
	
	/**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    
    /**
     * 
     * <p class="detail"> 对象转换成XML字符串 </p>
     * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月9日 上午11:34:17
     * @param obj
     * @return
     */
    public static String toXml(Object obj){
    	//解决XStream对出现双下划线的bug
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        return xStream.toXML(obj);
    }
    
//   /**
//    * 从RefunQueryResponseString里面解析出退款订单数据
//    * @param refundQueryResponseString RefundQuery API返回的数据
//    * @return 因为订单数据有可能是多个，所以返回一个列表
//    */
//   public static List<RefundOrderData> getRefundOrderList(String refundQueryResponseString) throws IOException, SAXException, ParserConfigurationException {
//       List list = new ArrayList();
//
//       Map<String,Object> map = XMLParser.getMapFromXML(refundQueryResponseString);
//
//      int count = Integer.parseInt((String) map.get("refund_count"));
//      Util.log("count:" + count);
//
//       if(count<1){
//           return list;
//       }
//
//       RefundOrderData refundOrderData;
//
//       for(int i=0;i<count;i++){
//           refundOrderData = new RefundOrderData();
//
//           refundOrderData.setOutRefundNo(Util.getStringFromMap(map,"out_refund_no_" + i,""));
//           refundOrderData.setRefundID(Util.getStringFromMap(map,"refund_id_" + i,""));
//           refundOrderData.setRefundChannel(Util.getStringFromMap(map,"refund_channel_" + i,""));
//           refundOrderData.setRefundFee(Util.getIntFromMap(map,"refund_fee_" + i));
//           refundOrderData.setCouponRefundFee(Util.getIntFromMap(map,"coupon_refund_fee_" + i));
//           refundOrderData.setRefundStatus(Util.getStringFromMap(map,"refund_status_" + i,""));
//           list.add(refundOrderData);
//       }
//
//       return list;
//   }

   /**
    * 
    * <p class="detail"> 将xml字符串解析成map </p>
    * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月9日 下午1:53:50
    * @param xmlString
    * @return
    * @throws ParserConfigurationException
    * @throws IOException
    * @throws SAXException
    */
   public static Map<String,String> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {
       //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       ByteArrayInputStream tInputStringStream = null;
       if(xmlString != null && !xmlString.trim().equals("")){
    	   tInputStringStream = new ByteArrayInputStream(xmlString.getBytes());
       }
       InputStream is = tInputStringStream;
       Document document = builder.parse(is);

       //获取到document里面的全部结点
       NodeList allNodes = document.getFirstChild().getChildNodes();
       Node node;
       Map<String, String> map = new HashMap<String, String>();
       int i=0;
       while (i < allNodes.getLength()) {
           node = allNodes.item(i);
           if(node instanceof Element){
               map.put(node.getNodeName(),node.getTextContent());
           }
           i++;
       }
       return map;
   }
   
   	/**
   	 * 
   	 * <p class="detail"> 签名 </p>
   	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月9日 下午1:41:48
   	 * @param map
   	 * @return
   	 */
	public static String getSign(Map<String,String> map){
	    ArrayList<String> list = new ArrayList<String>();
	    for(Map.Entry<String,String> entry:map.entrySet()){
	        if(entry.getValue()!=""){
	            list.add(entry.getKey() + "=" + entry.getValue() + "&");
	        }
	    }
	    int size = list.size();
	    String [] arrayToSort = list.toArray(new String[size]);
	    Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < size; i ++) {
	        sb.append(arrayToSort[i]);
	    }
	    String result = sb.toString();
	    result += "key=" + WXConfig.key;
	    return MD5.sign(result, "", "utf-8").toUpperCase();
	}
	
	/**
     * 验证消息是否是合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String,String> map){
        String signFromAPIResponse = map.get("sign").toString();
        if(signFromAPIResponse=="" || signFromAPIResponse == null){
            return false;
        }
        //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        map.put("sign","");
        //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        String signForAPIResponse = getSign(map);

        if(!signForAPIResponse.equals(signFromAPIResponse)){
            //签名验不过，表示这个API返回的数据有可能已经被篡改了
            return false;
        }
        return true;
    }
    
    /**
     * 通过Https往API post xml数据
     *
     * @param url    API地址
     * @param xmlObj 要提交的XML数据对象
     * @return API回包的实际数据
     * @throws IOException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static String sendPost(String url, Object xmlObj) throws Exception{
//        if (!hasInit) {
//            init();
//        }
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(toXml(xmlObj), "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);

        //设置请求器的配置
//        httpPost.setConfig(requestConfig);
        httpPost.setConfig(RequestConfig.custom().setSocketTimeout(WXConfig.socketTimeout).setConnectTimeout(WXConfig.connectTimeout).build());
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            httpPost.abort();
            if (client != null) {
            	client.close();
			}
        }
        return result;
    }
    
//    /**
//     * 
//     * <p class="detail"> https初始化 </p>
//     * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月9日 下午2:12:44
//     * @throws IOException
//     * @throws KeyStoreException
//     * @throws UnrecoverableKeyException
//     * @throws NoSuchAlgorithmException
//     * @throws KeyManagementException
//     */
//    @SuppressWarnings("deprecation")
//    private static void init() throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        FileInputStream instream = new FileInputStream(new File(WXConfig.certLocalPath));//加载本地的证书进行https加密传输
//        try {
//            keyStore.load(instream, WXConfig.certPassword.toCharArray());//设置证书密码
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } finally {
//            instream.close();
//        }
//        // Trust own CA and all self-signed certs
//        SSLContext sslcontext = SSLContexts.custom()
//                .loadKeyMaterial(keyStore, WXConfig.certPassword.toCharArray())
//                .build();
//        // Allow TLSv1 protocol only
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//                sslcontext,
//                new String[]{"TLSv1"},
//                null,
//                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//
//        httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//        //根据默认超时限制初始化requestConfig
//        requestConfig = RequestConfig.custom().setSocketTimeout(WXConfig.socketTimeout).setConnectTimeout(WXConfig.connectTimeout).build();
//        hasInit = true;
//    }
    
	/**
	 * 
	 * <p class="detail"> 微信生成预支付 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月9日 下午1:27:27
	 * @param orderId
	 * @param ip
	 * @param amount
	 * @param describe
	 * @param tradeTypeEnum
	 * @param openid
	 * @throws Exception 
	 */
	public static String unifiedorder(WxUnifiedorderEntity entity){
		try {
			String str = WXUtil.sendPost(WXConfig.UNIFIEDORDER_API, entity);
			if(StringUtils.hasText(str)){
				Map<String,String> result = WXUtil.getMapFromXML(str);
				if("SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))){
					return result.get("prepay_id");
				}
			}
		} catch (Exception e) {
			logger.error("unifiedorder:"+ e);
		} 
		throw new BusinessException(logger,"预支付id生成失败");
	}
	
	public static Map<String, String> submit(String prepayid){
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", WXConfig.appID);
		map.put("partnerid", WXConfig.mchID);
		map.put("prepayid", prepayid);
		map.put("package", "Sign=WXPay");
		map.put("noncestr", WXUtil.getRandomStringByLength(32));
		map.put("timestamp", new Date().getTime()/1000 + "");
		map.put("sign", getSign(map));
		map.remove("package");
		map.put("packageValue", "Sign=WXPay");
		return map;
	}
}
