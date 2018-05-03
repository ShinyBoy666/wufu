package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：代理商信息
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:16
 */
public class Agent implements IEntity{

    private static final long serialVersionUID = 513427487266328439L;

    private Integer id; //主键
    private String name; //用户昵称
    private String cellphone; //手机号码
    private String identityCard; //身份证号码
    private Integer sex; //1、未知2、男3、女
    private Double shopRegisterAmount; //每个店铺入驻需向平台缴费
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private Double cashAmount; //现金账户
    private Integer state; //1无效2有效
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
	
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
	
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    
    public String getCellphone() {
        return this.cellphone;
    }
	
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
    
    public String getIdentityCard() {
        return this.identityCard;
    }
	
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    public Integer getSex() {
        return this.sex;
    }
	
    public void setShopRegisterAmount(Double shopRegisterAmount) {
        this.shopRegisterAmount = shopRegisterAmount;
    }
    
    public Double getShopRegisterAmount() {
        return this.shopRegisterAmount;
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
	
    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }
    
    public Double getCashAmount() {
        return this.cashAmount;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
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