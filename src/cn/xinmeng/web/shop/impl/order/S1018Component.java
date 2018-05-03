package cn.xinmeng.web.shop.impl.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Order;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.OrderExample;
import cn.xinmeng.api.enums.OrderStateEnum;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.service.IOrderProductService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.base.util.StateConvertUtils;
import cn.xinmeng.web.shop.entity.order.S1018RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1018ResponseEntity;
import cn.xinmeng.web.shop.enums.WebShowOrderStateEnum;

/**
 * 我的订单查询
 * @param 
 * @ClassName: S1018Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.order.S1018Component")
public class S1018Component extends BaseService {

	@Resource
	private IOrderService orderService;
	@Resource
	private IOrderProductService orderProductService;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IProductPriceService productPriceService;
	@Resource
	private IShopInfoService shopInfoService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1018RequestEntity entity = parseRequertParam(data, S1018RequestEntity.class);
		
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getOrderState())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_STATE);
		}
		Integer shopId = request.getLoginShopId();
//		if(!Utils.isEmpty(entity.getShopId())){
//			shopId = entity.getShopId();
//		}

		//返回分页数据
		PageInfoEntity<S1018ResponseEntity> resPage = new PageInfoEntity<S1018ResponseEntity>();
		//返回列表数据
		List<S1018ResponseEntity> resList = new ArrayList<S1018ResponseEntity>();
		
		//查询我的订单（除待支付的）
		OrderExample orderExample = new OrderExample();
		OrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andCustomerIdEqualTo(entity.getCustomerId());
		orderExample.setOrderByClause(" id desc ");
		List<Order> listOrder = new ArrayList<Order>();
		

		//1-待付款，2-进行中，3，已完成
		if(entity.getOrderState() == 1){
			//待付款
			orderCriteria.andOrderStateEqualTo(Integer.valueOf(OrderStateEnum.STATE_SUCCESS.key()));//订单状态
			List<Integer> payStateList = new ArrayList<Integer>();
			payStateList.add(Integer.valueOf(PaymentStateEnum.STATE_PAY_NOT.key()));
			payStateList.add(Integer.valueOf(PaymentStateEnum.STATE_PAYING.key()));
			orderCriteria.andPayStateIn(payStateList);//支付状态
		}else if(entity.getOrderState() == 2){
			//进行中
			List<Integer> orderStateList = new ArrayList<Integer>();
			orderStateList.add(Integer.valueOf(OrderStateEnum.STATE_SUCCESS.key()));
			orderStateList.add(Integer.valueOf(OrderStateEnum.STATE_FOR_OUTBOUND.key()));
			orderStateList.add(Integer.valueOf(OrderStateEnum.STATE_DISTRIBUTION.key()));
			orderCriteria.andOrderStateIn(orderStateList);//订单状态
			orderCriteria.andPayStateEqualTo(Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key()));//支付状态
		}else if(entity.getOrderState() == 3){
			//已完成
			List<Integer> orderStateList = new ArrayList<Integer>();
			orderStateList.add(Integer.valueOf(OrderStateEnum.STATE_TIMEOUT.key()));
			orderStateList.add(Integer.valueOf(OrderStateEnum.STATE_CANCEL.key()));
			orderStateList.add(Integer.valueOf(OrderStateEnum.STATE_FINISH.key()));
			orderCriteria.andOrderStateIn(orderStateList);
		}
		
		//非待支付状态查询，总条数
		int totalCount = orderService.countByExample(orderExample);
		
		if(totalCount > 0){
			listOrder = orderService.selectByExample(entity.getCurrentPage(), entity.getLimit(), orderExample);
			if(listOrder != null && listOrder.size() > 0){
				ShopInfo shopInfo = shopInfoService.queryShopInfoById(listOrder.get(0).getShopId(),"id,shop_name,shop_logo");
				
				for (Order order : listOrder) {
					S1018ResponseEntity res = new S1018ResponseEntity();
					if(shopInfo != null){
						res.setShopName(shopInfo.getShopName());	//店铺名称
						res.setShopLogo(shopInfo.getShopLogo());//log
					}
					res.setChildOrderId(order.getOrderId());
					res.setParentOrderId(order.getOrderId());
					res.setPayAmount(order.getPayAmount());
					//设置商品图片，商品名称
					Map<String,List<String>> productNameMap = orderService.queryProductImage(order.getOrderId());
					setProductName(res, productNameMap);
					String orderState = StateConvertUtils.orderShowSateKey(order.getOrderState(),order.getPayState());
					res.setAlreadyPaid(order.getAccountPayment());
					res.setState(Integer.valueOf(orderState));
					res.setStateValue(WebShowOrderStateEnum.keyToValue(orderState));
					resList.add(res);
				}
			}
		}
		resPage.setList(resList);
		resPage.setCurrentPage(entity.getCurrentPage());
		resPage.setLimit(entity.getLimit());
		resPage.setTotalRecord(totalCount);
		return getAppResponseEntity(resPage);
	}

	private void setProductName(S1018ResponseEntity res,Map<String,List<String>> productNameMap){
		List<String> imageUrl = new ArrayList<String>();
		Iterator<String> itr = productNameMap.keySet().iterator();
		String productName = "";
		while(itr.hasNext()){
			productName = itr.next();
			List<String> list = productNameMap.get(productName);
			if(Utils.isEmpty(list)){
				continue;
			}
			imageUrl.addAll(list);
		}
		res.setProductName(productName);
		res.setProductImageList(imageUrl);
	}
}
