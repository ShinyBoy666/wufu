package cn.xinmeng.api.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.biz.OrderTotalBiz;
import cn.xinmeng.api.entity.auto.example.OrderExample;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;

/**
 * 接口：IOrderService
 * @author jiangyong.tan
 * 描述：订单表
 * @date 2016-01-24 14:39:00
 */
public interface IOrderService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Order record);
    
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
	public int updateByPrimaryKey(Order record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Order selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Order> selectByExample(OrderExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Order> selectByExample(int currentPage, int limit,OrderExample example);
    
    /**
     *  修改订单支付金额
     * @author jiangyong.tan
     * @date 2016年2月26日 上午10:12:38
     * @param orderId
     * @param accountPayment
     * @param payState
     */
    public void updateOrderAccountPaymentAndPayState(String orderId,Double accountPayment,PaymentStateEnum payState,Integer onlinePayType);
    
    /**
     *  查询订单
     * @author jiangyong.tan
     * @date 2016年3月1日 下午4:30:14
     * @param orderId
     * @param fieldList
     * @return
     */
    public Order queryByOrderId(String orderId,String fieldList);

	/**
	 * 根据订单编号，修改订单状态（历史记录生成）
	 * @param orderId
	 * @return
	 */
	public boolean updateOrderStateByOrderId(String orderId,Integer orderState,String remark);
	
	/**
	 * 根据订单编号，修改订单支付状态（历史记录生成）
	 * @param orderId
	 * @return
	 */
	public boolean updatePayStateByOrderId(String orderId,Integer payState,Double onlinePayment);
	
	/**
	 * 确认收货
	 * @param orderId
	 * @param orderState
	 * @return
	 */
	public boolean confirmReceipt(String orderId,Integer orderState,Double onlinePayment);
	
	/**
	 * 取消订单
	 * @param orderId
	 * @param orderState
	 * @return
	 */
	public boolean cancelOrderByOrderId(String orderId,OrderStateEnum orderStateEnum,String remark);
	
	/**
	 * 删除订单状态
	 * @param orderId
	 * @return
	 */
	public boolean deleteOrder(Integer id,String orderId);
	
	/**
	 *  查询商品名称图片：键：商品名称，值：商品图片列表
	 * @author jiangyong.tan
	 * @date 2016年2月29日 下午3:11:15
	 * @param orderId
	 * @return
	 */
	public Map<String,List<String>> queryProductImage(String orderId);
	
	/**
	 * 根据店铺id统计订单数目 
	 * @param shopId
	 * @param type
	 * @return
	 */
	public int countOrderByShopId(Integer shopId,String type,OrderExample example);	
	/**
	 * 根据订单id更新物流信息
	 * @param logisticsName
	 * @param logisticsNumber
	 * @param childOrderId
	 * @return
	 */
	public boolean updateLogisticsNumber(String logisticsName,String logisticsNumber,String childOrderId);
	

	/**
	 * 查询普订单统计
	 * @param shopId
	 * @param payTime
	 * @return
	 */
	public OrderTotalBiz queryOrderTotal(Integer shopId,Date payTime);
}