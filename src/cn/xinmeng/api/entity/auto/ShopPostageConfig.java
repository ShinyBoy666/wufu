package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：店铺邮费配置表
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:16
 */
public class ShopPostageConfig implements IEntity{

    private static final long serialVersionUID = 776841513562382569L;

    private Integer id; //主键、自增长
    private Integer shopId; //店铺编号
    private Integer logisticsId; //物流公司编号
    private Integer provinceId; //省
    private String provinceName; //省
    private Integer cityId; //市
    private String cityName; //市
    private Double postage; //邮费
    private Double postageFree; //满多少免邮费
    private Integer state; //状态1、无效3、有效
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
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }
    
    public Integer getLogisticsId() {
        return this.logisticsId;
    }
	
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    
    public Integer getProvinceId() {
        return this.provinceId;
    }
	
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    public String getProvinceName() {
        return this.provinceName;
    }
	
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    
    public Integer getCityId() {
        return this.cityId;
    }
	
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    public String getCityName() {
        return this.cityName;
    }
	
    public void setPostage(Double postage) {
        this.postage = postage;
    }
    
    public Double getPostage() {
        return this.postage;
    }
	
    public void setPostageFree(Double postageFree) {
        this.postageFree = postageFree;
    }
    
    public Double getPostageFree() {
        return this.postageFree;
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
	
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
}