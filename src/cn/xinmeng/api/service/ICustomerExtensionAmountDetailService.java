package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerExtensionAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerExtensionAmountDetailExample;
import java.util.List;

/**
 * 接口：ICustomerExtensionAmountDetailService
 * 描述：推广资金账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:26
 */
public interface ICustomerExtensionAmountDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerExtensionAmountDetail record);
    
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
	public int updateByPrimaryKey(CustomerExtensionAmountDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerExtensionAmountDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerExtensionAmountDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerExtensionAmountDetail> selectByExample(CustomerExtensionAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerExtensionAmountDetail> selectByExample(int currentPage, int limit,CustomerExtensionAmountDetailExample example);
}