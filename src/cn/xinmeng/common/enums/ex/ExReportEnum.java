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
public enum ExReportEnum implements IEnum {
	DAY_REPORT30("DAY_REPORT30","日报表最多只能查询30天数据！"),
	WEEK_REPORT100("WEEK_REPORT100","周报表最多只能查询100天数据！"),
	month_REPORT731("month_REPORT731","月报表最多只能查询2年数据！"),
	;
	private ExReportEnum(String key,String value){
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
