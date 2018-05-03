package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerAccount;
import cn.xinmeng.api.entity.auto.example.CustomerAccountExample;
import java.util.List;

/**
 * 接口：ICustomerAccountService
 * 描述：客户账户信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:09
 */
public interface ICustomerAccountService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerAccount record);
    
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
	public int updateByPrimaryKey(CustomerAccount record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerAccount selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerAccountExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerAccount> selectByExample(CustomerAccountExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerAccount> selectByExample(int currentPage, int limit,CustomerAccountExample example);
    
    /**
     * 
     * <p class="detail"> 根据账户类型和客户编号查询 </p>
     * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月1日 下午3:46:20
     * @param accountType
     * @param customerId
     * @return
     */
    public CustomerAccount selectByCustomerIdAndAccountType(Integer accountType,Integer customerId);
}