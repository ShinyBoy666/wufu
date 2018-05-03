package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductPriceDao;
import cn.xinmeng.api.dao.ex.ExProductInfoDao;
import cn.xinmeng.api.dao.ex.ExProductPriceDao;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.biz.ProductBasicInfo;
import cn.xinmeng.api.entity.auto.example.ProductPriceExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：ProductPriceServiceImpl
 * @author jiangyong.tan
 * 描述：商品价格表
 * @date 2016-01-24 14:39:05
 */
@Service("productPriceService")
public class ProductPriceServiceImpl implements IProductPriceService {

    @Resource
	private ProductPriceDao productPriceDao;
	@Resource
	private ExProductInfoDao exProductInfoDao;
	@Resource
	private ExProductPriceDao exProductPriceDao;
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductPrice record){
    	return productPriceDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productPriceDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductPrice record){
		return productPriceDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductPrice selectByPrimaryKey(Integer id){
    	return productPriceDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductPriceExample example){
		return productPriceDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductPrice> selectByExample(ProductPriceExample example){
    	return productPriceDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductPrice> selectByExample(int currentPage, int limit,ProductPriceExample example){
        return productPriceDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
	/**
	 * 根据商品ID与sku查询商品价格信息
	 * @param productId
	 * @param skuValuesText
	 * @return
	 */
	public ProductPrice queryProductPrice(Integer productId,String skuValuesText){
		ProductPriceExample productPriceExample = new ProductPriceExample();
		ProductPriceExample.Criteria productPriceCriteria = productPriceExample.createCriteria();
		productPriceCriteria.andProductIdEqualTo(productId);
		productPriceCriteria.andSkuEqualTo(skuValuesText);
		productPriceCriteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		productPriceExample.setOrderByClause(" id desc ");
		List<ProductPrice> listProductPrice = productPriceDao.selectByExample(productPriceExample);
		if(listProductPrice != null && listProductPrice.size() > 0){
			return listProductPrice.get(0);
		}
		return null;
	}	
	
	/**
	 * 根据商品ID与sku查询商品价格信息
	 * @param productId
	 * @param skuValuesText
	 * @param fieldList
	 * @return
	 */
	public ProductPrice queryProductPrice(Integer productId,String skuValuesText,String fieldList,Integer state){
		ProductPriceExample productPriceExample = new ProductPriceExample();
		productPriceExample.setFieldList(fieldList);
		ProductPriceExample.Criteria productPriceCriteria = productPriceExample.createCriteria();
		productPriceCriteria.andProductIdEqualTo(productId);
		productPriceCriteria.andSkuEqualTo(skuValuesText);
		if(!Utils.isEmpty(state)){
			productPriceCriteria.andStateEqualTo(state);
			productPriceExample.setOrderByClause(" id desc ");
		}else{
			productPriceExample.setOrderByClause(" id desc,state desc ");
		}
		List<ProductPrice> listProductPrice = productPriceDao.selectByExample(productPriceExample);
		if(listProductPrice != null && listProductPrice.size() > 0){
			return listProductPrice.get(0);
		}
		return null;
	}
	
	/**
	 *  查询商品零售价格
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午10:33:19
	 * @param productId
	 * @param skuValuesText
	 * @return
	 */
	public Double queryRetailPriceByProductId(Integer productId,String skuValuesText){
		ProductPriceExample example = new ProductPriceExample();
		example.setFieldList("retail_price");
		example.setOrderByClause(" id desc,state desc ");
		ProductPriceExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		criteria.andSkuEqualTo(skuValuesText);
//		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		List<ProductPrice> list = productPriceDao.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0).getRetailPrice();
		}
		return new Double(0);
	}
	
	/**
	 *  加减库存
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午1:47:51
	 * @param productBasicInfos
	 * @return
	 */
	public void addAndSubStock(List<ProductBasicInfo>  productBasicInfos){
		if(productBasicInfos != null && productBasicInfos.size() > 0){
			for (ProductBasicInfo basicInfo : productBasicInfos) {
				//查询商品价格id，与原库存信息

				Integer priceId = basicInfo.getPriceId();
				if(Utils.isEmpty(priceId)){
					ProductPriceExample example = new ProductPriceExample();
					example.setFieldList("id,quantity");
					ProductPriceExample.Criteria criteria = example.createCriteria();
					criteria.andProductIdEqualTo(basicInfo.getProductId());
					criteria.andSkuEqualTo(basicInfo.getSku());
					criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
					List<ProductPrice> list = productPriceDao.selectByExample(example);
					if(list == null || list.size() == 0){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCTPRICE_NOT_EXITS);
					}
					priceId = list.get(0).getId();
					Integer quantity = list.get(0).getQuantity();//原库存
					basicInfo.setOldActualQuantity(quantity);
					basicInfo.setPriceId(priceId);
				}else{
					ProductPrice productPrice = productPriceDao.selectByPrimaryKey(priceId);
					if(Utils.isEmpty(productPrice)){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCTPRICE_NOT_EXITS);
					}
					basicInfo.setOldActualQuantity(productPrice.getQuantity());
					basicInfo.setPriceId(priceId);
				}
				
				if(basicInfo.getOperateType() == 1){//等于1表示加库存
					//修改实际库存数量
					int rows = exProductPriceDao.updateAddActualQuantity(basicInfo.getActualProductNumber(), priceId);
					if(rows == 0){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_ADD_STOCK);
					}
					
					if(basicInfo.getFlag() == 1){
						rows = exProductInfoDao.updateBuyNum(-basicInfo.getActualProductNumber(), basicInfo.getProductId(),null);
						if(rows == 0){
							throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_ADD_STOCK);
						}
					}
					
				}else{//表示减库存
					
					//修改实际库存数量
					int rows = exProductPriceDao.updateSubtractActualQuantity(basicInfo.getActualProductNumber(), priceId);
					if(rows == 0){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_SUB_STOCK);
					}
					
					if(basicInfo.getFlag() == 1){
						rows = exProductInfoDao.updateBuyNum(basicInfo.getActualProductNumber(), basicInfo.getProductId(),null);
						if(rows == 0){
							throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_SUB_STOCK);
						}
					}
				}
			}
		}
	}

	@Override
	public List<ProductPrice> selectByProductId(Integer productId) {
		ProductPriceExample example = new ProductPriceExample();
		ProductPriceExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		return productPriceDao.selectByExample(example);
	}
}