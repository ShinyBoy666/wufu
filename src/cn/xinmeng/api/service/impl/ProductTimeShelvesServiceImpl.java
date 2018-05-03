package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductTimeShelvesDao;
import cn.xinmeng.api.entity.auto.ProductTimeShelves;
import cn.xinmeng.api.entity.auto.example.ProductTimeShelvesExample;
import cn.xinmeng.api.service.IProductTimeShelvesService;

/**
 * 业务层：ProductTimeShelvesServiceImpl
 * @author jiangyong.tan
 * 描述：商品定时上架表
 * @date 2016-01-24 14:39:07
 */
@Service("productTimeShelvesService")
public class ProductTimeShelvesServiceImpl implements IProductTimeShelvesService {

    @Resource
	private ProductTimeShelvesDao productTimeShelvesDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductTimeShelves record){
    	return productTimeShelvesDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productTimeShelvesDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductTimeShelves record){
		return productTimeShelvesDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductTimeShelves selectByPrimaryKey(Integer id){
    	return productTimeShelvesDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductTimeShelvesExample example){
		return productTimeShelvesDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductTimeShelves> selectByExample(ProductTimeShelvesExample example){
    	return productTimeShelvesDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductTimeShelves> selectByExample(int currentPage, int limit,ProductTimeShelvesExample example){
        return productTimeShelvesDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}