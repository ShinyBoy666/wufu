package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExBaseEnum;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.user.S1000RequestEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;

/**
 * 会员注册
 * @param 
 * @ClassName: S1000Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1000Component")
public class S1000Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private ISmsService smsService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1000RequestEntity entity = parseRequertParam(data, S1000RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getLoginName())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_LOGINNAME);
		}else if(Utils.isEmpty(entity.getPassword())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_PASSWORD);
		}else if(Utils.isEmpty(entity.getSmsCode())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExBaseEnum.EX_NULL_SMS_CODE);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}
		//wap前端没有加密
		if("wap".equalsIgnoreCase(request.getSource())){
			entity.setPassword(UtilMD5.MD5(entity.getPassword()));
		}
		String loginName = entity.getLoginName();
		String smsCode = entity.getSmsCode();
		int shopId = entity.getShopId();
		String password = UtilMD5.MD5(entity.getPassword());
		String inviteCode = entity.getInviteCode();
		
		//用户是否被注册
		if(customerService.existsUser(loginName,shopId)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_USERNAME_HAVE_REGISTER);
		}
		
//		ShopInfo shopInfo = shopInfoService.queryShopInfoById(shopId, "shop_name");
//		if(shopInfo == null){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_NOTEXISTS_SHOP);
//		}
		
		//验证手机验证码是否有效
		smsService.verifySmsCode(loginName, smsCode);
		CustomerUser customerVo = new CustomerUser();
		Customer customer = customerService.registerUser(loginName, password,shopId, inviteCode,entity.getImei(),null);
		CloneUtils.copyEntity(customer, customerVo);
		customerVo.setAccountDeduct(systemConfigService.notNumberBalancePay(customer));
		customerVo.setHeadSculpture(Utils.getImageUrl(customerVo.getHeadSculpture(),"?300_300"));
		//注册用户
		return getAppResponseEntity(customerVo);
	}
	
	
}
