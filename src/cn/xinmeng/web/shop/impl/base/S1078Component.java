package cn.xinmeng.web.shop.impl.base;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.order.vo.ResponseOrderBiz;

/**
 * 店铺入住申请
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1078Component")
public class S1078Component extends BaseService {

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Integer rechargeType = Integer.valueOf(PaymentGatewayEnum.PAY_GATEWAY_WE_CHAT.key());
		
		ResponseOrderBiz biz = new ResponseOrderBiz();
		biz.setOrderId("");
		biz.setRechargeId("");
		biz.setTotalAmount(0.0);
		biz.setPaymentAmount(0.0);
		biz.setSource(request.getSource());
		biz.setUrl(rechargeType+"",request.getLoginShopId(),request.getIp());
		return getAppResponseEntity(biz);
	}
}
