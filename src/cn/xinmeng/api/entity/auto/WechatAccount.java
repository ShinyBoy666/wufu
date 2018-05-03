package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户微信信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:54
 */
public class WechatAccount implements IEntity{

    private static final long serialVersionUID = 347100801869122511L;

    private Integer id; //主键
    private String openid; //微信openid
    private String nickname; //昵称
    private String heardImage; //头像
    private Integer sex; //性别
    private String country; //国家
    private String province; //省
    private String city; //市
    private String language; //语言
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
	
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    
    public String getOpenid() {
        return this.openid;
    }
	
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getNickname() {
        return this.nickname;
    }
	
    public void setHeardImage(String heardImage) {
        this.heardImage = heardImage;
    }
    
    public String getHeardImage() {
        return this.heardImage;
    }
	
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    public Integer getSex() {
        return this.sex;
    }
	
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountry() {
        return this.country;
    }
	
    public void setProvince(String province) {
        this.province = province;
    }
    
    public String getProvince() {
        return this.province;
    }
	
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return this.city;
    }
	
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public String getLanguage() {
        return this.language;
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