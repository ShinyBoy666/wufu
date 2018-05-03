package com.pay.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.impl.pay.SPayComponent;

import com.pay.common.AliUtil;
import com.pay.common.MD5;
import com.pay.common.PayFinal;
import com.pay.common.WXUtil;
import com.pay.config.SystemConfig;

@Controller
public class PayController{

	private static Logger logger = LoggerFactory.getLogger("payReturnLog");
	
	@Resource(name="cn.xinmeng.web.shop.impl.pay.SPayComponent")
	private SPayComponent payComponent;
	
	
	/**
	 * wap通知
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pay/wap/notify/",method = RequestMethod.POST)
	public String wapNotify(Model model,@RequestParam(value = "json")String json){
		String flag = PayFinal.fail;
		try {
			if(!Utils.isEmpty(json)){
				Map<String,String> params = FastJsonUtils.json2Bean(json, Map.class);
				logger.info("wap params:"+params);
				if(params.size() > 0){
					String key = "wufu@2016";
					String rechargeId = params.get("rechargeId");
					String tradeNumber = params.get("tradeNumber");
					String amount = params.get("amount");
					StringBuffer sb = new StringBuffer("");
					sb.append(rechargeId);
					sb.append(tradeNumber);
					sb.append(amount);
					String signature = MD5.sign(sb.toString(), key, SystemConfig.input_charset);
					if(signature.equals(params.get("signature"))){
						//验证通过 调用业务逻辑
						payComponent.callback(rechargeId, tradeNumber, amount);
						flag = PayFinal.success;
					}
				}
			}
		} catch (Exception e) {
			logger.error("wapNotify:"+ e);
		}
		model.addAttribute("result", flag);
		return "/ajax";
	}
	
	/**
	 * wap通知
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pay/wap/sumbit/")
	public String wapSubmit(Model model,@RequestParam(value = "r")String r,@RequestParam(value = "m")String m,@RequestParam(value = "s")String s){
		String result = "";
		try {
			if(!Utils.isEmpty(r) && !Utils.isEmpty(m)){
				Map<String, String> param = new HashMap<String, String>();
				param.put("RechargeId", r);
				param.put("Fee", m);
				param.put("ShopId", s);
				String json = HttpClientUtils.postRequest("http://pay.51shunkai.com/api/PayApi/HandleAlipayWap", param);
				if(!Utils.isEmpty(json)){
					param.clear();
					param = FastJsonUtils.json2Bean(json, Map.class);
					if(param.size() > 0 && "SUCCESS".equals(param.get("ReturnState"))){
						result = param.get("AlipayRes");
					}
				}
			}
		} catch (Exception e) {
			logger.error("wapSubmit:"+ e);
		}
		model.addAttribute("result", result);
		return "/ajax";
	}
	
	/**
	 * 支付宝异步通知
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = SystemConfig.ali_notify)
	public String alipayNotify(Model model,HttpServletRequest request){
		String flag = PayFinal.fail;
		try {
			Map<String,String> params = aliGetParams(request,false);
			if(params.size() > 0 && AliUtil.verify(params)){
				//交易状态
				String tradeStatus = params.get("trade_status");
				String outTradeNo = params.get("out_trade_no");
				String tradeNo =  params.get("trade_no");
				String totalFee =  params.get("total_fee");
				if("TRADE_FINISHED".equals(tradeStatus) || "TRADE_SUCCESS".equals(tradeStatus)){
					//验证通过 调用业务逻辑
					payComponent.callback(outTradeNo, tradeNo, totalFee);
				}
				flag = PayFinal.success;
	    	}
		} catch (Exception e) {
			logger.error("alipayNotify:"+ e);
		}
		model.addAttribute("result", flag);
		return "/ajax";
	}
	
//	@RequestMapping(value = SystemConfig.ali_return)
//	public Boolean alipayReturn(Model model,HttpServletRequest request){
//		String flag = PayFinal.fail;
//		try {
//			Map<String,String> params = aliGetParams(request,true);
//			if(params.size() > 0 && AliUtil.verify(params)){
//				//交易状态
//				String tradeStatus = params.get("trade_status");
//				String outTradeNo = params.get("out_trade_no");
//				String tradeNo =  params.get("trade_no");
//				String totalFee =  params.get("total_fee");
//				if("TRADE_FINISHED".equals(tradeStatus) || "TRADE_SUCCESS".equals(tradeStatus)){
//					//验证通过 调用业务逻辑
//					payComponent.callback(outTradeNo, tradeNo, totalFee);
//				}
//				flag = PayFinal.success;
//	    	}
//		} catch (Exception e) {
//			logger.error("alipayReturn:"+ e);
//		}
//		model.addAttribute("result", flag);
//		return "/ajax";
//	}
	
	/**
	 * 支付宝 通知 通过 request获取参数
	 * @param request
	 * @param isEncoding 是否要转码
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings({"rawtypes"})
	private Map<String,String> aliGetParams(HttpServletRequest request,boolean isEncoding) throws UnsupportedEncodingException{
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		logger.info("requestParams:"+requestParams);
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			if(isEncoding){
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			}
			params.put(name, valueStr);
		}
		logger.info("params:"+params);
		return params;
	}
	
//	@RequestMapping("/paytest")
//	public String test(Model model,Double amount,HttpServletRequest request){
//		if(amount == null){
//			amount = 0.01d;
//		}
//		try {
//			model.addAttribute("result", WXUtil.unifiedorder(new WxUnifiedorderEntity(new Date().getTime()+"",null,"1","jph",WXTradeTypeEnum.APP,null)));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////      model.addAttribute("result", AliUtil.submit(amount+"", new Date().getTime()+"", "jph", ""));
//        return "/ajax";
//	}
	
	
	@RequestMapping(value = SystemConfig.wx_notify)
	public String wxpayNotify(Model model,HttpServletRequest request,HttpServletResponse response){
		String flag = PayFinal.fail;
		try {
			InputStream inStream = request.getInputStream();
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = inStream.read(buffer)) != -1) {
	            outSteam.write(buffer, 0, len);
	        }
	        outSteam.close();
	        inStream.close();
	        String result  = new String(outSteam.toByteArray(),SystemConfig.input_charset);//获取微信调用我们notify_url的返回信息
	        logger.info("result:"+result);
	        Map<String, String> payMap = WXUtil.getMapFromXML(result);
	        logger.info("payMap:"+payMap);
	        if(payMap.size() > 0 && WXUtil.verify(payMap)){
				//验证通过 调用业务逻辑
				if("SUCCESS".equals(payMap.get("return_code")) && "SUCCESS".equals(payMap.get("result_code"))){
					payComponent.callback(payMap.get("out_trade_no"), payMap.get("transaction_id"), payMap.get("total_fee"));
				}
				flag = PayFinal.success;
	    	}
		} catch (Exception e) {
			logger.error("wxpayNotify:"+ e);
		}
		model.addAttribute("result", flag);
		return "/ajax";
	}
	
}
