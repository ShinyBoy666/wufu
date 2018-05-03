package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerFeedbackChild;
import cn.xinmeng.api.entity.auto.example.CustomerFeedbackChildExample;
import java.util.List;

/**
 * 接口：ICustomerFeedbackChildService
 * 描述：客户意见反馈子表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:50
 */
public interface ICustomerFeedbackChildService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerFeedbackChild record);
    
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
	public int updateByPrimaryKey(CustomerFeedbackChild record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerFeedbackChild selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerFeedbackChildExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerFeedbackChild> selectByExample(CustomerFeedbackChildExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerFeedbackChild> selectByExample(int currentPage, int limit,CustomerFeedbackChildExample example);
}