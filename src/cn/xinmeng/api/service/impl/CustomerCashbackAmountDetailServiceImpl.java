package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.ICustomerCashbackAmountDetailService;
import cn.xinmeng.api.dao.auto.CustomerCashbackAmountDetailDao;
import cn.xinmeng.api.entity.auto.CustomerCashbackAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerCashbackAmountDetailExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：CustomerCashbackAmountDetailServiceImpl
 * 描述：返现账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:23
 */
@Service("customerCashbackAmountDetailService")
public class CustomerCashbackAmountDetailServiceImpl implements ICustomerCashbackAmountDetailService {

    @Resource
	private CustomerCashbackAmountDetailDao customerCashbackAmountDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerCashbackAmountDetail record){
    	return customerCashbackAmountDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerCashbackAmountDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerCashbackAmountDetail record){
		return customerCashbackAmountDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerCashbackAmountDetail selectByPrimaryKey(Integer id){
    	return customerCashbackAmountDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerCashbackAmountDetailExample example){
		return customerCashbackAmountDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerCashbackAmountDetail> selectByExample(CustomerCashbackAmountDetailExample example){
    	return customerCashbackAmountDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerCashbackAmountDetail> selectByExample(int currentPage, int limit,CustomerCashbackAmountDetailExample example){
        return customerCashbackAmountDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}