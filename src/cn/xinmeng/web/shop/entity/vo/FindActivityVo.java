package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;

import cn.xinmeng.common.util.Utils;

public class FindActivityVo implements Serializable{

	private static final long serialVersionUID = 8176314142211178854L;

    private Integer id; //活动id
    private Integer showPlace; //显示位置
    private Integer contentType; //1、活动2、职位3、小组
    private String headSculpture; //用户头像
    private String title; //活动标题
    private String imgUrl; //活动背景图片
    private String description; //活动简介
    private String address; //活动地址
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer activityType; //活动类型1、线下活动2、在线直播
    private Integer applyPerson; //活动报名人数
    
    //set get 

    /**
     * 活动类型1、线下活动2、在线直播
     * @return
     */
	public String getActivityTypeValue() {
		if(Utils.isEmpty(activityType)){
			return "";
		}else if(activityType == 1){
			return "线下活动";
		}else if(activityType == 2){
			return "在线直播";
		}
		return "";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShowPlace() {
		return showPlace;
	}
	public void setShowPlace(Integer showPlace) {
		this.showPlace = showPlace;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public String getHeadSculpture() {
		return headSculpture;
	}
	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(Integer applyPerson) {
		this.applyPerson = applyPerson;
	}
    
}
