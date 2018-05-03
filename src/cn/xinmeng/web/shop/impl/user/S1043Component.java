package cn.xinmeng.web.shop.impl.user;

import java.text.MessageFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Sms;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.sms.SmsUtils;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.user.S1043RequestEntity;

/**
 * 发送短信验证码
 * @param 
 * @ClassName: S1043Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1043Component")
public class S1043Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private ISmsService smsService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1043RequestEntity entity = parseRequertParam(data, S1043RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCellphone())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_LOGINNAME);
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		String num = Utils.random(4);
		String smsContent = MessageFormat.format(HelperPropertie.getValue("sms.template.verifyCode"), num);
		boolean flag = SmsUtils.sendSms(entity.getCellphone(),smsContent);
		if(flag){
			Sms sms = new Sms();
			sms.setCreateTime(new Date());
			sms.setCreateUser("api");
			sms.setCustomerId(entity.getCustomerId());
			sms.setFromType(1);
			sms.setReceivePhone(entity.getCellphone());
			sms.setShopId(shopId == 0 ? "" : shopId+"");
			sms.setSmsCode(num);
			sms.setSmsContent(smsContent);
			sms.setState(2);//已发送
			smsService.add(sms);
		}
		
		return getAppResponseEntity(flag,flag ?  "发送验证码成功": "发送验证码失败");
	}
	
	
}
