package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户常用地址表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:49
 */
public class CommonAddress implements IEntity{

    private static final long serialVersionUID = 648511743162732142L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private String recipientName; //收件人姓名
    private String recipientIdentityCard; //收件人身份证
    private Integer addressType; //1：公司、2：家庭
    private String recipientPhone; //收件人电话
    private Integer provinceId; //省
    private Integer cityId; //市
    private Integer districtId; //区
    private Integer town; //乡镇
    private String recipientzipCode; //邮编
    private String recipientAddress; //地址
    private Integer isDefault; //是否默认地址1：否2：是
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人
    private java.util.Date updateTime; //修改时间
    private String updateUser; //修改人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    
    public String getRecipientName() {
        return this.recipientName;
    }
	
    public void setRecipientIdentityCard(String recipientIdentityCard) {
        this.recipientIdentityCard = recipientIdentityCard;
    }
    
    public String getRecipientIdentityCard() {
        return this.recipientIdentityCard;
    }
	
    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }
    
    public Integer getAddressType() {
        return this.addressType;
    }
	
    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }
    
    public String getRecipientPhone() {
        return this.recipientPhone;
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
	
    public void setTown(Integer town) {
        this.town = town;
    }
    
    public Integer getTown() {
        return this.town;
    }
	
    public void setRecipientzipCode(String recipientzipCode) {
        this.recipientzipCode = recipientzipCode;
    }
    
    public String getRecipientzipCode() {
        return this.recipientzipCode;
    }
	
    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }
    
    public String getRecipientAddress() {
        return this.recipientAddress;
    }
	
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
    
    public Integer getIsDefault() {
        return this.isDefault;
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
	
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
}