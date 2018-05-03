package cn.xinmeng.common.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;


/**
 * Freemarker 处理异常
 * @author 120750
 *
 */
public class FileException extends GeneralException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2353498722162121276L;

	public FileException(String msg){
		super(msg);
	}
	
	public FileException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public <T extends IEnum> FileException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> FileException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}
}
