package cn.xinmeng.web.shop.entity.order.vo;

import java.text.MessageFormat;
import java.util.Map;

import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;

import com.pay.common.WXTradeTypeEnum;
import com.pay.common.WXUtil;
import com.pay.common.WxUnifiedorderEntity;
import com.pay.config.SystemConfig;

public class ResponseOrderBiz extends ResponseBaseEntity {
	private static final long serialVersionUID = -2031980179646357787L;

	private String orderId;		//订单编号
	private String orderDescribe = "舜凯云商商场";//订单描述
	private long surplusValidTime;	//未支付订单有效时间
	private String rechargeId;		//支付单号
	private double totalAmount;		//订单总金额
	private double paymentAmount;	//在线支付金额
	private double deductAmount;	//本次账户应扣金额
	private String url = "";  //当请求来源为wap时,值为wap支付地址
	private String source = ""; //来源
	
	private Map<String, String> paramMap;

	//set get
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDescribe() {
		if(!Utils.isEmpty(source)){
			return source + orderDescribe;
		}
		return orderDescribe;
	}
	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}
	public long getSurplusValidTime() {
		int validTime = Integer.valueOf(HelperPropertie.getValue("time.valid.order"));
		setSurplusValidTime(validTime * 60);
		return surplusValidTime;
	}
	public void setSurplusValidTime(long surplusValidTime) {
		this.surplusValidTime = surplusValidTime;
	}
	public String getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(String rechargeId) {
		this.rechargeId = rechargeId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public double getDeductAmount() {
		return deductAmount;
	}
	public void setDeductAmount(double deductAmount) {
		this.deductAmount = deductAmount;
	}
	public String getUrl() {
		return url;
	}
	public Map<String, String> getParamMap() {
		return paramMap;
	}
	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setUrl(String type,int shopId,String ip) {
		if(paymentAmount > 0 && !Utils.isEmpty(rechargeId)){
			if("wap".equals(source)){
				if(PaymentGatewayEnum.PAY_GATEWAY_PAY_TREASURE.key().equals(type)){
					url = MessageFormat.format(SystemConfig.ali_wap, rechargeId,paymentAmount+"",shopId);
				}else if (PaymentGatewayEnum.PAY_GATEWAY_WE_CHAT.key().equals(type)) {
					Double amount = UtilMoney.multiplyToDouble(paymentAmount, 100);
					url = MessageFormat.format(SystemConfig.wx_wap, rechargeId,amount.intValue()+"",shopId);
				}
			}else{
				if(PaymentGatewayEnum.PAY_GATEWAY_WE_CHAT.key().equals(type)){
					Double amount = UtilMoney.multiplyToDouble(paymentAmount, 100);
					String prepayId = WXUtil.unifiedorder(new WxUnifiedorderEntity(rechargeId,ip,amount.intValue()+"",orderDescribe,WXTradeTypeEnum.APP,null));;
					this.setParamMap(WXUtil.submit(prepayId));
				}
			}
		}
	}
}
