package cn.xinmeng.web.base.entity;

import cn.xinmeng.common.entity.IEntity;

public class AppRequestEntity implements IEntity {

	private static final long serialVersionUID = -6572054556738958047L;

	private String source = "";	//请求来源，Android，IOS，wap
	private String code = "";	//服务号
	private String mak = "";	//秘钥
	private String token = "";	//token
	private long timestamp;		//时间戳  毫秒
	private String imei = "";	//手机串号
	private String data = "";	//请求数据 JSON 格式字符串
	private int sourceShopId;	//来源店铺ID
	private int loginShopId;	//登录店铺
	private String ip;			//来源ip
	
	
	//set get
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMak() {
		return mak;
	}
	public void setMak(String mak) {
		this.mak = mak;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getSourceShopId() {
		return sourceShopId;
	}
	public void setSourceShopId(int sourceShopId) {
		this.sourceShopId = sourceShopId;
	}
	public int getLoginShopId() {
		return loginShopId;
	}
	public void setLoginShopId(int loginShopId) {
		this.loginShopId = loginShopId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
