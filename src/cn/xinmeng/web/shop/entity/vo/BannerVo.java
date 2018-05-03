package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;

import cn.xinmeng.common.util.Utils;

public class BannerVo implements Serializable{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午3:11:05
	 */ 
	private static final long serialVersionUID = -3539436836106133924L;
	
	private Integer id; //编号
    private Integer provinceId; //省份编号
    private Integer cityId; //城市编号
    private String title; //标题
    private String imageUrl; //图片地址
    private Integer showType; //1、商品详情2、H5页面
    private String objectId; //如果是详情则为商品ID，如果活动则为活动ID
    private String linkUrl; //链接地址
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return Utils.getImageUrl(imageUrl);
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getShowType() {
		return showType;
	}
	public void setShowType(Integer showType) {
		this.showType = showType;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
}
