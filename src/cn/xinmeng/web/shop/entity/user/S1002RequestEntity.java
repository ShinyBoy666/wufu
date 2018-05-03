package cn.xinmeng.web.shop.entity.user;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 修改密码
 * @param 
 * @ClassName: S1002RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:10:51 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1002RequestEntity extends RequestBaseEntity{
	
	private static final long serialVersionUID = 3731559427522609483L;
	
	private String password;	//必填：原密码 （密码传递前MD5加密）
	private String newPassword;	//必填：新密码 （密码传递前MD5加密）
	
	
	//set get
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
}
