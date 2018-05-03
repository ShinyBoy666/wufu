package cn.xinmeng.api.dao.ex;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.xinmeng.api.entity.auto.biz.OrderTotalBiz;

public interface ExOrderDao {

	/**
	 * 修改订单支付金额与状态
	 * @param orderId
	 * @param accountPayment
	 * @param payState
	 * @return
	 */
	public Integer updateOrderAccountPayment(@Param("orderId") String orderId,@Param("accountPayment") Double accountPayment,@Param("payState") Integer payState,@Param("onlinePayType") Integer onlinePayType);
	
	/**
	 * 修改已领取优惠劵金额
	 * @param orderId
	 * @param receiveCouponAmount
	 * @return
	 */
	public Integer updateQuickOrderReceiveCouponAmount(@Param("orderId") String orderId,@Param("receiveCouponAmount") Double receiveCouponAmount);
	
	
	/**
	 * 查询普订单统计
	 * @param shopId
	 * @param payTime
	 * @return
	 */
	public OrderTotalBiz queryOrderTotal(@Param("shopId") Integer shopId,@Param("payTime") Date payTime);
	

	/**
	 * 查询优惠买单统计
	 * @param shopId
	 * @param payTime
	 * @return
	 */
	public OrderTotalBiz queryQuickOrderTotal(@Param("shopId") Integer shopId,@Param("payTime") Date payTime);
}
