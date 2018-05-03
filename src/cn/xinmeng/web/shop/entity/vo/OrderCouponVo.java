package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.Date;

import cn.xinmeng.common.util.Utils;

public class OrderCouponVo implements Serializable{

	private static final long serialVersionUID = 2156612689303374548L;
	
	private Integer id; 					//主键
	private Integer customerId;				//客户id
	private Date beginTime;					//开始时间
	private Date endTime;					//结束时间
    private Integer useShopId; 				//使用店铺编号
    private Integer couponApplyId; 			//优惠券申请编号
    private Double couponMoney; 			//优惠券金额
    private Double orderMoney; 				//订单金额，满多少才能使用
    private String couponCode;				//优惠券编码
    private String couponTypeValue = "全场通用";			//优惠券类型值（全场通用）
	private String shopName;				//使用店铺名称
	private String shopLogo="";				//店铺logo
	private String shopBossImage="";				//店主形象照
    private String couponName; 				//优惠券名称
    private String canUseDay; //每个星期哪几天才能使用，用"|"线隔开
    private String canUseHour; //每天几点到几点才能使用，开始时间结束时间直接用"|"线隔开
	private String description;				//描述
    private Integer maxUseNumber; 			//叠加使用数量
    private String remark; 					//备注
	
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
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopLogo() {
		return Utils.getImageUrl(shopLogo);
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public String getShopBossImage() {
		return Utils.getImageUrl(shopBossImage);
	}
	public void setShopBossImage(String shopBossImage) {
		this.shopBossImage = shopBossImage;
	}
	public Integer getMaxUseNumber() {
		return maxUseNumber;
	}
	public void setMaxUseNumber(Integer maxUseNumber) {
		this.maxUseNumber = maxUseNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Integer getCouponApplyId() {
		return couponApplyId;
	}
	public void setCouponApplyId(Integer couponApplyId) {
		this.couponApplyId = couponApplyId;
	}
	public String getCouponTypeValue() {
		return couponTypeValue;
	}
	public void setCouponTypeValue(String couponTypeValue) {
		this.couponTypeValue = couponTypeValue;
	}
	
}
