package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
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
@Component ("cn.xinmeng.web.shop.impl.user.S1083Component")
public class S1083Component extends BaseService {
	
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
		
		//验证
		smsService.verifySmsCode(cellphone, smsCode);
		
		Customer customer = customerService.queryCustomerByCellphone(cellphone, null,shopId);
		if(Utils.isEmpty(customer)){
			//创建用户
			customer = customerService.registerUser(cellphone, Utils.default_password, entity.getShopId(), null, request.getImei(),entity.getOpenId());
		}else{
			//修改绑定openid
			if(!Utils.isEmpty(entity.getOpenId()) && !entity.getOpenId().equals(customer.getOpenId())){
				//解除原先openId的绑定关系
				customerService.reSetOpenId(entity.getOpenId());
				
				customer.setOpenId(entity.getOpenId());
				customerService.updateByPrimaryKey(customer);
			}
		}
		
		CustomerUser customerVo = new CustomerUser();
		CloneUtils.copyEntity(customer, customerVo);
		return getAppResponseEntity(customerVo);
	}
	
	
}
