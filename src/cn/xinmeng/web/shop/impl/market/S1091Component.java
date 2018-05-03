package cn.xinmeng.web.shop.impl.market;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1091RequestEntity;

/**
 * 优惠券配额接口
 * @param 
 * @ClassName: S1091Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1091Component")
public class S1091Component extends BaseService {

	@Resource
	private IRedisService redisService;
	@Resource
	private IQuickOrderService quickOrderService;
	@Resource
	private ICustomerService customerService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1091RequestEntity entity = parseRequertParam(data, S1091RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
//		}else if(Utils.isEmpty(entity.getCustomerId())) {
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
//		QuickOrder order = quickOrderService.queryByOrderId(entity.getOrderId());
//		if(Utils.isEmpty(order)){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
//		}
//		if(!PaymentStateEnum.STATE_PAY_SUCCESS.key().equals(order.getPayState()+"")){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),MessageFormat.format(ExOrderEnum.EX_ERROR_STATE.value(), "订单信息已过期"));
//		}
//		if(UtilMoney.compareTo(order.getTotalAmount(), order.getReceiveCouponAmount()) <= 0){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_HAVE);
//		}
//		Customer customer = customerService.queryCustomerByOpenId(order.getOpenId(), "");
//		if(customer == null || customer.getId() != entity.getCustomerId()){
//			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCouponEnum.EX_TIMEOUT);
//		}
		
//		return redisService.getDiscountAmountVo(entity.getOrderId(), UtilMoney.subtractToDouble(order.getTotalAmount(), order.getReceiveCouponAmount()), entity.getCustomerId());
		return getAppResponseEntity(redisService.getDiscountAmountVo(entity.getOrderId(),entity.getCustomerId()));
	}
}
