package cn.xinmeng.api.thread;

import java.util.Date;
import java.util.List;

import cn.xinmeng.api.entity.auto.OrderState;
import cn.xinmeng.api.service.IOrderStateService;
import cn.xinmeng.common.util.LogManager;

/**
 * 订单历史记录
 * @param 
 * @ClassName: OrderStateHisHistoryThread 
 * @version V1.0  
 * @date 2015年11月18日 下午3:38:22 
 * @author jiangyong.tan
 * @return 
 *
 */
public class OrderStateHisHistoryThread implements Runnable{

	IOrderStateService orderStateService;
	/**
	 * 订单ID
	 */
	List<String> childOrderIdList;
	
	/**
	 * 订单状态
	 */
	int state = 0;
	
	/**
	 * 状态中文
	 */
	String stateValue = "";
	
	/**
	 * 订单状态类型
	 */
	int stateType = 0;
	
	public OrderStateHisHistoryThread(IOrderStateService orderStateService,List<String> childOrderIdList,int state,String stateValue,int stateType){
		this.orderStateService = orderStateService;
		this.childOrderIdList = childOrderIdList;
		this.state = state;
		this.stateValue = stateValue;
		this.stateType = stateType;
	}
	
	@Override
	public void run() {
		try {
			if(orderStateService != null){
				if(childOrderIdList != null && childOrderIdList.size() > 0){
					for (String orderId : childOrderIdList) {
						OrderState record = new OrderState();
						record.setCreateTime(new Date());
						record.setCreateUser("API");
						record.setOrderId(orderId);
						record.setRemark(stateValue);
						record.setState(state);
						record.setStateText(stateValue);
						record.setStateType(stateType);
						orderStateService.add(record);
					}
				}
			}
		} catch (Exception e) {
			LogManager.error(this.getClass(), "修改订单状态异常：childOrderIdList："+childOrderIdList, e);
		}
	}

}
