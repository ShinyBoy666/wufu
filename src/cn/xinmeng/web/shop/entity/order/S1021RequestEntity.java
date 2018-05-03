package cn.xinmeng.web.shop.entity.order;

import java.util.List;

import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.shop.entity.order.vo.OrderCartVo;


/**
 * 创建订单
 * @param 
 * @ClassName: S1019RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:12:42 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1021RequestEntity extends RequestBaseEntity{
	
	private static final long serialVersionUID = -8488427047264809072L;

	private Integer orderFrom;				//订单来源
	private Integer addressId;				//收货地址id
	private Integer onlinePayType;			//在线支付方式
	private boolean accountDeduct;			//是否账户扣款
	private String recipientIdentityCard;	//收件人身份证
	private String realyname;				//身份证名称
	private List<OrderCartVo> shopCarts;	//店铺购物车
	private String seatNumber; //座位号
	
	//set get
	
	public Integer getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getOnlinePayType() {
		return onlinePayType;
	}

	public void setOnlinePayType(Integer onlinePayType) {
		this.onlinePayType = onlinePayType;
	}

	public List<OrderCartVo> getShopCarts() {
		return shopCarts;
	}

	public void setShopCarts(List<OrderCartVo> shopCarts) {
		this.shopCarts = shopCarts;
	}

	public boolean isAccountDeduct() {
		return accountDeduct;
	}

	public void setAccountDeduct(boolean accountDeduct) {
		this.accountDeduct = accountDeduct;
	}

	public String getRecipientIdentityCard() {
		return recipientIdentityCard;
	}

	public void setRecipientIdentityCard(String recipientIdentityCard) {
		this.recipientIdentityCard = recipientIdentityCard;
	}

	public String getRealyname() {
		return realyname;
	}

	public void setRealyname(String realyname) {
		this.realyname = realyname;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
}
