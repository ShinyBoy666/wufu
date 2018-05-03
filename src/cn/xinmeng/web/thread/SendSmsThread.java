package cn.xinmeng.web.thread;

import java.util.Date;

import cn.xinmeng.api.entity.auto.Sms;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.common.sms.SmsUtils;
import cn.xinmeng.common.util.LogManager;

@SuppressWarnings("all")
public class SendSmsThread implements Runnable{

	private ISmsService smsService;
	private String cellphone;
	private String content;
	private String smsCode;
	private Integer loginShopId;
	private Integer customerId;
	
	public SendSmsThread(ISmsService smsService,String cellphone,String content,String smsCode,Integer loginShopId,Integer customerId){
		this.smsService = smsService;
		this.cellphone = cellphone;
		this.content = content;
		this.smsCode = smsCode;
		this.loginShopId = loginShopId;
		this.customerId = customerId;
	}
	
	@Override
	public void run() {
		
		try {
			if(smsService != null){
				boolean flag = SmsUtils.sendSms(cellphone,content);
				Sms sms = new Sms();
				if(flag){
					sms.setState(2);//已发送
				}else{
					sms.setState(3);//发送失败
				}
				sms.setCreateTime(new Date());
				sms.setCreateUser("api");
				sms.setCustomerId(customerId);
				sms.setFromType(1);
				sms.setReceivePhone(cellphone);
				sms.setShopId(loginShopId == null ? "" : loginShopId+"");
				sms.setSmsCode(smsCode);
				sms.setSmsContent(content);
				smsService.add(sms);
			}
		} catch (Exception e) {
			LogManager.error(this.getClass(),"记录接口日志异常：",e);
		}
	}
	
	

}
