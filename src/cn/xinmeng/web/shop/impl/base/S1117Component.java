package cn.xinmeng.web.shop.impl.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 常见问题
 * @param 
 * @ClassName: S1117Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1117Component")
public class S1117Component extends BaseService {
	
	@Resource
	private IRedisService redisService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		return getAppResponseEntity(redisService.getQuestion(6));
	}
	
	
}
