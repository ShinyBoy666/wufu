package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 消费类型枚举
 * @author jiangyong.tan
 */
public enum ConsumTypeEnum implements IEnum{

	//后台充值 = 1, 销售收入 = 2,推荐奖励 = 3,销售奖励 = 4,提现拒绝 = 5,打款失败 = 6,店铺给客户充值 = 7,代理商给店铺充值 = 8，跨店铺销售收入=9,增值服务收入=10,
	//后台扣款 = 50,用户提现 = 51,订单退款 = 52,销售奖励取消 = 53,店铺给客户充值扣款 = 54,代理商给店铺充值扣款 = 55,

	TYPE_1("1","后台充值"),
	TYPE_2("2","销售收入"),
	TYPE_3("3","推荐奖励"),
	TYPE_4("4","销售奖励"),
	TYPE_5("5","提现拒绝"),
	TYPE_6("6","打款失败"),
	TYPE_7("7","店铺给客户充值"),
	TYPE_8("8","代理商给店铺充值"),
	TYPE_9("9","跨店铺销售收入"),
	TYPE_10("10","增值服务收入"),
	

	TYPE_50("50","后台扣款"),
	TYPE_51("51","提现"),
	TYPE_52("52","订单退款"),
	TYPE_53("53","销售奖励取消"),
	TYPE_54("54","店铺给客户充值扣款"),
	TYPE_55("55","代理商给店铺充值扣款"),
	TYPE_56("56","订单支付"),
	
	
//	TYPE_EXTRACT_DIVIDE("1","提成"),
//	TYPE_SYSTEM_RECHARGE("2","后台充值"),
//	TYPE_OTHER_RECHARGE("3","其他充值"),
//	TYPE_ORDER_REFUND("4","订单退款"),
//	TYPE_SERVER_COMMISSION("5","服务佣金"),
//	TYPE_RECOMMEND_COMMISSION("6","推荐佣金"),
//	TYPE_ORDER_RECHARGE("7","订单充值"),
//	TYPE_CASH_EXTRACT_VETO("8","提现拒绝"),
//	TYPE_CASH_EXTRACT_FAILURE("9","打款失败"),
//	TYPE_CUST_RECHARGE("10","客户充值"),
//	TYPE_OTHER_CONSUME("50","其他消费"),
//	TYPE_SERVER_COMMISSION_REFUND("51","服务佣金退款"),
//	TYPE_RECOMMEND_COMMISSION_REFUND("52","推荐佣金退款"),
//	TYPE_SYSTEM_DEDUCT("53","后台扣款"),
//	TYPE_ORDER_DEDUCT("54","订单扣款"),
//	TYPE_CASH_EXTRACT("55","现金提取"),
//	TYPE_STOCK_RECHARGE_CASH("56","充值订金账户"),
	;
	private ConsumTypeEnum(String key,String value){
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
		for (ConsumTypeEnum item : ConsumTypeEnum.values()) {
			if(item.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static String keyToValue(String key){
		for (ConsumTypeEnum item : ConsumTypeEnum.values()) {
			if(item.key().equals(key)){
				return item.value();
			}
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(ConsumTypeEnum.exist("1"));
	}
}
