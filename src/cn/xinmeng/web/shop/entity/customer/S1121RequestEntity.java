package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

public class S1121RequestEntity extends RequestBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nickname;	//客户名称
	private String headSculpture;	//头像
	private int contributionamount;//贡献
	private int scoreamount;//积分
	private int cashamount;//现金
	private int state;	//1-贡献,2-积分,3-现金
	public int getContributionamount() {
		return contributionamount;
	}
	public void setContributionamount(int contributionamount) {
		this.contributionamount = contributionamount;
	}
	public int getScoreamount() {
		return scoreamount;
	}
	public void setScoreamount(int scoreamount) {
		this.scoreamount = scoreamount;
	}
	public int getCashamount() {
		return cashamount;
	}
	public void setCashamount(int cashamount) {
		this.cashamount = cashamount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadSculpture() {
		return headSculpture;
	}
	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}
}
