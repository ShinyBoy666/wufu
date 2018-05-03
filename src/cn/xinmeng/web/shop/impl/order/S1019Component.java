package cn.xinmeng.web.shop.impl.order;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.enums.OrderTypeEnum;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IOrderProductService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.base.util.StateConvertUtils;
import cn.xinmeng.web.shop.entity.order.S1019RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1019ResponseEntity;
import cn.xinmeng.web.shop.enums.WebShowOrderStateEnum;

/**
 * 我的订单详情
 * @param 
 * @ClassName: S1019Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.order.S1019Component")
public class S1019Component extends BaseService {
	
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IRedisService redisService;
	@Resource
	private IOrderProductService orderProductService;
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private ISystemConfigService systemConfigService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1019RequestEntity entity = parseRequertParam(data, S1019RequestEntity.class);
		
		/**
		 * 非空验证
		 */
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getChildOrderId()) && Utils.isEmpty(entity.getParentOrderId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_ID);
		}
		
		String orderId;
		if(!Utils.isEmpty(entity.getChildOrderId())){
			orderId = entity.getChildOrderId();
		}else{
			orderId = entity.getParentOrderId();
		}
		//查询订单详情
		Order order = orderService.queryByOrderId(orderId,null);
		if(order == null){
			throw new NullException(LogManager.getLogger(getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
		}
		//订单相关数据
		S1019ResponseEntity resEntity = new S1019ResponseEntity();
		resEntity.setCustomerId(order.getCustomerId());
		resEntity.setRecipientName(order.getRecipientName());
		resEntity.setRecipientPhone(order.getRecipientPhone());
		resEntity.setRecipientAddress(order.getRecipientAddress());
		Region region = redisService.getRegion(order.getDistrictId());
		if(region != null){
			if(Utils.isEmpty(region.getCityName())){
				resEntity.setRecipientCityName(region.getAreaName());
			}else{
				resEntity.setRecipientCityName(region.getCityName());
			}
			resEntity.setRecipientProvinceName(region.getProvinceName());
			resEntity.setRecipientDistrictName(region.getRegionName());
		}
		
		resEntity.setParentOrderId(order.getOrderId());
		resEntity.setChildOrderId(order.getOrderId());
		resEntity.setTargetShopId(order.getShopId());
		resEntity.setDiscountAmount(order.getDiscountAmount());
		resEntity.setPostage(order.getPostage());
		resEntity.setAccountPayment(order.getAccountPayment());
		resEntity.setPayAmount(order.getPayAmount());
		resEntity.setTotalAmount(order.getTotalAmount());
		resEntity.setCouponPayment(order.getCouponPayment());
		resEntity.setLogisticsNumber(order.getLogisticsNumber());
		resEntity.setCreateTime(order.getCreateTime());
		String orderState = StateConvertUtils.orderShowSateKey(order.getOrderState(),order.getPayState());
		resEntity.setState(Integer.valueOf(orderState));
		resEntity.setStateValue(WebShowOrderStateEnum.keyToValue(orderState));
		
		ShopInfo shopInfo = shopInfoService.queryShopInfoById(order.getShopId(), "id,shop_name,shop_logo");
		if(shopInfo != null){
			resEntity.setShopLogo(shopInfo.getShopLogo());
			resEntity.setShopName(shopInfo.getShopName());
		}
		//订单商品相关数据
		resEntity.setProductList(orderProductService.queryOrderProductVoByOrderId(orderId));
		if(customerService.isMember(entity.getCustomerId())){
			resEntity.setAccountDeduct(true);
		}else{
			if(order.getOrderType().equals(OrderTypeEnum.MEMBER.key())){
				resEntity.setAccountDeduct(true);
			}else{
				resEntity.setAccountDeduct(systemConfigService.notNumberBalancePay());
			}
		}
		return getAppResponseEntity(resEntity);
	}
}
