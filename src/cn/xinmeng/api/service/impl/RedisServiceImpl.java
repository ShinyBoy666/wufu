package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.xinmeng.api.constant.RedisConstant;
import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.service.IActivityProductService;
import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.IHomepageSettingService;
import cn.xinmeng.api.service.IIcoSettingService;
import cn.xinmeng.api.service.IProductDetailInfoService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IRegionService;
import cn.xinmeng.api.service.ISystemManualService;
import cn.xinmeng.common.enums.ex.ExCouponEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.redis.interfaces.handle.IHJedisHash;
import cn.xinmeng.redis.interfaces.handle.IHJedisString;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;
import cn.xinmeng.web.shop.entity.vo.DiscountAmountVo;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingParentVo;
import cn.xinmeng.web.shop.entity.vo.IcoSettingVo;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

@SuppressWarnings("all")
@Service("redisService")
public class RedisServiceImpl extends RedisBase implements IRedisService {
	
	private static final String activityInfoStatic = "activityInfo";
	private static final String soldNumberStatic = "soldNumber";
	private static final int expireTime = 3*24*3600;//3天
	private static final int expireTime15m = 600;//15分钟
	
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IActivityProductService activityProductService;
	@Resource
	private ICommonAddressService commonAddressService;
	@Resource
	private IRegionService regionService;
	@Resource
	private IHomepageSettingService homepageSettingService;
	@Resource
	private IProductDetailInfoService productDetailInfoService;
	@Resource
	private IIcoSettingService icoSettingService;
	@Resource
	private ICouponService couponService;
	@Resource
	private IQuickOrderService quickOrderService;
	@Resource
	private ISystemManualService systemManualService;
	
