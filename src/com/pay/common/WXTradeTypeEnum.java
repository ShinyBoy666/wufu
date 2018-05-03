package com.pay.common;

/**
 * 
 * <p class="detail">微信支付类型枚举</p>
 * 
 * @param 
 * @ClassName: TradeTypeEnum 
 * @version V1.0  @date 2016年3月9日 下午2:28:06 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
public enum WXTradeTypeEnum {
	JSAPI,//公众号支付
	NATIVE,//原生扫码支付
	APP,//app支付
	MICROPAY//刷卡支付
}
