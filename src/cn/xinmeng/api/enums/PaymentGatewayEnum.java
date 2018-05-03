package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 在线支付方式 ：1 - 支付宝 ；2 - 微信 ；3 - 银联
 * @author jiangyong.tan
 *
 */
public enum PaymentGatewayEnum  implements IEnum{
	PAY_GATEWAY_PAY_TREASURE("1","支付宝支付"),
	PAY_GATEWAY_WE_CHAT("2","微信支付"),
	PAY_GATEWAY_UNIONPAY("3","银联支付")
	;
	
	private PaymentGatewayEnum(String key,String value){
		this.key = key;
		this.value = value;
	}
	private String key;
	private String value;
	@Override
	public String value() {
		return this.value;
	}

	@Override
	public String key() {
		return this.key;
	}

	@Override
	public IEnum parseValue(Object... params) {
		return setValue(MessageFormat.format(value, params));
	}

	@Override
	public IEnum setValue(String value) {
		this.value = value;
		return this;
	}

	public static String keyToValue(String key){
		for (PaymentGatewayEnum item : PaymentGatewayEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
	
	/**
	 * 校验是否存在
	 * @param value
	 * @return
	 */
	public static boolean exist(String value){
		boolean exist = false;
		for (PaymentGatewayEnum payGateway : PaymentGatewayEnum.values()) {
			if(payGateway.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
}
