package cn.xinmeng.web.shop.entity.user;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 手机号码验证是否存在
 * @param 
 * @ClassName: S1005RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1005RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String username;//用户名
	private String cellphone;	//cellphone
	private Integer type;//1-注册，2-验证码登录，3-手机修改密码(新版：发送验证吗用),4-openid关联用户，5-返现：活动申请
	

	//set get

	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
