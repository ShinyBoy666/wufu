package cn.xinmeng.api.entity.auto.biz;

import cn.xinmeng.common.entity.IEntity;

public class ProductBasicInfo implements IEntity{

	private static final long serialVersionUID = 870973462445329716L;

	private Integer productId;   			//商品编号
	private String sku; 					//sku
	private Integer canSoldProductNumber;  	//加减可卖库存
	private Integer actualProductNumber;	//加减实际库存数量
	private Integer operateType;  			//操作类型(加或者减库存---1表示加库存，2表示减库存)
	private Integer flag = 1;				//是否需要更改商品信息中的实际购买量和虚拟购买量(1表示需要更改)
	private String orderId;  				//order_id
	private String remark;   				//remark
	private Integer priceId;				//商品价格id
	private int changeType;  				//活动类型
	private int oldActualQuantity;			//原实际库存（更改库存时查询的，记录历史需要）
	
	
	//set get
	
	public String getSku() {
		return sku;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getCanSoldProductNumber() {
		return canSoldProductNumber;
	}
	public void setCanSoldProductNumber(Integer canSoldProductNumber) {
		this.canSoldProductNumber = canSoldProductNumber;
	}
	public Integer getActualProductNumber() {
		return actualProductNumber;
	}
	public void setActualProductNumber(Integer actualProductNumber) {
		this.actualProductNumber = actualProductNumber;
	}
	public Integer getOperateType() {
		return operateType;
	}
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
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
	public int getChangeType() {
		return changeType;
	}
	public void setChangeType(int changeType) {
		this.changeType = changeType;
	}
	public int getOldActualQuantity() {
		return oldActualQuantity;
	}
	public void setOldActualQuantity(int oldActualQuantity) {
		this.oldActualQuantity = oldActualQuantity;
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
	
}
