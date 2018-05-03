package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerAmountDetailExample;
import java.util.List;

/**
 * 接口：ICustomerAmountDetailService
 * 描述：现金账户金额流水表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:48
 */
public interface ICustomerAmountDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerAmountDetail record);
    
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
	public int updateByPrimaryKey(CustomerAmountDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerAmountDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerAmountDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerAmountDetail> selectByExample(CustomerAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerAmountDetail> selectByExample(int currentPage, int limit,CustomerAmountDetailExample example);
}