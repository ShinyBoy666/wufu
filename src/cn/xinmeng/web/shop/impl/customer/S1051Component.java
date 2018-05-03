package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CustomerAccount;
import cn.xinmeng.api.enums.AccountTypeEnum;
import cn.xinmeng.api.service.ICustomerAccountService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 查询帐户信息
 * @param 
 * @ClassName: S1051Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1051Component")
public class S1051Component extends BaseService {
	
	@Resource
	private ICustomerAccountService customerAccountService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){

		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		CustomerAccount customerAccount = customerAccountService.selectByCustomerIdAndAccountType(Integer.valueOf(AccountTypeEnum.USER.key()), entity.getCustomerId());
		return getAppResponseEntity(customerAccount);
	}
	
	
}
