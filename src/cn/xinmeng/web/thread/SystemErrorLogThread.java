package cn.xinmeng.web.thread;

import java.util.HashMap;
import java.util.Map;

import cn.xinmeng.common.context.HelperSpringWeb;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.service.BaseService;

@SuppressWarnings("all")
public class SystemErrorLogThread implements Runnable{

	String params = "";			//接口参数（错误时，参数信息）
	String fullStackTrace = "";	//错误的堆栈信息
	String code = "";			//接口编码
	String message = "";		//错误信息
	String createUser = "";		//创建人
	String imei = "";
	Integer loginShopId = 0;
	Integer sourceShopId = 0;
	
	public SystemErrorLogThread(String fullStackTrace,String params,String code,
			String message,String createUser,String imei,Integer loginShopId,Integer sourceShopId){
		this.fullStackTrace = fullStackTrace;
		this.params = params;
		this.code = code;
		this.message = message;
		this.createUser = createUser;
		this.imei = imei;
		this.loginShopId = loginShopId;
		this.sourceShopId = sourceShopId;
	}
	
	@Override
	public void run() {
		Map<String, Object> systemErrorLog = new HashMap<String, Object>();
		try {
			Map<String,String> serviceMap = HelperSpringWeb.getBean("shop_service_config",Map.class);
			BaseService appService = HelperSpringWeb.getBean(serviceMap.get("errorlog"),BaseService.class);
			if(appService != null){
				systemErrorLog.put("ip", imei);// app 设备号  wap ip
				if(fullStackTrace != null && fullStackTrace.length() > 2000){
					systemErrorLog.put("errorInformation",fullStackTrace.substring(0, 3000));
				}else{
					systemErrorLog.put("errorInformation",fullStackTrace);
				}
				systemErrorLog.put("pri",10);
				if(message != null && message.length() > 100){
					systemErrorLog.put("description", message.substring(0, 100));
				}else{
					systemErrorLog.put("description", message);
				}
				systemErrorLog.put("platform", 1);
				if(params != null && params.length() > 800){
					systemErrorLog.put("runCommand", params.substring(0, 800));
				}else{
					systemErrorLog.put("runCommand", params);
				}
				systemErrorLog.put("createUser", createUser);
				AppRequestEntity entity = new AppRequestEntity();
				entity.setSource("api");
				entity.setSourceShopId(sourceShopId);
				entity.setLoginShopId(loginShopId);
				entity.setData(FastJsonUtils.bean2Json(systemErrorLog));
				appService.callServer(entity,entity.getData());
			}
		} catch (Exception e) {
			LogManager.info(this.getClass(),"记录接口日志异常：保存对象："+systemErrorLog);
			LogManager.info(this.getClass(),"记录接口日志异常：参数："+params);
			LogManager.error(this.getClass(),"记录接口日志异常：",e);
		}
	}
	
	

}
