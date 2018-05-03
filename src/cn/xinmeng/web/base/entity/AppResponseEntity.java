package cn.xinmeng.web.base.entity;

import cn.xinmeng.common.entity.IEntity;

public class AppResponseEntity implements IEntity {
	
	private static final long serialVersionUID = -5574667804538372268L;

	private String errorCode = "";	//错误code
	private int success;	//请求是否成功 1 成功、0 失败
	private String message = "";	//响应消息
	private Object data = "";	//响应数据数据
	private int sourceShopId;	//来源店铺ID
	private int loginShopId;	//登录店铺
	
	
	//set get
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
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
	
	
}
