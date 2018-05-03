package cn.xinmeng.web.shop.entity.base;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 发送短信内容
 * @param 
 * @ClassName: S1043RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1065RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private Integer type;	//1-非会员帐户支付，2-非会员余额提现


	//set get
	
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
