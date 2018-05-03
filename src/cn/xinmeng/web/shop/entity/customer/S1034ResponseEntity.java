package cn.xinmeng.web.shop.entity.customer;

import java.util.Date;

import cn.xinmeng.common.entity.IEntity;

/**
 * 优惠券
 * @param 
 * @ClassName: CouponApplyBiz 
 * @version V1.0  
 * @date 2016年2月23日 下午2:32:43 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1034ResponseEntity implements IEntity{

    private static final long serialVersionUID = 954232087746595554L;

    private Integer id; 					//主键
    private Integer useShopId; 				//使用店铺编号
	private String useShopName;			//使用店铺名称
	private String useShopLogo;			//使用店铺logo
    private String couponName; 				//优惠券名称
    private Double couponMoney; 			//优惠券金额
    private Integer couponNumber; 			//优惠券数量
    private Integer couponReceiveNumber; 	//优惠券已领用数量
    private Integer overNumber;				//优惠券剩余数量
    private Double orderMoney; 				//订单金额，满多少才能使用
	private String description;				//描述
	private Date beginTime;					//开始时间
	private Date endTime;					//结束时间
	private boolean receive;				//是否可以领取

	
	// set get
	
	
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
	public Integer getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Integer couponNumber) {
		this.couponNumber = couponNumber;
	}
	public Integer getCouponReceiveNumber() {
		return couponReceiveNumber;
	}
	public void setCouponReceiveNumber(Integer couponReceiveNumber) {
		this.couponReceiveNumber = couponReceiveNumber;
	}
	public Integer getOverNumber() {
		if(couponNumber != null && couponReceiveNumber != null){
			return couponNumber - couponReceiveNumber;
		}
		return overNumber;
	}
	public void setOverNumber(Integer overNumber) {
		this.overNumber = overNumber;
	}
	public Double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isReceive() {
		return receive;
	}
	public void setReceive(boolean receive) {
		this.receive = receive;
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
	public String getUseShopName() {
		return useShopName;
	}
	public void setUseShopName(String useShopName) {
		this.useShopName = useShopName;
	}
	public String getUseShopLogo() {
		return useShopLogo;
	}
	public void setUseShopLogo(String useShopLogo) {
		this.useShopLogo = useShopLogo;
	}
    
}