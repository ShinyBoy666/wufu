package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.api.service.ICustomerRechargeService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IOrderSubimtService;
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
import cn.xinmeng.web.shop.entity.customer.S1067RequestEntity;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;

/**
 * 会员充值
 * @param 
 * @ClassName: S1067Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1067Component")
public class S1067Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	@Resource
	private ICustomerRechargeService customerRechargeService;
	@Resource
	private IPaymentService paymentService;
	@Resource
	private IOrderSubimtService orderSubimtService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1067RequestEntity entity = parseRequertParam(data, S1067RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(PaymentGatewayEnum.exist(String.valueOf(entity.getOnlinePayType())) == false 
				&& (entity.isAccountDeduct() == false)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_PAY_WAY);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		PayOrderBiz payOrderBiz = orderSubimtService.vipSubmitOrder(entity, request.getSourceShopId(), request.getLoginShopId());
		
		//账户扣款与支付
		try {
			return getAppResponseEntity(paymentService.payOrder(payOrderBiz,request.getSource(),request.getLoginShopId(),request.getIp()));
		} catch (Exception e) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_PAY_FAILD_CREATE_ORDER,e);
		}
	}
	
	
}
