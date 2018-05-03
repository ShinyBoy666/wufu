package cn.xinmeng.api.thread;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.xinmeng.api.entity.auto.GetuiMessage;
import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.WechatAccount;
import cn.xinmeng.api.enums.ConsumTypeEnum;
import cn.xinmeng.api.enums.QuickOrderTypeEnum;
import cn.xinmeng.api.service.IAccountService;
import cn.xinmeng.api.service.IGetuiMessageService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.IWechatAccountService;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.H5Utils;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilGetui;
import cn.xinmeng.common.util.UtilGetui.GetuiTypeEnum;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.common.util.http.HttpClient;

/**
 * 推送通知
 * @author Administrator
 *
 */
public class GetuiThread implements Runnable{

	private Integer type;//类型 : 新订单推送 -1;新快速订单推送 -2;
	
	private QuickOrder quickOrder;//优惠买单
	
	private Order order;
	
	private IGetuiMessageService getuiMessageService;
	
	private IAccountService accountService;
	
	private IWechatAccountService wechatAccountService;
	
	private IShopInfoService shopInfoService;
	
	public GetuiThread(Order order,IGetuiMessageService getuiMessageService){
		this.order = order;
		this.getuiMessageService = getuiMessageService;
		this.type = 1;
	}
	
	public GetuiThread(QuickOrder quickOrder,IGetuiMessageService getuiMessageService,IAccountService accountService,IWechatAccountService wechatAccountService,IShopInfoService shopInfoService){
		this.getuiMessageService = getuiMessageService;
		this.quickOrder = quickOrder;
		this.type = 2;
		this.accountService = accountService;
		this.wechatAccountService = wechatAccountService;
		this.shopInfoService = shopInfoService;
	}
	
