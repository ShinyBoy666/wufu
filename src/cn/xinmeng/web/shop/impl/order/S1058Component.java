package cn.xinmeng.web.shop.impl.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.ShopPostageConfig;
import cn.xinmeng.api.enums.ProductStateEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.IShopPostageConfigService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.address.S1015ResponseEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCustCouponVo;
import cn.xinmeng.web.shop.entity.customer.S1033ResponseEntity;
import cn.xinmeng.web.shop.entity.order.S1058RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1058ResponseEntity;

/**
 * 订单确认页面（wap需要，以后app可能也用）
 * @param 
 * @ClassName: S1058Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.order.S1058Component")
public class S1058Component extends BaseService {

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
	@Resource
	private ICommonAddressService commonAddressService;
	@Resource
	private IRedisService redisService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private IShopPostageConfigService shopPostageConfigService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1058RequestEntity entity = parseRequertParam(data, S1058RequestEntity.class);
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
		S1058ResponseEntity res = new S1058ResponseEntity();

		List<ShopCartVo> shopCarts = new ArrayList<ShopCartVo>();
		Double totalAmount = 0.00;
		Double postage = 0.00;
		Double postageFree = 0.00;
		Customer customer = customerService.selectByPrimaryKey(entity.getCustomerId());
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		res.setCashAmount(customer.getCashAmount());
		if(customerService.isMember(customer)){
			res.setAccountDeduct(true);
		}else{
			res.setAccountDeduct(systemConfigService.notNumberBalancePay());
		}

		//查询购物车列表
		List<Cart> listCart = cartService.searchCartByCartIds(entity.getCartIds());
		if(!Utils.isEmpty(listCart)){
			List<Integer> productIds = new ArrayList<Integer>();
			//商品信息
			for (Cart cart : listCart) {
				ShopCartVo shopCart = new ShopCartVo();
				shopCart.setProductNumber(cart.getProductNumber());
				shopCart.setSku(cart.getSku());
				shopCart.setAddCartTime(cart.getCreateTime());
				shopCart.setProductId(cart.getProductId());
				shopCart.setId(cart.getId());
				
				//查询商品信息
				String productFieldList = "product_name,image_url,shop_id,state";
				ProductInfo productInfo = productInfoService.queryProductInfoByProductId(cart.getProductId(),productFieldList);
				if(productInfo == null){
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_PRODUCTID);
				}
				shopCart.setProductName(productInfo.getProductName());
				shopCart.setImageUrl(productInfo.getImageUrl());
				shopCart.setShopId(productInfo.getShopId());
				//查询商品价格信息
				String priceFieldList = "retail_price,profit_third,quantity";
				ProductPrice productPrice = productPriceService.queryProductPrice(cart.getProductId(), cart.getSku(),priceFieldList,Integer.valueOf(StateEnum.EFFECTION.key()));
				if(productPrice == null){
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCT_PRICE_ERROR);
				}
				shopCart.setRetailPrice(productPrice.getRetailPrice());
				shopCart.setQuantity(productPrice.getQuantity());
				
				//商品状态
				if(ProductStateEnum.STATE_SHELVE.key().equals(productInfo.getState()+"")){
					shopCart.setProductState(1);
					shopCart.setProductStateValue("上架");
					if(cart.getProductNumber() > productPrice.getQuantity()){
						shopCart.setProductState(3);
						shopCart.setProductStateValue("无货");
					}
				}else{
					shopCart.setProductState(2);
					shopCart.setProductStateValue("下架");
				}
				
				shopCarts.add(shopCart);
				productIds.add(cart.getProductId());
				//订单商品总金额
				Double productAmount = UtilMoney.multiplyToDouble(cart.getProductNumber(), shopCart.getRetailPrice());
				totalAmount = UtilMoney.addToDouble(totalAmount, productAmount);
			}
			
			//客户地址
			CommonAddress commonAddress = commonAddressService.queryDefaultAddress(entity.getCustomerId());
			if(commonAddress != null){
				S1015ResponseEntity defaultAddress = new S1015ResponseEntity();
				CloneUtils.copyEntity(commonAddress, defaultAddress);
				defaultAddress.setIsDefault(Utils.isDefaultAddress(defaultAddress.getIsDefault(), false));
				Region region = redisService.getRegion(commonAddress.getDistrictId());
				if(region != null){
					defaultAddress.setProvinceName(region.getProvinceName());
					if(Utils.isEmpty(region.getCityName())){
						defaultAddress.setCityName(region.getAreaName());
					}else{
						defaultAddress.setCityName(region.getCityName());
					}
					defaultAddress.setDistrictName(region.getRegionName());
				}
				res.setAddress(defaultAddress);
			}

			boolean isDelivery = productInfoService.queryProductInfoIsDelivery(productIds);				//是否需要发货
			boolean realyname = productInfoService.queryProductInfoRealyname(productIds);			//是否需要填写身份证
			if(isDelivery){
				ShopPostageConfig shopPostageConfig = shopPostageConfigService.queryPostage(entity.getShopId(), commonAddress);
				if(shopPostageConfig != null){
					postageFree = shopPostageConfig.getPostageFree();
					if(UtilMoney.compareTo(postageFree, totalAmount) > 0){
						postage = shopPostageConfig.getPostage();
					}
				}
			}
			
			//店铺可用优惠券
			//获取每一个店铺可用优惠券信息
			List<S1033ResponseEntity> shopCoupons = new ArrayList<S1033ResponseEntity>();
					
			List<ShopCustCouponVo> usableCoupons = couponService.searchCouponByShopId(entity.getShopId(),request.getLoginShopId(), entity.getCustomerId(), shopCarts);
			if(!Utils.isEmpty(usableCoupons)){
				S1033ResponseEntity resEntity = new S1033ResponseEntity();
				resEntity.setShopId(entity.getShopId());	//店铺ID
				resEntity.setUsableCoupons(usableCoupons);
				resEntity.setShopName(shopInfoService.queryShopNameByShopId(entity.getShopId()));
				resEntity.setDelivery(isDelivery);//是否需要发货
				resEntity.setRealyname(realyname);//是否需要填写身份证
				resEntity.setPostage(postage);
				shopCoupons.add(resEntity);
			}
			
			res.setShopCoupons(shopCoupons);
			res.setDelivery(isDelivery);//是否需要发货
			res.setRealyname(realyname);//是否需要填写身份证
		}
		res.setShopCarts(shopCarts);
		res.setTotalAmount(totalAmount);
		res.setTotalPostage(postage);
		res.setPostageFree(postageFree);
		return getAppResponseEntity(res);
	}

}
