package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ShopAccountConfig;
import cn.xinmeng.api.entity.auto.example.ShopAccountConfigExample;
import java.util.List;

/**
 * 接口：IShopAccountConfigService
 * 描述：店铺账户配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:25
 */
public interface IShopAccountConfigService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopAccountConfig record);
    
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
	public int updateByPrimaryKey(ShopAccountConfig record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopAccountConfig selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopAccountConfigExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopAccountConfig> selectByExample(ShopAccountConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopAccountConfig> selectByExample(int currentPage, int limit,ShopAccountConfigExample example);
}