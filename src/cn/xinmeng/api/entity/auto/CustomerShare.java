package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：分享记录表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:57
 */
public class CustomerShare implements IEntity{

    private static final long serialVersionUID = 890530930635645245L;

    private Integer id; //主键
    private Integer customerId; //客户编号
    private Integer sharePartal; //1、微信好友2、微信朋友圈3、QQ好友4、QQ空间5、新浪微博
    private Integer objectType; //分享对象objectType1、商品2、店铺
    private String objectId; //分享对象ID
    private Integer isReback; //1、否2、是
    private java.util.Date createTime; //创建时间
    private String createUser; //创建者

	
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
	
    public void setSharePartal(Integer sharePartal) {
        this.sharePartal = sharePartal;
    }
    
    public Integer getSharePartal() {
        return this.sharePartal;
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
	
    public void setIsReback(Integer isReback) {
        this.isReback = isReback;
    }
    
    public Integer getIsReback() {
        return this.isReback;
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