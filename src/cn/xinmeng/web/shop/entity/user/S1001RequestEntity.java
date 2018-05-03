package cn.xinmeng.web.shop.entity.user;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 会员登录
 * @param 
 * @ClassName: S1001RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:08:46 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1001RequestEntity extends RequestBaseEntity{
	
	private static final long serialVersionUID = 4164900864783271653L;
	
	/**
	 * 登录名
	 */
	private String loginName;
	/**
	 * 密码
	 */
	private String password;
	
	private String imei;//手机
	
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
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	
}
