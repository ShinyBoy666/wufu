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
public enum ExRequestEnum implements IEnum {
	REQUEST_ERROR("REQUEST_ERROR","请求内容有错误！"),
	REQUEST_DATA("REQUEST_DATA","请求数据不能为空..."),
	REQUEST_SOURCE("REQUEST_SOURCE","来源不能为空..."),
	REQUEST_CODE("REQUEST_CODE","服务号不能为空..."),
	REQUEST_CODE_NOT_EXISTS("REQUEST_CODE_NOT_EXISTS","找不到服务号..."),
	REQUEST_TOKEN("REQUEST_TOKEN","token不能为空..."),
	REQUEST_TIMESTAMP("REQUEST_TIMESTAMP","时间戳不能为0..."),
	REQUEST_MAK("REQUEST_MAK","密钥为空..."),
	REQUEST_MAK_ERROR("REQUEST_MAK_ERROR","签名失败..."),
	REQUEST_LOGINSHOPID("REQUEST_LOGINSHOPID","登录店铺ID为空..."),
	REQUEST_SOURCESHOPID("REQUEST_SOURCESHOPID","来源店铺ID为空..."),
	;
	private ExRequestEnum(String key,String value){
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
