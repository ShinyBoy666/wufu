package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.Date;

import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.Utils;

public class ActivityVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4525514380709570298L;
	
	private Integer id; //主键
    private String title; //活动标题
    private String description; //活动描述
    private String imageUrl; //活动图片
    private java.util.Date showTime; //展示时间
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer activityType; //活动类型
    private Integer state;
    
    private Integer activityProductNum = 0;//活动商品数量
    //只有一个活动时候，下面两个属性才会有
	private Integer productPriceId;//活动价格id
    private Integer productId;//活动商品id
    

	/**
	 * 活动时间：1=还未开始，2=正在进行，3=已经结束
	 * @return
	 */
	public Integer getActivityState() {
		Date now = new Date();
		if(Utils.isEmpty(beginTime) || Utils.isEmpty(endTime)){
			return 0;
		}else if(DateUtil.compareDate(beginTime, now)){
			return 1;
		}else if(DateUtil.compareDate(now, endTime)){
			return 3;
		}else if(DateUtil.compareDate(now, beginTime) && DateUtil.compareDate(endTime, now)){
			return 2;
		}
		return 0;
	}

	/**
	 * 活动时间：当活动状态=1时表示距离开始时间，2时表示距离结束时间，3时可以返回0
	 * @return
	 */
	public long getActivityTime() {
		Date now = new Date();
		Integer activityState = getActivityState();
		if(activityState == 1){
			return DateUtil.dateSubDate(beginTime, now);
		}else if(activityState == 2){
			return DateUtil.dateSubDate(endTime, now);
		}
		return 0;
	}
    
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public java.util.Date getShowTime() {
		return showTime;
	}
	public void setShowTime(java.util.Date showTime) {
		this.showTime = showTime;
	}
	public java.util.Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	public Integer getActivityType() {
		return activityType;
	}
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getActivityProductNum() {
		return activityProductNum;
	}
	public void setActivityProductNum(Integer activityProductNum) {
		this.activityProductNum = activityProductNum;
	}
	public Integer getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
}
