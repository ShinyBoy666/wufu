package cn.xinmeng.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	private static final String PORT = "25";
	private static final String FROM = "舜凯云商";//发送者,显示的发件人名字
	private static final String USER = "server@51shunkai.com";//发送者邮箱地址
	private static final String SERVER = "smtp.exmail.qq.com";
	private static final String PASSWORD = "P@ssw0rd11026";//密码
	private static final String ENCODING = "UTF-8";//邮件编码
	
	private static Session session;
	
	public static void initSession() {
		Properties props = new Properties();
        props.put("mail.smtp.host", SERVER);//SMTP服务器地址
        props.put("mail.smtp.port", PORT);//端口
        props.put("mail.smtp.auth", "true");//SMTP服务器是否需要用户认证，默认为false
        props.put("mail.stmp.timeout", "2000");
		session = Session.getInstance(props, new Authenticator() { 
        	 // 验账账户
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER,PASSWORD);
            }
        });
	}
	
	/**
	 * 
	 * <p class="detail"> 发送邮件 </p>
	 * @author <a href="mailto:niukun@taojinzi.com ">牛坤</a> 2016年1月7日 下午2:38:21
	 * @param title 标题
	 * @param html 内容
	 * @param recipients 收件人
	 * @throws Exception
	 */
	public static void sendEmail(String title,String html,InternetAddress ... recipients){
		try {
			if(Utils.isEmpty(title) || Utils.isEmpty(html) || recipients == null || recipients.length == 0){
				return;
			}
	    	if(null==session){
	    		initSession();
	    	}
	    	MimeMessage msg = new MimeMessage(session);
	        msg.setSentDate(new Date());
	        msg.setFrom(new InternetAddress(USER,FROM,ENCODING));
	        
	        //这里可以添加多个目的用户
	        for (InternetAddress recipient : recipients) {
	        	msg.addRecipient(Message.RecipientType.TO,recipient);
			}
	        
	        msg.setSubject(title, ENCODING);   
	        
	        //设置邮件内容格式为混合内容  
	        MimeMultipart msgMultipart = new MimeMultipart("mixed");  
	        MimeBodyPart mbp = new MimeBodyPart();  
	        //设置html内容  
	        mbp.setContent(html,"text/html;charset=utf-8");
	        msgMultipart.addBodyPart(mbp); 
	        msg.setContent(msgMultipart);
	        Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * <p class="detail"> 生成收件人 </p>
	 * @author <a href="mailto:niukun@taojinzi.com ">牛坤</a> 2016年1月7日 下午2:38:42
	 * @param email 邮箱
	 * @param name 名称
	 * @return
	 * @throws Exception
	 */
	public static InternetAddress getRecipient(String email,String name){
		try {
			return new InternetAddress(email, name, ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    /**
     * 
     * <p class="detail"> 测试 </p>
     * @author <a href="mailto: "></a> 2014-5-28 下午1:29:23
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String args[]) throws UnsupportedEncodingException{
    	String content = "<STYLE type=\"text/css\">BODY { font-size: 14px; line-height: 1.5  } </STYLE><html><head><meta http-equiv=Content-Type content=\"text/html; charset=utf-8\"/></head><body><h1>这个是一个测试邮件:<a href=\"http://www.baidu.com\">百度的连接</h1></body></html>";
		sendEmail("系统邮件", content, getRecipient("tanjiangyong@51shunkai.com", "test"));
        System.out.println("ok");
    }
}

