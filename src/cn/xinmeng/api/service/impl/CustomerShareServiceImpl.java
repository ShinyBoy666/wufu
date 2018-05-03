package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerShareDao;
import cn.xinmeng.api.entity.auto.CustomerShare;
import cn.xinmeng.api.entity.auto.example.CustomerShareExample;
import cn.xinmeng.api.service.ICustomerShareService;

/**
 * 业务层：CustomerShareServiceImpl
 * @author jiangyong.tan
 * 描述：分享记录表
 * @date 2016-01-24 14:38:51
 */
@Service("customerShareService")
public class CustomerShareServiceImpl implements ICustomerShareService {

    @Resource
	private CustomerShareDao customerShareDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerShare record){
    	return customerShareDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerShareDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerShare record){
		return customerShareDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerShare selectByPrimaryKey(Integer id){
    	return customerShareDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerShareExample example){
		return customerShareDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerShare> selectByExample(CustomerShareExample example){
    	return customerShareDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerShare> selectByExample(int currentPage, int limit,CustomerShareExample example){
        return customerShareDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}