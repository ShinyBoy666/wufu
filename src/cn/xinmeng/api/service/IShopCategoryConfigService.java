package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ShopCategoryConfig;
import cn.xinmeng.api.entity.auto.example.ShopCategoryConfigExample;
import java.util.List;

/**
 * 接口：IShopCategoryConfigService
 * 描述：店铺和类别关系表
 * @author jiangyong.tan
 * @date 2016-03-23 14:06:48
 */
public interface IShopCategoryConfigService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopCategoryConfig record);
    
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
	public int updateByPrimaryKey(ShopCategoryConfig record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopCategoryConfig selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopCategoryConfigExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopCategoryConfig> selectByExample(ShopCategoryConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopCategoryConfig> selectByExample(int currentPage, int limit,ShopCategoryConfigExample example);
}