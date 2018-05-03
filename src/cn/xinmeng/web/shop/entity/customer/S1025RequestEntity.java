package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 头像上传
 * @param 
 * @ClassName: S1025RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1025RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	public String base64String;	//图片base64
	public String imgType;	//类型
	public String projectName = "wufu";

	//set get

	public String getBase64String() {
		return base64String;
	}

	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
