package cn.xinmeng.common.mail.impl;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import cn.xinmeng.common.mail.MailEngineService;
import cn.xinmeng.common.mail.MailEnum;
import cn.xinmeng.common.util.LogManager;

public class MailEngineServiceImpl implements MailEngineService{
	
	private VelocityEngine velocityEngine;
	private MailSender mailSender;
	private InternetAddress adminInternetAddress;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	public void setAdminInternetAddress(InternetAddress adminInternetAddress) {
		this.adminInternetAddress = adminInternetAddress;
	}

	/**
	 * 通过模板产生邮件正文
	 * 
	 * @param templateName
	 *            邮件模板名称
	 * @param map
	 *            模板中要填充的对象
	 * @return 邮件正文（HTML）
	 */
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public String generateEmailContent(String templateName, Map map) {
		// 使用Vilocity模板
		try {
			return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, map);
		} catch (VelocityException e) {
			LogManager.error(this.getClass(),e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 发送邮件
	 * 
	 * @param emailAddress
	 *            收件人Email地址的数组
	 * @param fromEmail
	 *            寄件人Email地址, null为默认寄件人web@maitian.cn
	 * @param bodyText
	 *            邮件正文
	 * @param subject
	 *            邮件主题
	 * @param attachmentName
	 *            附件名
	 * @param resource
	 *            附件
	 * @throws MessagingException
	 */
	public void sendMessage(String[] emailAddresses, String fromEmail, String bodyText, String subject, String attachmentName, ClassPathResource resource) throws MessagingException {
		MimeMessage message = ((JavaMailSenderImpl) mailSender).createMimeMessage();
		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(emailAddresses);
		if (fromEmail != null) {
			helper.setFrom(fromEmail);
		}
		helper.setText(bodyText, true);
		helper.setSubject(subject);

		if (attachmentName != null && resource != null)
			helper.addAttachment(attachmentName, resource);

		((JavaMailSenderImpl) mailSender).send(message);
	}

	/**
	 * 发送简单邮件
	 * 
	 * @param msg
	 */
	public void send(SimpleMailMessage msg) {
		try {
			((JavaMailSenderImpl) mailSender).send(msg);
		} catch (MailException ex) {
			// log it and go on
			LogManager.error(this.getClass(),ex.getMessage());
		}
	}

	/**
	 * 系统发送邮件
	 * @param title
	 * @param templateName
	 * @param model
	 * @param receive
	 */
	public void sendEmail(MailEnum mailEnum,Map model,String ... receive){
		String content = generateEmailContent(mailEnum.key(), model);
		sendEmail(mailEnum.value(), content, receive);
	}

	/**
	 * 系统发送邮件
	 * @param title
	 * @param content
	 * @param receive
	 */
	public void sendEmail(String title,String content,String ... receive){
		MimeMessage mimeMsg = null;
		try {
			mimeMsg = ((JavaMailSenderImpl) mailSender).createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "utf-8");
			helper.setTo(receive);
			helper.setCc(receive);
			helper.setSubject(title);
			helper.setFrom(adminInternetAddress);

			helper.setText(content, true);

			((JavaMailSenderImpl) mailSender).send(mimeMsg);
		} catch (Exception e) {
			LogManager.error(this.getClass(),e.getMessage());
		}
	}
}