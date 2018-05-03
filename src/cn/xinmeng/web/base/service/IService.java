package cn.xinmeng.web.base.service;

import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppResponseEntity;

public abstract class IService {
	/**
	 * JSON转实体
	 * @param <T>
	 * @param json
	 * @param cls
	 * @return
	 */
	protected <T> T parseRequertParam(String json,Class<T> cls){
		try {
			return FastJsonUtils.json2Bean(json, cls);
		} catch (Exception ex) {
			throw new BusinessException("请求参数有误...",ex);
		}
	}
	
	/**
	 * 实体转JSON
	 * @param obj
	 * @return
	 */
	protected String beanToJSON(Object obj){
		return FastJsonUtils.bean2Json(obj);
	}
	
	/**
	 * 返回值
	 * @param message
	 * @param data
	 * @return
	 */
	protected AppResponseEntity getAppResponseEntity(Object data,String message) {
		AppResponseEntity response = new AppResponseEntity();
		response.setData(data);
		response.setSuccess(1);
		if(Utils.isEmpty(message)){
			response.setMessage("请求成功...");
		}else{
			response.setMessage(message);
		}
		return response;
	}
	
	/**
	 * 返回值
	 * @param message
	 * @param data
	 * @return
	 */
	protected AppResponseEntity getAppResponseEntity(Object data) {
		return getAppResponseEntity(data,null);
	}
}
