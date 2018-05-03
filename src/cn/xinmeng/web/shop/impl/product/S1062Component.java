package cn.xinmeng.web.shop.impl.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;

/**
 * 云商城列表
 * @author tanjiangyong
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1062Component")
public class S1062Component extends BaseService {
	
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IRedisService redisService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		S1006RequestEntity entity = parseRequertParam(data, S1006RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}
		if(entity.getCurrentPage() == 1 && entity.getLimit() == 10){
			return getAppResponseEntity(redisService.getYunShopProductList(entity));
		}else{
			return getAppResponseEntity(productInfoService.selectHotProductInfoList(entity));
		}
	}
}
