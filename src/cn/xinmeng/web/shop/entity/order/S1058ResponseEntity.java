package cn.xinmeng.web.shop.entity.order;

import java.util.List;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.address.S1015ResponseEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;
import cn.xinmeng.web.shop.entity.customer.S1033ResponseEntity;


/**
 * 查询订单确认界面数据
 * @param 
 * @ClassName: S1058ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午3:24:12 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1058ResponseEntity extends ResponseBaseEntity {
	
	private static final long serialVersionUID = 4038552910872488148L;

	private boolean isDelivery = true;				//是否需要发货
	private boolean isRealyname = false;			//是否需要填写身份证
	private boolean isSeat = false;			//是否需要填写座位号
	private boolean accountDeduct;//帐户支付
    private Double cashAmount; //现金账户
	private Double totalAmount;				//商品总金额
	private Double totalPostage;			//总邮费
	private Double postageFree;			//满多少免邮费
	private S1015ResponseEntity address;	//默认地址（没有默认地址，默认取第一条）
	List<ShopCartVo> shopCarts;			//店铺购物车商品
	
	List<S1033ResponseEntity> shopCoupons;	//店铺优惠券列表

	
	//set get
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public S1015ResponseEntity getAddress() {
		return address;
	}
	public void setAddress(S1015ResponseEntity address) {
		this.address = address;
	}
	public Double getTotalPostage() {
		return totalPostage;
	}
	public void setTotalPostage(Double totalPostage) {
		this.totalPostage = totalPostage;
	}
	public List<S1033ResponseEntity> getShopCoupons() {
		return shopCoupons;
	}
	public void setShopCoupons(List<S1033ResponseEntity> shopCoupons) {
		this.shopCoupons = shopCoupons;
	}
	public List<ShopCartVo> getShopCarts() {
		return shopCarts;
	}
	public void setShopCarts(List<ShopCartVo> shopCarts) {
		this.shopCarts = shopCarts;
	}
	public Double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public boolean isAccountDeduct() {
		return accountDeduct;
	}
	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}
	public boolean getIsDelivery() {
		return isDelivery;
	}
	public void setDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}
	public boolean getIsRealyname() {
		return isRealyname;
	}
	public void setRealyname(boolean isRealyname) {
		this.isRealyname = isRealyname;
	}
	public boolean getIsSeat() {
		return isSeat;
	}
	public void setIsSeat(boolean isSeat) {
		this.isSeat = isSeat;
	}
	public Double getPostageFree() {
		return postageFree;
	}
	public void setPostageFree(Double postageFree) {
		this.postageFree = postageFree;
	}
}
