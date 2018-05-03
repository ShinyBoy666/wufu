package cn.xinmeng.web.shop.impl.redis;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 首页下架，删除缓存
 * @param 
 * @ClassName: S1074Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.redis.S1074Component")
public class S1074Component extends BaseService {

	@Resource
	private IRedisService redisService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}
		redisService.delHomepageSettingParentVo(entity.getShopId());
		return getAppResponseEntity(true);
	}
}
