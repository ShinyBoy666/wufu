package cn.xinmeng.web.base.util;

import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.enums.WebShowOrderStateEnum;


/**
 * 状态转换
 * @author jiangyong.tan
 * 2015年11月12日下午6:04:42
 *
 */
public class StateConvertUtils {
	public static int convertOrderActivityType(Integer activityType){
		//1、团购 2、砍价 3、特价 4、值得买 5、闪购
		//订单：1、无 2、团购 3、砍价 4、秒杀 5、特价 6、积分订单
		if(Utils.isEmpty(activityType)){
			return 1;
		}else if(activityType == 1){
			return 2;
		}else if(activityType == 2){
			return 3;
		}else if(activityType == 3){
			return 5;
		}else if(activityType == 5){
			return 4;
		}
		return 1;
	}
	
//	public static String orderShowSateKey(Integer orderState){
//		String str = String.valueOf(orderState);
//		if(OrderStateEnum.STATE_CANCEL.key().equals(str)){
//			return WebShowOrderStateEnum.STATE_CANCEL.key();
//		}else if(OrderStateEnum.STATE_TIMEOUT.key().equals(str)){
//			return WebShowOrderStateEnum.STATE_TIMEOUT.key();
//		}else{
//			return WebShowOrderStateEnum.COMPLETED.key();
//		}
//	}

	
	public static String orderShowSateKey(Integer orderState,Integer payState){
		String orderStateStr = String.valueOf(orderState);
		String payStateStr = String.valueOf(payState);
		if(OrderStateEnum.STATE_CANCEL.key().equals(orderStateStr)){
			//取消
			return WebShowOrderStateEnum.STATE_CANCEL.key();
		}else if(OrderStateEnum.STATE_TIMEOUT.key().equals(orderStateStr)){
			//超时
			return WebShowOrderStateEnum.STATE_TIMEOUT.key();
		}else if(OrderStateEnum.STATE_SUCCESS.key().equals(orderStateStr) && 
				(PaymentStateEnum.STATE_PAY_NOT.key().equals(payStateStr) 
					|| PaymentStateEnum.STATE_PAYING.key().equals(payStateStr))){
			//支付中
			return WebShowOrderStateEnum.NO_PAYMENT.key();
		}else if((OrderStateEnum.STATE_SUCCESS.key().equals(orderStateStr)
			|| OrderStateEnum.STATE_FOR_OUTBOUND.key().equals(orderStateStr)
			|| OrderStateEnum.STATE_DISTRIBUTION.key().equals(orderStateStr) 
			&& PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(orderStateStr))){
			//进行中
			return WebShowOrderStateEnum.CARRIED_OUT.key();
		}else{
			//已完成
			return WebShowOrderStateEnum.COMPLETED.key();
		}
	}
}
