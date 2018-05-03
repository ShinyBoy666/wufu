package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.OrderStateDao;
import cn.xinmeng.api.entity.auto.OrderState;
import cn.xinmeng.api.entity.auto.example.OrderStateExample;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.enums.OrderStateTableEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.service.IOrderStateService;
import cn.xinmeng.api.thread.OrderStateHisHistoryThread;

/**
 * 业务层：OrderStateServiceImpl
 * @author jiangyong.tan
 * 描述：订单状态表
 * @date 2016-01-24 14:39:02
 */
@Service("orderStateService")
public class OrderStateServiceImpl implements IOrderStateService {

	@Resource
	IOrderStateService orderStateService;
    @Resource
	private OrderStateDao orderStateDao;
	@Resource
	private TaskExecutor orderStateHisHistoryThreadPool;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderState record){
    	return orderStateDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return orderStateDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderState record){
		return orderStateDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderState selectByPrimaryKey(Integer id){
    	return orderStateDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(OrderStateExample example){
		return orderStateDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderState> selectByExample(OrderStateExample example){
    	return orderStateDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<OrderState> selectByExample(int currentPage, int limit,OrderStateExample example){
        return orderStateDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
	/**
	 * 添加订单状态历史记录
	 * @param orderId
	 * @param orderState
	 */
	public void addOrderStateHis(String orderId,Integer orderState){
		String value = OrderStateEnum.keyToValue(orderState+"");
		List<String> childOrderIdList = new ArrayList<String>();
		childOrderIdList.add(orderId);
		orderStateHisHistoryThreadPool.execute(new OrderStateHisHistoryThread(orderStateService, childOrderIdList, orderState, value, Integer.valueOf(OrderStateTableEnum.ORDER_STATE.key())));
	}
	
	/**
	 * 添加订单状态历史记录
	 * @param orderId
	 * @param orderState
	 */
	public void addOrderStateHis(List<String> childOrderIdList ,Integer orderState){
		String value = OrderStateEnum.keyToValue(orderState+"");
		orderStateHisHistoryThreadPool.execute(new OrderStateHisHistoryThread(orderStateService, childOrderIdList, orderState, value, Integer.valueOf(OrderStateTableEnum.ORDER_STATE.key())));
	}

	/**
	 * 添加订单支付状态历史记录
	 * @param orderId
	 * @param payOrderState
	 */
	public void addOrderPayStateHis(String orderId,Integer payOrderState){
		String value = PaymentStateEnum.keyToValue(payOrderState+"");
		List<String> childOrderIdList = new ArrayList<String>();
		childOrderIdList.add(orderId);
		orderStateHisHistoryThreadPool.execute(new OrderStateHisHistoryThread(orderStateService, childOrderIdList, payOrderState, value, Integer.valueOf(OrderStateTableEnum.ORDER_PAY_STATE.key())));
	}
	
	/**
	 * 添加订单支付状态历史记录
	 * @param orderId
	 * @param payOrderState
	 */
	public void addOrderPayStateHis(List<String> childOrderIdList ,Integer payOrderState){
		String value = PaymentStateEnum.keyToValue(payOrderState+"");
		orderStateHisHistoryThreadPool.execute(new OrderStateHisHistoryThread(orderStateService, childOrderIdList, payOrderState, value, Integer.valueOf(OrderStateTableEnum.ORDER_PAY_STATE.key())));
	}
}