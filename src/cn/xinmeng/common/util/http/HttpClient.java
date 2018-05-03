package cn.xinmeng.common.util.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLConnection;

public class HttpClient {
	private static HttpClient client = new HttpClient();
	private static final String REQUEST_METHOD_POST = "POST";
	private static final String ENCODED = "UTF-8";

	public static HttpClient getInstance(){
		synchronized (HttpClient.class) {
			if (client == null) {
				client = new HttpClient();
			}
		}
		return client;
	}

	public String doPost(String url, String params) throws Exception{
		URLConnection conn = null;
		if (url.startsWith("http:")){
			conn = URLConnectionUtils.getHttpConnection(url, REQUEST_METHOD_POST);
		}else {
			conn = URLConnectionUtils.getHttpsConnection(url, REQUEST_METHOD_POST);
		}

		//参数
		OutputStream outputStream=conn.getOutputStream();
		if(params==null)
			params="";
		outputStream.write(params.getBytes());
		outputStream.flush();
		outputStream.close();

		//获取返回消息
		StringBuffer result=new StringBuffer("");
		InputStream inStream=conn.getInputStream();
		BufferedReader in=new BufferedReader(new InputStreamReader(inStream,ENCODED));
		String line;
		while((line=in.readLine())!=null){
			result.append(line);
		}
		return result.toString();
	}

	public static void main(String[] args) throws Exception {
		HttpClient httpClient= HttpClient.getInstance();
		
//		String result = httpClient.doPost("http://ht.51shunkai.com/shopoutservice/action001", "{\"UserName\":\"E0001-tjy\",\"Pwd\":\"f379eaf3c831b04de153469d1bec345e\"}");
//		System.out.println(result);
//		B2000ResponseEntity res = new B2000ResponseEntity();
//		ShopkeeperUser user = FastJsonUtils.json2Bean(result, ShopkeeperUser.class);
//		if(user != null){
//			CloneUtils.copyEntity(user, res);
//		}
		System.out.println();
//		String url = "http://ht.51shunkai.com/shopoutservice/action001";
//		HttpClient httpClient= HttpClient.getInstance();
//		ShopkeeperUser user = new ShopkeeperUser();
//		try {
//			String result = httpClient.doPost(url, beanToJSON(entity));
//			user = parseRequertParam(result, ShopkeeperUser.class);
//		} catch (Exception e) {
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExBaseEnum.EX_UNKNOWN);
//		}
	}
}
