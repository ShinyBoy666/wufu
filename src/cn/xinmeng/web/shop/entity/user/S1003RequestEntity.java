package cn.xinmeng.web.shop.entity.user;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * token登录
 * @param 
 * @ClassName: S1003RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1003RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String token;	//token
	
	private boolean searchCartCount; //是否查询购物车数量
	//set get
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean getSearchCartCount() {
		return searchCartCount;
	}

	public void setSearchCartCount(boolean searchCartCount) {
		this.searchCartCount = searchCartCount;
	}
	
}
