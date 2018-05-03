package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerShare;
import cn.xinmeng.api.entity.auto.example.CustomerShareExample;
import java.util.List;

/**
 * 接口：ICustomerShareService
 * 描述：分享记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:53
 */
public interface ICustomerShareService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerShare record);
    
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
	public int updateByPrimaryKey(CustomerShare record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerShare selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerShareExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerShare> selectByExample(CustomerShareExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerShare> selectByExample(int currentPage, int limit,CustomerShareExample example);
}