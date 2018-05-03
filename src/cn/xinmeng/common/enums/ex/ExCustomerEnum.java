package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 账户流水收支类型枚举
 *
 */
public enum ExCustomerEnum implements IEnum{
	
	EX_NULL_OLD_PASSWORD("EX_NULL_OLD_PASSWORD","旧密码为空..."),
	EX_NULL_NEW_PASSWORD("EX_NULL_NEW_PASSWORD","新密码为空..."),
	EX_NULL_TOKEN("EX_NULL_TOKEN","token为空..."),
	EX_NULL_LOGINNAME("EX_NULL_LOGINNAME","登录名为空..."),
	EX_NULL_PASSWORD("EX_NULL_PASSWORD","密码为空..."),
	EX_ERROR_PASSWORD("EX_ERROR_PASSWORD","密码错误..."),
	EX_ERROR_OLD_PASSWORD("EX_ERROR_OLD_PASSWORD","旧密码不正确..."),
	EX_ERROR_OLDANDNEW_PASSWORD("EX_ERROR_OLDANDNEW_PASSWORD","旧密码和新密码不能一样..."),
	EX_ERROR_TOKEN("EX_ERROR_TOKEN","您的账户已经在其它终端登录"),
	EX_USERNAME_HAVE_REGISTER("EX_USERNAME_HAVE_REGISTER","用户名已经被注册..."),
	EX_USERNAME_NOT_HAVE_REGISTER("EX_USERNAME_NOT_HAVE_REGISTER","手机未注册..."),
	EX_DISABLE("EX_DISABLE","帐号已被禁用..."),
	EX_PHONE_DISABLE("EX_PHONE_DISABLE","手机已被禁用..."),
	EX_NULL_PHONE("EX_NULL_PHONE","手机号不能为空..."),
	EX_PHONE_SHOP("EX_PHONE_SHOP","手机号没绑定店铺账号..."),
	EX_SHOP_PHONE("EX_SHOP_PHONE","店铺没绑定手机..."),
	EX_SHOP_PHONE_NOTSAME("EX_SHOP_PHONE_NOTSAME","店铺绑定手机与填写手机不一致..."),
	EX_PHONE_USERNAME("EX_PHONE_USERNAME","手机号没有与该账号绑定..."),
	
	EX_NULL_APP_VERSION_IS("EX_NULL_APP_VERSION_IS","app版本号为空..."),
	EX_NULL_DEVICE_NUMBER_IS("EX_NULL_DEVICE_NUMBER_IS","设备号为空..."),
	EX_NULL_SYSTEM_VERSION_IS("EX_NULL_SYSTEM_VERSION_IS","系统版本号为空..."),
	
	EX_CUSTOMER_NOT_EXISTS("CUSTOMER_NOT_EXISTS","客户不存在..."),
	EX_USERNAME_EXISTS("EX_USERNAME_EXISTS","用户名存在..."),
	EX_USER_NOT_EXISTS("EX_USER_NOT_EXISTS","用户不存在..."),
	EX_NULL_CUSTOMER_ID("E_GENERAL_CUSTOMER","客户编号为空..."),
	
	EX_NULL_CARTID_IS("EX_NULL_CARTID_IS","购物车id不能为空..."),
	EX_NULL_CART_NUMBER("EX_NULL_CART_NUMBER","商品数量必须大于0..."),
	EX_NULL_CART_PRODUCTID("EX_NULL_CART_PRODUCTID","购物车商品id为空..."),
	EX_CART_PRODUCT_NOT_EXISTS("CART_PRODUCT_NOT_EXISTS","购物车商品信息不存在..."),
	
	EX_NULL_FEEDBACK_SOURCE("EX_NULL_FEEDBACK_SOURCE","反馈来源为空..."),
	EX_NULL_FEEDBACK_CONTENT("EX_NULL_FEEDBACK_CONTENT","反馈内容为空..."),
	EX_NULL_FEEDBACK_SOURCE_IS("EX_NULL_FEEDBACK_SOURCE_IS","反馈来源为空..."),
	EX_NULL_FEEDBACK_CONTEXT_IS("EX_NULL_FEEDBACK_CONTEXT_IS","反馈内容为空..."),
	EX_NOTEXIST_FEEDBACK_SOURCE("E_GENERAL_CUSTOMER","反馈来源不存在..."),
	
