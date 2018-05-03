package cn.xinmeng.web.shop.impl.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.shop.S1036RequestEntity;

/**
 * 
 * <p class="detail">附近店铺 </p>
 * 
 * @param 
 * @ClassName: S1036Component 
 * @version V1.0  @date 2016年2月19日 下午4:51:47 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.shop.S1036Component")
public class S1036Component extends BaseService {
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1036RequestEntity entity = parseRequertParam(data, S1036RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
//		}else if(Utils.isEmpty(entity.getLatitude())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ShopExceptionEnum.latitude_is_null);
//		}else if(Utils.isEmpty(entity.getLongitude())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ShopExceptionEnum.longitude_is_null);
//		}else if(Utils.isEmpty(entity.getDistance())){
//			entity.setDistance(5000.0);
		}
//		if(!Utils.isEmpty(entity.getLatitude()) && !Utils.isEmpty(entity.getLongitude())){
//			GeohashUtils.encodeLatLon(entity.getLatitude(), entity.getLongitude(),5);
//		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		entity.setCurrentShopId(shopId);
		return getAppResponseEntity(shopInfoService.selectShopInfoVoList(entity));
	}
	
	
}
