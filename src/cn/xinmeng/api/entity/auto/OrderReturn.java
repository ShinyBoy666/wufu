package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：订单退换货信息
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:18
 */
public class OrderReturn implements IEntity{

    private static final long serialVersionUID = 850514632376299036L;

    private Integer id; //主键、自增长
    private String orderId; //订单编号
    private Integer orderProductId; //商品编号（对应order_product表的Id）
    private Integer productNumber; //商品数量
    private Double productPrice; //商品单价
    private Double totalAmount; //金额
    private Integer returnType; //1、退货2、换货
    private String applyReason; //申请理由
    private String remark; //客服填写备注
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
	
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return this.orderId;
    }
	
    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }
    
    public Integer getOrderProductId() {
        return this.orderProductId;
    }
	
    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
    
    public Integer getProductNumber() {
        return this.productNumber;
    }
	
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    
    public Double getProductPrice() {
        return this.productPrice;
    }
	
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public Double getTotalAmount() {
        return this.totalAmount;
    }
	
    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }
    
    public Integer getReturnType() {
        return this.returnType;
    }
	
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }
    
    public String getApplyReason() {
        return this.applyReason;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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