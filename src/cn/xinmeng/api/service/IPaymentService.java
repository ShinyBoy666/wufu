package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;
import cn.xinmeng.web.shop.entity.order.vo.ResponseOrderBiz;

/**
 * 支付服务
 * @param 
 * @ClassName: IPaymentService 
 * @version V1.0  
 * @date 2016年2月25日 上午11:32:29 
 * @author jiangyong.tan
 * @return 
 *
 */
public interface IPaymentService {
	
	/**
	 *  订单支付
	 * @author jiangyong.tan
	 * @date 2016年2月25日 上午11:39:47
	 * @param order
	 */
	public ResponseOrderBiz payOrder(PayOrderBiz payOrderBiz,String source,Integer shopId,String ip);
	
	/**
	 * 
	 * <p class="detail"> 支付回调 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2015年11月19日 下午5:19:52
	 * @param customerRecharge
	 * @param tradeNumber
	 * @param amount
	 * @return
	 */
	public String payReturn(CustomerRecharge customerRecharge,String tradeNumber,Double amount);
	
	/**
	 * 快速订单支付
	 * @param order
	 * @param source
	 * @param shopId
	 * @param ip
	 * @param customerId
	 * @return
	 */
	public ResponseOrderBiz payQuickOrder(QuickOrder order,String source,Integer shopId,String ip,Integer customerId);
}
