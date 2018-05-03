package cn.xinmeng.web.shop.entity.market;

import java.util.List;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.address.S1015ResponseEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCustCouponVo;

/**
 * 秒杀订单确认页
 * @param 
 * @ClassName: S1071ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1071ResponseEntity extends ResponseBaseEntity{

	private static final long serialVersionUID = 276803916103086879L;


	private boolean isDelivery = true;				//是否需要发货
	private boolean isRealyname = false;			//是否需要填写身份证
	private boolean isSeat = false;			//是否需要填写座位号
    private Double discountAmount; //订单优惠金额
	private boolean accountDeduct;					//帐户支付
    private Double cashAmount; 						//现金账户
	private Double totalAmount;						//商品总金额
	private Double totalPostage;					//总邮费
	private S1015ResponseEntity address;			//默认地址（没有默认地址，默认取第一条）
	private ShopCartVo productInfo;					//商品信息
	private List<ShopCustCouponVo> usableCoupons;	//可使用优惠券
	
	
	//set get 
	
	
	public boolean getIsDelivery() {
		return isDelivery;
	}
	public void setIsDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}
	public boolean getIsRealyname() {
		return isRealyname;
	}
	public void setRealyname(boolean isRealyname) {
		this.isRealyname = isRealyname;
	}
	public boolean isAccountDeduct() {
		return accountDeduct;
	}
	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}
	public Double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getTotalPostage() {
		return totalPostage;
	}
	public void setTotalPostage(Double totalPostage) {
		this.totalPostage = totalPostage;
	}
	public S1015ResponseEntity getAddress() {
		return address;
	}
	public void setAddress(S1015ResponseEntity address) {
		this.address = address;
	}
	public ShopCartVo getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ShopCartVo productInfo) {
		this.productInfo = productInfo;
	}
	public List<ShopCustCouponVo> getUsableCoupons() {
		return usableCoupons;
	}
	public void setUsableCoupons(List<ShopCustCouponVo> usableCoupons) {
		this.usableCoupons = usableCoupons;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public boolean getIsSeat() {
		return isSeat;
	}
	public void setIsSeat(boolean isSeat) {
		this.isSeat = isSeat;
	}
}
