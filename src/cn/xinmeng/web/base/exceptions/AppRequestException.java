package cn.xinmeng.web.base.exceptions;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;

import cn.xinmeng.common.enums.IEnum;
import cn.xinmeng.common.exceptions.BusinessException;

public class AppRequestException extends BusinessException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1011926058819893900L;
	
	public <T extends IEnum> AppRequestException(Logger log,T ienum){
		super(log, ienum);
	}
	
	public <T extends IEnum> AppRequestException(Logger log,T ienum,Map<String, Serializable> data){
		super(log, ienum, data);
	}

}
