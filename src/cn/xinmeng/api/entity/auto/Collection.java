package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户收藏表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:48
 */
public class Collection implements IEntity{

    private static final long serialVersionUID = 541549615939108527L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private Integer shopId; //店铺编号
    private Integer objectType; //类型1、商品2、店铺
    private String objectId; //收藏对象Id当收藏类型为1时，ObjId为产品Id
    private java.util.Date createTime; //创建时间

	
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
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }
    
    public Integer getObjectType() {
        return this.objectType;
    }
	
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
    
    public String getObjectId() {
        return this.objectId;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}