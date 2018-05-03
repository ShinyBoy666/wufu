package cn.xinmeng.web.shop.impl.address;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.ShopPostageConfig;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopPostageConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.address.S1056ResponseEntity;

/**
 * 查询常用地址
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.address.S1056Component")
public class S1056Component extends BaseService {

	@Resource
	private IRedisService redisService;
	@Resource
	private IShopPostageConfigService shopPostageConfigService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_ADDRESS_ID);
		}else{
			CommonAddress address = redisService.getCommonAddress(entity.getId());
			if(address != null){
				S1056ResponseEntity responseEntity = new S1056ResponseEntity();
				Region region = redisService.getRegion(address.getDistrictId());
				CloneUtils.copyEntity(address, responseEntity);
				responseEntity.setIsDefault(Utils.isDefaultAddress(responseEntity.getIsDefault(), false));
				if(region != null){
					responseEntity.setProvinceName(region.getProvinceName());
					if(Utils.isEmpty(region.getCityName())){
						responseEntity.setCityName(region.getAreaName());
					}else{
						responseEntity.setCityName(region.getCityName());
					}
					responseEntity.setDistrictName(region.getRegionName());
				}
				
				ShopPostageConfig shopPostageConfig = shopPostageConfigService.queryPostage(request.getLoginShopId(), address);
				if(shopPostageConfig != null){
					responseEntity.setPostage(shopPostageConfig.getPostage());
					responseEntity.setPostageFree(shopPostageConfig.getPostageFree());
				}
				return  getAppResponseEntity(responseEntity);
			}else {
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NOTEXISTS_CUSTOMER_ADDRESS);
			}
			
		}
	}

	
}
