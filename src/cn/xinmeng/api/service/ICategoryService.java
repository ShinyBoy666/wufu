package cn.xinmeng.api.service;

import java.util.List;
import java.util.Map;

import cn.xinmeng.api.entity.auto.Category;
import cn.xinmeng.api.entity.auto.example.CategoryExample;

/**
 * 接口：ICategoryService
 * 描述：商品类别表
 * @author jiangyong.tan
 * @date 2016-02-23 14:08:41
 */
public interface ICategoryService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Category record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Category record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Category selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CategoryExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Category> selectByExample(CategoryExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<Category> selectByExample(int currentPage, int limit,CategoryExample example);
    
    /**
     *  分类ID集合查询分类
     * @author jiangyong.tan
     * @date 2016年2月23日 下午2:21:06
     * @param categoryIds
     * @return
     */
    public List<Category> searchCategoryByIds(List<Integer> categoryIds);
    

    /**
     *  分类ID集合查询分类
     * @author jiangyong.tan
     * @date 2016年2月23日 下午2:21:06
     * @param categoryIds
     * @return
     */
    public Map<Integer,String> searchCategoryNameByIds(List<Integer> categoryIds);
    
    /**
     *  查询某一个级别所有数据
     * @author jiangyong.tan
     * @date 2016年2月25日 上午9:49:55
     * @param level
     * @param second
     * @param first
     * @return
     */
    public List<Category> searchCategory(Integer level,Integer second,Integer first,Integer shopId);
}