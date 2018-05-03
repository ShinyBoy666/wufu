package cn.xinmeng.web.shop.entity.address;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;


/**
 * 常用地址列表
 * @param 
 * @ClassName: S1015ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午1:58:26 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1015ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = -5597595961508827722L;
	
	private Integer id;					//id
	private Integer customerId;			//客户编号
    private String recipientName; //收件人姓名
    private Integer addressType; //0：公司、1：家庭
    private String recipientPhone; //收件人电话
    private Integer provinceId; //省
    private Integer cityId; //市 
    private Integer districtId; //区
    private String provinceName; //省
    private String cityName; //市 
    private String districtName; 
    private String recipientAddress; //地址
    private Integer isDefault;	//是否默认地址0：否 1：是
    
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public Integer getAddressType() {
		return addressType;
	}
	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
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
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
