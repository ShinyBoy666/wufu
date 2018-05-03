package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerAmountDetailDao;
import cn.xinmeng.api.entity.auto.CustomerAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerAmountDetailExample;
import cn.xinmeng.api.service.ICustomerAmountDetailService;

/**
 * 业务层：CustomerAmountDetailServiceImpl
 * @author jiangyong.tan
 * 描述：客户账户金额流水表
 * @date 2016-01-24 14:38:49
 */
@Service("customerAmountDetailService")
public class CustomerAmountDetailServiceImpl implements ICustomerAmountDetailService {

    @Resource
	private CustomerAmountDetailDao customerAmountDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerAmountDetail record){
    	return customerAmountDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerAmountDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerAmountDetail record){
		return customerAmountDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerAmountDetail selectByPrimaryKey(Integer id){
    	return customerAmountDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerAmountDetailExample example){
		return customerAmountDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerAmountDetail> selectByExample(CustomerAmountDetailExample example){
    	return customerAmountDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerAmountDetail> selectByExample(int currentPage, int limit,CustomerAmountDetailExample example){
        return customerAmountDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}