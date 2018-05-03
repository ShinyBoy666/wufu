package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单状态表，状态
 * 状态类型：1=订单状态，2=支付状态，3=商品状态
 * @param 
 * @ClassName: OrderStateEnum 
 * @version V1.0  
 * @date 2016年2月24日 下午6:20:48 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum OrderStateTableEnum implements IEnum{
	ORDER_STATE("1","订单状态"),
	ORDER_PAY_STATE("2","支付状态"),
	PRODUCT_STATE("3","商品状态"),
	/**
	 * 已收货
	 */
	STATE_RECEIVED_ALL ("6","已收货"),
	;
	private OrderStateTableEnum(String key,String value){
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
		for (OrderStateTableEnum item : OrderStateTableEnum.values()) {
			if(item.key().equals(value)){
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
		for (OrderStateTableEnum item : OrderStateTableEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
}
