package cn.xinmeng.api.service.impl;

import java.util.List;

import cn.xinmeng.api.service.ICustomerReportService;
import cn.xinmeng.api.dao.auto.CustomerReportDao;
import cn.xinmeng.api.entity.auto.CustomerReport;
import cn.xinmeng.api.entity.auto.example.CustomerReportExample;
import cn.xinmeng.common.util.Utils;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：CustomerReportServiceImpl
 * 描述：客户报表统计
 * @author jiangyong.tan
 * @date 2016-11-17 20:43:21
 */
@Service("customerReportService")
public class CustomerReportServiceImpl implements ICustomerReportService {

    @Resource
	private CustomerReportDao customerReportDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerReport record){
    	return customerReportDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerReportDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerReport record){
		return customerReportDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerReport selectByPrimaryKey(Integer id){
    	return customerReportDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerReportExample example){
		return customerReportDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerReport> selectByExample(CustomerReportExample example){
    	return customerReportDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerReport> selectByExample(int currentPage, int limit,CustomerReportExample example){
        return customerReportDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public CustomerReport queryByCustomerId(Integer customerId) {
		CustomerReportExample example = new CustomerReportExample();
		CustomerReportExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(customerId);
		
		List<CustomerReport> list = customerReportDao.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
    
}