package cn.xinmeng.web.shop.impl.pay;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IPaymentService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;

/**
 * 再次支付
 * @param 
 * @ClassName: S1023Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.pay.S1023Component")
public class S1023Component extends BaseService {
	
	@Resource
	private IOrderService orderService;
	@Resource
	private IPaymentService paymentService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		PayOrderBiz entity = parseRequertParam(data, PayOrderBiz.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(entity.isAccountDeduct() == false && PaymentGatewayEnum.exist(String.valueOf(entity.getOnlinePayType())) == false){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_PAY_WAY);
		}
		//查询支付订单
		String fieldList = "total_amount,discount_amount,coupon_payment,postage,account_payment";
		Order order = orderService.queryByOrderId(entity.getParentOrderId(), fieldList);
		if(order == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
		}
		//组装支付相关金额
		entity.setPaidAccountPayment(order.getAccountPayment());
		entity.setTotalAmount(order.getTotalAmount());
		entity.setPostage(order.getPostage());
		entity.setCouponPayment(order.getCouponPayment());
		entity.setDiscountAmount(order.getDiscountAmount());
		
		//再次支付
		return getAppResponseEntity(paymentService.payOrder(entity,request.getSource(),request.getLoginShopId(),request.getIp()));
	}
	
}
