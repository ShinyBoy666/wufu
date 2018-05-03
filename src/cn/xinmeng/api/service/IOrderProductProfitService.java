package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.OrderProductProfit;
import cn.xinmeng.api.entity.auto.example.OrderProductProfitExample;

/**
 * 接口：IOrderProductProfitService
 * 描述：订单商品利润分配信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:11
 */
public interface IOrderProductProfitService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderProductProfit record);
    
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
	public int updateByPrimaryKey(OrderProductProfit record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderProductProfit selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderProductProfitExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderProductProfit> selectByExample(OrderProductProfitExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<OrderProductProfit> selectByExample(int currentPage, int limit,OrderProductProfitExample example);
    
    /**
     * 确认收货，修改订单商品利润状态
     * @param childOrderId
     */
    public void updateOrderProfitState(String childOrderId);
    
    /**
	 * 订单商品分利
	 * @param customerId
	 * @param order
	 */
	public void merchandiseDistribution(Order order);
    
    /**
	 * 订单商品分利(自己永远享受分利)
	 * @param customerId
	 * @param order
	 */
	public void newMerchandiseDistribution(Order order);

    /**
	 * 会员充值分利
	 * @param customerId
	 * @param order
	 */
	public void nemberMerchandiseDistribution(Order order,Double onlinePayment);
	
	/**
	 * 获取店铺冻结金额
	 * @param shopId
	 * @return
	 */
	public Double getFreezeAmount(Integer shopId);
	
}