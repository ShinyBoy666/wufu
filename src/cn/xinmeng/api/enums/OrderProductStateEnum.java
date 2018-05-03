package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单商品状态
 * 1=待发货,2=已发货,3=已收货,4=申请退货,5=退货成功,6=退货失败
 * @param 
 * @ClassName: OrderStateEnum 
 * @version V1.0  
 * @date 2016年2月24日 下午6:20:48 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum OrderProductStateEnum implements IEnum{
	TO_BE_SHIPPED("1","待发货"),
	ALREADY_SHIPPED("2","已发货 "),
	RECEIVED_GOODS("3","已收货"),
	APPLICATION_FOR_RETURN("4","申请退货"),
	RETURN_SUCCESS("5","退货成功"),
	RETURN_FAIL("6","退货失败"),
	;
	private OrderProductStateEnum(String key,String value){
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
		for (OrderProductStateEnum item : OrderProductStateEnum.values()) {
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
		for (OrderProductStateEnum item : OrderProductStateEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
}
