package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.api.entity.auto.example.CustomerRechargeExample;

/**
 * 接口：ICustomerRechargeService
 * @author jiangyong.tan
 * 描述：客户充值记录表
 * @date 2016-01-24 14:38:51
 */
public interface ICustomerRechargeService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerRecharge record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
    /**
     * 按主修改
     * @param record
     * @return
     */
	public int updateSelectiveByPrimaryKey(CustomerRecharge record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerRecharge selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerRechargeExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerRecharge> selectByExample(CustomerRechargeExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerRecharge> selectByExample(int currentPage, int limit,CustomerRechargeExample example);
    
    /**
     *  查询订单支付工单
     * @author jiangyong.tan
     * @date 2016年2月25日 下午3:30:15
     * @param orderId
     * @param state
     * @return
     */
    public CustomerRecharge queryCustomerRechargeByOrderId(String orderId,Integer state);
    
    /**
     *  查询订单支付工单
     * @author jiangyong.tan
     * @date 2016年2月25日 下午3:30:15
     * @param orderId
     * @param state
     * @return
     */
    public List<CustomerRecharge> queryCustomerRechargeByOrderId(String orderId,List<Integer> stateList,String fieldList);
    
    /**
     *  修改支付工单状态
     * @author jiangyong.tan
     * @date 2016年3月2日 上午11:31:43
     * @param id
     * @param state
     */
    public void updateCustomerRechargeState(Integer id,Integer state);
    
    /**
	 * 
	 * <p class="detail"> 根据支付单号查询 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2015年11月19日 上午11:02:06
	 * @param rechargeId
	 * @return
	 */
	public CustomerRecharge searchByRechargeId(String rechargeId);
}