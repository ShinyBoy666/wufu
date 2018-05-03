package cn.xinmeng.web.shop.impl.order;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.order.S1020RequestEntity;

/**
 * 取消/确认（收货）订单
 * @param 
 * @ClassName: S1020Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.order.S1020Component")
public class S1020Component extends BaseService {
	
	
	@Resource
	private IOrderService orderService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1020RequestEntity entity = parseRequertParam(data, S1020RequestEntity.class);
		
		/**
		 * 非空验证
		 */
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getParentOrderId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_ID);
		}else if(Utils.isEmpty(entity.getState())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_STATE);
		}
		
		String parentOrderId = entity.getParentOrderId();
		String childOrderId = entity.getChildOrderId();
		Integer state = entity.getState();
		if(state.compareTo(2) == 0){
			//订单取消
			orderService.cancelOrderByOrderId(parentOrderId,OrderStateEnum.STATE_CANCEL,null);
			return getAppResponseEntity(true);
		}else if(state.compareTo(3) == 0){
			//订单删除
			String fieldList = "id,order_state,pay_state";
			Order order = orderService.queryByOrderId(childOrderId, fieldList);
			if(order == null){
				return getAppResponseEntity(false);
			}
			if(OrderStateEnum.STATE_TIMEOUT.key().equals(order.getOrderState()+"")
				|| OrderStateEnum.STATE_CANCEL.key().equals(order.getOrderState()+"")
				|| OrderStateEnum.STATE_DELETE.key().equals(order.getOrderState()+"")
				|| OrderStateEnum.STATE_FINISH.key().equals(order.getOrderState()+"")){
				orderService.deleteOrder(order.getId(),childOrderId);
				return getAppResponseEntity(true);
			}
			return getAppResponseEntity(false);
		}else if(state.compareTo(1) == 0){
			//订单确认收货
			boolean flag = orderService.confirmReceipt(childOrderId,Integer.valueOf(OrderStateEnum.STATE_FINISH.key()),null);
			if(!flag){
				throw new BusinessException(LogManager.getLogger(getClass()),ExOrderEnum.EX_ERROR_ORDER_RECEIVING);
			}
			return getAppResponseEntity(true);
		}else if(state.compareTo(4) == 0){
			//后台超时取消
			orderService.cancelOrderByOrderId(parentOrderId,OrderStateEnum.STATE_TIMEOUT,entity.getRemark());
			return getAppResponseEntity(true);
		}else{
			return getAppResponseEntity(false);
		}
	}
	
}
