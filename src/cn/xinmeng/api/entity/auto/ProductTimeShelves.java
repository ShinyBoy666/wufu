package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：商品定时上架表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:29
 */
public class ProductTimeShelves implements IEntity{

    private static final long serialVersionUID = 967318121347199967L;

    private Integer id; //主键
    private Integer productId; //商品编号
    private java.util.Date operationTime; //上下架时间
    private Integer operationType; //1、上架2、下架
    private Integer state; //1、未处理2、已处理
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
	
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
	
    public void setOperationTime(java.util.Date operationTime) {
        this.operationTime = operationTime;
    }
    
    public java.util.Date getOperationTime() {
        return this.operationTime;
    }
	
    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }
    
    public Integer getOperationType() {
        return this.operationType;
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