package cn.xinmeng.common.enums.ex;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 订单模块错误提示
 * @param 
 * @ClassName: ShowOrderStateEnum 
 * @version V1.0  
 * @date 2015年12月8日 上午9:14:17 
 * @author jiangyong.tan
 * @return 
 *
 */
public enum ExProductEnum implements IEnum {
	EX_NULL_PRODUCTID("EX_NULL_PRODUCTID","商品ID为空..."),
	EX_NULL_PRODUCTPRICEID("EX_NULL_PRODUCTPRICEID","商品价格ID为空..."),
	EX_EXISTS_PRODUCTID("EX_EXISTS_PRODUCTID","商品不存在..."),
	EX_ACTIVITYPURCHASE("EX_ACTIVITYPURCHASE","您已经参与活动..."),
	EX_EXISTS_ACTIVITY_PRODUCT("EX_EXISTS_ACTIVITY_PRODUCT","活动商品不存在..."),
	EX_NOT_ACTIVITY("EX_NOT_ACTIVITY","活动暂未实现..."),
	EX_NULL_ACTIVITYID("EX_NULL_ACTIVITYID","活动ID为空..."),
	EX_NULL_ACTIVITYTYPE("EX_NULL_ACTIVITYTYPE","活动类型为空..."),
	EX_EXISTS_ACTIVITY("EX_EXISTS_ACTIVITY","活动不存在..."),
	EX_EXISTS_ACTIVITY_TYPE("EX_EXISTS_ACTIVITY_TYPE","活动类型不存在..."),
	EX_NULL_MODUL_ID("EX_NULL_MODUL_ID","模板ID为空..."),
	EX_NULL_PRODUCT_SKU("EX_NULL_PRODUCT_SKU","商品sku为空..."),
	PRODUCTPRICE_NOT_EXITS("PRODUCTPRICE_NOT_EXITS","商品价格不存在..."),
	SCORE_PRODUCT_NOT_EXITS("SCORE_PRODUCT_NOT_EXITS","积分商品不存在..."),
	PRODUCTINFO_NOT_EXITS("PRODUCTINFO_NOT_EXITS","商品不存在..."),
	PRODUCT_LOW_STOCKS("PRODUCT_LOW_STOCKS","商品库存不足..."),
	MAX_BUY("MAX_BUY","超过最大购买量..."),
	PRODUCT_NUMBER_NULL("PRODUCT_NUMBER_NULL","商品数量不能为空..."),
	PRODUCTID_IS_NULL("PRODUCTID_IS_NULL","商品编号不能为空..."),
	SOCRE_PRODUCT_IS_NULL("SOCRE_PRODUCT_IS_NULL","商品兑换积分不能为空或为零..."),
	PRODUCT_SOLD_OUT("PRODUCT_SOLD_OUT","商品已下架..."),
	ACTIVITY_EXPIRED("ACTIVITY_EXPIRED","活动已经过期..."),
	PRODUCT_PRICE_ERROR("PRODUCT_PRICE_ERROR","商品价格异常..."),
	EX_NULL_CATEGORY_ID("EX_NULL_CATEGORY_ID","商品分类ID为空..."),
	;
	private ExProductEnum(String key,String value){
		this.key = key;
		this.value = value;
	}
	private String key;
	private String value;
	
	@Override
	public String value() {
		return this.value;
	}

	@Override
	public String key() {
		return this.key;
	}

	@Override
	public IEnum parseValue(Object... params) {
		return setValue(MessageFormat.format(value, params));
	}

	@Override
	public IEnum setValue(String value) {
		this.value = value;
		return this;
	}

}
