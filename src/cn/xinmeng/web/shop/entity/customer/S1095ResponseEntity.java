package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

public class S1095ResponseEntity extends ResponseBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3405089434357464080L;
	
	private Integer id; //主键
    private String openid; //客户编号
    private String wechat; //微信号
    private String nickname; //真实姓名
    private String heardImage; //邮箱
    private Integer sex; //身份证号码
    private String address; //QQ
    
    //set get
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeardImage() {
		return heardImage;
	}
	public void setHeardImage(String heardImage) {
		this.heardImage = heardImage;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
