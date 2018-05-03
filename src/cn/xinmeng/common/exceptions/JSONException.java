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
public class JSONException extends GeneralException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JSONException(String msg){
		super(msg);
	}
	
	public JSONException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public JSONException(String msg,Throwable cause,Map<String, Serializable> data){
		super(msg,cause,data);
	}
	
	public <T extends IEnum> JSONException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> JSONException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
	
	public JSONException(Logger log,Throwable cause){
		super(log, cause);
	}
	
	public <T extends IEnum> JSONException(Logger log,T ienum,Throwable cause){
		super(log, ienum, cause);
	}
}
