package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单商品分利级别
 * //0利润等级1、一级 2、二级 3、三级10店铺
 * @param 
 * @ClassName: OrderProductProfitStateEnum 
 * @version V1.0  
 * @date 2016年2月24日 下午6:20:48 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum OrderProductProfitLevelEnum implements IEnum{

	//利润等级1、一级 2、二级 3、三级10店铺
	FIRST("1","一级 "),
	SECOND("2","二级"),
	THIRD("3","三级"),
	SHOP("4","货款"),
	;
	private OrderProductProfitLevelEnum(String key,String value){
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
		for (OrderProductProfitLevelEnum item : OrderProductProfitLevelEnum.values()) {
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
		for (OrderProductProfitLevelEnum item : OrderProductProfitLevelEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
}
