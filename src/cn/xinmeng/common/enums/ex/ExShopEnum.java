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
public enum ExShopEnum implements IEnum {
	EX_SHOPID_NULL("EX_SHOPID_NULL","店铺编号为空..."),
	EX_NOTEXISTS_SHOP("EX_NOTEXISTS_SHOP","店铺不存在..."),
	EX_USE_SHOPID_NULL("EX_USE_SHOPID_NULL","使用店铺编号为空..."),
	EX_DISABLE("EX_SHOPID_NULL","店铺被禁用..."),
	EX_DELETE("EX_SHOPID_NULL","店铺被删除..."),
	EX_OVERDUE("EX_SHOPID_NULL","店铺已过期..."),
	;
	private ExShopEnum(String key,String value){
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
