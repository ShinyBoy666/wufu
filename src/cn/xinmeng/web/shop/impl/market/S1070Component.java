package cn.xinmeng.web.shop.impl.market;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ActivityProduct;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.enums.ActivityTypeEnum;
import cn.xinmeng.api.service.IActivityProductService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1070RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1070ResponseEntity;

/**
 * 秒杀活动详商品列表
 * @param 
 * @ClassName: S1070Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1070Component")
public class S1070Component extends BaseService {

	@Resource
	private IActivityProductService activityProductService;
	@Resource
	private IProductInfoService productInfoService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1070RequestEntity entity = parseRequertParam(data, S1070RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getActivityId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_ACTIVITYID);
		}else if(Utils.isEmpty(entity.getActivityType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_ACTIVITYTYPE);
		}else if(ActivityTypeEnum.exist(entity.getActivityType()+"") == false){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_TYPE);
		}
		List<S1070ResponseEntity>  resList = new ArrayList<S1070ResponseEntity>();
		List<ActivityProduct> list = activityProductService.selectByExample(entity.getActivityId(),entity.getActivityType());
		if(!Utils.isEmpty(list)){
			for (ActivityProduct activityProduct : list) {
				S1070ResponseEntity res = new S1070ResponseEntity();
				CloneUtils.copyEntity(activityProduct, res);
				res.setRetailPrice(activityProduct.getProductActivityPrice());
				res.setMarketPrice(activityProduct.getProductPrice());
				ProductInfo productInfo = productInfoService.queryProductInfoByProductId(activityProduct.getProductId());
				if(!Utils.isEmpty(productInfo)){
					res.setProductName(productInfo.getProductName());
					res.setImageUrl(productInfo.getImageUrl());
				}
				resList.add(res);
			}
		}
		return getAppResponseEntity(resList);
	}
}
