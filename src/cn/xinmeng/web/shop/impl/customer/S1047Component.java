package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CustomerAccount;
import cn.xinmeng.api.service.ICustomerAccountService;
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

/**
 * 
 * <p class="detail">绑定支付宝信息</p>
 * 
 * @param 
 * @ClassName: S1047Component 
 * @version V1.0  @date 2016年2月29日 上午11:20:05 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1047Component")
public class S1047Component extends BaseService {
	
	@Resource
	private ICustomerAccountService customerAccountService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		CustomerAccount account = parseRequertParam(data, CustomerAccount.class);
		if(account == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(account.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(account.getAlipay())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_ALIPAY);
		}else if(Utils.isEmpty(account.getRealname())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_ALIPAY_REALNAME);
		}
		CustomerAccount customerAccount = customerAccountService.selectByCustomerIdAndAccountType(1, account.getCustomerId());
		boolean isOK = false;
		if(customerAccount == null){
			customerAccount = new CustomerAccount();
			customerAccount.setAccountType(1);
			customerAccount.setCustomerId(account.getCustomerId());
			customerAccount.setAlipay(account.getAlipay());
			customerAccount.setRealname(account.getRealname());
			if(customerAccountService.add(customerAccount) > 0){
				isOK = true;
			}
		}else{
			customerAccount.setAlipay(account.getAlipay());
			customerAccount.setRealname(account.getRealname());
			if(customerAccountService.updateByPrimaryKey(customerAccount) > 0){
				isOK = true;
			}
		}
		return getAppResponseEntity(isOK);
	}
	
	
}
