package cn.xinmeng.web.shop.entity.order;

import java.util.List;

import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;


/**
 * 我的订单查询
 * @param 
 * @ClassName: S1018ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:59:44 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1018ResponseEntity extends ResponseBaseEntity {
	
	private static final long serialVersionUID = 5262480240079496315L;
	
	private String parentOrderId;	//父订单ID
	private String childOrderId;	//订单ID
	private String shopName = "舜凯云商";	//
	private String shopLogo;	//店铺图标
	private List<String> productImageList;//购买商品图片
	private String productName;//商品名称
	private Double payAmount;//实付款
	private Double alreadyPaid;//已付款
	private int state;	//状态 1-待支付，2-待收货，3-已完成，4-已取消
	private String stateValue;	//状态值 1-待支付，2-待收货，3-已完成，4-已取消
	
	
	//set get
	
	public String getChildOrderId() {
		return childOrderId;
	}
	public void setChildOrderId(String childOrderId) {
		this.childOrderId = childOrderId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public List<String> getProductImageList() {
		return productImageList;
	}
	public void setProductImageList(List<String> productImageList) {
		this.productImageList = productImageList;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateValue() {
		return stateValue;
	}
	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}
	public String getParentOrderId() {
		return parentOrderId;
	}
	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getAlreadyPaid() {
		return alreadyPaid;
	}
	public void setAlreadyPaid(Double alreadyPaid) {
		this.alreadyPaid = alreadyPaid;
	}
	public String getShopLogo() {
		if(Utils.isEmpty(shopLogo)){
			return HelperPropertie.getValue("jipinhui.logo");
		}
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	
}
