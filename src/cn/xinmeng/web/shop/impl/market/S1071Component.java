package cn.xinmeng.web.shop.impl.market;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.enums.ActivityTypeEnum;
import cn.xinmeng.api.service.IActivityProductService;
import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IRegionService;
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
import cn.xinmeng.web.shop.entity.market.S1071RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1071ResponseEntity;

/**
 * 秒杀订单确认页
 * @param 
 * @ClassName: S1071Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1071Component")
public class S1071Component extends BaseService {

	@Resource
	private IActivityProductService activityProductService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IRedisService redisService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private ICommonAddressService commonAddressService;
	@Resource
	private IRegionService regionService;
	@Resource
	private IProductInfoService productInfoService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1071RequestEntity entity = parseRequertParam(data, S1071RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getActivityId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_ACTIVITYID);
		}else if(Utils.isEmpty(entity.getActivityType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_ACTIVITYTYPE);
		}else if(ActivityTypeEnum.exist(entity.getActivityType()+"") == false){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_TYPE);
		}else if(Utils.isEmpty(entity.getProductId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCTID);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getProductPriceId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCTPRICEID);
		}else if(Utils.isEmpty(entity.getProductNumber())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCT_NUMBER_NULL);
		}

		//返回数据
		S1071ResponseEntity res = new S1071ResponseEntity();
		
		
		//缓存中活动信息
		ActvityProductInfoBiz biz = redisService.getActvityProductInfoBiz(entity.getActivityId(), entity.getActivityType(), entity.getProductId(),entity.getProductPriceId());
		if(Utils.isEmpty(biz)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_PRODUCT);
		}
		res.setDiscountAmount(UtilMoney.multiplyToDouble(entity.getProductNumber(),UtilMoney.subtractToDouble(biz.getMarketPrice(), biz.getRetailPrice())));

		
		//商品信息
		ShopCartVo vo = new ShopCartVo();
		vo.setProductId(biz.getProductId());
		List<String> imageUrl = biz.getImageUrlList();
		if(!Utils.isEmpty(imageUrl)){
			vo.setImageUrl(imageUrl.get(0));
		}
		vo.setProductName(biz.getProductName());
		vo.setProductNumber(entity.getProductNumber());
		vo.setProductState(1);
		vo.setProductStateValue("上架");
		vo.setQuantity(biz.getQuantity());
		vo.setRetailPrice(biz.getRetailPrice());
		vo.setShopId(biz.getShopId());
		vo.setSku(biz.getSku());
		vo.setProductPriceId(biz.getProductPriceId());
		vo.setActivityId(biz.getActivityId());
		vo.setActivityType(biz.getActivityType());
		
		//优惠券
//		resEntity.setUsableCoupons( couponService.searchCouponByShopId(biz.getShopId(),loginShopId, entity.getCustomerId(), vo));
		


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
		
		//地址加入到缓存
		redisService.updateCommonAddress(commonAddress);
		
		if(!Utils.isEmpty(biz.getIsDelivery()) && biz.getIsDelivery() == 1){
			res.setIsDelivery(false);//是否需要发货
		}
		if(!Utils.isEmpty(biz.getIsHaveSeat()) && biz.getIsHaveSeat() == 2){
			res.setIsSeat(true);//是否需要座位号
		}
//		res.setRealyname(productInfoService.queryProductInfoRealyname(new ArrayList<String>()));//是否需要填写身份证
		res.setProductInfo(vo);
		res.setTotalAmount(UtilMoney.multiplyToDouble(biz.getMarketPrice(), entity.getProductNumber()));
		res.setTotalPostage(biz.getPostage());
		return getAppResponseEntity(res);
	}
}
