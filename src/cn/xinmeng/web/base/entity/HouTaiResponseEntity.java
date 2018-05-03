package cn.xinmeng.web.base.entity;

import cn.xinmeng.common.entity.IEntity;

public class HouTaiResponseEntity implements IEntity {
	
	private static final long serialVersionUID = -5574667804538372268L;

	private String isSuccess;//SUCCESS
    private String Msg;
    private Object data;
	
	
	//set get
    
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}
