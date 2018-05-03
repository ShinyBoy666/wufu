package cn.xinmeng.web.shop.impl.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.base.S1065RequestEntity;

/**
 * 系统配置，余额提现，支付
 * @param 
 * @ClassName: S1065Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1065Component")
public class S1065Component extends BaseService {
	
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private ICustomerService customerService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1065RequestEntity entity = parseRequertParam(data, S1065RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		
		if(customerService.isMember(entity.getCustomerId())){
			//会员可以操作一切
			return getAppResponseEntity(true);
		}
		
		if(entity.getType() == 1){
			//帐户支付
			return getAppResponseEntity(systemConfigService.notNumberBalancePay());
		}else if(entity.getType() == 2){
			//帐户提现
			return getAppResponseEntity(systemConfigService.notNumberWithdrawals());
		}
		return getAppResponseEntity(false);
	}
	
	
}
