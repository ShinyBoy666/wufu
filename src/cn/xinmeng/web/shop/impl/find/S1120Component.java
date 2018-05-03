package cn.xinmeng.web.shop.impl.find;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.service.ICustomerRewardConfigService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.find.S1120RequestEntity;
import cn.xinmeng.web.shop.entity.find.S1120ResponseEntity;

/**
 * 增值服务费用
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.find.S1120Component")
public class S1120Component extends BaseService {
	
	@Resource
	private ICustomerRewardConfigService customerRewardConfigService;
	@Resource
	private ICustomerService customerService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1120RequestEntity entity = parseRequertParam(data, S1120RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
//		}else if(Utils.isEmpty(entity.getType())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExBaseEnum.EX_NULL_TYPE);
		}
		Customer customer = customerService.selectByPrimaryKey(entity.getCustomerId());
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		} 
		S1120ResponseEntity result = new S1120ResponseEntity();
		result.setType(1);
		result.setAmount(customerRewardConfigService.queryVipAmount(request.getLoginShopId()));
		result.setRemark("会员充值");
		result.setAccountDeduct(true);
		result.setCashAmount(customer.getCashAmount());
		return getAppResponseEntity(result);
	}
}
