package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerFeedbackChildDao;
import cn.xinmeng.api.dao.auto.CustomerFeedbackDao;
import cn.xinmeng.api.entity.auto.CustomerFeedback;
import cn.xinmeng.api.entity.auto.CustomerFeedbackChild;
import cn.xinmeng.api.entity.auto.example.CustomerFeedbackExample;
import cn.xinmeng.api.service.ICustomerFeedbackService;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.customer.S1027RequestEntity;

/**
 * 业务层：CustomerFeedbackServiceImpl
 * @author jiangyong.tan
 * 描述：客户意见反馈表
 * @date 2016-01-24 14:38:50
 */
@Service("customerFeedbackService")
public class CustomerFeedbackServiceImpl implements ICustomerFeedbackService {

    @Resource
	private CustomerFeedbackDao customerFeedbackDao;
    @Resource
    private CustomerFeedbackChildDao customerFeedbackChildDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerFeedback record){
    	return customerFeedbackDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerFeedbackDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerFeedback record){
		return customerFeedbackDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerFeedback selectByPrimaryKey(Integer id){
    	return customerFeedbackDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerFeedbackExample example){
		return customerFeedbackDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerFeedback> selectByExample(CustomerFeedbackExample example){
    	return customerFeedbackDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerFeedback> selectByExample(int currentPage, int limit,CustomerFeedbackExample example){
        return customerFeedbackDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    /**
     *  新增反馈信息
     * @author jiangyong.tan
     * @date 2016年2月19日 上午9:30:42
     * @param record
     * @return
     */
    public int insert(S1027RequestEntity record){
    	Date date = new Date();
    	if(Utils.isEmpty(record.getPhoneType())){
    		record.setPhoneType("");
    	}
    	if(Utils.isEmpty(record.getCellphone())){
    		record.setCellphone("");
    	}
    	if(Utils.isEmpty(record.getLat())){
    		record.setLat(0.0);
    	}
    	if(Utils.isEmpty(record.getLng())){
    		record.setLng(0.0);
    	}
    	record.setState(0);
    	record.setCreateTime(date);
    	record.setCreateUser(Utils.createUser);
    	//客户反馈
    	customerFeedbackDao.insert(record);
    	
    	//反馈子表保存
    	CustomerFeedbackChild child = new CustomerFeedbackChild();
    	child.setFeedbackId(record.getId());
    	child.setFeedbackChildId(0);
    	child.setReplyType(1);
    	child.setReplyContent(record.getReplyContent());
    	child.setCreateTime(date);
    	child.setCreateUser(Utils.createUser);
    	child.setUpdateTime(date);
    	child.setUpdateUser(Utils.createUser);
    	return customerFeedbackChildDao.insert(child);
    }
}