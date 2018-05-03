package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：行政信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:24
 */
public class Region implements IEntity{

    private static final long serialVersionUID = 136989529920244369L;

    private Integer id; //主键
    private String regionCode; //国家标准区域编号
    private String regionName; //省市区镇名称
    private Integer parentId; //上级编号
    private Integer provinceId; //省编号
    private String provinceName; //省名
    private Integer cityId; //市编号
    private String cityName; //市名
    private Integer areaId; //区编号
    private String areaName; //区名
    private Integer regionLevel; //层级
    private String pinyin; //拼音
    private String jianpin; //简拼
    private Integer sort; //排序
    private Integer state; //1、无效2、有效
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
    
    public String getRegionCode() {
        return this.regionCode;
    }
	
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
    public String getRegionName() {
        return this.regionName;
    }
	
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public Integer getParentId() {
        return this.parentId;
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
	
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
    
    public Integer getAreaId() {
        return this.areaId;
    }
	
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    public String getAreaName() {
        return this.areaName;
    }
	
    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }
    
    public Integer getRegionLevel() {
        return this.regionLevel;
    }
	
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    
    public String getPinyin() {
        return this.pinyin;
    }
	
    public void setJianpin(String jianpin) {
        this.jianpin = jianpin;
    }
    
    public String getJianpin() {
        return this.jianpin;
    }
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
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
}