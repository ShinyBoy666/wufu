package cn.xinmeng.api.constant;

public final class ConstantSystem {

	/**
	 * 支付单号前缀 => 秒杀订单
	 */
	public static String PAYMENT_NO_SECKILL_PREFIX = "S";
	
	/**
	 * 支付单号前缀 => 团购订单
	 */
	public static String PAYMENT_NO_GROUPON_PREFIX = "T";
	
	/**
	 * 支付单号前缀 => 普通订单
	 */
	public static String PAYMENT_NO_GENERAL_PREFIX = "Z";
	
	/**
	 * 支付单号前缀 => 优惠买单，快速订单
	 */
	public static String PAYMENT_NO_QUICK_PREFIX = "Q";

	/**
	 * 支付单号前缀 => 购买公司系统产品
	 */
	public static String PAYMENT_NO_PRODUCT_PREFIX = "P";
	
	/**
	 * 支付单号前缀 => 充值
	 */
	public static String PAYMENT_NO_RECHARGE_PREFIX = "CZ";

	/**
	 * 支付单号前缀 => 会员
	 */
	public static String PAYMENT_NO_VIP_PREFIX = "VIP";
}
