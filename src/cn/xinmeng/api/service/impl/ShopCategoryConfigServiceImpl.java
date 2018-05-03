package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ShopCategoryConfigDao;
import cn.xinmeng.api.entity.auto.ShopCategoryConfig;
import cn.xinmeng.api.entity.auto.example.ShopCategoryConfigExample;
import cn.xinmeng.api.service.IShopCategoryConfigService;

/**
 * 业务层：ShopCategoryConfigServiceImpl
 * 描述：店铺和类别关系表
 * @author jiangyong.tan
 * @date 2016-03-23 14:06:48
 */
@Service("shopCategoryConfigService")
public class ShopCategoryConfigServiceImpl implements IShopCategoryConfigService {

    @Resource
	private ShopCategoryConfigDao shopCategoryConfigDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopCategoryConfig record){
    	return shopCategoryConfigDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopCategoryConfigDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopCategoryConfig record){
		return shopCategoryConfigDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopCategoryConfig selectByPrimaryKey(Integer id){
    	return shopCategoryConfigDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopCategoryConfigExample example){
		return shopCategoryConfigDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopCategoryConfig> selectByExample(ShopCategoryConfigExample example){
    	return shopCategoryConfigDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopCategoryConfig> selectByExample(int currentPage, int limit,ShopCategoryConfigExample example){
        return shopCategoryConfigDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}