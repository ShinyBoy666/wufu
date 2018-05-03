package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ShopCategory;
import cn.xinmeng.api.entity.auto.example.ShopCategoryExample;
import java.util.List;

/**
 * 接口：IShopCategoryService
 * 描述：店铺类别表
 * @author jiangyong.tan
 * @date 2016-03-23 14:06:43
 */
public interface IShopCategoryService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopCategory record);
    
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
	public int updateByPrimaryKey(ShopCategory record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopCategory selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopCategoryExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopCategory> selectByExample(ShopCategoryExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopCategory> selectByExample(int currentPage, int limit,ShopCategoryExample example);
}