package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ActivityProductDao;
import cn.xinmeng.api.entity.auto.ActivityProduct;
import cn.xinmeng.api.entity.auto.FlashPurchaseActivity;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.entity.auto.example.ActivityProductExample;
import cn.xinmeng.api.enums.ActivityTypeEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IActivityProductService;
import cn.xinmeng.api.service.IFlashPurchaseActivityService;
import cn.xinmeng.api.service.IProductDetailInfoService;
import cn.xinmeng.api.service.IProductImageService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：ActivityProductServiceImpl
 * 描述：活动商品表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:04
 */
@Service("activityProductService")
public class ActivityProductServiceImpl implements IActivityProductService {

    @Resource
	private ActivityProductDao activityProductDao;
    @Resource
    private IFlashPurchaseActivityService flashPurchaseActivityService;
    @Resource
    private IProductPriceService productPriceService;
    @Resource
    private IProductImageService productImageService;
    @Resource
    private IProductDetailInfoService productDetailInfoService;
    @Resource
    private IProductInfoService productInfoService;
    @Resource
    private IShopInfoService shopInfoService;
    @Resource
    private IRedisService redisService;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ActivityProduct record){
    	return activityProductDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return activityProductDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ActivityProduct record){
		return activityProductDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ActivityProduct selectByPrimaryKey(Integer id){
    	return activityProductDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ActivityProductExample example){
		return activityProductDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ActivityProduct> selectByExample(ActivityProductExample example){
    	return activityProductDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ActivityProduct> selectByExample(int currentPage, int limit,ActivityProductExample example){
        return activityProductDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    

    /**
     * 查询活动详情信息
     * @param activityId
     * @param activityType
     * @param productId
     * @return
     */
    public ActvityProductInfoBiz getActvityProductInfoBiz(Integer activityId,Integer activityType,Integer productId,Integer productPriceId){
    	if(Utils.isEmpty(activityId) || Utils.isEmpty(activityType) || Utils.isEmpty(productId)){
    		return null;
    	}
    	ActvityProductInfoBiz biz = new ActvityProductInfoBiz();
    	ActivityTypeEnum type = ActivityTypeEnum.keyToEnum(String.valueOf(activityType));
    	if(Utils.isEmpty(type)){
    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_TYPE);
    	}
    	switch (type) {
			case SECKILL:
				FlashPurchaseActivity flashPurchaseActivity = flashPurchaseActivityService.selectByPrimaryKey(activityId);
				if(Utils.isEmpty(flashPurchaseActivity)){
		    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY);
				}
				biz.setActivityId(activityId);
				biz.setActivityType(activityType);
				biz.setShopId(flashPurchaseActivity.getShopId());
				biz.setBeginTime(flashPurchaseActivity.getBeginTime());
				biz.setEndTime(flashPurchaseActivity.getEndTime());
				biz.setShowTime(flashPurchaseActivity.getShowTime());
				biz.setTitle(flashPurchaseActivity.getTitle());
				biz.setActivityImage(flashPurchaseActivity.getImageUrl());
				break;
			default:
	    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NOT_ACTIVITY);
		}
    	
    	/**
    	 * 活动商品信息
    	 */
    	ActivityProductExample example = new ActivityProductExample();
    	ActivityProductExample.Criteria criteria = example.createCriteria();
    	criteria.andActivityIdEqualTo(activityId);
    	criteria.andActivityTypeEqualTo(activityType);
    	criteria.andProductIdEqualTo(productId);
    	criteria.andProductPriceIdEqualTo(productPriceId);
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	List<ActivityProduct> list = activityProductDao.selectByExample(new RowBounds(1, 1),example);
    	if(Utils.isEmpty(list)){
    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_ACTIVITY_PRODUCT);
    	}
    	
    	ActivityProduct activityProduct = list.get(0);
    	biz.setRetailPrice(activityProduct.getProductActivityPrice());
    	biz.setMarketPrice(activityProduct.getProductPrice());
    	biz.setProductNumber(activityProduct.getProductNumber());
    	biz.setSoldNumber(activityProduct.getSoldNumber());
    	biz.setMaxBuy(activityProduct.getMaxBuy());
    	biz.setId(activityProduct.getId());
    	
    	/**
    	 * 活动sku信息
    	 */
    	ProductPrice productPrice = productPriceService.selectByPrimaryKey(activityProduct.getProductPriceId());
    	if(Utils.isEmpty(productPrice)){
    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCTPRICE_NOT_EXITS);
    	}
    	biz.setSku(productPrice.getSku());
    	biz.setProductPriceId(productPrice.getId());
    	
    	/**
    	 * 活动商品图片信息
    	 */
    	List<String> imageUrl = productImageService.queryProductImage(productPrice.getId());
    	if(!Utils.isEmpty(imageUrl)){
    		biz.setImageUrlList(imageUrl);
    	}
    	
    	/**
    	 * 商品基础信息
    	 */
    	ProductInfo productInfo = productInfoService.queryProductInfoByProductId(productId);
    	if(Utils.isEmpty(productInfo)){
    		throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_EXISTS_PRODUCTID);
    	}
    	biz.setProductState(productInfo.getState());
    	biz.setProductId(productId);
    	biz.setProductName(productInfo.getProductName());
    	biz.setProductIntroduction(productInfo.getProductIntroduction());
    	biz.setIsDelivery(productInfo.getIsDelivery());
    	
    	//店铺名称
    	biz.setShopName(shopInfoService.queryShopNameByShopId(productInfo.getShopId()));
		biz.setShareUrl(HelperPropertie.getValue("local.url")+"pages/"+productInfo.getShopId()+"/productdetail.html?pid="+productInfo.getProductId());
		biz.setProductDetailUrl(HelperPropertie.getValue("local.url")+"/App/ProductDetail?id="+productInfo.getProductId());
    	return biz;
    }
    

    /**
     * 修改活动商品信息
     * @param biz
     * @return
     */
    public int updateActivityProduct(ActvityProductInfoBiz biz){
    	if(Utils.isEmpty(biz)){
    		return 0;
    	}
    	if(Utils.isEmpty(biz.getActivityId()) 
    			|| Utils.isEmpty(biz.getActivityType()) 
    			|| Utils.isEmpty(biz.getProductId())
    			|| Utils.isEmpty(biz.getProductPriceId())){
    		return 0;
    	}
    	ActivityProduct ap = new ActivityProduct();
    	ap.setSoldNumber(biz.getSoldNumber());
    	
    	ActivityProductExample example = new ActivityProductExample();
    	ActivityProductExample.Criteria criteria = example.createCriteria();
    	criteria.andActivityIdEqualTo(biz.getActivityId());
    	criteria.andActivityTypeEqualTo(biz.getActivityType());
    	criteria.andProductIdEqualTo(biz.getProductId());
    	criteria.andProductPriceIdEqualTo(biz.getProductPriceId());
    	return activityProductDao.updateByExampleSelective(ap, example);
    }

    /**
     * redis同步到mysql
     */
    public void redisSyncMysqlActivityProduct(){
    	List<FlashPurchaseActivity> list = flashPurchaseActivityService.selectAllShowFlashPurchaseActivity(null);
		LogManager.info(this.getClass(),"redis同步job   list:"+list);
    	if(!Utils.isEmpty(list)){
    		for (FlashPurchaseActivity flashPurchaseActivity : list) {
    			Integer activityType = Integer.valueOf(ActivityTypeEnum.SECKILL.key());
    			Integer activityId = Integer.valueOf(flashPurchaseActivity.getId());
    	    	ActivityProductExample example = new ActivityProductExample();
    	    	example.setFieldList("product_id,Product_Price_Id");
    	    	ActivityProductExample.Criteria criteria = example.createCriteria();
    	    	criteria.andActivityIdEqualTo(activityId);
    	    	criteria.andActivityTypeEqualTo(activityType);
    	    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	    	List<ActivityProduct> listActivityProduct = activityProductDao.selectByExample(example);
    	    	if(Utils.isEmpty(listActivityProduct)){
    	    		continue;
    	    	}
    	    	for (ActivityProduct activityProduct : listActivityProduct) {
    	    		redisService.redisToMysqlActvityProductInfo(activityId, activityType, activityProduct.getProductId(),activityProduct.getProductPriceId());
				}
			}
    	}
    }
    
    /**
     * 按条件查询
     * @param activityId
     * @param activityType
     * @return
     */
    public List<ActivityProduct> selectByExample(Integer activityId,Integer activityType){
    	ActivityProductExample example = new ActivityProductExample();
    	ActivityProductExample.Criteria criteria = example.createCriteria();
    	criteria.andActivityIdEqualTo(activityId);
    	criteria.andActivityTypeEqualTo(activityType);
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	return activityProductDao.selectByExample(example);
    }
}