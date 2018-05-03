package cn.xinmeng.web.shop.entity.quickorder;

import cn.xinmeng.web.base.entity.PageSearchEntity;


/**
 * 我的订单查询
 * @param 
 * @ClassName: S1018RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1084RequestEntity extends PageSearchEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private String openId;
	

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}	
}
