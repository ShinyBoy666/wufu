package com.pay.common;

import java.io.Serializable;
import java.util.Map;

import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.Utils;

import com.pay.config.SystemConfig;
import com.pay.config.WXConfig;

/**
 * 微信生成预支付id实体
 * @author Administrator
 *
 */
public class WxUnifiedorderEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -283661020163618111L;
	
	public WxUnifiedorderEntity(String orderId,String ip,String amount,String describe,WXTradeTypeEnum tradeTypeEnum,String openid) {
		
		this.appid = WXConfig.appID;
		this.mch_id = WXConfig.mchID;
		this.nonce_str = WXUtil.getRandomStringByLength(32);
		this.notify_url = SystemConfig.path + SystemConfig.wx_notify;
		
		//附加数据  this.attach = attach;
		
		this.out_trade_no = orderId;
		this.body = describe;
		if(!Utils.isEmpty(ip)){
			this.spbill_create_ip = ip;
		}else{
			this.spbill_create_ip = "127.0.0.1";
		}
		this.trade_type = tradeTypeEnum.toString();
		this.total_fee = amount;
		this.sign = WXUtil.getSign(FastJsonUtils.json2Bean(FastJsonUtils.bean2Json(this), Map.class));
//		if(tradeTypeEnum == WXTradeTypeEnum.JSAPI){
//			this.openid = openid;//trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。
//		}
	}

	private String appid;
	private String body;
	private String mch_id;
	private String nonce_str;
	private String notify_url;
	private String out_trade_no;
	private String spbill_create_ip;
	private String total_fee;
	private String trade_type;
	private String sign;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
