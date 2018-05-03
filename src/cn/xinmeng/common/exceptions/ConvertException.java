package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;


/**
 * Parse 异常类
 * @author jiangyong.tan
 *
 */
public class ConvertException extends GeneralException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConvertException(String msg){
		super(msg);
	}
	
	public ConvertException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public ConvertException(String msg,Throwable cause,Map<String, Serializable> data){
		super(msg,cause,data);
	}
	
	public <T extends IEnum> ConvertException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> ConvertException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
	
	public ConvertException(Logger log,Throwable cause){
		super(log, cause);
	}
	
	public <T extends IEnum> ConvertException(Logger log,T ienum,Throwable cause){
		super(log, ienum, cause);
	}
}
