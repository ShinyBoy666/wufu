package cn.xinmeng.api.entity.auto.biz;

import cn.xinmeng.api.entity.auto.Cart;

/**
 * 购物车信息
 * @param 
 * @ClassName: CartLine 
 * @version V1.0  
 * @date 2016年2月19日 下午2:43:35 
 * @author jiangyong.tan
 * @return 
 *
 */
public class CartLine extends Cart{

    private static final long serialVersionUID = 451166871983699940L;
    
    /**
     * 价格信息
     */
    private double buyPrice;				//购买价格
    private Integer priceId;				//商品价格id
    private double profitFirst; 			//一级利润
    private double profitSecond; 			//二级利润
    private double profitThird; 			//三级利润
    private Integer quantity; 				//库存
    private Integer isDelivery;				//是否需要发货
    
    /**
     * 商品信息
     */
    private int categoryId;					//分类ID
    private Integer productState; //1：无效、2：有效、3：上架、4：下架
    
    /**
     * 订单字段
     */
    private String orderId;				//订单ID（加减库存用）
    private String remark;				//备注（加减库存用）
    
    
    //set get
    
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getProfitFirst() {
		return profitFirst;
	}
	public void setProfitFirst(double profitFirst) {
		this.profitFirst = profitFirst;
	}
	public double getProfitSecond() {
		return profitSecond;
	}
	public void setProfitSecond(double profitSecond) {
		this.profitSecond = profitSecond;
	}
	public double getProfitThird() {
		return profitThird;
	}
	public void setProfitThird(double profitThird) {
		this.profitThird = profitThird;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getProductState() {
		return productState;
	}
	public void setProductState(Integer productState) {
		this.productState = productState;
	}
	public Integer getIsDelivery() {
		return isDelivery;
	}
	public void setIsDelivery(Integer isDelivery) {
		this.isDelivery = isDelivery;
	}
	
}