	/**
	 * 查询活动商品信息
	 * @param shopId
	 * @param activityId
	 * @param activityType
	 * @return
	 */
	public ActvityProductInfoBiz getActvityProductInfoBiz(Integer activityId,Integer activityType,Integer productId,Integer productPriceId){
		//缓存查询
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.activity_product_desc, activityId,activityType,productId,productPriceId);
			IHJedisHash jedisHash = getJedisHash();
			String result = jedisHash.hget(redisKey, activityInfoStatic);
			if(!Utils.isEmpty(result)){
				ActvityProductInfoBiz biz = json2Bean(result, ActvityProductInfoBiz.class);
				String soldNumber = jedisHash.hget(redisKey, soldNumberStatic);
				if(!Utils.isEmpty(soldNumber)){
					biz.setSoldNumber(Integer.parseInt(soldNumber));
				}
				return biz;
			}
		}
		
		//缓存无数据，数据库查询
		ActvityProductInfoBiz biz = activityProductService.getActvityProductInfoBiz(activityId, activityType, productId,productPriceId);
		
		//查询结果放入缓存
		if(isUseRedisCacheQuery() && !Utils.isEmpty(biz)){
			String redisKey = getRedisKey(RedisConstant.activity_product_desc, activityId,activityType,productId,productPriceId);
			IHJedisHash jedisHash = getJedisHash();
			jedisHash.hset(redisKey, "activityInfo",beanToJSON(biz));
			jedisHash.hset(redisKey, "soldNumber",UtilMoney.integerToZero(biz.getSoldNumber())+"");
		}
		return biz;
	}

	/**
	 * 缓存同步mysql
	 * @param productId
	 * @param activityId
	 * @param activityType
	 */
	public void redisToMysqlActvityProductInfo(Integer activityId,Integer activityType,Integer productId,Integer productPriceId){
		if(isUseRedisCacheQuery()){
			//有缓存，且把缓存数据同步到数据库
			String redisKey = getRedisKey(RedisConstant.activity_product_desc, activityId,activityType,productId,productPriceId);
			IHJedisHash jedisHash = getJedisHash();
			String result = jedisHash.hget(redisKey, activityInfoStatic);
			if(!Utils.isEmpty(result)){
				ActvityProductInfoBiz biz = json2Bean(result, ActvityProductInfoBiz.class);
				String soldNumber = jedisHash.hget(redisKey, soldNumberStatic);
				if(!Utils.isEmpty(soldNumber)){
					biz.setSoldNumber(Integer.parseInt(soldNumber));
				}
				//同步数据到数据库
				activityProductService.updateActivityProduct(biz);
			}
		}
	}
	
	/**
	 * 删除缓存
	 * @param activityId
	 * @param activityType
	 */
	public void delRedisActvityProductInfoBiz(Integer activityId,Integer activityType,Integer productId,Integer productPriceId){
		if(isUseRedisCacheQuery()){
			//有缓存，且把缓存数据同步到数据库
			String redisKey = getRedisKey(RedisConstant.activity_product_desc, activityId,activityType,productId,productPriceId);
			IHJedisHash jedisHash = getJedisHash();
			String result = jedisHash.hget(redisKey, activityInfoStatic);
			if(!Utils.isEmpty(result)){
				ActvityProductInfoBiz biz = json2Bean(result, ActvityProductInfoBiz.class);
				String soldNumber = jedisHash.hget(redisKey, soldNumberStatic);
				if(!Utils.isEmpty(soldNumber)){
					biz.setSoldNumber(Integer.parseInt(soldNumber));
				}
				//同步数据到数据库
				activityProductService.updateActivityProduct(biz);
				//删除缓存中数据
				jedisHash.hdel(redisKey,activityInfoStatic);
				jedisHash.hdel(redisKey,soldNumberStatic);
			}
		}
	}
	
	/**
	 * 更新商品已售数量
	 * @param activityId
	 * @param activityType
	 * @param productId
	 * @param productNumber
	 * @return
	 */
	public boolean updateActvityProductSoldNumber(Integer activityId,Integer activityType,Integer productId,Integer productPriceId,Integer productNumber){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.activity_product_desc, activityId,activityType,productId,productPriceId);
			IHJedisHash jedisHash = getJedisHash();
			long result = jedisHash.hincrBy(redisKey, soldNumberStatic,productNumber);
			if(result > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 更新购买地址缓存
	 * @param address
	 */
	public void updateCommonAddress(CommonAddress address){
		if(isUseRedisCacheQuery()){
			//查询结果放入缓存
			if(!Utils.isEmpty(address)){
				String redisKey = getRedisKey(RedisConstant.address_id, address.getId());
				IHJedisString jedisString = getJedisString();
				jedisString.set(redisKey,beanToJSON(address));
			}
		}
	}

	/**
	 * 删除地址缓存
	 * @param address
	 */
	public void delCommonAddress(int addressId){
		if(isUseRedisCacheQuery()){
			//查询结果放入缓存
			if(!Utils.isEmpty(addressId)){
				String redisKey = getRedisKey(RedisConstant.address_id,addressId);
				IHJedisString jedisString = getJedisString();
				jedisString.del(redisKey);
			}
		}
	}
	
	/**
	 * 获取购买地址
	 * @param addressId
	 * @return
	 */
	public CommonAddress getCommonAddress(Integer addressId){
		
		//查询缓存地址
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.address_id, addressId);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return json2Bean(result, CommonAddress.class);
			}
		}
		
		//查询数据库地址
		CommonAddress commonAddress = commonAddressService.selectByPrimaryKey(addressId);
		//查询结果放入缓存
		if(isUseRedisCacheQuery() && !Utils.isEmpty(commonAddress)){
			String redisKey = getRedisKey(RedisConstant.address_id, addressId);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime,beanToJSON(commonAddress));
		}
		return commonAddress;
	}
	

	/**
	 * 参与活动
	 * @param activityId
	 * @param activityType
	 * @param customerId
	 * @param productNumber
	 * @param endTime
	 */
	public void activityPurchase(Integer activityId,Integer activityType,Integer customerId,Integer productId,Integer productPriceId,Integer productNumber,Date endTime){
		//查询缓存
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.activity_purchase, activityId,activityType,productId,productPriceId,customerId);
			IHJedisString jedisString = getJedisString();
			int expireTime = DateUtil.getDateDiffSecond(new Date(), endTime);
			jedisString.set(redisKey, expireTime, String.valueOf(productNumber));
		}
	}
	/**
	 * 删除参与活动
	 * @param activityId
	 * @param activityType
	 * @param customerId
	 * @param productNumber
	 * @param endTime
	 */
	public void delActivityPurchase(Integer activityId,Integer activityType,Integer customerId,Integer productId,Integer productPriceId,Integer productNumber){
		//查询缓存
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.activity_purchase, activityId,activityType,productId,productPriceId,customerId);
			IHJedisString jedisString = getJedisString();
			jedisString.del(redisKey);
		}
	}
	
	/**
	 * 是否已经参与购买活动
	 * @param activityId
	 * @param activityType
	 * @param customerId
	 * @param endTime
	 */
	public boolean existsActivityPurchase(Integer activityId,Integer activityType,Integer customerId,Integer productId,Integer productPriceId){
		//查询缓存
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.activity_purchase, activityId,activityType,productId,productPriceId,customerId);
			IHJedisString jedisString = getJedisString();
			return jedisString.exists(redisKey);
		}
		return false;
	}
	
	/**
	 * 获取区域地址信息
	 * @param Id
	 * @return
	 */
	public Region getRegion(Integer id){
		//查询缓存
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.region_id, id);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return json2Bean(result, Region.class);
			}
		}
		//查询数据库
		Region region = regionService.selectByPrimaryKey(id);
		if(!Utils.isEmpty(region)){
			String redisKey = getRedisKey(RedisConstant.region_id, id);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime, beanToJSON(region));
		}
		return region;
	}

	/**
	 * 获取区域地址信息
	 * @param Id
	 * @return
	 */
	public void delRegion(Integer id){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.region_id, id);
			IHJedisString jedisString = getJedisString();
			jedisString.del(redisKey);
		}
	}
	

	/**
	 * 首页配置缓存
	 * @param shopId
	 * @return
	 */
	public List<HomepageSettingParentVo> getHomepageSettingParentVo(Integer shopId){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.home_page, shopId);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return  JSON.parseArray(result, HomepageSettingParentVo.class);
			}
		}
		List<HomepageSettingParentVo> list = homepageSettingService.getHomepageList(shopId);
		if(!Utils.isEmpty(list)){
			String redisKey = getRedisKey(RedisConstant.home_page, shopId);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime,beanToJSON(list));
		}
		return list;
	}
	

	/**
	 * 首页配置下架，删除缓存
	 * @param shopId
	 * @return
	 */
	public void delHomepageSettingParentVo(Integer shopId){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.home_page, shopId);
			IHJedisString jedisString = getJedisString();
			jedisString.del(redisKey);
		}
	}
	
	/**
	 * 云商城默认商品（第一页商品）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageInfoEntity<ProductInfoVo> getYunShopProductList(S1006RequestEntity entity){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.yun_shop_product_data);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return  json2Bean(result, PageInfoEntity.class);
			}
		}
		PageInfoEntity<ProductInfoVo> res = productInfoService.selectHotProductInfoList(entity);
		if(!Utils.isEmpty(res)){
			String redisKey = getRedisKey(RedisConstant.yun_shop_product_data);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime15m,beanToJSON(res));
		}
		return res;
	}
	

	/**
	 * 云商城默认商品（第一页商品）,删除缓存
	 * @return
	 */
	public void delYunShopProductList(){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.yun_shop_product_data);
			IHJedisString jedisString = getJedisString();
			jedisString.del(redisKey);
		}
	}
	
	/**
	 * 商品详情
	 * @param productId
	 * @return
	 */
	public ProductDetailInfo getProductDetailInfo(Integer productId){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.product_detail_info,productId);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return  json2Bean(result, ProductDetailInfo.class);
			}
		}
		ProductDetailInfo info = productDetailInfoService.selectByProductId(productId);
		if(!Utils.isEmpty(info)){
			String redisKey = getRedisKey(RedisConstant.product_detail_info,productId);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime15m,beanToJSON(info));
		}
		return info;
	}
	
	/**
	 * 商品信息（商品图文详情用）
	 * @param productId
	 * @return
	 */
	public ProductInfo getProductInfo(Integer productId){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.product_info,productId);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return  json2Bean(result, ProductInfo.class);
			}
		}
		ProductInfo info = productInfoService.selectByProductId(productId);
		if(!Utils.isEmpty(info)){
			String redisKey = getRedisKey(RedisConstant.product_info,productId);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime15m,beanToJSON(info));
		}
		return info;
	}

	/**
	 * 首页图标
	 * @param shopId
	 * @return
	 */
	public List<IcoSettingVo> getHomePageTopIoc(Integer shopId){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.home_page_top_ico,shopId);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return  json2List(result, IcoSettingVo.class);
			}
		}
		List<IcoSettingVo> list = icoSettingService.queryHomePageMenu(shopId);
		if(!Utils.isEmpty(list)){
			String redisKey = getRedisKey(RedisConstant.home_page_top_ico,shopId);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime15m,beanToJSON(list));
		}
		return list;
	}
