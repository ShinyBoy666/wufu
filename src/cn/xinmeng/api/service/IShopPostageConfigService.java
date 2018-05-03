package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.ShopPostageConfig;
import cn.xinmeng.api.entity.auto.example.ShopPostageConfigExample;

import java.util.List;

/**
 * 接口：IShopPostageConfigService
 * 描述：店铺邮费配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:28
 */
public interface IShopPostageConfigService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopPostageConfig record);
    
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
	public int updateByPrimaryKey(ShopPostageConfig record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopPostageConfig selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopPostageConfigExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopPostageConfig> selectByExample(ShopPostageConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopPostageConfig> selectByExample(int currentPage, int limit,ShopPostageConfigExample example);
    
    /**
     * 获取邮费
     * @param shopId
     * @param commonAddress
     * @param amount
     * @return
     */
    public double queryPostage(Integer shopId,CommonAddress commonAddress,Double amount);
    
    /**
     * 获取邮费配置
     * @param shopId
     * @param commonAddress
     * @return
     */
    public ShopPostageConfig queryPostage(Integer shopId,CommonAddress commonAddress);
}