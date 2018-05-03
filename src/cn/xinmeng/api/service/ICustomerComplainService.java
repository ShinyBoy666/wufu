package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerComplain;
import cn.xinmeng.api.entity.auto.example.CustomerComplainExample;
import java.util.List;

/**
 * 接口：ICustomerComplainService
 * 描述：用户投诉
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:49
 */
public interface ICustomerComplainService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerComplain record);
    
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
	public int updateByPrimaryKey(CustomerComplain record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerComplain selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerComplainExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerComplain> selectByExample(CustomerComplainExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerComplain> selectByExample(int currentPage, int limit,CustomerComplainExample example);
}