//	/**
//	 * 获取领取优惠券面额
//	 * @param orderId
//	 * @param amount
//	 * @return
//	 */
//	public DiscountAmountVo getDiscountAmountVo(String orderId,Double amount,Integer customerId){
//		if(isUseRedisCacheQuery()){
//			String redisKey = getRedisKey(RedisConstant.quick_orderid,orderId);
//			IHJedisString jedisString = getJedisString();
//			String result = jedisString.get(redisKey);
//			if(!Utils.isEmpty(result)){
//				return  json2Bean(result, DiscountAmountVo.class);
//			}
//		}
//		DiscountAmountVo map = couponService.getDiscountAmountVo(orderId, amount,customerId);
//		if(!Utils.isEmpty(map)){
//			String redisKey = getRedisKey(RedisConstant.quick_orderid,orderId);
//			IHJedisString jedisString = getJedisString();
//			jedisString.set(redisKey,expireTime15m,beanToJSON(map));
//		}
//		return map;
//	}
	/**
	 * 获取领取优惠券面额
	 * @param orderId
	 * @param amount
	 * @return
	 */
	public DiscountAmountVo getDiscountAmountVo(String orderId,Integer customerId){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.quick_orderid,orderId);
			IHJedisString jedisString = getJedisString();
			String result = jedisString.get(redisKey);
			if(!Utils.isEmpty(result)){
				return  json2Bean(result, DiscountAmountVo.class);
			}
		}
		QuickOrder order = quickOrderService.queryByOrderId(orderId);
		if(Utils.isEmpty(order)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
		}
