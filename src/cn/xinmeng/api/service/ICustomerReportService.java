package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerReport;
import cn.xinmeng.api.entity.auto.example.CustomerReportExample;
import java.util.List;

/**
 * 接口：ICustomerReportService
 * 描述：客户报表统计
 * @author jiangyong.tan
 * @date 2016-11-17 20:43:21
 */
public interface ICustomerReportService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerReport record);
    
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
	public int updateByPrimaryKey(CustomerReport record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerReport selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerReportExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerReport> selectByExample(CustomerReportExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerReport> selectByExample(int currentPage, int limit,CustomerReportExample example);
    
    /**
     * 根据客户编号查询
     * @param customerId
     * @return
     */
    public CustomerReport queryByCustomerId(Integer customerId);
}