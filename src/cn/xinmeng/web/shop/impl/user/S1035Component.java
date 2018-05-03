package cn.xinmeng.web.shop.impl.user;

import java.text.MessageFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.example.CustomerExample;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.user.S1005RequestEntity;
import cn.xinmeng.web.thread.SendSmsThread;

/**
 * 发送短信验证吗
 * @param 
 * @ClassName: S1005Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1035Component")
public class S1035Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private ISmsService smsService;
	@Resource
	private TaskExecutor sendMessageThreadPool;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1005RequestEntity entity = parseRequertParam(data, S1005RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCellphone())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_LOGINNAME);
		}else if(Utils.isEmpty(entity.getType())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		if(entity.getType() == 5){
			String smsCode = Utils.random(4);
			String smsContent = MessageFormat.format(HelperPropertie.getValue("sms.template.verifyCode"), smsCode);
			sendMessageThreadPool.execute(new SendSmsThread(smsService, entity.getCellphone(), smsContent, smsCode, shopId, entity.getCustomerId()));
			return getAppResponseEntity(true);
		}else{
			//1-注册，2-验证码登录，3-手机验证码修改密码
			CustomerExample customerExample = new CustomerExample();
			customerExample.setOrderByClause("state desc,id desc");
			customerExample.setFieldList("id,state");
			CustomerExample.Criteria customerCriteria = customerExample.createCriteria();
			customerCriteria.andCellphoneEqualTo(entity.getCellphone());
			List<Customer> list = customerService.selectByExample(customerExample);
			if(entity.getType() == 1){
				if(!Utils.isEmpty(list)){
					if(list.get(0).getState() == 1){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_DISABLE);
					}else{
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_USERNAME_HAVE_REGISTER);
					}
				}
			}else if(entity.getType() == 2){
				if(!Utils.isEmpty(list)){
					if(list.get(0).getState() == 1){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_DISABLE);
					}
				}else{
//					throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_USERNAME_NOT_HAVE_REGISTER);
				}
			}else if(entity.getType() == 3){
				if(!Utils.isEmpty(list)){
					if(list.get(0).getState() == 1){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_DISABLE);
					}
				}else{
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_USERNAME_NOT_HAVE_REGISTER);
				}
			}else if(entity.getType() == 4){
				if(!Utils.isEmpty(list)){
					if(list.get(0).getState() == 1){
						throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_PHONE_DISABLE);
					}
				}
			}else{
				return getAppResponseEntity(false);
			}
			

			String smsCode = Utils.random(4);
			String smsContent = MessageFormat.format(HelperPropertie.getValue("sms.template.verifyCode"), smsCode);
			sendMessageThreadPool.execute(new SendSmsThread(smsService, entity.getCellphone(), smsContent, smsCode, shopId, entity.getCustomerId()));
			return getAppResponseEntity(true);
		}
	}
	
	
}
