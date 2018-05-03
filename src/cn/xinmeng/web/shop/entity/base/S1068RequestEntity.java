package cn.xinmeng.web.shop.entity.base;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 更新个推id
 * @param 
 * @ClassName: S1068RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1068RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String getuiId;

	public String getGetuiId() {
		return getuiId;
	}

	public void setGetuiId(String getuiId) {
		this.getuiId = getuiId;
	}
}
