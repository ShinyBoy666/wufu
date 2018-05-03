package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerDetailDao;
import cn.xinmeng.api.entity.auto.CustomerDetail;
import cn.xinmeng.api.entity.auto.example.CustomerDetailExample;
import cn.xinmeng.api.service.ICustomerDetailService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CustomerDetailServiceImpl
 * @author jiangyong.tan
 * 描述：客户详细信息表
 * @date 2016-01-24 14:38:50
 */
@Service("customerDetailService")
public class CustomerDetailServiceImpl implements ICustomerDetailService {

    @Resource
	private CustomerDetailDao customerDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerDetail record){
    	return customerDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerDetail record){
		return customerDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerDetail selectByPrimaryKey(Integer id){
    	return customerDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerDetailExample example){
		return customerDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerDetail> selectByExample(CustomerDetailExample example){
    	return customerDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerDetail> selectByExample(int currentPage, int limit,CustomerDetailExample example){
        return customerDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     * 查询客户详细信息
     * @param customerId
     * @param fieldList
     * @return
     */
    public CustomerDetail getCustomerDetail(Integer customerId,String fieldList){
    	CustomerDetailExample example = new CustomerDetailExample();
    	if(!Utils.isEmpty(fieldList)){
        	example.setFieldList(fieldList);
    	}
    	CustomerDetailExample.Criteria criteria = example.createCriteria();
    	criteria.andCustomerIdEqualTo(customerId);
    	List<CustomerDetail> list = selectByExample(1,1,example);
    	if(!Utils.isEmpty(list)){
    		return list.get(0);
    	}
    	return null;
    }
    
    /**
     * 修改姓名，身份证
     * @param customerId
     * @param realname
     * @param identityCard
     */
    public void updateCustomerDetail(Integer customerId,String realname,String identityCard){
    	CustomerDetail detail = new CustomerDetail();
    	detail.setRealname(realname);
    	detail.setIdentityCard(identityCard);

    	CustomerDetailExample example = new CustomerDetailExample();
    	CustomerDetailExample.Criteria criteria = example.createCriteria();
    	criteria.andCustomerIdEqualTo(customerId);
    	
    	customerDetailDao.updateByExampleSelective(detail, example);
    }
}