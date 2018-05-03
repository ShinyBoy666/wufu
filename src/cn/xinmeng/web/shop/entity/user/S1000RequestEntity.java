package cn.xinmeng.web.shop.entity.user;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/** 
 * 会员注册
 * @param 
 * @ClassName: S1000RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午3:58:16 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1000RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 8621960133010140596L;
	
	private String loginName;	//必填：登录名
	private String password;	//必填：登录密码（密码传递前MD5加密）
	private String smsCode;		//短信验证码
	private String inviteCode;	//邀请码
	private String imei;		//手机imei
	
	//set get
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	
}
