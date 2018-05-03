package cn.xinmeng.common.sms;

import cn.xinmeng.common.enums.ex.ExSmsEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.sms.entity.SmsParams;
import cn.xinmeng.common.sms.entity.SmsResponse;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.http.HttpClient;

public class SmsUtils {
	
	//发送短信验证码
	private static String sendUrl = "http://wt.3tong.net/json/sms/Submit";
	//检测黑名单
	private static String black = "http://wt.3tong.net/json/sms/BlackListCheck";
	
	/**
	 * 发送短信验证吗
	 * @param phone
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	public static boolean sendSms(String phone,String content){
		SmsParams sms = new SmsParams(phone, content);
		HttpClient client = HttpClient.getInstance();
		try {
			if(blackPhone(phone)){
				throw new BusinessException(LogManager.getLogger(SmsUtils.class),ExSmsEnum.EX_BLACK_PHONE);
			}
			String result = client.doPost(sendUrl, FastJsonUtils.bean2Json(sms));
			SmsResponse response = FastJsonUtils.json2Bean(result, SmsResponse.class);
			if(response != null && "0".equals(response.getResult())){
				return true;
			}
			return false;
		} catch (Exception e) {
			LogManager.error(SmsUtils.class,e.getMessage(), e);
			throw new BusinessException(LogManager.getLogger(SmsUtils.class),ExSmsEnum.EX_SMS_FAILD);
		}
	}
	
	/**
	 * 检查手机号码
	 * @param phone
	 * @return
	 */
	public static boolean blackPhone(String phone){
		SmsParams sms = new SmsParams(phone);
		HttpClient client = HttpClient.getInstance();
		try {
			String result = client.doPost(black, FastJsonUtils.bean2Json(sms));
			SmsResponse response = FastJsonUtils.json2Bean(result, SmsResponse.class);
			if(response == null){
				return false;
			}
			if(response.getBlacklist() != null && response.getBlacklist().contains(phone)){
				return true;
			}
		} catch (Exception e) {
			LogManager.error(SmsUtils.class,e.getMessage(), e);
			throw new BusinessException(LogManager.getLogger(SmsUtils.class),ExSmsEnum.EX_PHONE_CHECK);
		}
		return false;
	}
	
}
