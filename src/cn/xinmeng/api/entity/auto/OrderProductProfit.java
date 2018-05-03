package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：订单商品利润分配信息表
 * @author jiangyong.tan
 * @date 2016-03-24 22:11:57
 */
public class OrderProductProfit implements IEntity{

    private static final long serialVersionUID = 184773704074672240L;

    private Integer id; //主键、自增长
    private String orderId; //订单编号
    private Integer orderProductId; //商品编号（对应order_product表的Id）
    private Integer productNumber; //商品数量
    private Integer customerId; //用户编号
    private Double customerAward; //用户分成
    private Integer accountType; //1、用户2、店铺
    private Integer profitLevel; //利润等级1、一级2、二级3、三级4、货款
    private Integer handleState; //处理状态，1为未结算，2为已结算，3无需结算，4待结算，5已退款（1，2，4状态其实都已经给现金账户加过钱了）
    private java.util.Date createTime; //创建时间
    private java.util.Date profitTime; //结算时间
    private java.util.Date cancelTime; //取消时间
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
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setCustomerAward(Double customerAward) {
        this.customerAward = customerAward;
    }
    
    public Double getCustomerAward() {
        return this.customerAward;
    }
	
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
    
    public Integer getAccountType() {
        return this.accountType;
    }
	
    public void setProfitLevel(Integer profitLevel) {
        this.profitLevel = profitLevel;
    }
    
    public Integer getProfitLevel() {
        return this.profitLevel;
    }
	
    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
    }
    
    public Integer getHandleState() {
        return this.handleState;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
	
    public void setProfitTime(java.util.Date profitTime) {
        this.profitTime = profitTime;
    }
    
    public java.util.Date getProfitTime() {
        return this.profitTime;
    }
	
    public void setCancelTime(java.util.Date cancelTime) {
        this.cancelTime = cancelTime;
    }
    
    public java.util.Date getCancelTime() {
        return this.cancelTime;
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