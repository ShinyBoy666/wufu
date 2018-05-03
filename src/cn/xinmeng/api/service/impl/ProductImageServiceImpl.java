package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductImageDao;
import cn.xinmeng.api.entity.auto.ProductImage;
import cn.xinmeng.api.entity.auto.example.ProductImageExample;
import cn.xinmeng.api.service.IProductImageService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：ProductImageServiceImpl
 * @author jiangyong.tan
 * 描述：商品图片表
 * @date 2016-01-24 14:39:05
 */
@Service("productImageService")
public class ProductImageServiceImpl implements IProductImageService {

    @Resource
	private ProductImageDao productImageDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductImage record){
    	return productImageDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productImageDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductImage record){
		return productImageDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductImage selectByPrimaryKey(Integer id){
    	return productImageDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductImageExample example){
		return productImageDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductImage> selectByExample(ProductImageExample example){
    	return productImageDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductImage> selectByExample(int currentPage, int limit,ProductImageExample example){
        return productImageDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    /**
     * 查询商品价格图片
     * @param productId
     * @param sku
     * @return
     */
    public List<String> queryProductImage(Integer priceId){
    	List<String> resList = new ArrayList<String>();
    	if(Utils.isEmpty(priceId)){
    		return resList;
    	}
    	ProductImageExample example = new ProductImageExample();
    	example.setFieldList("Image_Url");
    	ProductImageExample.Criteria criteria = example.createCriteria();
    	criteria.andProductPriceIdEqualTo(priceId);
    	List<ProductImage> list = selectByExample(1,1,example);
    	if(!Utils.isEmpty(list)){
    		for (ProductImage productImage : list) {
    			resList.add(productImage.getImageUrl());
			}
    	}
    	return resList;
    }

    /**
     * 查询商品图片
     * @param listPriceId
     * @return
     */
    public List<String> queryProductImage(List<Integer> listPriceId){
    	List<String> imageUrl = new ArrayList<String>();
    	if(Utils.isEmpty(listPriceId)){
    		return imageUrl;
    	}
    	for (Integer priceId : listPriceId) {
    		List<String> image = queryProductImage(priceId);
    		if(Utils.isEmpty(image)){
    			continue;
    		}
    		imageUrl.addAll(image);
		}
    	return imageUrl;
    }
}