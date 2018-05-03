package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerFeedbackChildDao;
import cn.xinmeng.api.entity.auto.CustomerFeedbackChild;
import cn.xinmeng.api.entity.auto.example.CustomerFeedbackChildExample;
import cn.xinmeng.api.service.ICustomerFeedbackChildService;

/**
 * 业务层：CustomerFeedbackChildServiceImpl
 * @author jiangyong.tan
 * 描述：客户意见反馈子表
 * @date 2016-01-24 14:38:50
 */
@Service("customerFeedbackChildService")
public class CustomerFeedbackChildServiceImpl implements ICustomerFeedbackChildService {

    @Resource
	private CustomerFeedbackChildDao customerFeedbackChildDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerFeedbackChild record){
    	return customerFeedbackChildDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerFeedbackChildDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerFeedbackChild record){
		return customerFeedbackChildDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerFeedbackChild selectByPrimaryKey(Integer id){
    	return customerFeedbackChildDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerFeedbackChildExample example){
		return customerFeedbackChildDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerFeedbackChild> selectByExample(CustomerFeedbackChildExample example){
    	return customerFeedbackChildDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerFeedbackChild> selectByExample(int currentPage, int limit,CustomerFeedbackChildExample example){
        return customerFeedbackChildDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}