package cn.xinmeng.web.shop.impl.log;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.SystemErrorLog;
import cn.xinmeng.api.service.ISystemErrorLogService;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 错误日志
 * @param 
 * @ClassName: SErrorLogComponent 
 * @version V1.0  
 * @date 2016年3月2日 下午3:51:25 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.log.SErrorLogComponent")
public class SErrorLogComponent extends BaseService {

	@Resource
	private ISystemErrorLogService systemErrorLogService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		SystemErrorLog entity = parseRequertParam(data, SystemErrorLog.class);
		systemErrorLogService.add(entity);
		return getAppResponseEntity(true);
	}

}
