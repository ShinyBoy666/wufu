package com.pay.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.pay.config.AlipayConfig;
import com.pay.config.SystemConfig;

public class AliUtil {
	/**
	 * 支付宝消息验证地址
	 */
	private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

	/**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
	public static boolean verify(Map<String, String> params) {
		// 判断responsetTxt是否为true，isSign是否为true
		// responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
		// isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
		String responseTxt = "false";
		if (params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
		// LogManager.info(PayUtil.class,"verify function:"+responseTxt);
		String sign = "";
		if(params.get("sign") != null){sign = params.get("sign");}
		boolean isSign = getSignVeryfy(params, sign);

		// 写日志记录（若要调试，请取消下面两行注释）
		// String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign +"\n 返回回来的参数：" + AlipayCore.createLinkString(params);
		// AlipayCore.logResult(sWord);
		// LogManager.info(PayUtil.class,"verify isSign:"+isSign);
		if (isSign && responseTxt.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	/**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
		// 过滤空值、sign与sign_type参数
		Map<String, String> sParaNew = paraFilter(Params);
		// 获取待签名字符串
		String preSignStr = createLinkString(sParaNew);
		// 获得签名验证结果
		boolean isSign = false;

		String signType = Params.get("sign_type");
		if(PayFinal.MD5.equals(signType)){
			isSign = MD5.verify(preSignStr, sign, AlipayConfig.key, SystemConfig.input_charset);
		} else if (PayFinal.RSA.equals(signType)) {
			isSign = RSA.verify(preSignStr, sign, AlipayConfig.ali_public_key, SystemConfig.input_charset);
		}
		return isSign;
	}

	/**
     * 获取远程服务器ATN结果,验证返回URL
     * @param notify_id 通知校验ID
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
	private static String verifyResponse(String notify_id) {
		// 获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
		String partner = AlipayConfig.partner;
		String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;
		return checkUrl(veryfy_url);
	}
	
	/**
     * 获取远程服务器ATN结果
     * @param urlvalue 指定URL路径地址
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
	private static String checkUrl(String urlvalue) {
		String inputLine = "";
		try {
			URL url = new URL(urlvalue);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
		} catch (Exception e) {
			e.printStackTrace();
			inputLine = "";
		}
		// LogManager.info(PayUtil.class,"urlvalue:"+urlvalue);
		// LogManager.info(PayUtil.class,"checkUrl:"+inputLine);
		return inputLine;
	}
	
	/**
	 * 除去数组中的空值和签名参数
	 * @param sArray 签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
	                || key.equalsIgnoreCase("sign_type")) {
	                continue;
			}
			result.put(key, value);
		}
		return result;
	}

	/** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}

	public static String submit(String amount,String outTradeNo,String subject,String ip) {
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("seller_email", AlipayConfig.seller_email);
		sParaTemp.put("_input_charset", SystemConfig.input_charset);
		sParaTemp.put("payment_type", "1");
		sParaTemp.put("notify_url", SystemConfig.path + SystemConfig.ali_notify);
		sParaTemp.put("return_url", SystemConfig.path + SystemConfig.ali_return);
		sParaTemp.put("out_trade_no", outTradeNo);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", amount);
		// sParaTemp.put("body", "");
		// sParaTemp.put("anti_phishing_key", anti_phishing_key);//防钓鱼时间戳
		sParaTemp.put("exter_invoke_ip", ip);

		String strMethod = "get";
		String strButtonName = "确认";

		// 除去数组中的空值和签名参数
		Map<String, String> sPara = AliUtil.paraFilter(sParaTemp);
		// 签名结果与签名方式加入请求提交参数组中
		sPara.put("sign", MD5.sign(AliUtil.createLinkString(sPara),AlipayConfig.key, SystemConfig.input_charset));
		sPara.put("sign_type", PayFinal.MD5);

		StringBuffer sbHtml = new StringBuffer();
		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"https://mapi.alipay.com/gateway.do?"
				+ "_input_charset="+ SystemConfig.input_charset+ "\" method=\"" + strMethod + "\">");
		for (Entry<String, String> entry : sPara.entrySet()) {
			sbHtml.append("<input type=\"hidden\" name=\"" + entry.getKey()+ "\" value=\"" + entry.getValue() + "\"/>");
		}

		// submit按钮控件请不要含有name属性
		sbHtml.append("<input type=\"submit\" value=\"" + strButtonName+ "\" style=\"display:none;\"></form>");
		sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
		return sbHtml.toString();
	}
	
}
