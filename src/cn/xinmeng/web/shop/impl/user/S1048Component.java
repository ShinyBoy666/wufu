package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.common.enums.ex.ExBaseEnum;
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
import cn.xinmeng.web.shop.entity.user.S1048RequestEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;

/**
 * 手机验证码修改密码
 * @param 
 * @ClassName: S1048Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1048Component")
public class S1048Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private ISmsService smsService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1048RequestEntity entity = parseRequertParam(data, S1048RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCellphone())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_LOGINNAME);
		}else if(Utils.isEmpty(entity.getSmsCode())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExBaseEnum.EX_NULL_SMS_CODE);
		}else if(Utils.isEmpty(entity.getNewPassword())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_PASSWORD);
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		//wap前端没有加密
		if("wap".equalsIgnoreCase(request.getSource())){
			entity.setNewPassword(UtilMD5.MD5(entity.getNewPassword()));
		}
		String cellphone = entity.getCellphone();
		String smsCode = entity.getSmsCode();
		String newPassword = UtilMD5.MD5(entity.getNewPassword());
		if(customerService.existsUser(cellphone,shopId) == false){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_USERNAME_NOT_HAVE_REGISTER);
		}
		Customer cust = customerService.queryCustomerByCellphone(cellphone,Integer.valueOf(StateEnum.EFFECTION.key()),shopId);
		if(Utils.isEmpty(cust)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_DISABLE);
		}
		//验证
		smsService.verifySmsCode(cellphone, smsCode);
		
		CustomerUser customerUser = new CustomerUser();
		CloneUtils.copyEntity(cust,customerUser);
		
		//修改密码
		Customer customer = new Customer();
		customer.setPassword(newPassword);
		customer.setId(customerUser.getId());
		customerService.updateSelectiveByPrimaryKey(customer);

		return getAppResponseEntity(customerUser);
	}
	
	
}