	EX_NULL_RECOMMEND_CUSTOMER_ID("E_GENERAL_CUSTOMER","推荐人编号为空...."),
	EX_NOTEXIST_RECOMMEND_CUSTOMER("E_GENERAL_CUSTOMER","推荐人不存在..."),
	EX_NULL_RECOMMEND_CODE("E_GENERAL_CUSTOMER","推荐码为空...."),

	EX_NULL_OPEN_ID("E_GENERAL_CUSTOMER","openId为空...."),
	EX_NULL_GETUI("E_GENERAL_CUSTOMER","个推编号为空..."),
	
	EX_COLLECT_TYPE_IS_NULL("E_COLLECT_TYPE_IS_NULL","收藏类型不能为空..."),
	EX_COLLECT_ID_IS_NULL("E_COLLECT_ID_IS_NULL","收藏编号不能为空..."),
	
	
	EX_NULL_RECIPIENT_NAME("E_GENERAL_CUSTOMER","收件人姓名为空..."),
	EX_NULL_RECIPIENT_PHONE("E_GENERAL_CUSTOMER","收件人电话为空..."),
	EX_NULL_RECIPIENT_ADDRESS("E_GENERAL_CUSTOMER","收件人地址为空..."),
	EX_NULL_ADDRESS_TYPE("E_GENERAL_CUSTOMER","地址类型为空..."),
	EX_NULL_PROVINCE_ID("E_GENERAL_CUSTOMER","省份为空..."),
	EX_NULL_CITY_ID("E_GENERAL_CUSTOMER","城市为空..."),
	EX_NULL_DISTRICT_ID("E_GENERAL_CUSTOMER","区/县为空..."),
	EX_NULL_TOWN("E_GENERAL_CUSTOMER","街道/乡镇为空..."),
	EX_NULL_ADDRESS_ID("E_GENERAL_CUSTOMER","地址编号为空..."),
	EX_NULL_REALYNAME("EX_NULL_REALYNAME","请填写实名制..."),
	EX_NOTEXISTS_CUSTOMER_ADDRESS("EX_NOTEXISTS_CUSTOMER_ADDRESS","客户地址不存在..."),
	EX_NULL_PROVINCE_NAME("E_GENERAL_PAYMENT","省名称为空..."),
	EX_NULL_CITY_NAME("E_GENERAL_PAYMENT","城市名称为空..."),
	
	EX_NULL_CHAT_ID("EX_NULL_CHAT_ID","聊天编号为空..."),
	EX_NULL_CHAT_CONTENT("EX_NULL_CHAT_CONTENT","消息为空..."),
	EX_NULL_CHAT_TO_CUSTOMER("EX_NULL_CHAT_TO_CUSTOMER","接收人为空..."),
	EX_NULL_GROUP_ICON("EX_NULL_GROUP_ICON","小组图标为空..."),
	EX_NULL_GROUP_NAME("EX_NULL_GROUP_NAME","小组名称为空..."),
	EX_ERROR_GROUP_NAME("EX_ERROR_GROUP_NAME","小组名称已被使用..."),
	EX_ERROR_CUSTOMER_RIGHTS("EX_ERROR_CUSTOMER_RIGHTS","您的名额已用完..."),
	EX_NULL_GROUP_DESCRIPTION("EX_NULL_GROUP_DESCRIPTION","小组简介为空..."),
	EX_NULL_GROUP_ID("EX_NULL_GROUP_ID","小组编号为空..."),
	EX_NULL_GROUP_CONTENT("EX_NULL_GROUP_CONTENT","动态内容为空..."),
	EX_ERROR_GROUP("EX_NULL_GROUP","小组不存在或已下线..."),
	EX_ERROR_GROUP_JOIN("EX_ERROR_GROUP_JOIN","您已加入该小组..."),
	EX_ERROR_GROUP_USER("EX_ERROR_GROUP_USER","您未加入该小组..."),
	
	EX_ERROR_VIP("EX_ERROR_VIP","您未开通会员或已过期..."),
	;

	private ExCustomerEnum(String key,String value){
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
