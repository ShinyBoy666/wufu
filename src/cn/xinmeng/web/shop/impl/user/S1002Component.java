package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.user.S1002RequestEntity;

/**
 * 客户修改密码
 * @param 
 * @ClassName: S1002Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1002Component")
public class S1002Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1002RequestEntity entity = parseRequertParam(data, S1002RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getPassword())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_PASSWORD);
		}else if(Utils.isEmpty(entity.getNewPassword())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_NEW_PASSWORD);
		}
		//wap前端没有加密
		if("wap".equalsIgnoreCase(request.getSource())){
			entity.setPassword(UtilMD5.MD5(entity.getPassword()));
			entity.setNewPassword(UtilMD5.MD5(entity.getNewPassword()));
		}
		int customerId = entity.getCustomerId();
		String password = UtilMD5.MD5(entity.getPassword());
		String newPassword = UtilMD5.MD5(entity.getNewPassword());
		
		Customer customer = customerService.selectByPrimaryKey(customerId);
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		if(customer.getPassword().equals(password) == false){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExCustomerEnum.EX_ERROR_PASSWORD);
		}
		
		//修改密码
		return getAppResponseEntity(customerService.passwordReset(customerId, newPassword));
	}
	
	
}
