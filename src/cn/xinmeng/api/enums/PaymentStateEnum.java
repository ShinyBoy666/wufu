package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 支付状态枚举
 * @author jiangyong.tan
 * 支付状态 1 - 未支付；2 - 支付中；3 - 支付成功；4 - 支付失败；5 - 已退款
 */
public enum PaymentStateEnum implements IEnum{
	/**
	 * 未支付
	 */
	STATE_PAY_NOT("1","未支付"),
	/**
	 * 支付中
	 */
	STATE_PAYING("2","支付中"),
	/**
	 * 支付成功
	 */
	STATE_PAY_SUCCESS("3","支付成功"),
	/**
	 * 支付失败
	 */
	STATE_PAY_FAIL("4","支付失败"),
	
	/**
	 * 已退款
	 */
	STATE_REFUNDED("5","已退款"),
	;
	private PaymentStateEnum(String key,String value){
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
	/**
	 * 校验是否存在
	 * @param value
	 * @return
	 */
	public static boolean exist(String value){
		boolean exist = false;
		for (PaymentStateEnum state : PaymentStateEnum.values()) {
			if(state.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}

	/**
	 * 通过 key 获取 value
	 * @param key
	 * @return
	 */
	public static String keyToValue(String key){
		for (PaymentStateEnum item : PaymentStateEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
}
