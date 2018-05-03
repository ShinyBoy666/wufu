package cn.xinmeng.web.shop.entity.order.vo;


public class OrderProductVO {
	
	private int productId;	//商品ID
	private String sku;		//sku
	private int productNumber;	//商品购买数量
	private double productPrice;//商品价格
	private String productName;	//商品名称
	private String imageUrl;	//图片地址
	private double productDiscountMoney;//折扣金额
	private double productPayMoney;//支付金额

	//set get

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getProductDiscountMoney() {
		return productDiscountMoney;
	}
	public void setProductDiscountMoney(double productDiscountMoney) {
		this.productDiscountMoney = productDiscountMoney;
	}
	public double getProductPayMoney() {
		return productPayMoney;
	}
	public void setProductPayMoney(double productPayMoney) {
		this.productPayMoney = productPayMoney;
	}
	
	
	
}
