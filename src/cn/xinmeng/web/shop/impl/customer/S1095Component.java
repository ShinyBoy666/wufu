package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.WechatAccount;
import cn.xinmeng.api.service.IWechatAccountService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1095ResponseEntity;

/**
 * 查询微信信息
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1095Component")
public class S1095Component extends BaseService {
	
	@Resource
	private IWechatAccountService wechatAccountService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data,RequestBaseEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getOpenId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_OPEN_ID);
		}
		WechatAccount wechatAccount = wechatAccountService.getWechatAccount(entity.getOpenId());
		if(wechatAccount == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_USER_NOT_EXISTS);
		}
		S1095ResponseEntity result = new S1095ResponseEntity();
		CloneUtils.cloneEntity(wechatAccount, result);
		return getAppResponseEntity(result);
	}
	
	
}
