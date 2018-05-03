package cn.xinmeng.web.shop.entity.base;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 广告
 * @param 
 * @ClassName: S1080RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1080RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private Integer deviceType;//1、IOS 2、安卓 3、wap
	private String provinceName;//省名称
	private String cityName;//市名称
	
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
