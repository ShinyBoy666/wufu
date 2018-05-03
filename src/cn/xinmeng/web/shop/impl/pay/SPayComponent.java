package cn.xinmeng.web.shop.impl.pay;

import java.text.MessageFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.api.entity.auto.SystemErrorLog;
import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.api.enums.RechargeStateEnum;
import cn.xinmeng.api.service.ICustomerRechargeService;
import cn.xinmeng.api.service.IPaymentService;
import cn.xinmeng.api.service.ISystemErrorLogService;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
/**
 * 
 * <p class="detail">支付回调 业务</p>
 * 
 * @param 
 * @ClassName: SPayComponent 
 * @version V1.0  @date 2015年11月19日 下午4:41:03 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.pay.SPayComponent")
public class SPayComponent{

	@Resource
	private ICustomerRechargeService customerRechargeService;
	
	@Resource
	private IPaymentService paymentService;
	
	@Resource
	private ISystemErrorLogService systemErrorLogService;
	
	/**
	 * 
	 * <p class="detail"> 支付回调 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2015年11月24日 下午4:45:18
	 * @param rechargeId
	 * @param tradeNumber
	 * @param amount
	 */
	public void callback(String rechargeId,String tradeNumber,String amount) {
		String message = null;
		try {
			if(Utils.isEmpty(rechargeId)|| Utils.isEmpty(tradeNumber)){
				message = ExRequestEnum.REQUEST_DATA.value();
			}else{
				CustomerRecharge recharge = customerRechargeService.searchByRechargeId(rechargeId);
				if(recharge == null){
					message = ExPaymentEnum.EX_RECHARE_ID_NOT_EXISTS.value();
				}else if(RechargeStateEnum.STATE_SUCCESS.key().equals(recharge.getState()+"")){
					message = ExPaymentEnum.EX_RECHARE_ID_HAVE_PROCESS.value();
				}else{
					Double d = Double.parseDouble(amount);
					if(PaymentGatewayEnum.PAY_GATEWAY_WE_CHAT.key().equals(recharge.getRechargeType()+"")){
						d = UtilMoney.divideToDouble(d, 100d);
					}
					message = paymentService.payReturn(recharge, tradeNumber,d);
				}
			}
		} catch (Exception e) {
			message = Utils.exceptionConvertStr(e);
		}
		
		if(!Utils.isEmpty(message)){
			SystemErrorLog errorLog = new SystemErrorLog();
			errorLog.setDescription("API异常：支付回调");
			errorLog.setPri(10);
			errorLog.setPlatform(1);
			errorLog.setCreateUser("API");
			errorLog.setIp("0.0.0.0");
			errorLog.setActionType(4);
			errorLog.setErrorInformation(message);
			errorLog.setRunCommand(MessageFormat.format("rechargeId={0},tradeNumber={1},amount={2}", rechargeId,tradeNumber,amount));
			errorLog.setInformed(0);
			errorLog.setCreateTime(new Date());
			systemErrorLogService.add(errorLog);
		}
	}
	

}
