package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 消费类型枚举
 */
public enum ScoreConsumTypeEnum implements IEnum{

	//后台充值 = 1, 推荐奖励 = 2, 销售奖励 = 3
	//后台扣款 = 50, 积分消费 = 51,  销售奖励取消 = 52

	TYPE_1("1","后台充值"),
	TYPE_2("2","推荐奖励"),
	TYPE_3("3","销售奖励"),
	

	TYPE_50("50","后台扣款"),
	TYPE_51("51","积分消费"),
	TYPE_52("52","销售奖励取消"),
	
	;
	private ScoreConsumTypeEnum(String key,String value){
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
		for (ScoreConsumTypeEnum item : ScoreConsumTypeEnum.values()) {
			if(item.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static String keyToValue(String key){
		for (ScoreConsumTypeEnum item : ScoreConsumTypeEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(ScoreConsumTypeEnum.exist("1"));
	}
}
