package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IProductClickLogService;
import cn.xinmeng.api.dao.auto.ProductClickLogDao;
import cn.xinmeng.api.entity.auto.ProductClickLog;
import cn.xinmeng.api.entity.auto.example.ProductClickLogExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：ProductClickLogServiceImpl
 * 描述：商品点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:23
 */
@Service("productClickLogService")
public class ProductClickLogServiceImpl implements IProductClickLogService {

    @Resource
	private ProductClickLogDao productClickLogDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductClickLog record){
    	return productClickLogDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productClickLogDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductClickLog record){
		return productClickLogDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductClickLog selectByPrimaryKey(Integer id){
    	return productClickLogDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductClickLogExample example){
		return productClickLogDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductClickLog> selectByExample(ProductClickLogExample example){
    	return productClickLogDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ProductClickLog> selectByExample(int currentPage, int limit,ProductClickLogExample example){
        return productClickLogDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}