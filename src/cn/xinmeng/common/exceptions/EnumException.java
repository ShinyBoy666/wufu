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
public class EnumException extends GeneralException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EnumException(String msg){
		super(msg);
	}
	
	public EnumException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public EnumException(String msg,Throwable cause,Map<String, Serializable> data){
		super(msg,cause,data);
	}
	
	public <T extends IEnum> EnumException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> EnumException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
	
	public EnumException(Logger log,Throwable cause){
		super(log, cause);
	}
	
	public <T extends IEnum> EnumException(Logger log,T ienum,Throwable cause){
		super(log, ienum, cause);
	}
}
