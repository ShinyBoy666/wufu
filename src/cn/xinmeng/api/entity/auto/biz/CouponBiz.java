package cn.xinmeng.api.entity.auto.biz;

import java.util.Date;

import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.Utils;

/**
 * 优惠券
 * @param 
 * @ClassName: CouponBiz 
 * @version V1.0  
 * @date 2016年2月23日 下午2:32:43 
 * @author jiangyong.tan
 * @return 
 *
 */
public class CouponBiz implements IEntity{

	private static final long serialVersionUID = -4865443073265601285L;
	
	private int customerId;			//客户编号
	private int shopId;				//店铺编号
	private int useShopId;			//使用店铺id
	private String couponCode;		//优惠券编码
	private String couponName;		//优惠劵名称
	private double couponMoney;		//优惠金额
	private double orderMoney;		//满多少使用：订单金额
	private String description;		//描述
	private int categoryId;			//分类id
	private int brandId;			//品牌ID
	private Date beginTime;			//开始时间
	private Date endTime;			//结束时间
	private Date useTime;			//使用时间
	private Integer state;			//状态
	
	
	
	private Integer applyId; 					//主键
	private String useShopName;				//使用店铺名称
	private String useShopLogo;				//店铺logo
	private String shopBossImage;			//店铺老板照
    private String couponTypeValue = "全场通用";			//优惠券类型值（全场通用）
    private Integer couponReceiveNumber;	//优惠券已领用数量
    private String canUseDay; //每个星期哪几天才能使用，用"|"线隔开
    private String canUseHour; //每天几点到几点才能使用，开始时间结束时间直接用"|"线隔开
    private String remark; 					//备注
    private String startToEndTime;
    private String stateValue;			//状态，1-未使用，2－已使用，3-已过期
	
	
	//set get
	
	public Date getEndTime() {
		return endTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getUseShopId() {
		return useShopId;
	}
	public void setUseShopId(int useShopId) {
		this.useShopId = useShopId;
	}
	
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public String getUseShopName() {
		return useShopName;
	}
	public void setUseShopName(String useShopName) {
		this.useShopName = useShopName;
	}
	public String getUseShopLogo() {
		return Utils.getImageUrl(useShopLogo,"100*100");
	}
	public void setUseShopLogo(String useShopLogo) {
		this.useShopLogo = useShopLogo;
	}
	public String getShopBossImage() {
		return shopBossImage;
	}
	public void setShopBossImage(String shopBossImage) {
		this.shopBossImage = shopBossImage;
	}
	public String getCouponTypeValue() {
		return couponTypeValue;
	}
	public void setCouponTypeValue(String couponTypeValue) {
		this.couponTypeValue = couponTypeValue;
	}
	public Integer getCouponReceiveNumber() {
		return couponReceiveNumber+Utils.getCouponNum(applyId);
	}
	public void setCouponReceiveNumber(Integer couponReceiveNumber) {
		this.couponReceiveNumber = couponReceiveNumber;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartToEndTime() {
		if(!Utils.isEmpty(this.getBeginTime()) && !Utils.isEmpty(this.getEndTime())){
			return DateUtil.formatDate(this.getBeginTime(), "yyyy.MM.dd")+"-"+DateUtil.formatDate(this.getEndTime(), "yyyy.MM.dd");
		}
		return "";
	}
	public void setStartToEndTime(String startToEndTime) {
		this.startToEndTime = startToEndTime;
	}
	public String getStateValue() {
		return stateValue;
	}
	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}
}