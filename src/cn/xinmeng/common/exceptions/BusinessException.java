package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;


/**
 * 业务异常类
 * @author jiangyong.tan
 *
 */
public class BusinessException extends GeneralException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String msg){
		super(msg);
	}
	
	public BusinessException(Logger log,String msg){
		super(log,msg);
	}
	
	public BusinessException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public <T extends IEnum> BusinessException(Logger log,T ienum,Object... param){
		super(log,ienum,param);
	}
	
	public BusinessException(String msg,Throwable cause,Map<String, Serializable> data){
		super(msg,cause,data);
	}
	
	public <T extends IEnum> BusinessException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> BusinessException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
	
	public BusinessException(Logger log,Throwable cause){
		super(log, cause);
	}
	
	public <T extends IEnum> BusinessException(Logger log,T ienum,Throwable cause){
		super(log, ienum, cause);
	}
}
