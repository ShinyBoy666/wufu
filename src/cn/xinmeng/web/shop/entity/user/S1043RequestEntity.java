package cn.xinmeng.web.shop.entity.user;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 发送手机验证码
 * @param 
 * @ClassName: S1043RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1043RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String cellphone;	//cellphone
	

	//set get

	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	
}
