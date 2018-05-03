package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;


/**
 * JSON常类
 * @author jiangyong.tan
 *
 */
public class EnumJSONException extends GeneralException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EnumJSONException(String msg){
		super(msg);
	}
	
	public EnumJSONException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public EnumJSONException(String msg,Throwable cause,Map<String, Serializable> data){
		super(msg,cause,data);
	}
	
	public <T extends IEnum> EnumJSONException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> EnumJSONException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
	
	public EnumJSONException(Logger log,Throwable cause){
		super(log, cause);
	}
	
	public <T extends IEnum> EnumJSONException(Logger log,T ienum,Throwable cause){
		super(log, ienum, cause);
	}
}
