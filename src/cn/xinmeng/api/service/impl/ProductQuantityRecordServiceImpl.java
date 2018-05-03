package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductQuantityRecordDao;
import cn.xinmeng.api.entity.auto.ProductQuantityRecord;
import cn.xinmeng.api.entity.auto.example.ProductQuantityRecordExample;
import cn.xinmeng.api.service.IProductQuantityRecordService;

/**
 * 业务层：ProductQuantityRecordServiceImpl
 * @author jiangyong.tan
 * 描述：商品价格表流水
 * @date 2016-01-24 14:39:07
 */
@Service("productQuantityRecordService")
public class ProductQuantityRecordServiceImpl implements IProductQuantityRecordService {

    @Resource
	private ProductQuantityRecordDao productQuantityRecordDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductQuantityRecord record){
    	return productQuantityRecordDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productQuantityRecordDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductQuantityRecord record){
		return productQuantityRecordDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductQuantityRecord selectByPrimaryKey(Integer id){
    	return productQuantityRecordDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductQuantityRecordExample example){
		return productQuantityRecordDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductQuantityRecord> selectByExample(ProductQuantityRecordExample example){
    	return productQuantityRecordDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductQuantityRecord> selectByExample(int currentPage, int limit,ProductQuantityRecordExample example){
        return productQuantityRecordDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}