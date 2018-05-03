package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ShopCategoryDao;
import cn.xinmeng.api.entity.auto.ShopCategory;
import cn.xinmeng.api.entity.auto.example.ShopCategoryExample;
import cn.xinmeng.api.service.IShopCategoryService;

/**
 * 业务层：ShopCategoryServiceImpl
 * 描述：店铺类别表
 * @author jiangyong.tan
 * @date 2016-03-23 14:06:43
 */
@Service("shopCategoryService")
public class ShopCategoryServiceImpl implements IShopCategoryService {

    @Resource
	private ShopCategoryDao shopCategoryDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopCategory record){
    	return shopCategoryDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopCategoryDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopCategory record){
		return shopCategoryDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopCategory selectByPrimaryKey(Integer id){
    	return shopCategoryDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopCategoryExample example){
		return shopCategoryDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopCategory> selectByExample(ShopCategoryExample example){
    	return shopCategoryDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopCategory> selectByExample(int currentPage, int limit,ShopCategoryExample example){
        return shopCategoryDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}