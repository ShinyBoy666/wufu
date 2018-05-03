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
public class S1064RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private String cellphone;	//cellphone
	private String content;//短信内容
	private Integer fromType;//短信来源1、API2、后台3、Windows服务
	

	//set get

	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getFromType() {
		return fromType;
	}
	public void setFromType(Integer fromType) {
		this.fromType = fromType;
	}
	
}