//		if(!PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(order.getPayState()+"")){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),MessageFormat.format(ExOrderEnum.EX_ERROR_STATE.value(), "订单信息已过期"));
//		}
		if(UtilMoney.compareTo(order.getTotalAmount(), order.getReceiveCouponAmount()) <= 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
		DiscountAmountVo map = couponService.getDiscountAmountVo(orderId, UtilMoney.subtractToDouble(order.getTotalAmount(), order.getReceiveCouponAmount()), customerId);
		if(!Utils.isEmpty(map)){
			String redisKey = getRedisKey(RedisConstant.quick_orderid,orderId);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime15m,beanToJSON(map));
		}
		return map;
	}
	
	/**
	 * 修改缓存中数量
	 * @param orderId
	 * @param amount
	 * @return
	 */
	public void setDiscountAmountVo(DiscountAmountVo vo,String orderId){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.quick_orderid,orderId);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime15m,beanToJSON(vo));
		}
	}
	
	/**
	 * 客户端常见的问题
	 * @param id
	 * @return
	 */
	public String getQuestion(Integer id){
		if(isUseRedisCacheQuery()){
			String redisKey = getRedisKey(RedisConstant.question_html,id);
			IHJedisString jedisString = getJedisString();
			String content = jedisString.get(redisKey);
			if(!Utils.isEmpty(content)){
				return content;
			}
		}
		String content = systemManualService.queryContentById(id);
		if(!Utils.isEmpty(content)){
			String redisKey = getRedisKey(RedisConstant.question_html,id);
			IHJedisString jedisString = getJedisString();
			jedisString.set(redisKey,expireTime15m,content);
		}
		return content;
	}

	@Override
	public void set(String key, String value, int expireTime) {
		IHJedisString jedisString = getJedisString();
		jedisString.set(key,expireTime,value);
	}
	
}
