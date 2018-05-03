package cn.xinmeng.web.shop.impl.customer;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerAccount;
import cn.xinmeng.api.entity.auto.Enchashment;
import cn.xinmeng.api.service.ICustomerAccountService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IEnchashmentService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.thread.SendSmsThread;

/**
 * 提现
 * @param 
 * @ClassName: S1030Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1030Component")
public class S1030Component extends BaseService {
	
	@Resource
	private IEnchashmentService enchashmentService;
	@Resource
	private ICustomerAccountService customerAccountService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private TaskExecutor sendMessageThreadPool;
	@Resource
	private ISmsService smsService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Enchashment enchashment = parseRequertParam(data, Enchashment.class);
		if(null == enchashment){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if (Utils.isEmpty(enchashment.getCustomerId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if (Utils.isEmpty(enchashment.getEnchashmentType())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_EXTRACT_CASH_TYPE);
		}else if (enchashment.getEnchashmentType() != 1) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),"目前仅支持提现到支付宝账户");
		}else if (Utils.isEmpty(enchashment.getAmount()) || enchashment.getAmount() < 10) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_ERROR_CASH_MONET);
		}
		Customer customer = customerService.selectByPrimaryKey(enchashment.getCustomerId());
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		
		if(customerService.isMember(customer) == false && systemConfigService.notNumberWithdrawals() == false){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NOT_VIP_CASH_MONET);
		}

		CustomerAccount customerAccount = customerAccountService.selectByCustomerIdAndAccountType(1, enchashment.getCustomerId());
		if(customerAccount == null || Utils.isEmpty(customerAccount.getAlipay()) || Utils.isEmpty(customerAccount.getRealname())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NOTEXIST_ALIPAY);
		}
		enchashment.setAccountType(1);
		// 设置：支付宝信息
		enchashment.setAlipay(customerAccount.getAlipay());
		// 设置：真实名称
		enchashment.setRealname(customerAccount.getRealname());
		//设置：微信账户
		enchashment.setWechat("");
		//设置：银行卡号
		enchashment.setBankCard("");
		// 设置：银行名称
		enchashment.setBankName("");
		// 设置：支行名称
		enchashment.setBankBranch("");
		// 设置：身份证
		enchashment.setIdentityCard("");
		// 设置：手机号码
		enchashment.setCellphone(customer.getCellphone());
		if(enchashmentService.add(enchashment) > 0){
			//，发送短信
//			if(request.getLoginShopId() == 1){
				String smsContent = "您好，"+DateUtil.formatDate(new Date(), "MM-dd日HH:mm分")+"有用户申请提现请及时处理！";
				sendMessageThreadPool.execute(new SendSmsThread(smsService, "13578742552", smsContent, null, request.getLoginShopId(), enchashment.getCustomerId()));
//			}
			return getAppResponseEntity(true);
		}
		return getAppResponseEntity(false);
	}
}
