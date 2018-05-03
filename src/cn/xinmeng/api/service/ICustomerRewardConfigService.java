package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerRewardConfig;
import cn.xinmeng.api.entity.auto.example.CustomerRewardConfigExample;

import java.util.List;

/**
 * 接口：ICustomerRewardConfigService
 * 描述：客户推荐奖励配置
 * @author jiangyong.tan
 * @date 2016-03-24 22:11:46
 */
public interface ICustomerRewardConfigService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerRewardConfig record);
    
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
	public int updateByPrimaryKey(CustomerRewardConfig record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerRewardConfig selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerRewardConfigExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerRewardConfig> selectByExample(CustomerRewardConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerRewardConfig> selectByExample(int currentPage, int limit,CustomerRewardConfigExample example);
    
    /**
     * 查询平台vip费用
     * @param shopId
     * @return
     */
    public double queryVipAmount(Integer shopId);
    
    /**
     * 查询平台vip费用
     * @param shopId
     * @return
     */
    public CustomerRewardConfig queryVipFeeCustomerRewardConfig(Integer shopId);
}