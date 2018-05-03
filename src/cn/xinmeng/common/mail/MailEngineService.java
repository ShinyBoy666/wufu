package cn.xinmeng.common.mail;

import java.util.Map;

public interface MailEngineService {
	
	/**
	 * 系统发送邮件
	 * @param title
	 * @param templateName
	 * @param model
	 * @param receive
	 */
	@SuppressWarnings("rawtypes")
	public void sendEmail(MailEnum mailEnum,Map model,String ... receive);

	/**
	 * 系统发送邮件
	 * @param title
	 * @param content
	 * @param receive
	 */
	public void sendEmail(String title,String content,String ... receive);
}
