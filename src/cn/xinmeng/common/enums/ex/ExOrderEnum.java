package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单模块错误提示
 * @param 
 * @ClassName: ShowOrderStateEnum 
 * @version V1.0  
 * @date 2015年12月8日 上午9:14:17 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum ExOrderEnum implements IEnum {
	
	EX_TEST_PROPAGATION("E_GENERAL_ORDER","事务测试"),
	
	EX_ERROR_ORDER_PARAM("1","下单参数有误..."),
	EX_ERROR_ORDER_SUBMIT("1","下单失败..."),
	EX_ERROR_ACCOUNT_DEDUCT("2","余额扣款失败..."),
	EX_ERROR_PAYMENT_CREATE("3","支付号生成失败..."),

	EX_ORDER_EXCEPTION("EX_ORDER_EXCEPTION","创建订单异常..."),
	EX_NULL_CONDITION("E_GENERAL_ORDER","参数为空..."),
	EX_NULL_CUSTOMER_ID("E_GENERAL_ORDER","客户编号为空..."),
	EX_NULL_SERVICE_CUSTOMER_ID("E_GENERAL_ORDER","服务人编号为空..."),
	EX_NULL_RECIPIENT_IDENTITY_CARD("E_GENERAL_ORDER","收件人身份证为空..."),
	EX_NULL_ORDER_ID("E_GENERAL_ORDER","订单编号为空..."),
	EX_NULL_ORDER_SEND_ID("E_GENERAL_ORDER","订单推送编号为空..."),
	EX_NULL_ORDER_STATE("E_GENERAL_ORDER","订单状态为空..."),
	EX_ERROR_ORDER_STATE("E_GENERAL_ORDER","订单状态异常 钱充值到账户余额..."),
	EX_NULL_PAYMENT_ID("E_GENERAL_ORDER","支付编号为空..."),
	EX_NULL_TRADE_NO("E_GENERAL_ORDER","支付回调流水号为空..."),
	EX_NULL_PAYMENT_STATE("E_GENERAL_ORDER","支付状态为空..."),
	EX_NULL_ADDRESS("E_GENERAL_ORDER","收件人参数为空..."),
	EX_NULL_ADDRESS_ERROR("E_GENERAL_ORDER","收件人地址为空..."),
	EX_NULL_CHOOSE_CART_LIST("E_GENERAL_ORDER","购物车未选择商品..."),
	EX_NULL_PAYMENT("E_GENERAL_ORDER","支付参数为空..."),
	EX_NULL_PAYMENT_TYPE("E_GENERAL_ORDER","请选择支付方式..."),
	EX_NOTEXIST_PAYMENT_TYPE("E_GENERAL_ORDER","在线支付方式不存在..."),
	EX_NULL_RECHARGE_FROM("E_GENERAL_ORDER","充值来源为空..."),
	EX_NOTEXIST_RECHARGE_FROM("E_GENERAL_ORDER","充值来源不存在..."),
	EX_NULL_RECHARGE_AMOUNT("E_GENERAL_ORDER","错误的充值金额..."),
	EX_NULL_CUSTOMER_CATEGORY("E_GENERAL_ORDER","客户类别为空..."),
	EX_NOTEXIST_CUSTOMER_CATEGORY("E_GENERAL_ORDER","客户类别不存在..."),
	EX_NULL_ORDER_PROVINCE_ID("E_GENERAL_ORDER","下单省份为空..."),
	EX_NULL_ORDER_CITY_ID("E_GENERAL_ORDER","下单城市为空..."),
	EX_NULL_ORDER_FROM("E_GENERAL_ORDER","订单来源为空..."),
	EX_NOTEXIST_ORDER_FROM("E_GENERAL_ORDER","订单来源不存在..."),
	EX_ERROR_ORDER_PRODUCT("E_GENERAL_ORDER","请选择要购买的商品..."),
	EX_ERROR_PRODUCT_STORAGE("E_GENERAL_ORDER","商品库存不足,请到购物车修改数量..."),
	EX_NULL_CART("E_GENERAL_ORDER","购物车为空..."),
	EX_NULL_CART_ID("E_GENERAL_ORDER","购物车编号为空..."),
	EX_NOTEXIST_CART_ID("E_GENERAL_ORDER","购物车编号不存在..."),
	EX_NULL_PRODUCT_ID("E_GENERAL_ORDER","商品编号为空..."),
	EX_NULL_PRODUCT_PRICE("E_GENERAL_ORDER","商品价格信息为空..."),
	EX_NULL_PRODUCT_NUMBER("E_GENERAL_ORDER","商品数量为空..."),
	
	EX_NOTEXIST_ACTIVITY_TYPE("E_GENERAL_ORDER","活动类型不存在..."),
	EX_NULL_ACTIVITY_ID("E_GENERAL_ORDER","活动编号为空..."),
	EX_JOIN_ACTIVITY("E_GENERAL_ORDER","您已参加此活动..."),
	EX_ERROR_ACTIVITY_PRODUCT_NUMBER("E_GENERAL_ORDER","超出活动商品限购数量..."),
	
	EX_ERROR_STORAGE_SUB("E_GENERAL_ORDER","减库存失败..."),
	EX_ERROR_STORAGE_ADD("E_GENERAL_ORDER","加库存失败..."),
	EX_NULL_LOGISTICS_NUMBER("EX_NULL_LOGISTICS_NUMBER","物流单号为空..."),
	EX_NULL_LOGISTICS_NAME("EX_NULL_LOGISTICS_NAME","物流公司名称为空..."),
	
	
	EX_NULL_SKU_VALUES("E_GENERAL_ORDER","SKU值集合为空..."),
	EX_NULL_SKU_VALUES_TEXT("E_GENERAL_ORDER","SKU值文本集合为空..."),
	
	EX_ERROR_ACCOUNT_NOT_FULL("E_ORTER_ACCOUNT","余额不足，扣款失败..."),
	
	
	EX_NOTEXIST_ORDER_PRODUCTS("E_GENERAL_ORDER","该订单不存在商品信息..."),
	
	EX_NOTEXIST_SEARCH_STATE("E_GENERAL_ORDER","查询状态不存在..."),
	EX_NULL_SEARCH_STATE("E_GENERAL_ORDER","查询状态为空..."),
	
	EX_NOTEXIST_ORDER("E_GENERAL_ORDER","订单不存在..."),
	EX_FAID_CANCEL_ORDER("EX_FAID_CANCEL_ORDER","订单取消失败..."),
	
	EX_NULL_TOTAL_AMOUNT("E_GENERAL_ORDER","订单总金额为零..."),
	EX_PAY_FAILD_CREATE_ORDER("EX_PAY_FAILD_CREATE_ORDER","支付异常，订单已创建..."),
	
	EX_ERROR_PAY_SUCCESS("E_GENERAL_ORDER","订单已支付..."),
	EX_ERROR_STATE("E_GENERAL_ORDER","{0},请重新下单..."),
	
	EX_NULL_ORDER_PRODUCT_ID("E_GENERAL_ORDER","订单商品编号为空..."),
	
	EX_NOT_EXIST_ORDER_PRODUCT_SEND("E_GENERAL_ORDER","订单商品推行信息不存在..."),
	
	EX_NOT_EXIST_ORDER_PRODUCT("E_GENERAL_ORDER","订单商品不存在..."),
	
	EX_ERROR_PRODUCT_STATE_SHIP_YET("E_GENERAL_ORDER","只有已发货的商品才可以确认收货..."),
	EX_ERROR_ORDER_RECEIVING("EX_ERROR_ORDER_RECEIVING","订单确认收货失败..."),
	
	EX_ERROR_PRODUCT_STATE_RECEIVE("E_GENERAL_ORDER","只有已收货的商品才可以评论..."),
	
	EX_NULL_ORDER_PRODUCT_STATE("E_GENERAL_ORDER","订单商品状态为空..."),
	
	EX_NULL_PRODUCT_STATE_REMARK("E_GENERAL_ORDER","订单商品状态描述为空..."),
	
	
	EX_NULL_PRODUCT_SCORE("E_GENERAL_ORDER","评分为空..."),
	
	EX_NULL_COMMENT_CONTENT("E_GENERAL_ORDER","评论内容为空..."),
	
	EX_ERROR_SEND_SUCCESS("E_GENERAL_ORDER","订单已处理，不能取消订单..."),
	
	EX_ERROR_NOT_COMMIT_TRUE("E_GENERAL_ORDER","订单状态为：{0}，不能取消订单..."),
	
	EX_ERROR_PRODUCT_STATE("E_GENERAL_ORDER","商品信息已过期..."),
	
	EX_ERROR_REFUND_MONEY("E_GENERAL_ORDER","退款金额异常，不能取消订单..."),
	EX_ERROR_UPDATE_PARAMS("E_GENERAL_ORDER","更新参数异常..."),
	EX_NULL_PAYMENT_GATEWAY("E_GENERAL_ORDER","在线支付方式为空..."),
	EX_NULL_PAYMENT_AMOUNT("E_GENERAL_ORDER","在线支付金额为零..."),
	
	
	EX_ERROR_PACKAGE_CONFIG("E_GENERAL_ORDER","礼包分红信息不存在，参数：referrerShopAmount:{0},targetShopAmount:{1}"),
	
	EX_ERROR_SHOP("E_GENERAL_ORDER","开店成功，分红失败..."),
	
	EX_NOT_VALID_PRODUCT("E_GENERAL_ORDER","商品已失效..."),
	EX_ACTIVITYORDER_EXIST_CUSTOMER("E_GENERAL_ORDER","该用户已存在..."),

	EX_NOT_VIP_FEE("EX_NOT_VIP_FEE","系统未配置会员费..."),
	EX_NOT_VIP_PRODUCT("EX_NOT_VIP_PRODUCT","系统未配置会员商品..."),
	
	EX_ERROR_COUPON("E_GENERAL_ORDER","优惠劵信息不存在或已过期..."),
	EX_ERROR_COUPON_USE("E_GENERAL_ORDER","使用优惠劵失败..."),
	EX_ERROR_COUPON_MAX_USE_NUMBER("EX_ERROR_COUPON_MAX_USE_NUMBER","优惠劵叠加张数超过允许的数量..."),
	EX_ERROR_COUPON_ORDER_AMOUNT("E_GENERAL_ORDER","不满足优惠劵使用条件..."),
	
	EX_ERROR_ADD_STOCK("EX_ERROR_ADD_STOCK","加库存异常..."),
	EX_ERROR_SUB_STOCK("EX_ERROR_SUB_STOCK","减库存异常..."),
	
	;
	private ExOrderEnum(String key,String value){
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
