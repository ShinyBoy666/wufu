package cn.xinmeng.common.util.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SendSMSUtils {

	private static final String URL="http://si.800617.com:4400/SendSms.aspx?un=hzwqpp-1&pwd=116af3";
	
	/**
	 * 发送短信
	 */
	public static String sendMessage(String cellphone,String msg){
		try {
			// 创建StringBuffer对象用来操作字符串
			StringBuffer sb = new StringBuffer(URL);
			
			// 向StringBuffer追加手机号码
			sb.append("&mobile="+cellphone);
			
			// 向StringBuffer追加消息内容转URL标准码
			sb.append("&msg="+URLEncoder.encode("【舜凯云商】"+msg,"gb2312"));
			
			
			URL url = new URL(sb.toString());
			
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
	
			// 返回发送结果
			
			BufferedReader reader = null;
			String result = null;
			StringBuffer sbf = new StringBuffer();

			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
			}
			reader.close();
			result = sbf.toString();
			
			Map<String, String> map = new HashMap<String, String>();
			if(result != null && !"".equals(result)){
				String [] resultArray = result.split("&");
				if(resultArray != null && resultArray.length > 0){
					for (String str : resultArray) {
						if(str == null || "".equals(str)){
							continue;
						}
						String [] strArray = str.split("=");
						if(strArray != null && strArray.length == 2){
							map.put(strArray[0], strArray[1]);
						}
					}
				}
			}
	        return map.get("result");
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	
	public static String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {    
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
	
}
