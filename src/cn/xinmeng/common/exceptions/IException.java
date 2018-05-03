package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import cn.xinmeng.common.enums.IEnum;

/**
 * 异常接口类
 * @author jiangyong.tan
 *
 */
public interface IException {
    /**
	 * 返回 key
	 * @return
	 */
	String key();
	
	/**
	 * 重置异常 code
	 * @param code
	 * @return
	 */
	GeneralException setKey(String code);
	
	/**
	 * 返回 value
	 * @return
	 */
	String getMessage();
	
	String value();
	
	/**
	 * 设置信息
	 * @param value
	 * @return
	 */
	GeneralException setValue(String value);
	
	/**
	 * 设置信息
	 * @param key code
	 * @param value msg
	 * @return
	 */
	GeneralException set(String key,String value);
	
	/**
	 * 设置信息
	 * @param t
	 * @return
	 */
	<T extends IEnum> GeneralException set(T t);
	
	/**
	 * 信息加前缀
	 * @param value
	 * @return
	 */
	GeneralException valuePrefix(String prefix);
	
	/**
	 * 信息加后缀
	 * @param value
	 * @return
	 */
	GeneralException valueSuffix(String suffix);
	/**
	 * 获取异常数据
	 * @return
	 */
	Map<String,Serializable> getErrorDate();
}
