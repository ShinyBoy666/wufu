package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：客户基本信息表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:20
 */
public class Customer implements IEntity{

    private static final long serialVersionUID = 314966574781576010L;

    private Integer id; //主键
    private String recommendCode; //推荐码
    private String token; //客户凭证
    private String password; //密码
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private Integer recommendCustomerId; //推荐人编号
    private Integer shopId; //店铺编号
    private String cellphone; //手机号码
    private String openId; //微信openid
    private String nickname; //用户昵称
    private String customerCategory; //用户类型1、普通用户2、付费用户
    private String headSculpture; //用户头像
    private Integer level; //用户等级1、一级2、二级3、三级
    private Integer sex; //1、未知2、男3、女
    private Double cashAmount; //现金账户
    private Integer scoreAmount; //积分账户
    private Double extensionAmount; //推荐奖励，购物奖励统一放到此帐户
    private Double cashbackAmount; //积分换算后的返现统一放到此帐户
    private Double contributionAmount; //向平台损款后的贡献记录
    private Integer state; //1无效2有效
    private java.util.Date openTime; //付费会员开始时间
    private java.util.Date endTime; //付费会员到期时间
    private String getuiId; //个推ID
    private String imei; //IMEI
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人
    private java.util.Date updateTime; //修改时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }
    
    public String getRecommendCode() {
        return this.recommendCode;
    }
	
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getToken() {
        return this.token;
    }
	
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
	
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    
    public Integer getProvinceId() {
        return this.provinceId;
    }
	
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    
    public Integer getCityId() {
        return this.cityId;
    }
	
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
    
    public Integer getDistrictId() {
        return this.districtId;
    }
	
    public void setRecommendCustomerId(Integer recommendCustomerId) {
        this.recommendCustomerId = recommendCustomerId;
    }
    
    public Integer getRecommendCustomerId() {
        return this.recommendCustomerId;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    
    public String getCellphone() {
        return this.cellphone;
    }
	
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    public String getOpenId() {
        return this.openId;
    }
	
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getNickname() {
        return this.nickname;
    }
	
    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }
    
    public String getCustomerCategory() {
        return this.customerCategory;
    }
	
    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }
    
    public String getHeadSculpture() {
        return Utils.getImageUrl(this.headSculpture);
    }
	
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Integer getLevel() {
        return this.level;
    }
	
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    public Integer getSex() {
        return this.sex;
    }
	
    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }
    
    public Double getCashAmount() {
        return this.cashAmount;
    }
	
    public void setScoreAmount(Integer scoreAmount) {
        this.scoreAmount = scoreAmount;
    }
    
    public Integer getScoreAmount() {
        return this.scoreAmount;
    }
	
    public void setExtensionAmount(Double extensionAmount) {
        this.extensionAmount = extensionAmount;
    }
    
    public Double getExtensionAmount() {
        return this.extensionAmount;
    }
	
    public void setCashbackAmount(Double cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }
    
    public Double getCashbackAmount() {
        return this.cashbackAmount;
    }
	
    public void setContributionAmount(Double contributionAmount) {
        this.contributionAmount = contributionAmount;
    }
    
    public Double getContributionAmount() {
        return this.contributionAmount;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setOpenTime(java.util.Date openTime) {
        this.openTime = openTime;
    }
    
    public java.util.Date getOpenTime() {
        return this.openTime;
    }
	
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    
    public java.util.Date getEndTime() {
        return this.endTime;
    }
	
    public void setGetuiId(String getuiId) {
        this.getuiId = getuiId;
    }
    
    public String getGetuiId() {
        return this.getuiId;
    }
	
    public void setImei(String imei) {
        this.imei = imei;
    }
    
    public String getImei() {
        return this.imei;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
	
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
}