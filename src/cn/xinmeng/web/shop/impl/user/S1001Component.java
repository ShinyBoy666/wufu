package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.user.S1001RequestEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;

/**
 * 会员登录
 * @param 
 * @ClassName: S1001Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1001Component")
public class S1001Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private ISystemConfigService systemConfigService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1001RequestEntity entity = parseRequertParam(data, S1001RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getLoginName())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_LOGINNAME);
		}else if(Utils.isEmpty(entity.getPassword())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_PASSWORD);
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		//wap前端没有加密
		if("wap".equalsIgnoreCase(request.getSource())){
			entity.setPassword(UtilMD5.MD5(entity.getPassword()));
		}
		String loginName = entity.getLoginName();
		String password = UtilMD5.MD5(entity.getPassword());
		Customer customer = customerService.queryCustomerByCellphone(loginName,Integer.valueOf(StateEnum.EFFECTION.key()),shopId);
		if(customer == null){
			if(customerService.existsUser(loginName,shopId)){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_DISABLE);
			}
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}else if(false == password.equals(customer.getPassword())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_ERROR_PASSWORD);
		}
		
		//更新token
		String token = customerService.updateToken(customer.getId(), customer.getToken());
		customer.setToken(token);

		CustomerUser customerVo = new CustomerUser();
		CloneUtils.copyEntity(customer, customerVo);
		customerVo.setAccountDeduct(systemConfigService.notNumberBalancePay(customer));
		customerVo.setHeadSculpture(Utils.getImageUrl(customerVo.getHeadSculpture(),"?300_300"));
		return getAppResponseEntity(customerVo);
	}
}
