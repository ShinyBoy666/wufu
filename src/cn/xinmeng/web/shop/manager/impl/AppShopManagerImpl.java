package cn.xinmeng.web.shop.manager.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.context.HelperSpringWeb;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.exceptions.AppRequestException;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.manager.IAppShopManager;
import cn.xinmeng.web.thread.SystemErrorLogThread;

@Service("appShopManager")
public class AppShopManagerImpl extends IAppShopManager {

	@Resource
	TaskExecutor systemErrorLogThreadPool;
	@Resource
	IShopInfoService shopInfoService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity entity,HttpServletRequest request) {
		AppResponseEntity response = new AppResponseEntity();
		long beginTime = System.currentTimeMillis();//请求开始时间
		String ip = Utils.getHostIp(request);
		entity.setIp(ip);
		try{
			LogManager.info(this.getClass(),"线程id：{}，请求来源：{}，参数为：{}", Thread.currentThread().getId(),entity.getSource(),beanToJSON(entity));

			/**
			 * 校验数据合法性
			 */
			this.verifySecurity(entity);
			
			//验证店铺有效性
			shopInfoService.shopEffection(entity.getLoginShopId(), entity.getSourceShopId());
			

			//获取服务接口
			BaseService appService =  this.getAppService(entity.getCode());
			response = appService.callServer(entity, entity.getData());
			//执行服务调用
//			response.setData(appService.callServer(entity.getData(),entity.getSourceShopId(),entity.getLoginShopId(),entity.getSource(),Utils.getIpAddr(request)));
//
//			//setting 调用成功
//			response.setSuccess(1);
//
//			response.setMessage("请求成功...");

		}catch(BusinessException ex){
			//setting 调用失败
			response.setSuccess(0);
			//setting 业务异常 信息
			response.setMessage(ex.value());
			//异常code
			response.setErrorCode(ex.key());
			
			LogManager.error(this.getClass(),"业务异常",ex);
		}catch(NullException ex){
			//setting 调用失败
			response.setSuccess(0);
			//setting 业务异常 信息
			response.setMessage(ex.value());
			//异常code
			response.setErrorCode(ex.key());

			LogManager.error(this.getClass(),"空指针异常",ex);
		}catch(Exception ex){
			ex.printStackTrace();
			//setting 调用失败
			response.setSuccess(0);
			//setting 业务异常 信息
			response.setMessage("未知异常");
			LogManager.error(this.getClass(),"未知异常",ex);
			//记录异常
			String fullStackTrace = Utils.exceptionConvertStr(ex);
			systemErrorLogThreadPool.execute(new SystemErrorLogThread(fullStackTrace, beanToJSON(entity), entity.getCode(), 
					ex.getMessage(),entity.getSource(), entity.getImei(),entity.getLoginShopId(),entity.getSourceShopId()));
		}finally{
			//time	source	code	ip	time
			LogManager.infoStatLog("{},{},{},{},{},{}",DateUtil.formatDateTime(),entity.getSource(),entity.getCode(),ip,(System.currentTimeMillis()-beginTime),entity.getSourceShopId());
//			LogManager.info(this.getClass(),"线程id：{}，访问用时：{}ms，code：{}",Thread.currentThread().getId(), (System.currentTimeMillis()-beginTime),entity.getCode());
			LogManager.info(this.getClass(),"线程id：{}，访问时间：{}，【server】响应数据：{}",Thread.currentThread().getId(),(System.currentTimeMillis()-beginTime), beanToJSON(response));
		}

		return response;
	}

	/**
	 * 校验请求数据 安全校验
	 * @param request
	 */
	private void verifySecurity(AppRequestEntity entity){
		
		//非空验证
		if(Utils.isEmpty(entity.getCode())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_CODE);
		}else if(Utils.isEmpty(entity.getMak())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_MAK);
		}else if(Utils.isEmpty(entity.getSource())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_SOURCE);
		}else if(Utils.isEmpty(entity.getTimestamp())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_TIMESTAMP);
//		}else if(Utils.isEmpty(entity.getToken())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_TOKEN);
		}
		
		//店铺验证
		verifyShop(entity);
		
		
		//密钥验证
		StringBuilder sb = new StringBuilder();
		sb.append(IAppShopManager.PM); // 公共秘钥
		sb.append(entity.getCode()); // 服务号
		sb.append(entity.getImei()); // 手机串号
		sb.append(entity.getData()); //　请求数据
		sb.append(entity.getSource()); //　请求来源
		sb.append(entity.getToken()); //　token
		sb.append(entity.getTimestamp()); //　时间戳  毫秒
		sb.append(entity.getSourceShopId());
		sb.append(entity.getLoginShopId());

		LogManager.debug(this.getClass(),"【server】加密前:" + sb.toString());
		LogManager.debug(this.getClass(),"【server】加密后:" + UtilMD5.MD5(sb));
		LogManager.debug(this.getClass(),"【client】加密后:" + entity.getMak());
		//校验 服务端加密串 与 客户端加密串 合法性
		if(UtilMD5.MD5(sb).equals(entity.getMak()) == false){
			// md5 数据校验异常
			throw new AppRequestException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_MAK_ERROR);
		}
	}
	
	private void verifyShop(AppRequestEntity entity){
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("1000", "1000");
		map.put("1001", "1001");
		map.put("1002", "1002");
		map.put("1003", "1003");
		map.put("1004", "1004");
		map.put("1005", "1005");
		map.put("1043", "1043");
		map.put("1035", "1035");
		map.put("1048", "1048");
		map.put("1049", "1049");
		map.put("1064", "1064");
		map.put("2000", "2000");
		map.put("2014", "2014");
		map.put("1121", "1121");
		map.put("1117", "1117");
		if(!map.containsKey(entity.getCode())){
			if(Utils.isEmpty(entity.getLoginShopId())){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_LOGINSHOPID);
			}else if(Utils.isEmpty(entity.getSourceShopId())){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_SOURCESHOPID);
			}
		}
	}
	
	/**
	 * 获取服务接口
	 * @param serviceCode 服务编码
	 * @return AppService 服务接口
	 */
	@SuppressWarnings("unchecked")
	protected BaseService getAppService(String serviceCode){
		if(Utils.isEmpty(serviceCode)){
			throw new AppRequestException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_CODE);
		}
		Map<String,String> serviceMap = null;
		if(serviceCode.startsWith("2")){
			//店铺端
			serviceMap = HelperSpringWeb.getBean("business_service_config",Map.class);
		}else{
			//客户端
			serviceMap = HelperSpringWeb.getBean("shop_service_config",Map.class);
		}
		BaseService appService = HelperSpringWeb.getBean(serviceMap.get(serviceCode),BaseService.class);

		if(Utils.isEmpty(appService)){
			throw new AppRequestException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_CODE_NOT_EXISTS);
		}
		return appService;
	}
	
}
