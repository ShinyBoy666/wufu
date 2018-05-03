package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.api.service.ISystemConfigService;
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
import cn.xinmeng.web.shop.entity.user.S1004RequestEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;

/**
 * 手机验证码登录
 * @param 
 * @ClassName: S1004Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1004Component")
public class S1004Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private ISmsService smsService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1004RequestEntity entity = parseRequertParam(data, S1004RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCellphone())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_LOGINNAME);
		}else if(Utils.isEmpty(entity.getSmsCode())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExBaseEnum.EX_NULL_SMS_CODE);
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		String cellphone = entity.getCellphone();
		String smsCode = entity.getSmsCode();
//		if(customerService.existsUser(cellphone,shopId) == false){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_USERNAME_NOT_HAVE_REGISTER);
//		}
		
		//验证
		smsService.verifySmsCode(cellphone, smsCode);
		Customer customer = customerService.queryCustomerByCellphone(cellphone,Integer.valueOf(StateEnum.EFFECTION.key()),shopId);
		if(Utils.isEmpty(customer)){
			//未注册 注册用户
			customer = customerService.registerUser(cellphone, UtilMD5.MD5(smsCode),shopId, null,entity.getImei(),null);
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_DISABLE);
		}

		CustomerUser customerVo = new CustomerUser();
		CloneUtils.copyEntity(customer, customerVo);
		customerVo.setAccountDeduct(systemConfigService.notNumberBalancePay(customer));
		customerVo.setHeadSculpture(Utils.getImageUrl(customerVo.getHeadSculpture(),"?300_300"));
		return getAppResponseEntity(customerVo);
	}
	
	
}
