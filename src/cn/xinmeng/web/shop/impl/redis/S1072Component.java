package cn.xinmeng.web.shop.impl.redis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ActivityProduct;
import cn.xinmeng.api.service.IActivityProductService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1071RequestEntity;

/**
 * 活动下架，删除缓存
 * @param 
 * @ClassName: S1072Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.redis.S1072Component")
public class S1072Component extends BaseService {

	@Resource
	private IRedisService redisService;
	@Resource
	private IActivityProductService activityProductService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1071RequestEntity entity = parseRequertParam(data, S1071RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}

		List<ActivityProduct> list = activityProductService.selectByExample(entity.getActivityId(), entity.getActivityType());
		for (ActivityProduct activityProduct : list) {
			redisService.delRedisActvityProductInfoBiz(entity.getActivityId(), entity.getActivityType(), activityProduct.getProductId(),activityProduct.getProductPriceId());
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		redisService.delHomepageSettingParentVo(shopId);
		return getAppResponseEntity(true);
	}
}
