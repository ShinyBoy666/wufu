package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;
import cn.xinmeng.common.util.LogManager;

/**
 * 基础异常类
 * @author jiangyong.tan
 *
 */
public class GeneralException extends RuntimeException implements IException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 异常 key
	 */
	protected String key;
	/**
	 * 异常 信息
	 */
	protected String value;
	
	protected Map<String,Serializable> errorData;
	
	public GeneralException(String msg){
		super(msg);
		this.value = msg;
	}
	
	public <T extends IEnum> GeneralException(Logger log,String msg){
		this(msg);
		if(log != null){
			log.error(this.getMessage(),this);
		}
	}
	public GeneralException(String msg,Throwable cause){
		super(msg,cause);
		this.value = msg;
		if(cause instanceof BusinessException){
			this.key = ((BusinessException)cause).key();
		}
		LogManager.error(this.getClass(), msg, cause);
	}
	
	public GeneralException(String msg,Throwable cause,Map<String, Serializable> data){
		this(msg,cause);
		this.errorData = data;
	}
	
	public <T extends IEnum> GeneralException(Logger log,T ienum){
		super(ienum.value());
		this.key = ienum.key();
		this.value = ienum.value();
		if(log != null){
			log.error(this.value(),this);
		}
	}
	
	public <T extends IEnum> GeneralException(Logger log,T ienum,Throwable cause){
		this(ienum.value(),cause);
		if(log != null){
			log.error(this.value(),this);
		}
	}
	
	public <T extends IEnum> GeneralException(Logger log,T ienum,Map<String, Serializable> data){
		this(log,ienum);
		this.errorData = data;
	}
	
	public <T extends IEnum> GeneralException(Logger log,T ienum,Object... param){
		this(log,ienum.parseValue(param));
	}
	
	public GeneralException(Throwable cause){
		super(cause);
		this.value = cause.getMessage();
		if(cause instanceof BusinessException){
			this.key = ((BusinessException)cause).key();
		}
	}
	
	public GeneralException(Logger log,Throwable cause){
		this(cause);
		if(log != null){
			log.error(this.getMessage(),this);
		}
	}
	
	
	public String key() {
		return key;
	}

	@Override
	public Map<String, Serializable> getErrorDate() {
		return errorData;
	}

	@Override
	public GeneralException setKey(String code) {
		this.key = code;
		return this;
	}

	@Override
	public String value() {
		return this.value;
	}

	@Override
	public GeneralException setValue(String value) {
		this.value = value;
		return this;
	}

	@Override
	public GeneralException set(String key, String value) {
		this.key = key;
		this.value = value;
		return this;
	}

	@Override
	public GeneralException valuePrefix(String prefix) {
		this.value = prefix + this.value; 
		return this;
	}

	@Override
	public GeneralException valueSuffix(String suffix) {
		this.value = this.value + suffix;
		return this;
	}

	@Override
	public <T extends IEnum> GeneralException set(T t) {
		this.key = t.key();
		this.value = t.value();
		return this;
	}
}
