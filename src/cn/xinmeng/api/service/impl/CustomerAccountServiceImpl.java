package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerAccountDao;
import cn.xinmeng.api.entity.auto.CustomerAccount;
import cn.xinmeng.api.entity.auto.example.CustomerAccountExample;
import cn.xinmeng.api.service.ICustomerAccountService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CustomerAccountServiceImpl
 * 描述：客户账户信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:09
 */
@Service("customerAccountService")
public class CustomerAccountServiceImpl implements ICustomerAccountService {

    @Resource
	private CustomerAccountDao customerAccountDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerAccount record){
    	Date now = new Date();
    	record.setCreateTime(now);
    	record.setUpdateTime(now);
    	record.setCreateUser("api");
    	record.setUpdateUser("api");
    	return customerAccountDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerAccountDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerAccount record){
		return customerAccountDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerAccount selectByPrimaryKey(Integer id){
    	return customerAccountDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerAccountExample example){
		return customerAccountDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerAccount> selectByExample(CustomerAccountExample example){
    	return customerAccountDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerAccount> selectByExample(int currentPage, int limit,CustomerAccountExample example){
        return customerAccountDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public CustomerAccount selectByCustomerIdAndAccountType(
			Integer accountType, Integer customerId) {
		CustomerAccountExample example = new CustomerAccountExample();
		CustomerAccountExample.Criteria criteria = example.createCriteria();
		criteria.andAccountTypeEqualTo(accountType);
		criteria.andCustomerIdEqualTo(customerId);
		List<CustomerAccount> list = customerAccountDao.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
    
}