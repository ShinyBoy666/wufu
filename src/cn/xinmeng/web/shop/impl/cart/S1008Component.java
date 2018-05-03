package cn.xinmeng.web.shop.impl.cart;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 新增 购物车商品 
 * 描述
 * @param 
 * @ClassName: S1008Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:37:22 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.cart.S1008Component")
public class S1008Component extends BaseService {
	
	@Resource
	private ICartService cartService; 
	@Resource
	private IProductPriceService productPriceService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Cart cart = parseRequertParam(data, Cart.class);
		if(cart == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(cart.getCustomerId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(cart.getProductId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCTID);
		}else if((cart.getProductNumber() > 0) == false){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CART_NUMBER);
		}else if(Utils.isEmpty(cart.getSku())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCT_SKU);
		}else{
//			cart.setShopId(request.getLoginShopId());
			Cart entity = cartService.queryCartByProductId(cart.getCustomerId(),cart.getShopId(), cart.getProductId(),cart.getSku());
			if(entity != null){
				entity.setCreateTime(new Date());
				entity.setProductNumber(cart.getProductNumber() + entity.getProductNumber());

				//修改购物车商品数量
				if(cartService.updateByPrimaryKey(entity) > 0){
					return getAppResponseEntity(true);
				}
			}else{
				//购物车添加商品
				if(cartService.add(cart) > 0){
					return getAppResponseEntity(true);
				}
			}
			return getAppResponseEntity(false);
		}
	}

}
