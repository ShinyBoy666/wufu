package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerRechargeDao;
import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.api.entity.auto.example.CustomerRechargeExample;
import cn.xinmeng.api.enums.RechargeStateEnum;
import cn.xinmeng.api.service.ICustomerRechargeService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CustomerRechargeServiceImpl
 * @author jiangyong.tan
 * 描述：客户充值记录表
 * @date 2016-01-24 14:38:51
 */
@Service("customerRechargeService")
public class CustomerRechargeServiceImpl implements ICustomerRechargeService {

    @Resource
	private CustomerRechargeDao customerRechargeDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerRecharge record){
    	Date now = new Date();
		record.setId(null);
		record.setCreateTime(now);
		record.setUpdateTime(now);
		record.setState(Integer.valueOf(RechargeStateEnum.STATE_VALID.key()));
		record.setCreateUser("api");
		record.setUpdateUser("api");
    	return customerRechargeDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerRechargeDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主修改
     * @param record
     * @return
     */
	public int updateSelectiveByPrimaryKey(CustomerRecharge record){
		return customerRechargeDao.updateSelectiveByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerRecharge selectByPrimaryKey(Integer id){
    	return customerRechargeDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerRechargeExample example){
		return customerRechargeDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerRecharge> selectByExample(CustomerRechargeExample example){
    	return customerRechargeDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerRecharge> selectByExample(int currentPage, int limit,CustomerRechargeExample example){
        return customerRechargeDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     *  查询订单支付工单
     * @author jiangyong.tan
     * @date 2016年2月25日 下午3:30:15
     * @param orderId
     * @param state
     * @return
     */
    public CustomerRecharge queryCustomerRechargeByOrderId(String orderId,Integer state){
    	CustomerRechargeExample example = new CustomerRechargeExample();
    	CustomerRechargeExample.Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(state);
    	criteria.andOrderIdEqualTo(orderId);
    	List<CustomerRecharge> list = customerRechargeDao.selectByExample(example);
    	if(list != null && list.size() > 0){
    		return list.get(0);
    	}
    	return null;
    }
    
    /**
     *  查询订单支付工单
     * @author jiangyong.tan
     * @date 2016年2月25日 下午3:30:15
     * @param orderId
     * @param state
     * @return
     */
    public List<CustomerRecharge> queryCustomerRechargeByOrderId(String orderId,List<Integer> stateList,String fieldList){
    	CustomerRechargeExample example = new CustomerRechargeExample();
    	if(!Utils.isEmpty(fieldList)){
    		example.setFieldList(fieldList);
    	}
    	CustomerRechargeExample.Criteria criteria = example.createCriteria();
    	criteria.andStateIn(stateList);
    	criteria.andOrderIdEqualTo(orderId);
    	return customerRechargeDao.selectByExample(example);
    }
    
    /**
     *  修改支付工单状态
     * @author jiangyong.tan
     * @date 2016年3月2日 上午11:31:43
     * @param id
     * @param state
     */
    public void updateCustomerRechargeState(Integer id,Integer state){
    	CustomerRecharge recharge = new CustomerRecharge();
    	recharge.setId(id);
    	recharge.setState(state);
    	customerRechargeDao.updateSelectiveByPrimaryKey(recharge);
    }
    
    @Override
	public CustomerRecharge searchByRechargeId(String rechargeId) {
		CustomerRechargeExample example = new CustomerRechargeExample();
		CustomerRechargeExample.Criteria criteria = example.createCriteria();
		criteria.andRechargeIdEqualTo(rechargeId);
		List<CustomerRecharge> list = customerRechargeDao.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
}