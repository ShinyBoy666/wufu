package cn.xinmeng.web.shop.impl.market;

import java.text.MessageFormat;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.common.enums.ex.ExCouponEnum;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1099RequestEntity;

/**
 * 领取优惠劵
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1099Component")
public class S1099Component extends BaseService {

	@Resource
	private ICouponService couponService;
	
	@Resource
	private IQuickOrderService quickOrderService;
	
	@Resource
	private ICustomerService customerService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1099RequestEntity entity = parseRequertParam(data, S1099RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
//		}else if(Utils.isEmpty(entity.getUseShopId())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_USE_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getCouponApplyId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NULL_COUPONAPPLYID);
		}else if(Utils.isEmpty(entity.getOrderId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_ID);
		}
		Customer customer = customerService.selectByPrimaryKey(entity.getCustomerId());
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
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
		//验证是否是当前用户
		if(!order.getOpenId().equals(customer.getOpenId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()), "用户信息和下单信息不一致...");
		}
		//返回值：1-领取成功，2-已经领完，3-现领张数达到
		entity.setShopId(request.getLoginShopId());
		return getAppResponseEntity(couponService.addCoupon(entity,entity.getOrderId()));
	}
}
