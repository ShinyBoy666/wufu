package cn.xinmeng.web.shop.impl.market;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.common.enums.ex.ExCouponEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1097RequestEntity;

/**
 * 付款后查询优惠券
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1097Component")
public class S1097Component extends BaseService {

	@Resource
	private IQuickOrderService quickOrderService;
//	@Resource
//	private ICustomerService customerService;
	@Resource
	private ICouponApplyService couponApplyService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1097RequestEntity entity = parseRequertParam(data, S1097RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getOrderId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_ID);
		}
		
		QuickOrder order = quickOrderService.queryByOrderId(entity.getOrderId());
		if(Utils.isEmpty(order)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
		}
		if(!PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(order.getPayState()+"")){
			throw new BusinessException(LogManager.getLogger(this.getClass()),MessageFormat.format(ExOrderEnum.EX_ERROR_STATE.value(), "订单信息已过期"));
		}
		if(UtilMoney.compareTo(order.getTotalAmount(), order.getReceiveCouponAmount()) <= 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
//		int customerId = 0; 
//		Customer customer = customerService.queryCustomerByOpenId(order.getOpenId(), "id");
//		if(customer != null){
//			customerId = customer.getId();
//		}
		Map<String, Object> result = new HashMap<String, Object>();
		Double scAmount = UtilMoney.subtractToDouble(order.getTotalAmount(), order.getReceiveCouponAmount());
		result.put("list", couponApplyService.searchCouponApplyList(scAmount, entity));
		result.put("scAmount", scAmount.intValue());
		return getAppResponseEntity(result);
	}
}