	@Override
	public void run() {
		try {
			LogManager.info(this.getClass(), MessageFormat.format("推送参数：type={0},quickOrder={1},order={2}",type,FastJsonUtils.bean2Json(quickOrder),FastJsonUtils.bean2Json(order)));
			StringBuffer sb = new StringBuffer("");
			if(type == 1 && order != null){
				sb.append(order.getShopId());
			}else if(type == 2 && quickOrder != null && !Utils.isEmpty(quickOrder.getShopId())){
				try {
					if(accountService != null){
						if(QuickOrderTypeEnum.RANDOM.key().equals(quickOrder.getOrderType()+"")){
							if(UtilMoney.compareTo(quickOrder.getTotalAmount(), 0.0) > 0){
								/** 销售收入  = 订单总金额 */
								accountService.shopRecharge(quickOrder.getShopId(), quickOrder.getTotalAmount(), ConsumTypeEnum.TYPE_2, quickOrder.getOrderId());
								if(UtilMoney.compareTo(quickOrder.getDiscountAmount(), 0.0) > 0){
									/** 销售奖励  = 客户享受的折扣 */
									accountService.shopRecharge(quickOrder.getShopId(), quickOrder.getDiscountAmount(), ConsumTypeEnum.TYPE_4, quickOrder.getOrderId());
								}
							}else{
								LogManager.info(this.getClass(), "订单金额异常不执行店铺充值,参数:quickOrder="+FastJsonUtils.bean2Json(quickOrder));
							}
						}else{
							if(UtilMoney.compareTo(quickOrder.getPayAmount(), 0.0) > 0){
								/** 销售收入  = 客户实际付的钱 */
								accountService.shopRecharge(quickOrder.getShopId(), quickOrder.getPayAmount(), ConsumTypeEnum.TYPE_2, quickOrder.getOrderId());
							}else{
								LogManager.info(this.getClass(), "订单金额异常不执行店铺充值,参数:quickOrder="+FastJsonUtils.bean2Json(quickOrder));
							}
						}
					}
				} catch (Exception e) {
					LogManager.error(this.getClass(), "店铺充值异常,参数:quickOrder="+quickOrder,e);
				}
				
				sb.append(quickOrder.getShopId());
				
				String shopName = shopInfoService.queryShopNameByShopId(quickOrder.getShopId());
				Integer totalAmount = quickOrder.getTotalAmount().intValue();
				String remark;
				if(Utils.isEmpty(totalAmount)){
					remark = MessageFormat.format("本次买单优惠{0}元，订单总金额{1}。祝您生活愉快！", quickOrder.getDiscountAmount(),quickOrder.getTotalAmount());
				}else{
					remark = MessageFormat.format("本次买单优惠{0}元，订单总金额{1}，同时您获取领取{2}元优惠券的机会！祝您生活愉快！", quickOrder.getDiscountAmount(),quickOrder.getTotalAmount(),totalAmount);
				}
				sendWechatMessage(quickOrder.getOpenId(), remark, shopName, quickOrder.getPayAmount());
			}
			if(sb.length() > 0){
				//查询个推id
				String result = HttpClient.getInstance().doPost(H5Utils.getHoutaiUrl("shopoutservice/action003"), "{\"shopIds\":\""+sb.toString()+"\"}");
				Map<String, Object> resMap = FastJsonUtils.json2Bean(result, Map.class);
				if(resMap != null && "SUCCESS".equals(resMap.get("IsSuccess")) && !Utils.isEmpty(resMap.get("Data"))){
					String cid = resMap.get("Data").toString();
					String title = "新订单";
					String description = "您有一个新订单，请及时处理！";
					if(type == 2){
						WechatAccount wechatAccount = wechatAccountService.getWechatAccount(quickOrder.getOpenId());
						if(wechatAccount != null && !Utils.isEmpty(wechatAccount.getNickname())){
							title = MessageFormat.format("收到{0}的付款信息", wechatAccount.getNickname());
						}else{
							title = MessageFormat.format("收到订单编号为{0}的付款信息", quickOrder.getOrderId());
						}
						
						String orderType = QuickOrderTypeEnum.keyToValue(quickOrder.getOrderType()+""); 
						description = MessageFormat.format("实付金额{0}，优惠金额{1}，优惠方式{2}，订单总额{3}。",quickOrder.getPayAmount(),quickOrder.getDiscountAmount(),orderType,quickOrder.getTotalAmount());
					}
					
					String appID = HelperPropertie.getValue("getui.appID.business");
					Map<String, Object> obj = new HashMap<String, Object>();
					obj.put("Title", title);
					obj.put("Description", description);
					obj.put("Type", type);
					
					GetuiMessage getuiMessage = new GetuiMessage();
					getuiMessage.setTitle(title);
					getuiMessage.setDescription(description);
					getuiMessage.setShowType(1);
					getuiMessage.setSendType(type);
					getuiMessage.setUrlLink("");
					getuiMessage.setReceiveType(2);
					getuiMessage.setReceiveObject(cid);
					getuiMessage.setWhetherSend(1);
					
					if(UtilGetui.send(cid, appID, title, "", description, "004", obj, GetuiTypeEnum.LIST)){
						getuiMessage.setSendStatus(4);
					}else{
						getuiMessage.setSendStatus(5);
					}
					String createUser = "api";
					Date now = new Date();
					getuiMessage.setSendTime(now);
					getuiMessage.setCreateTime(now);
					getuiMessage.setCreateUser(createUser);
					getuiMessage.setUpdateTime(now);
					getuiMessage.setUpdateUser(createUser);
					getuiMessageService.add(getuiMessage);
				}
			}
		} catch (Exception e) {
			LogManager.error(this.getClass(), MessageFormat.format("推送通知异常：type={0},quickOrder={1},order={2}",type,FastJsonUtils.bean2Json(quickOrder),FastJsonUtils.bean2Json(order)), e);
		}
	}

	
	private void sendWechatMessage(String openId,String remark,String shopName,Double payAmount){
		Map<String, Object> param = new HashMap<String,Object>();
		try {
			Map<String, Object> data = new HashMap<String,Object>();
			data.put("first", "优惠买单成功");
			data.put("product", shopName);
			data.put("price", payAmount);
			data.put("time", DateUtil.formatDate(new Date(), "yyyy年MM月dd日"));
			data.put("remark", remark);
			param.put("Code", "001");
			param.put("OpenId", openId);
			param.put("Data", data);
			StringBuffer sb = new StringBuffer("");
			sb.append(param.get("Code"));
			sb.append(param.get("OpenId"));
			sb.append(FastJsonUtils.bean2Json(param.get("Data")));
			sb.append("123456");
			param.put("Sign", UtilMD5.MD5(sb.toString().toLowerCase()));
			String url = HelperPropertie.getValue("wechat.message.url");
			HttpClient.getInstance().doPost(url, FastJsonUtils.bean2Json(param));
		} catch (Exception e) {
			LogManager.error(this.getClass(), MessageFormat.format("微信模板消息异常：param={0}",FastJsonUtils.bean2Json(param)), e);
		}
	}
}
