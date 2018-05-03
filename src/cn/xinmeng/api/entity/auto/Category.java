package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：商品类别表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:20
 */
public class Category implements IEntity{

    private static final long serialVersionUID = 852876597284395422L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private String categoryName; //类别名称
    private String categoryDescription; //类别描述
    private Integer firstId; //第一级ID
    private Integer secondId; //第二级ID
    private String ico; //图片
    private Integer level; //所属级别
    private Integer sort; //排序
    private Integer state; //状态0：无效1：有效
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
	
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public String getCategoryName() {
        return this.categoryName;
    }
	
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
    
    public String getCategoryDescription() {
        return this.categoryDescription;
    }
	
    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }
    
    public Integer getFirstId() {
        return this.firstId;
    }
	
    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }
    
    public Integer getSecondId() {
        return this.secondId;
    }
	
    public void setIco(String ico) {
        this.ico = ico;
    }
    
    public String getIco() {
        return Utils.getImageUrl(this.ico);
    }
	
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Integer getLevel() {
        return this.level;
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