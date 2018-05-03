package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerCashbackAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerCashbackAmountDetailExample;
import java.util.List;

/**
 * 接口：ICustomerCashbackAmountDetailService
 * 描述：返现账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:23
 */
public interface ICustomerCashbackAmountDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerCashbackAmountDetail record);
    
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
	public int updateByPrimaryKey(CustomerCashbackAmountDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerCashbackAmountDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerCashbackAmountDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerCashbackAmountDetail> selectByExample(CustomerCashbackAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerCashbackAmountDetail> selectByExample(int currentPage, int limit,CustomerCashbackAmountDetailExample example);
}