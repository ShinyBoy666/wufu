package cn.xinmeng.api.service;

import java.util.Date;
import java.util.List;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;
import cn.xinmeng.web.shop.entity.vo.DiscountAmountVo;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingParentVo;
import cn.xinmeng.web.shop.entity.vo.IcoSettingVo;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

public interface IRedisService {
	
	/**
	 * 查询活动商品信息
	 * @param productId
	 * @param activityId
	 * @param activityType
	 * @param productPriceId
	 * @return
	 */
	public ActvityProductInfoBiz getActvityProductInfoBiz(Integer activityId,Integer activityType,Integer productId,Integer productPriceId);
	
	/**
	 * 缓存同步mysql
	 * @param productId
	 * @param activityId
	 * @param activityType
	 */
	public void redisToMysqlActvityProductInfo(Integer activityId,Integer activityType,Integer productId,Integer productPriceId);
	
	/**
	 * 删除缓存
	 * @param activityId
	 * @param activityType
	 * @param productId
	 */
	public void delRedisActvityProductInfoBiz(Integer activityId,Integer activityType,Integer productId,Integer productPriceId);
	
	/**
	 * 更新商品已售数量
	 * @param activityId
	 * @param activityType
	 * @param productId
	 * @param productNumber
	 * @return
	 */
	public boolean updateActvityProductSoldNumber(Integer activityId,Integer activityType,Integer productId,Integer productPriceId,Integer productNumber);
	
	/**
	 * 更新购买地址缓存
	 * @param address
	 */
	public void updateCommonAddress(CommonAddress address);
	
	/**
	 * 删除地址缓存
	 * @param address
	 */
	public void delCommonAddress(int addressId);
	
	/**
	 * 获取购买地址
	 * @param addressId
	 * @return
	 */
	public CommonAddress getCommonAddress(Integer addressId);
	
	/**
	 * 参与活动
	 * @param activityId
	 * @param activityType
	 * @param customerId
	 * @param productNumber
	 * @param endTime
	 */
	public void activityPurchase(Integer activityId,Integer activityType,Integer customerId,Integer productId,Integer productPriceId,Integer productNumber,Date endTime);
	
	/**
	 * 删除参与活动
	 * @param activityId
	 * @param activityType
	 * @param customerId
	 * @param productNumber
	 * @param endTime
	 */
	public void delActivityPurchase(Integer activityId,Integer activityType,Integer customerId,Integer productId,Integer productPriceId,Integer productNumber);
	
	/**
	 * 是否已经参与购买活动
	 * @param activityId
	 * @param activityType
	 * @param customerId
	 * @param endTime
	 */
	public boolean existsActivityPurchase(Integer activityId,Integer activityType,Integer customerId,Integer productId,Integer productPriceId);
	
	/**
	 * 获取区域地址信息
	 * @param Id
	 * @return
	 */
	public Region getRegion(Integer id);

	/**
	 * 获取区域地址信息
	 * @param Id
	 * @return
	 */
	public void delRegion(Integer id);
	
	/**
	 * 首页配置缓存
	 * @param shopId
	 * @return
	 */
	public List<HomepageSettingParentVo> getHomepageSettingParentVo(Integer shopId);
	

	/**
	 * 首页配置下架，删除缓存
	 * @param shopId
	 * @return
	 */
	public void delHomepageSettingParentVo(Integer shopId);
	

	/**
	 * 云商城默认商品（第一页商品）
	 * @return
	 */
	public PageInfoEntity<ProductInfoVo> getYunShopProductList(S1006RequestEntity entity);
	

	/**
	 * 云商城默认商品（第一页商品）,删除缓存
	 * @return
	 */
	public void delYunShopProductList();
	
	/**
	 * 商品详情
	 * @param productId
	 * @return
	 */
	public ProductDetailInfo getProductDetailInfo(Integer productId);
	
	/**
	 * 商品信息（商品图文详情用）
	 * @param productId
	 * @return
	 */
	public ProductInfo getProductInfo(Integer productId);
	
	/**
	 * 首页图标
	 * @param shopId
	 * @return
	 */
	public List<IcoSettingVo> getHomePageTopIoc(Integer shopId);
	
//	/**
//	 * 获取领取优惠券面额
//	 * @param orderId
//	 * @param amount
//	 * @return
//	 */
//	public DiscountAmountVo getDiscountAmountVo(String orderId,Double amount,Integer customerId);

	/**
	 * 获取领取优惠券面额
	 * @param orderId
	 * @param customerId
	 * @return
	 */
	public DiscountAmountVo getDiscountAmountVo(String orderId,Integer customerId);

	/**
	 * 修改缓存中数量
	 * @param orderId
	 * @param amount
	 * @return
	 */
	public void setDiscountAmountVo(DiscountAmountVo vo,String orderId);
	
	/**
	 * 客户端常见的问题
	 * @param id
	 * @return
	 */
	public String getQuestion(Integer id);
	
	/**
	 * 保存
	 * @param key
	 * @param value
	 * @param expireTime
	 */
	public void set(String key,String value,int expireTime);
}
