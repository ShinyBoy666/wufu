package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;


/**
 * NullException 处理异常
 * @author jiangyong.tan
 *
 */
public class NullException extends GeneralException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9171113488538667494L;

	public NullException(String msg){
		super(msg);
	}
	
	public NullException(String msg,Throwable cause){
		super(msg, cause);
	}
	
	public <T extends IEnum> NullException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> NullException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
}