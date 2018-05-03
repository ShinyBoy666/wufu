package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.constant.ConstantSystem;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.api.service.ICustomerRechargeService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.order.vo.ResponseOrderBiz;

/**
 * 充值
 * @param 
 * @ClassName: S1022Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1029Component")
public class S1029Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	@Resource
	private ICustomerRechargeService customerRechargeService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		CustomerRecharge recharge = parseRequertParam(data, CustomerRecharge.class);
		if(recharge == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(recharge.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(recharge.getAmount()) || recharge.getAmount() < 0) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_RECHARGE_AMOUNT_ERROR);
		}else if(Utils.isEmpty(recharge.getRechargeType())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_PAY_WAY);
		}else if(!PaymentGatewayEnum.exist(recharge.getRechargeType()+"")) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NOTEXIST_PAY_WAY);
		}else if(Utils.isEmpty(recharge.getRechareFrom())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_RECHARE_SOURCE);
		}
		Customer customer = customerService.selectByPrimaryKey(recharge.getCustomerId());
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		recharge.setCustomerName(customer.getNickname());
		String prefix = ConstantSystem.PAYMENT_NO_RECHARGE_PREFIX;//支付单号前缀
		recharge.setRechargeId(prefix+Utils.createNumber(recharge.getCustomerId()));
		recharge.setOrderId(prefix);
		
		if(customerRechargeService.add(recharge) > 0){
			ResponseOrderBiz orderReturnBiz = new ResponseOrderBiz();
			orderReturnBiz.setOrderDescribe("充值");
			orderReturnBiz.setPaymentAmount(recharge.getAmount());
			orderReturnBiz.setRechargeId(recharge.getRechargeId());
			orderReturnBiz.setSource(request.getSource());
			orderReturnBiz.setUrl(recharge.getRechargeType()+"",request.getLoginShopId(),request.getIp());
			return getAppResponseEntity(orderReturnBiz);
		}
		throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_ERROR_PAYMENT_ID);
	}
	
	
}
