package cn.xinmeng.common.util.http;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class URLConnectionUtils {
	private static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";
	private static final int CONNECT_TIME_OUT = 5000;
	private static final int READ_TIME_OUT = 100000;

	public static HttpsURLConnection getHttpsConnection(String url, String method)throws Exception{
		//创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new SecureRandom());
		System.setProperty("java.protocol.handler.pkgs", "javax.net.ssl");
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		URL myURL = new URL(url);
		HttpsURLConnection httpsConn = (HttpsURLConnection)myURL.openConnection();
		httpsConn.setSSLSocketFactory(ssf);
		httpsConn.setDoOutput(true);
		httpsConn.setDoInput(true);
		httpsConn.setUseCaches(false);
		httpsConn.setRequestMethod(method);
		httpsConn.setRequestProperty("Content-Type", CONTENT_TYPE_JSON);
		httpsConn.setConnectTimeout(CONNECT_TIME_OUT);
		httpsConn.setReadTimeout(READ_TIME_OUT);
		httpsConn.connect();
		return httpsConn;
	}

	public static HttpURLConnection getHttpConnection(String url, String method) throws Exception {
		URL myURL = new URL(url);
		HttpURLConnection httpConn = (HttpURLConnection)myURL.openConnection();
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		httpConn.setUseCaches(false);
		httpConn.setRequestMethod(method);
		httpConn.setRequestProperty("Content-Type", CONTENT_TYPE_JSON);
		httpConn.setConnectTimeout(CONNECT_TIME_OUT);
		httpConn.setReadTimeout(READ_TIME_OUT);
		return httpConn;
	}
}
