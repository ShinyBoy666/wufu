package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.ICustomerContributionAmountDetailService;
import cn.xinmeng.api.dao.auto.CustomerContributionAmountDetailDao;
import cn.xinmeng.api.entity.auto.CustomerContributionAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerContributionAmountDetailExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：CustomerContributionAmountDetailServiceImpl
 * 描述：贡献值帐户流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:25
 */
@Service("customerContributionAmountDetailService")
public class CustomerContributionAmountDetailServiceImpl implements ICustomerContributionAmountDetailService {

    @Resource
	private CustomerContributionAmountDetailDao customerContributionAmountDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerContributionAmountDetail record){
    	return customerContributionAmountDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerContributionAmountDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerContributionAmountDetail record){
		return customerContributionAmountDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerContributionAmountDetail selectByPrimaryKey(Integer id){
    	return customerContributionAmountDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerContributionAmountDetailExample example){
		return customerContributionAmountDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerContributionAmountDetail> selectByExample(CustomerContributionAmountDetailExample example){
    	return customerContributionAmountDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerContributionAmountDetail> selectByExample(int currentPage, int limit,CustomerContributionAmountDetailExample example){
        return customerContributionAmountDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}