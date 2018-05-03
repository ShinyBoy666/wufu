package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.OrderState;
import cn.xinmeng.api.entity.auto.example.OrderStateExample;

/**
 * 接口：IOrderStateService
 * @author jiangyong.tan
 * 描述：订单状态表
 * @date 2016-01-24 14:39:02
 */
public interface IOrderStateService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderState record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderState record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderState selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderStateExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderState> selectByExample(OrderStateExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<OrderState> selectByExample(int currentPage, int limit,OrderStateExample example);
    
	/**
	 * 添加订单状态历史记录
	 * @param orderId
	 * @param orderState
	 */
	public void addOrderStateHis(String orderId,Integer orderState);
	
	/**
	 * 添加订单状态历史记录
	 * @param orderId
	 * @param orderState
	 */
	public void addOrderStateHis(List<String> childOrderIdList ,Integer orderState);
	
	/**
	 * 添加订单支付状态历史记录
	 * @param orderId
	 * @param payOrderState
	 */
	public void addOrderPayStateHis(String orderId,Integer payOrderState);
	
	/**
	 * 添加订单支付状态历史记录
	 * @param orderId
	 * @param payOrderState
	 */
	public void addOrderPayStateHis(List<String> childOrderIdList ,Integer payOrderState);
	
}