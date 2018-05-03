package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 申请
 * @param 
 * @ClassName: ExShopApplyEnum 
 * @version V1.0  
 * @date 2015年12月8日 上午9:14:17 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum ExShopApplyEnum implements IEnum {
	
	EX_NULL_ID("EX_NULL_ID","申请ID不能为空..."),
	EX_NULL_ENTERPRISE_NAME("EX_NULL_ENTERPRISE_NAME","企业名称不能为空..."),
	EX_NULL_TELEPHONE("EX_NULL_TELEPHONE","联系电话不能为空..."),
	EX_NULL_EMAIL("EX_NULL_TELEPHONE","邮箱不能为空..."),
	EX_NULL_LINKMAN("EX_NULL_LINKMAN","联系人不能为空..."),
	EX_NULL_AGENT_TYPE("EX_NULL_TELEPHONE","代理级别不能为空..."),
	EX_NULL_APPLEVEL("EX_NULL_APPLEVEL","系统产品版本不能为空..."),
	;
	private ExShopApplyEnum(String key,String value){
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
