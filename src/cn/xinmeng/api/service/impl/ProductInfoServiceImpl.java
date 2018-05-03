package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductInfoDao;
import cn.xinmeng.api.dao.ex.ExProductInfoDao;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.example.ProductInfoExample;
import cn.xinmeng.api.service.ICollectionService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

/**
 * 业务层：ProductInfoServiceImpl
 * @author jiangyong.tan
 * 描述：商品基础信息表
 * @date 2016-01-24 14:39:05
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements IProductInfoService {

    @Resource
	private ProductInfoDao productInfoDao;
    
    @Resource
    private ExProductInfoDao exProductInfoDao;
    
    @Resource
    private ICollectionService collectionService;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductInfo record){
    	return productInfoDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productInfoDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductInfo record){
		return productInfoDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductInfo selectByPrimaryKey(Integer id){
    	return productInfoDao.selectByPrimaryKey(id);
    }
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductInfo selectByProductId(Integer productId){
    	ProductInfoExample example = new ProductInfoExample();
    	ProductInfoExample.Criteria criteria = example.createCriteria();
    	criteria.andProductIdEqualTo(productId);
    	List<ProductInfo> list = productInfoDao.selectByExample(example);
    	if(list != null && list.size() > 0){
    		return list.get(0);
    	}
    	return null;
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductInfoExample example){
		return productInfoDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductInfo> selectByExample(ProductInfoExample example){
    	return productInfoDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductInfo> selectByExample(int currentPage, int limit,ProductInfoExample example){
        return productInfoDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    /**
	 * 查询商品信息
	 * @author jiangyong.tan
	 * @date 2015年11月17日 下午3:27:17
	 * @param productId
	 * @return
	 */
	public ProductInfo queryProductInfoByProductId(Integer productId){
		if(Utils.isEmpty(productId)){
			return null;
		}
		ProductInfoExample example = new ProductInfoExample();
		ProductInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		List<ProductInfo> list = productInfoDao.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
    /**
	 * 查询商品信息
	 * @author jiangyong.tan
	 * @date 2015年11月17日 下午3:27:17
	 * @param productId
	 * @return
	 */
	public ProductInfo queryProductInfoByProductId(Integer productId,String fieldList){
		if(Utils.isEmpty(productId)){
			return null;
		}
		ProductInfoExample example = new ProductInfoExample();
		example.setFieldList(fieldList);
		ProductInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		List<ProductInfo> list = productInfoDao.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<ProductInfoVo> selectProductInfoVoByModulId(Integer modulId) {
		return exProductInfoDao.selectProductInfoVoByModulId(modulId);
	}

	@Override
	public PageInfoEntity<ProductInfoVo> selectProductInfoList(S1006RequestEntity entity) {
		PageInfoEntity<ProductInfoVo> pageInfoEntity = new PageInfoEntity<ProductInfoVo>(entity.getCurrentPage(), entity.getLimit());
		int count = exProductInfoDao.selectProductInfoListCount(entity);
		if(count > 0){
			List<ProductInfoVo> list = exProductInfoDao.selectProductInfoList(new RowBounds(entity.getCurrentPage(), entity.getLimit()), entity);
//			List<String> productIds = collectionService.selectObjectIdsByCustomerId(entity.getCustomerId(), 1);//查询客户收藏商品集合
			if(!Utils.isEmpty(list)){
				for (ProductInfoVo productInfoVo : list) {
					productInfoVo.setImageUrl(Utils.getImageUrl(productInfoVo.getImageUrl(),"?400_400"));
//					if(productIds.contains(productInfoVo.getProductId().toString())){
//						productInfoVo.setIsCollection(true);
//					}
				}
			}
			pageInfoEntity.setList(list);
		}else {
			pageInfoEntity.setList(new ArrayList<ProductInfoVo>());
		}
		pageInfoEntity.setTotalRecord(count);
		return pageInfoEntity;
	}
	

	/**
	 * 云商城
	 * @param entity
	 * @return
	 */
	public PageInfoEntity<ProductInfoVo> selectHotProductInfoList(S1006RequestEntity entity){
		PageInfoEntity<ProductInfoVo> pageInfoEntity = new PageInfoEntity<ProductInfoVo>(entity.getCurrentPage(), entity.getLimit());
		int count = exProductInfoDao.selectHotProductInfoListCount(entity);
		if(count > 0){
			List<ProductInfoVo> list = exProductInfoDao.selectHotProductInfoList(new RowBounds(entity.getCurrentPage(), entity.getLimit()), entity);
			if(!Utils.isEmpty(list)){
				for (ProductInfoVo productInfoVo : list) {
					productInfoVo.setImageUrl(Utils.getImageUrl(productInfoVo.getImageUrl(),"?400_400"));
				}
			}
			pageInfoEntity.setList(list);
		}else {
			pageInfoEntity.setList(new ArrayList<ProductInfoVo>());
		}
		pageInfoEntity.setTotalRecord(count);
		return pageInfoEntity;
	}
	
	/**
	 *  查询商品店铺ID
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午10:47:35
	 * @param productIds
	 * @return
	 */
	public Map<Integer,Integer> queryShopIdByProductId(List<Integer> productIds){
		ProductInfoExample example = new ProductInfoExample();
		example.setFieldList("shop_id,product_id");
		ProductInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdIn(productIds);
		List<ProductInfo> list = productInfoDao.selectByExample(example);
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		if(list != null && list.size() > 0){
			for (ProductInfo productInfo : list) {
				map.put(productInfo.getProductId(), productInfo.getShopId());
			}
		}
		return map;
	}

	/**
	 * 查询商品是否需要发货
	 * @param productIds
	 * @return
	 */
	public boolean queryProductInfoIsDelivery(List<Integer> productIds){
		ProductInfoExample example = new ProductInfoExample();
		ProductInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdIn(productIds);
		criteria.andIsDeliveryEqualTo(2);//需要发货
		if(productInfoDao.countByExample(example) > 0){
			return true;
		}
		return false;
	}

	/**
	 * 查询商品是否需要填写身份证
	 * @param productIds
	 * @return
	 */
	public boolean queryProductInfoRealyname(List<Integer> productIds){
		ProductInfoExample example = new ProductInfoExample();
		ProductInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdIn(productIds);
		criteria.andIsRealynameEqualTo(2);//需要需要身份证
		if(productInfoDao.countByExample(example) > 0){
			return true;
		}
		return false;
	}

	/**
	 * 查询商品是否需要发货
	 * @param productIds
	 * @return
	 */
	public Integer queryProductInfoIsDelivery(Integer productId){
		ProductInfoExample example = new ProductInfoExample();
		ProductInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		criteria.andIsDeliveryEqualTo(2);//需要发货
		if(productInfoDao.countByExample(example) > 0){
			return 2;
		}
		return 1;
	}
}