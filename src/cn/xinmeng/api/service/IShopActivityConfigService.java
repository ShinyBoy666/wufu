package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ShopActivityConfig;
import cn.xinmeng.api.entity.auto.example.ShopActivityConfigExample;
import java.util.List;

/**
 * 接口：IShopActivityConfigService
 * 描述：店铺优惠买单活动配置
 * @author jiangyong.tan
 * @date 2016-06-21 17:37:13
 */
public interface IShopActivityConfigService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopActivityConfig record);
    
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
	public int updateByPrimaryKey(ShopActivityConfig record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopActivityConfig selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopActivityConfigExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopActivityConfig> selectByExample(ShopActivityConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopActivityConfig> selectByExample(int currentPage, int limit,ShopActivityConfigExample example);
    
    /**
     * 根据主键查询
     * @param shopId
     * @return
     */
    public ShopActivityConfig queryByShopId(Integer shopId);
    
    /**
     * 保存或修改
     * @param shopActivityConfig
     * @return
     */
    public boolean insertOrUpdate(ShopActivityConfig record);
}