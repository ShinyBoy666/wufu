package cn.xinmeng.web.shop.entity.user.vo;

import java.util.Date;

import cn.xinmeng.api.enums.CustomerCategoryEnum;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;

@SuppressWarnings("serial")
public class CustomerUser extends ResponseBaseEntity{
	
    private Integer id; //主键
    private String recommendCode; //推荐码
    private String token; //客户凭证
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private Integer recommendCustomerId; //推荐人编号
    private String cellphone; //手机号码
    private String nickname; //用户昵称
    private String customerCategory; //用户类型1、普通用户2、付费用户
    private String headSculpture; //用户头像
    private Integer sex; //0、未知1、男2、女
    private Double cashAmount; //现金账户
    private Integer scoreAmount; //积分账户
    private Integer state; //0无效1有效
    private boolean accountDeduct;//是否能余额支付
    private java.util.Date openTime; //付费会员开始时间
    private java.util.Date endTime; //付费会员到期时间
    private java.util.Date createTime; //创建时间
	private String identityCard;	//收件人身份证
	private String realyname;				//身份证名称
	private String openId; //微信openId
	private Integer level; //用户等级1、一级2、二级3、三级
	private Integer cartCount;	//购物车商品数量
    
	//set get
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRecommendCode() {
		return recommendCode;
	}
	public void setRecommendCode(String recommendCode) {
		this.recommendCode = recommendCode;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getRecommendCustomerId() {
		return recommendCustomerId;
	}
	public void setRecommendCustomerId(Integer recommendCustomerId) {
		this.recommendCustomerId = recommendCustomerId;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCustomerCategory() {
		if(!Utils.isEmpty(customerCategory) && CustomerCategoryEnum.FEEPAY.key().equals(customerCategory)){
			Date now = new Date();
			if(DateUtil.compareDate(openTime, now) || DateUtil.compareDate(now, endTime)){
				return CustomerCategoryEnum.NOT_FEEPAY.key();
			}
		}
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public String getHeadSculpture() {
		return headSculpture;
	}
	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public Integer getScoreAmount() {
		return scoreAmount;
	}
	public void setScoreAmount(Integer scoreAmount) {
		this.scoreAmount = scoreAmount;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public java.util.Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(java.util.Date openTime) {
		this.openTime = openTime;
	}
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public boolean isAccountDeduct() {
		return accountDeduct;
	}
	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getRealyname() {
		return realyname;
	}
	public void setRealyname(String realyname) {
		this.realyname = realyname;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getCartCount() {
		return cartCount;
	}
	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}
}
