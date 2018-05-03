package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单状态
 * 1、提交成功 2、已超时 3、已取消 4、已删除 5、待出库 6、配送中 7、已完\n\n成
 * @param 
 * @ClassName: OrderStateEnum 
 * @version V1.0  
 * @date 2016年2月24日 下午6:20:48 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum OrderStateEnum implements IEnum{
	STATE_SUCCESS("1","提交成功"),
	STATE_TIMEOUT("2","已超时 "),
	STATE_CANCEL("3","已取消"),
	STATE_DELETE("4","已删除"),
	STATE_FOR_OUTBOUND("5","待出库"),
	STATE_DISTRIBUTION("6","配送中"),
	STATE_FINISH("7","已完成"),
	;
	private OrderStateEnum(String key,String value){
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
		for (OrderStateEnum item : OrderStateEnum.values()) {
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
		for (OrderStateEnum item : OrderStateEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
}
