package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单商品分利状态
 * //1为未结算，2为已结算，3无需结算，4待结算，5已退款（1，2，4状态其实都已经给现金账户加过钱了）
 * @param 
 * @ClassName: OrderProductProfitStateEnum 
 * @version V1.0  
 * @date 2016年2月24日 下午6:20:48 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum OrderProductProfitStateEnum implements IEnum{

	//1为未结算，2为已结算，3无需结算，4待结算，5已退款（1，2，4状态其实都已经给现金账户加过钱了）
	NOT_SETTLED("1","未结算"),
	YET_SETTLED("2","已结算 "),
	NO_SETTLED("3","无需结算"),
	PENDING_SETTLED("4","待结算"),
	YET_RETURN("5","已退款"),
	;
	private OrderProductProfitStateEnum(String key,String value){
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
		for (OrderProductProfitStateEnum item : OrderProductProfitStateEnum.values()) {
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
		for (OrderProductProfitStateEnum item : OrderProductProfitStateEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
}
