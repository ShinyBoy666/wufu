package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerDetail;
import cn.xinmeng.api.entity.auto.example.CustomerDetailExample;
import java.util.List;

/**
 * 接口：ICustomerDetailService
 * @author jiangyong.tan
 * 描述：客户详细信息表
 * @date 2016-01-24 14:38:50
 */
public interface ICustomerDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerDetail record);
    
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
	public int updateByPrimaryKey(CustomerDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerDetail> selectByExample(CustomerDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerDetail> selectByExample(int currentPage, int limit,CustomerDetailExample example);
    
    /**
     * 查询客户详细信息
     * @param customerId
     * @param fieldList
     * @return
     */
    public CustomerDetail getCustomerDetail(Integer customerId,String fieldList);
    
    /**
     * 修改姓名，身份证
     * @param customerId
     * @param realname
     * @param identityCard
     */
    public void updateCustomerDetail(Integer customerId,String realname,String identityCard);
}