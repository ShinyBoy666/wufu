package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：商品评论表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:22
 */
public class ProductComment implements IEntity{

    private static final long serialVersionUID = 643470489236001117L;

    private Integer id; //主键
    private Integer productId; //商品ID
    private String orderId; //订单编号
    private Integer productScore; //商品评分：1至5分
    private String commentContent; //评论内容
    private Integer customerId; //评论用户Id
    private String customerName; //评论用户名
    private Integer state; //状态：1、无效2、有效
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
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
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setProductScore(Integer productScore) {
        this.productScore = productScore;
    }
    
    public Integer getProductScore() {
        return this.productScore;
    }
	
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    
    public String getCommentContent() {
        return this.commentContent;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerName() {
        return this.customerName;
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