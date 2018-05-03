package cn.xinmeng.web.base.service;

import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;

public abstract class BaseService extends IService{
	
	/**
	 * 调用服务
	 * @param resquest
	 * @return
	 */
//	public abstract Object callServer(String data,Integer sourceShopId,Integer loginShopId,String source,String ip); 
	
	public abstract AppResponseEntity callServer(AppRequestEntity entity,String data);
}
