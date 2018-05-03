package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.SystemConfig;
import cn.xinmeng.api.entity.auto.example.SystemConfigExample;

/**
 * 接口：ISystemConfigService
 * 描述：系统配置表
 * @author jiangyong.tan
 * @date 2016-04-07 11:07:56
 */
public interface ISystemConfigService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemConfig record);
    
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
	public int updateByPrimaryKey(SystemConfig record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemConfig selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SystemConfigExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemConfig> selectByExample(SystemConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<SystemConfig> selectByExample(int currentPage, int limit,SystemConfigExample example);
    
    /**
     * 不是会员，是否能余额支付
     * @return
     */
    public boolean notNumberBalancePay();

    /**
     * 不是会员，是否能余额支付
     * @return
     */
    public boolean notNumberBalancePay(Customer customer);

    /**
     * 不是会员，是否能提现
     * @return
     */
    public boolean notNumberWithdrawals();
}