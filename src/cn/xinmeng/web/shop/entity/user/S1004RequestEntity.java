package cn.xinmeng.web.shop.entity.user;

import cn.xinmeng.web.base.entity.RequestBaseEntity;


/**
 * 验证码登录
 * @param 
 * @ClassName: S1004RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:17:24 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1004RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = -7066668767153816072L;
	
	public String cellphone;	//手机
	public String smsCode;		//短信验证码
	private String imei;//手机imei
	
	//set get

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

}
