package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;

public class RedisException extends GeneralException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2799665695467031858L;
	
	public RedisException(Logger log,String msg,Throwable cause){
		super(log, cause);
	}
	
	public <T extends IEnum> RedisException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> RedisException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
}
