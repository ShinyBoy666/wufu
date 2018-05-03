package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerComplainDao;
import cn.xinmeng.api.entity.auto.CustomerComplain;
import cn.xinmeng.api.entity.auto.example.CustomerComplainExample;
import cn.xinmeng.api.service.ICustomerComplainService;

/**
 * 业务层：CustomerComplainServiceImpl
 * @author jiangyong.tan
 * 描述：用户投诉
 * @date 2016-01-24 14:38:50
 */
@Service("customerComplainService")
public class CustomerComplainServiceImpl implements ICustomerComplainService {

    @Resource
	private CustomerComplainDao customerComplainDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerComplain record){
    	return customerComplainDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerComplainDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerComplain record){
		return customerComplainDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerComplain selectByPrimaryKey(Integer id){
    	return customerComplainDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerComplainExample example){
		return customerComplainDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerComplain> selectByExample(CustomerComplainExample example){
    	return customerComplainDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerComplain> selectByExample(int currentPage, int limit,CustomerComplainExample example){
        return customerComplainDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}