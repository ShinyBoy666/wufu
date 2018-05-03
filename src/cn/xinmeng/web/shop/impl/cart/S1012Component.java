package cn.xinmeng.web.shop.impl.cart;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.cart.S1012RequestEntity;

/**
 * 查询 购物车商品 数量
 * @param 
 * @ClassName: S1012Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:46:15 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.cart.S1012Component")
public class S1012Component extends BaseService {
	
	@Resource
	private ICartService cartService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1012RequestEntity entity = parseRequertParam(data, S1012RequestEntity.class);
		if(entity == null || Utils.isEmpty(entity.getCustomerId())){
			//查询购物车商品数量
			return getAppResponseEntity(0);
		}else if(entity.getCustomerId() == 0) {
			//查询购物车商品数量
			return getAppResponseEntity(0);
		}else{
			//查询购物车商品数量
			return getAppResponseEntity(cartService.searchCartProductCount(entity.getCustomerId(),request.getLoginShopId()));
		}
	} 
	
}
