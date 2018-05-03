package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.SystemConfigDao;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.SystemConfig;
import cn.xinmeng.api.entity.auto.example.SystemConfigExample;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISystemConfigService;

/**
 * 业务层：SystemConfigServiceImpl
 * 描述：系统配置表
 * @author jiangyong.tan
 * @date 2016-04-07 11:07:56
 */
@Service("systemConfigService")
public class SystemConfigServiceImpl implements ISystemConfigService {

    @Resource
	private SystemConfigDao systemConfigDao;
    @Resource
    private ICustomerService customerService;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemConfig record){
    	return systemConfigDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return systemConfigDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SystemConfig record){
		return systemConfigDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemConfig selectByPrimaryKey(Integer id){
    	return systemConfigDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(SystemConfigExample example){
		return systemConfigDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemConfig> selectByExample(SystemConfigExample example){
    	return systemConfigDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<SystemConfig> selectByExample(int currentPage, int limit,SystemConfigExample example){
        return systemConfigDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     * 不是会员，是否能余额支付
     * @return
     */
    public boolean notNumberBalancePay(){
    	SystemConfigExample example = new SystemConfigExample();
    	SystemConfigExample.Criteria criteria = example.createCriteria();
    	criteria.andCodeEqualTo("use_amount_condition");
    	criteria.andValueEqualTo("2");//非会员可以使用余额
    	if(systemConfigDao.countByExample(example) > 0){
    		return true;
    	}
    	return false;
    }


    /**
     * 不是会员，是否能余额支付
     * @return
     */
    public boolean notNumberBalancePay(Customer customer){
    	if(customerService.isMember(customer)){
    		return true;
    	}
    	return notNumberBalancePay();
    }
    
    /**
     * 不是会员，是否能提现
     * @return
     */
    public boolean notNumberWithdrawals(){
    	SystemConfigExample example = new SystemConfigExample();
    	SystemConfigExample.Criteria criteria = example.createCriteria();
    	criteria.andCodeEqualTo("withdraw_amount_condition");
    	criteria.andValueEqualTo("2");//非会员可以使用余额
    	if(systemConfigDao.countByExample(example) > 0){
    		return true;
    	}
    	return false;
    }
}