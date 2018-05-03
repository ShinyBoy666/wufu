package cn.xinmeng.web.shop.entity.address;

import cn.xinmeng.web.base.entity.PageSearchEntity;


/**
 * 常用地址列表
 * @param 
 * @ClassName: S1015RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午1:58:26 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1015RequestEntity extends PageSearchEntity{

	private static final long serialVersionUID = -5597595961508827722L;
	
	private Integer isDefault;//是否默认地址

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	
	
}
