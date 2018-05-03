package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.ICustomerExtensionAmountDetailService;
import cn.xinmeng.api.dao.auto.CustomerExtensionAmountDetailDao;
import cn.xinmeng.api.entity.auto.CustomerExtensionAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerExtensionAmountDetailExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：CustomerExtensionAmountDetailServiceImpl
 * 描述：推广资金账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:26
 */
@Service("customerExtensionAmountDetailService")
public class CustomerExtensionAmountDetailServiceImpl implements ICustomerExtensionAmountDetailService {

    @Resource
	private CustomerExtensionAmountDetailDao customerExtensionAmountDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerExtensionAmountDetail record){
    	return customerExtensionAmountDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerExtensionAmountDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerExtensionAmountDetail record){
		return customerExtensionAmountDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerExtensionAmountDetail selectByPrimaryKey(Integer id){
    	return customerExtensionAmountDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerExtensionAmountDetailExample example){
		return customerExtensionAmountDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerExtensionAmountDetail> selectByExample(CustomerExtensionAmountDetailExample example){
    	return customerExtensionAmountDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerExtensionAmountDetail> selectByExample(int currentPage, int limit,CustomerExtensionAmountDetailExample example){
        return customerExtensionAmountDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}