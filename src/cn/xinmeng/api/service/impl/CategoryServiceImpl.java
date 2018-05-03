package cn.xinmeng.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CategoryDao;
import cn.xinmeng.api.entity.auto.Category;
import cn.xinmeng.api.entity.auto.example.CategoryExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICategoryService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CategoryServiceImpl
 * 描述：商品类别表
 * @author jiangyong.tan
 * @date 2016-02-23 14:08:41
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Resource
	private CategoryDao categoryDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Category record){
    	return categoryDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return categoryDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Category record){
		return categoryDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Category selectByPrimaryKey(Integer id){
    	return categoryDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CategoryExample example){
		return categoryDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Category> selectByExample(CategoryExample example){
    	return categoryDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<Category> selectByExample(int currentPage, int limit,CategoryExample example){
        return categoryDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     *  分类ID集合查询分类
     * @author jiangyong.tan
     * @date 2016年2月23日 下午2:21:06
     * @param categoryIds
     * @return
     */
    public List<Category> searchCategoryByIds(List<Integer> categoryIds){
    	CategoryExample example = new CategoryExample();
    	CategoryExample.Criteria criteria = example.createCriteria();
    	criteria.andIdIn(categoryIds);
    	return categoryDao.selectByExample(example);
    }

    /**
     *  分类ID集合查询分类
     * @author jiangyong.tan
     * @date 2016年2月23日 下午2:21:06
     * @param categoryIds
     * @return
     */
    public Map<Integer,String> searchCategoryNameByIds(List<Integer> categoryIds){
    	Map<Integer,String> map = new HashMap<Integer, String>();
    	if(categoryIds == null || categoryIds.size() == 0){
    		return map;
    	}
    	CategoryExample example = new CategoryExample();
    	CategoryExample.Criteria criteria = example.createCriteria();
    	criteria.andIdIn(categoryIds);
    	List<Category> list = categoryDao.selectByExample(example);
    	if(list != null && list.size() > 0){
    		for (Category category : list) {
				map.put(category.getId(), category.getCategoryName());
			}
    	}
    	return map;
    }
    
    /**
     *  查询某一个级别所有数据
     * @author jiangyong.tan
     * @date 2016年2月25日 上午9:49:55
     * @param level
     * @param second
     * @param first
     * @return
     */
    public List<Category> searchCategory(Integer level,Integer second,Integer first,Integer shopId){
    	CategoryExample example = new CategoryExample();
    	CategoryExample.Criteria criteria = example.createCriteria();
    	if(!Utils.isEmpty(level)){
    		criteria.andLevelEqualTo(level);
    	}
    	if(!Utils.isEmpty(second)){
    		criteria.andSecondIdEqualTo(second);
    	}
    	if(!Utils.isEmpty(first)){
    		criteria.andFirstIdEqualTo(first);
    	}
    	if(!Utils.isEmpty(shopId)){
    		criteria.andShopIdEqualTo(shopId);
    	}
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		example.setOrderByClause("sort desc,id");
    	return categoryDao.selectByExample(example);
    }
}