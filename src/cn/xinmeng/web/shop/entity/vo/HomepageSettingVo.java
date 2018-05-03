package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.List;

import cn.xinmeng.common.util.Utils;

public class HomepageSettingVo implements Serializable{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午3:25:15
	 */ 
	private static final long serialVersionUID = -7855121728741215437L;
	
	private Integer id; //主键
    private String title; //模块标题
    private Integer type; //1、活动2、商品
    private String linkUrl; //链接地址
    private String imgUrl; //图片
    private List<ProductInfoVo> productInfos;//商品集合
    private ActivityVo activity;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getImgUrl() {
		return Utils.getImageUrl(imgUrl);
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public List<ProductInfoVo> getProductInfos() {
		return productInfos;
	}
	public void setProductInfos(List<ProductInfoVo> productInfos) {
		this.productInfos = productInfos;
	}
	public ActivityVo getActivity() {
		return activity;
	}
	public void setActivity(ActivityVo activity) {
		this.activity = activity;
	}
}
