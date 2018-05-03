package cn.xinmeng.common.sms.entity;

import java.io.Serializable;

public class SmsResponse implements Serializable{
	
	private static final long serialVersionUID = -3874598994110974713L;
	
	private String msgid;
	private String result;
	private String desc;
	private String failPhones;
	private String blacklist;
	
	
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getFailPhones() {
		return failPhones;
	}
	public void setFailPhones(String failPhones) {
		this.failPhones = failPhones;
	}
	public String getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}
	
	
}
