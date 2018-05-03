package cn.xinmeng.web.shop.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * app前端显示订单状态
 * @param 
 * @ClassName: ShowOrderStateEnum 
 * @version V1.0  
 * @date 2015年12月8日 上午9:14:17 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum WebShowOrderStateEnum implements IEnum {
	
	NO_PAYMENT("1","待付款"),
	CARRIED_OUT("2","进行中"),
	COMPLETED("3","已完成"),
	STATE_TIMEOUT("4","已超时 "),
	STATE_CANCEL("5","已取消"),
	;
	private WebShowOrderStateEnum(String key,String value){
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
		for (WebShowOrderStateEnum item : WebShowOrderStateEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
}
