package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：店铺和类别关系表
 * @author jiangyong.tan
 * @date 2016-03-23 14:06:48
 */
public class ShopCategoryConfig implements IEntity{

    private static final long serialVersionUID = 762776720727774789L;

    private Integer id; //主键
    private Integer categoryId; //商品类别编号
    private Integer shopId; //店铺编号
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    public Integer getCategoryId() {
        return this.categoryId;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
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