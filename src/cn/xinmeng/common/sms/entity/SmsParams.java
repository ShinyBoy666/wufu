package cn.xinmeng.common.sms.entity;

import java.io.Serializable;

import cn.xinmeng.common.util.UtilMD5;

public class SmsParams implements Serializable{
	private static final long serialVersionUID = -3874598994140974713L;
	
	
	private String account = "dh13661";
	private String password = UtilMD5.MD5("7M84rlzd");
//	private String sign = "【舜凯云商】";
	private String sign = "";
	private String subcode;
	private String msgid;
	private String sendtime;
	private String phones;
	private String content;

	public SmsParams(){}
	
	public SmsParams(String phones){
		this.phones = phones;
	}
	
	public SmsParams(String phones,String content){
		this.phones = phones;
		this.content = content;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
