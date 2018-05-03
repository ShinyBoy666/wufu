package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.Date;

import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.Utils;

public class CouponVo implements Serializable{

	private static final long serialVersionUID = 2156612689303374548L;
	
	private Integer id; 					//主键
    private Integer useShopId; 				//使用店铺编号
	private String useShopName;				//使用店铺名称
	private String shopLogo;				//店铺logo
	private String shopBossImage;			//店铺老板照
    private String couponName; 				//优惠券名称
    private Double couponMoney; 			//优惠券金额
    private Double orderMoney; 				//订单金额，满多少才能使用
    private String couponTypeValue = "全场通用";			//优惠券类型值（全场通用）
	private String description;				//描述
	private Date beginTime;					//开始时间
	private Date endTime;					//结束时间
    private Integer couponNumber; 			//优惠券数量
    private Integer couponReceiveNumber;	//优惠券已领用数量
    private Integer maxGetNumber; 			//每人可领张数，
    private Integer customerReceiveNumber;	//客户已经领取的数量
    private String canUseDay; //每个星期哪几天才能使用，用"|"线隔开
    private String canUseHour; //每天几点到几点才能使用，开始时间结束时间直接用"|"线隔开
	private boolean receive;				//是否可以领取，true－可以，false－不可以
	private boolean collection;				//是否可以收藏，true－可以，false－不可以
    private String remark; 					//备注
    private String startToEndTime;
	
	//set get
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUseShopId() {
		return useShopId;
	}
	public void setUseShopId(Integer useShopId) {
		this.useShopId = useShopId;
	}
	public String getUseShopName() {
		return useShopName;
	}
	public void setUseShopName(String useShopName) {
		this.useShopName = useShopName;
	}
	public String getShopBossImage() {
		return Utils.getImageUrl(shopBossImage);
	}
	public void setShopBossImage(String shopBossImage) {
		this.shopBossImage = shopBossImage;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public Double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public String getDescription() {
		String orderMeneyStr = "消费立减"+couponMoney+"元";
		if(!Utils.isEmpty(orderMoney)){
			orderMeneyStr = orderMeneyStr+"（满"+orderMoney+"可用）";
		}
		if(Utils.isEmpty(canUseDay) && Utils.isEmpty(canUseHour)){
			return orderMeneyStr;
		}else if(!Utils.isEmpty(canUseDay) && Utils.isEmpty(canUseHour)){
			return orderMeneyStr+"（ 可用周期："+Utils.getCanUseDay(canUseDay)+"） "/*+remark*/;
		}else if(Utils.isEmpty(canUseDay) && !Utils.isEmpty(canUseHour)){
			return orderMeneyStr+"（ 可用时间："+Utils.getCanUseHour(canUseHour)+"）  "/*+remark*/;
		}else if(!Utils.isEmpty(canUseDay) && !Utils.isEmpty(canUseHour)){
			return orderMeneyStr+"（ 可用周期："+Utils.getCanUseDay(canUseDay)+"，可用时间："+Utils.getCanUseHour(canUseHour)+"） "/*+remark*/;
		}
		return orderMeneyStr;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getMaxGetNumber() {
		return maxGetNumber;
	}
	public void setMaxGetNumber(Integer maxGetNumber) {
		this.maxGetNumber = maxGetNumber;
	}
	public boolean isReceive() {
		return receive;
	}
	public void setReceive(boolean receive) {
		this.receive = receive;
	}
	public boolean isCollection() {
		return collection;
	}
	public void setCollection(boolean collection) {
		this.collection = collection;
	}
	public Integer getCustomerReceiveNumber() {
		return customerReceiveNumber;
	}
	public void setCustomerReceiveNumber(Integer customerReceiveNumber) {
		this.customerReceiveNumber = customerReceiveNumber;
	}
	public Double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public Integer getCouponNumber() {
		return couponNumber+Utils.getCouponNum(id);
	}
	public void setCouponNumber(Integer couponNumber) {
		this.couponNumber = couponNumber;
	}
	public Integer getCouponReceiveNumber() {
		return couponReceiveNumber+Utils.getCouponNum(id);
	}
	public void setCouponReceiveNumber(Integer couponReceiveNumber) {
		this.couponReceiveNumber = couponReceiveNumber;
	}
	public String getShopLogo() {
		return Utils.getImageUrl(shopLogo);
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public String getCanUseDay() {
		return canUseDay;
	}
	public void setCanUseDay(String canUseDay) {
		this.canUseDay = canUseDay;
	}
	public String getCanUseHour() {
		return canUseHour;
	}
	public void setCanUseHour(String canUseHour) {
		this.canUseHour = canUseHour;
	}
	public String getCouponTypeValue() {
		return couponTypeValue;
	}
	public void setCouponTypeValue(String couponTypeValue) {
		this.couponTypeValue = couponTypeValue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartToEndTime() {
		if(!Utils.isEmpty(beginTime) && !Utils.isEmpty(endTime)){
			return DateUtil.formatDate(beginTime, "yyyy.MM.dd")+"-"+DateUtil.formatDate(endTime, "yyyy.MM.dd");
		}
		return "";
	}
	public void setStartToEndTime(String startToEndTime) {
		this.startToEndTime = startToEndTime;
	}
	
}
