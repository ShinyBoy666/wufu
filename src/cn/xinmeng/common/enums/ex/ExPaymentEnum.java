package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 账户流水收支类型枚举
 *
 */
public enum ExPaymentEnum implements IEnum{
	EX_NULL_PAY_WAY("EX_NULL_PAY_WAY","请选择支付方式..."),
	EX_NOTEXIST_PAY_WAY("EX_NULL_PAY_WAY","支付方式不存在..."),
	EX_ERROR_PAYMENT_ID("EX_ERROR_PAYMENT_ID","支付单号生成失败..."),
	
	
	EX_RECHARGE_AMOUNT_ERROR("E_RECHARGE_AMOUNT_ERROR","充值金额不正确..."),
	EX_NULL_RECHARE_SOURCE("E_GENERAL_PAYMENT","充值来源为空..."),
	EX_ERROR_RECHARE("E_GENERAL_PAYMENT","客户账户充值失败..."),
	EX_ERROR_SCORE_RECHARE("E_GENERAL_PAYMENT","客户积分账户充值失败..."),
	
	
	EX_NULL_PAYMENT_ID("E_GENERAL_CUSTOMER","支付单号为空..."),
	EX_NULL_RECHARGE_STATE("E_GENERAL_CUSTOMER","充值状态为空..."),
	EX_NOTEXIST_RECHARGE_STATE("EX_NOTEXIST_RECHARGE_STATE","充值状态不存在..."),
	EX_NULL_PAYMENT_OR_ORDER_ID("E_GENERAL_CUSTOMER","订单号或支付单号必须存在一个..."),
	EX_NOTEXIST_ORDER_RECHARGE("E_GENERAL_CUSTOMER","当前订单不存在有效的支付单号..."),
	EX_RECHARE_ID_NOT_EXISTS("EX_RECHARE_ID_NOT_EXISTS","支付单号不存在..."),
	EX_RECHARE_ID_HAVE_PROCESS("EX_RECHARE_ID_HAVE_PROCESS","支付单号已处理..."),
	
	EX_NULL_CHANGE_AMOUNT("E_GENERAL_PAYMENT","变更金额为空..."),
	
	EX_NULL_BANK_CARD("E_GENERAL_PAYMENT","银行卡号为空..."),
	EX_NULL_BANK_NAME("E_GENERAL_PAYMENT","银行名称为空..."),
	EX_NULL_BANK_BRANCH("E_GENERAL_PAYMENT","支行名称为空..."),
	
	EX_NOTEXIST_ALIPAY_EXPEND_INCOME_TPPE("E_GENERAL_PAYMENT","收支类型不存在..."),
	EX_NULL_ALIPAY_EXPEND_INCOME_TPPE("E_GENERAL_PAYMENT","收支类型为空..."),
	
	EX_NULL_EXTRACT_CASH_TYPE("E_GENERAL_PAYMENT","提现类型为空..."),
	EX_NOTEXIST_EXTRACT_CASH_TYPE("E_GENERAL_PAYMENT","提现类型不存在..."),
	EX_ERROR_CASH_MONET("E_GENERAL_PAYMENT","提现金额至少10元..."),
	EX_ERROR_SHOP_CASH_MONET("EX_ERROR_SHOP_CASH_MONET","提现金额至少100元..."),
	EX_GRESS_SHOP_CASH_MONET("EX_GRESS_SHOP_CASH_MONET","超过可提现金额..."),
	EX_NOT_VIP_CASH_MONET("EX_NOT_VIP_CASH_MONET","不是vip会员，不能提现..."),

	EX_CHANGE_AMOUNT_ZERO("EX_CHANGE_AMOUNT_ZERO","变更金额为零..."),
	EX_ERROR_SHOP_ACCOUNT_DEDUCT("EX_ERROR_SHOP_ACCOUNT_DEDUCT","店主现金账户变更失败..."),
	EX_ERROR_EXTRACT_CASH("E_GENERAL_PAYMENT","现金账户余额不足..."),
	EX_ERROR_EXTRACT_SCORE("E_GENERAL_PAYMENT","积分账户余额不足..."),
	
	EX_NULL_CONSUM_TYPE("E_GENERAL_PAYMENT","消费类型..."),
	EX_NOTEXIST_BANK_CARD("E_GENERAL_PAYMENT","请绑定银行卡信息..."),
	EX_NOTEXIST_ALIPAY("E_GENERAL_PAYMENT","请绑定支付宝信息..."),
	EX_NULL_ALIPAY("E_GENERAL_PAYMENT","支付宝账号为空..."),
	EX_NULL_ALIPAY_REALNAME("E_GENERAL_PAYMENT","真实姓名为空..."),
	EX_ORDER_YES_PAY("EX_ORDER_YES_PAY","订单已经支付..."),
	EX_ORDER_YES_CANCEL("EX_ORDER_YES_CANCEL","订单已经取消..."),
	EX_NOT_ORDER_CANCEL("EX_ORDER_YES_CANCEL","订单已经支付完成，不能取消..."),
	;

	private ExPaymentEnum(String key,String value){
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
}
