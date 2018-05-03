package cn.xinmeng.web.shop.impl.market;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.enums.ActivityTypeEnum;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1069RequestEntity;

/**
 * 秒杀活动详情
 * @param 
 * @ClassName: S1069Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1069Component")
public class S1069Component extends BaseService {

	@Resource
	private IRedisService redisService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1069RequestEntity entity = parseRequertParam(data, S1069RequestEntity.class);
		
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getActivityId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_ACTIVITYID);
		}else if(Utils.isEmpty(entity.getActivityType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_ACTIVITYTYPE);
		}else if(ActivityTypeEnum.exist(entity.getActivityType()+"") == false){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_TYPE);
		}else if(Utils.isEmpty(entity.getProductId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCTID);
		}else if(Utils.isEmpty(entity.getProductPriceId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCTPRICEID);
		}
		ActvityProductInfoBiz biz = redisService.getActvityProductInfoBiz(entity.getActivityId(), entity.getActivityType(), entity.getProductId(),entity.getProductPriceId());
		if(!Utils.isEmpty(biz)){
			biz.setAlreadyBuy(redisService.existsActivityPurchase(biz.getActivityId(), biz.getActivityType(), entity.getCustomerId(), biz.getProductId(), biz.getProductPriceId()));
		}
		if("wap".equalsIgnoreCase(request.getSource())){
			ProductDetailInfo p = redisService.getProductDetailInfo(biz.getProductId());
			if(!Utils.isEmpty(p)){
				biz.setProductDetail(p.getDescription());
			}
		}
		return getAppResponseEntity(biz);
	}
}
