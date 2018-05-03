package cn.xinmeng.web.shop.impl.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
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
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;
import cn.xinmeng.web.shop.entity.customer.S1033RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1033ResponseEntity;

/**
 * 下单，查询可用优惠券
 * @param 
 * @ClassName: S1033Component 
 * @version V1.0  
 * @date 2016年2月24日 上午10:38:27 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1033Component")
public class S1033Component extends BaseService {
	
	@Resource
	private ICartService cartService;
	@Resource
	private ICouponService couponService;
	@Resource
	private IProductPriceService productPriceService;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IShopInfoService shopInfoService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1033RequestEntity entity = parseRequertParam(data, S1033RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getCartIds())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CARTID_IS);
		}
		
		//返回数据
		List<S1033ResponseEntity> resList = new ArrayList<S1033ResponseEntity>();
		
		//查询购物车列表
		List<Cart> listCart = cartService.searchCartByCartIds(entity.getCartIds());
		if(listCart != null && listCart.size() > 0){
			List<Integer> productIds = new ArrayList<Integer>();
			for (Cart cart : listCart) {
				productIds.add(cart.getProductId());
			}
			boolean isDelivery = productInfoService.queryProductInfoIsDelivery(productIds);				//是否需要发货
			boolean realyname = productInfoService.queryProductInfoRealyname(productIds);			//是否需要填写身份证
			//商品对应的店铺ID
			Map<Integer,Integer> shopMap = productInfoService.queryShopIdByProductId(productIds);
			
			
			//获取商品价格
			Map<Integer,List<ShopCartVo>> shopCartMap = new HashMap<Integer,List<ShopCartVo>>();//店铺购物车Map，键：shopId
			for (Cart cart : listCart) {
				ShopCartVo vo = new ShopCartVo();
				CloneUtils.cloneEntity(cart, vo);
				Integer productId = cart.getProductId();
				String sku = cart.getSku();
				vo.setRetailPrice(productPriceService.queryRetailPriceByProductId(productId, sku));
				
				Integer shopId = shopMap.get(productId);
				if(shopCartMap.containsKey(shopId)){
					List<ShopCartVo> shopCartList = shopCartMap.get(shopId);
					shopCartList.add(vo);
					shopCartMap.put(shopId, shopCartList);
				}else{
					List<ShopCartVo> shopCartList = new ArrayList<ShopCartVo>();
					shopCartList.add(vo);
					shopCartMap.put(shopId, shopCartList);
				}
			}
			
			//获取每一个店铺可用优惠券信息
			Map<Integer,ShopInfo> shopInfoMap = new HashMap<Integer, ShopInfo>();
			if(shopCartMap.size() > 0){
				Iterator<Integer> itr = shopCartMap.keySet().iterator();
				while(itr.hasNext()){
					Integer shopId = itr.next();
					S1033ResponseEntity resEntity = new S1033ResponseEntity();
					resEntity.setShopId(shopId);	//店铺ID
					resEntity.setUsableCoupons(couponService.searchCouponByShopId(shopId,request.getLoginShopId(), entity.getCustomerId(), shopCartMap.get(shopId)));
					if(shopInfoMap.containsKey(shopId)){
						ShopInfo shopInfo = shopInfoMap.get(shopId);
						if(shopInfo != null){
							resEntity.setShopName(shopInfo.getShopName());
							resEntity.setShopLogo(shopInfo.getShopLogo());
							shopInfoMap.put(shopId, shopInfo);
						}
					}else{
						ShopInfo shopInfo = shopInfoService.queryShopInfoById(shopId,"shop_name,shop_logo");
						if(shopInfo != null){
							resEntity.setShopName(shopInfo.getShopName());
							resEntity.setShopLogo(shopInfo.getShopLogo());
							shopInfoMap.put(shopId, shopInfo);
						}
						
					}
					resEntity.setDelivery(isDelivery);
					resEntity.setRealyname(realyname);
					resEntity.setPostage(0.00);
					resList.add(resEntity);
				}
			}
		}
		
		return getAppResponseEntity(resList);
	}
	
	
}
