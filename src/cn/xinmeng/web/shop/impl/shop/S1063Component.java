package cn.xinmeng.web.shop.impl.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.enums.ShopImageTypeEnum;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IShopImageService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;
import cn.xinmeng.web.shop.entity.shop.S1063ResponseEntity;

/**
 * 附近店铺首页
 * @author tanjiangyong
 *
 */
@Component ("cn.xinmeng.web.shop.impl.shop.S1063Component")
public class S1063Component extends BaseService {
	
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IShopImageService shopImageService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1006RequestEntity entity = parseRequertParam(data, S1006RequestEntity.class);
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
		
		S1063ResponseEntity res = new S1063ResponseEntity();
		res.setShopName(shopInfo.getShopName());
		res.setShopLogo(Utils.getImageUrl(shopInfo.getShopLogo(),"?300_300"));
		res.setShopImage(Utils.getImageUrl(shopImageService.queryShopInfoImage(shopInfo.getId(),ShopImageTypeEnum.SHOP),"?640_320"));
		return getAppResponseEntity(res);
	}
}
