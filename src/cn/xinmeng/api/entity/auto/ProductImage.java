package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：商品图片表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:26
 */
public class ProductImage implements IEntity{

    private static final long serialVersionUID = 687154658364588407L;

    private Integer id; //主键
    private Integer productPriceId; //商品价格表编号
    private String imageUrl; //图片地址
    private Integer sort; //排序，数字越大越靠前
    private Integer state; //状态1：无效2：有效
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }
    
    public Integer getProductPriceId() {
        return this.productPriceId;
    }
	
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return Utils.getImageUrl(this.imageUrl);
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