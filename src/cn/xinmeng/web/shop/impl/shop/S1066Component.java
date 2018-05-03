package cn.xinmeng.web.shop.impl.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.enums.ShopImageTypeEnum;
import cn.xinmeng.api.service.IShopImageService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.vo.ShopInfoVo;

/**
 * 查询店铺信息
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.shop.S1066Component")
public class S1066Component extends BaseService {
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Resource
	private IShopImageService shopImageService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}
		
		//查询店铺信息
		ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(entity.getShopId());
		if(shopInfo == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_NOTEXISTS_SHOP);
		}
		
		ShopInfoVo result = new ShopInfoVo();
		CloneUtils.cloneEntity(shopInfo, result);
		result.setLogo(Utils.getImageUrl(shopInfo.getShopLogo(),"?100_100"));
		result.setBossImage(Utils.getImageUrl(shopImageService.queryShopInfoImage(entity.getShopId(), ShopImageTypeEnum.BOSS)));
		result.setShopImage(Utils.getImageUrl(shopImageService.queryShopInfoImage(entity.getShopId(), ShopImageTypeEnum.SHOP)));
		return getAppResponseEntity(result);
	}
}
