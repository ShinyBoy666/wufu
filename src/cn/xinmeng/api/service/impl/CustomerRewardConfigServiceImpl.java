package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerRewardConfigDao;
import cn.xinmeng.api.entity.auto.CustomerRewardConfig;
import cn.xinmeng.api.entity.auto.example.CustomerRewardConfigExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICustomerRewardConfigService;

/**
 * 业务层：CustomerRewardConfigServiceImpl
 * 描述：客户推荐奖励配置
 * @author jiangyong.tan
 * @date 2016-03-24 22:11:46
 */
@Service("customerRewardConfigService")
public class CustomerRewardConfigServiceImpl implements ICustomerRewardConfigService {

    @Resource
	private CustomerRewardConfigDao customerRewardConfigDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerRewardConfig record){
    	return customerRewardConfigDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerRewardConfigDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerRewardConfig record){
		return customerRewardConfigDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerRewardConfig selectByPrimaryKey(Integer id){
    	return customerRewardConfigDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerRewardConfigExample example){
		return customerRewardConfigDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerRewardConfig> selectByExample(CustomerRewardConfigExample example){
    	return customerRewardConfigDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerRewardConfig> selectByExample(int currentPage, int limit,CustomerRewardConfigExample example){
        return customerRewardConfigDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    

    /**
     * 查询平台vip费用
     * @return
     */
    public double queryVipAmount(Integer shopId){
    	CustomerRewardConfigExample example = new CustomerRewardConfigExample();
    	example.setFieldList("vip_fee");
    	CustomerRewardConfigExample.Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));//vip平台会员费
    	criteria.andShopIdEqualTo(shopId);
    	List<CustomerRewardConfig> list = selectByExample(example);
    	if(list != null && list.size() > 0){
    		return list.get(0).getVipFee();
    	}
    	return 0.00;
    }
    
    /**
     * 查询平台vip费用
     * @return
     */
    public CustomerRewardConfig queryVipFeeCustomerRewardConfig(Integer shopId){
    	CustomerRewardConfigExample example = new CustomerRewardConfigExample();
    	CustomerRewardConfigExample.Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));//vip平台会员费
    	criteria.andShopIdEqualTo(shopId);
    	List<CustomerRewardConfig> list = selectByExample(example);
    	if(list != null && list.size() > 0){
    		return list.get(0);
    	}
    	return null;
    }
}