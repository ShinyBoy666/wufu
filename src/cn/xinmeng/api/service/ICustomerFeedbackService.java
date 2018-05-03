package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.CustomerFeedback;
import cn.xinmeng.api.entity.auto.example.CustomerFeedbackExample;
import cn.xinmeng.web.shop.entity.customer.S1027RequestEntity;

/**
 * 接口：ICustomerFeedbackService
 * @author jiangyong.tan
 * 描述：客户意见反馈表
 * @date 2016-01-24 14:38:50
 */
public interface ICustomerFeedbackService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerFeedback record);
    
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
	public int updateByPrimaryKey(CustomerFeedback record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerFeedback selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerFeedbackExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerFeedback> selectByExample(CustomerFeedbackExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerFeedback> selectByExample(int currentPage, int limit,CustomerFeedbackExample example);
    
    /**
     *  新增反馈信息
     * @author jiangyong.tan
     * @date 2016年2月19日 上午9:30:42
     * @param record
     * @return
     */
    public int insert(S1027RequestEntity record);
}