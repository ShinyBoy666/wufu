package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductDetailInfoDao;
import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.example.ProductDetailInfoExample;
import cn.xinmeng.api.service.IProductDetailInfoService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：ProductDetailInfoServiceImpl
 * @author jiangyong.tan
 * 描述：商品详细信息表
 * @date 2016-01-24 14:39:05
 */
@Service("productDetailInfoService")
public class ProductDetailInfoServiceImpl implements IProductDetailInfoService {

    @Resource
	private ProductDetailInfoDao productDetailInfoDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductDetailInfo record){
    	return productDetailInfoDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productDetailInfoDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductDetailInfo record){
		return productDetailInfoDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductDetailInfo selectByPrimaryKey(Integer id){
    	return productDetailInfoDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductDetailInfoExample example){
		return productDetailInfoDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductDetailInfo> selectByExample(ProductDetailInfoExample example){
    	return productDetailInfoDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductDetailInfo> selectByExample(int currentPage, int limit,ProductDetailInfoExample example){
        return productDetailInfoDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public ProductDetailInfo selectByProductId(Integer productId) {
		ProductDetailInfoExample example = new ProductDetailInfoExample();
		ProductDetailInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		List<ProductDetailInfo> list = productDetailInfoDao.selectByExample(new RowBounds(1, 1),example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
    
}