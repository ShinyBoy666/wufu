package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 修改个人资料
 * @param 
 * @ClassName: S1026RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1026RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String nickname;	//客户名称
	private Integer sex;	//客户性别
	private String headSculpture;	//头像
	

	//set get

	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getHeadSculpture() {
		return headSculpture;
	}

	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}

}
