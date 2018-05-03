package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 秒杀订单确认页
 * @param 
 * @ClassName: S1071RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1071RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private Integer productId;
	private Integer activityType;
	private Integer activityId;
	private Integer productNumber;
	private Integer productPriceId;

	//set get

	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getActivityType() {
		return activityType;
	}
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	public Integer getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}
	
}
