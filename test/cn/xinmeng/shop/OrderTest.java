package cn.xinmeng.shop;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.xinmeng.api.entity.auto.AgentApply;
import cn.xinmeng.base.Base;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageSearchEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.shop.entity.base.S1080RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1069RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1070RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1071RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1091RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1018RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1019RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1020RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1021RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1022RequestEntity;
import cn.xinmeng.web.shop.entity.order.vo.OrderCartVo;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;
import cn.xinmeng.web.shop.entity.quickorder.S1084RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1004RequestEntity;

public class OrderTest extends Base{

	//创建订单
	@Test
	public void s1021() {
		S1021RequestEntity entity = new S1021RequestEntity();
		entity.setCustomerId(22);
		entity.setOrderFrom(1);
		entity.setAddressId(1);
		entity.setOnlinePayType(1);
		entity.setAccountDeduct(true);
		entity.setShopId(1);
		
		List<OrderCartVo> shopCarts = new ArrayList<OrderCartVo>();
		OrderCartVo shopCart = new OrderCartVo();
		shopCart.setShopId(1);
		
		//购物车
		List<Integer> cartIds = new ArrayList<Integer>();
//		cartIds.add(17);
		cartIds.add(22);
		shopCart.setCartIds(cartIds);
		shopCarts.add(shopCart);
		
		//店铺购物车
		entity.setShopCarts(shopCarts);

		String result = HttpClientUtils.postRequest(URL, getParam("1021", entityToMap(entity)));
		System.out.println(result);
	}

	//创建订单
	@Test
	public void s1022() {
		S1022RequestEntity entity = new S1022RequestEntity();
		entity.setCustomerId(22);
		entity.setOrderFrom(1);
		entity.setAddressId(5);
		entity.setOnlinePayType(1);
		entity.setAccountDeduct(true);
		entity.setShopId(1);
		entity.setProductId(100000);
		entity.setProductNumber(1);
		entity.setCouponCode("");
		entity.setSku("|默认|");
		String result = HttpClientUtils.postRequest(URL, getParam("1022", entityToMap(entity)));
		System.out.println(result);
	}

	
	//再次支付
	@Test
	public void s1023() {
		PayOrderBiz entity = new PayOrderBiz();
		entity.setCustomerId(22);
		entity.setParentOrderId("19194704700022");
		entity.setOnlinePayType(1);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1023", entityToMap(entity)));
		System.out.println(result);
	}
	
	//订单列表查询
	@Test
	public void s1018() {
		S1018RequestEntity entity = new S1018RequestEntity();
		entity.setCustomerId(22);
		entity.setShopId(1);
		entity.setOrderState(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1018", entityToMap(entity)));
		System.out.println(result);
	}

	//订单详情
	@Test
	public void s1019() {
		S1019RequestEntity entity = new S1019RequestEntity();
		entity.setCustomerId(25);
		entity.setShopId(1);
//		entity.setChildOrderId("19159290600022");
		entity.setParentOrderId("19376559100025");
		String result = HttpClientUtils.postRequest(URL, getParam("1019", entityToMap(entity)));
		System.out.println(result);
	}
	//订单确认、取消
	@Test
	public void s1020() {
		S1020RequestEntity entity = new S1020RequestEntity();
		entity.setCustomerId(22);
		entity.setShopId(1);
		entity.setState(3);//2取消，1-确认
		entity.setChildOrderId("19376559100025");
		entity.setParentOrderId("19376559100025");
		String result = HttpClientUtils.postRequest(URL, getParam("1020", entityToMap(entity)));
		System.out.println(result);
	}
	@Test
	public void s1069() throws BusinessException {
		S1069RequestEntity entity = new S1069RequestEntity();
		entity.setShopId(1);
		entity.setActivityId(1);
		entity.setActivityType(1);
		entity.setProductId(12);
		entity.setCustomerId(1);
		entity.setProductPriceId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1069", entityToMap(entity)));
		System.out.println(result);
	}


	@Test
	public void s1075() throws BusinessException {
		S1070RequestEntity entity = new S1070RequestEntity();
		entity.setShopId(1);
		entity.setActivityId(1);
		entity.setActivityType(1);
		entity.setCustomerId(1);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1075", entityToMap(entity)));
		System.out.println(result);
	}

	@Test
	public void s1070() throws BusinessException {
		S1070RequestEntity entity = new S1070RequestEntity();
		entity.setShopId(1);
		entity.setActivityId(1);
		entity.setActivityType(1);
		entity.setCustomerId(1);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1070", entityToMap(entity)));
		System.out.println(result);
	}

	@Test
	public void s1071() throws BusinessException {
		S1071RequestEntity entity = new S1071RequestEntity();
		entity.setShopId(1);
		entity.setActivityId(1);
		entity.setActivityType(1);
		entity.setProductId(12);
		entity.setProductNumber(3);
		entity.setCustomerId(8);
		entity.setProductPriceId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1071", entityToMap(entity)));
		System.out.println(result);
	}

	@Test
	public void s1072() throws BusinessException {
		RequestBaseEntity entity = new RequestBaseEntity();
		entity.setShopId(1);
		entity.setId(1);
		entity.setCustomerId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1072", entityToMap(entity)));
		System.out.println(result);
	}

	@Test
	public void s1073() throws BusinessException {
		RequestBaseEntity entity = new RequestBaseEntity();
		entity.setShopId(1);
		entity.setId(1);
		entity.setCustomerId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1073", entityToMap(entity)));
		System.out.println(result);
	}
	
	@Test
	public void s1022_1() throws BusinessException {
		S1022RequestEntity entity = new S1022RequestEntity();
		entity.setActivityId(1);
		entity.setActivityType(1);
		entity.setCustomerId(1);
		entity.setOrderFrom(1);
		entity.setAddressId(1);
		entity.setOnlinePayType(1);
		entity.setAccountDeduct(false);
		entity.setShopId(1);
		entity.setProductId(12);
		entity.setProductNumber(1);
		entity.setCouponCode("");
		entity.setSku("|默认|");
		entity.setProductPriceId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1022", entityToMap(entity)));
		System.out.println(result);
	}

	@Test
	public void s1037() throws BusinessException {
		RequestBaseEntity entity = new RequestBaseEntity();
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1037", entityToMap(entity)));
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
		
	}
	
	@Test
	public void s1079() throws BusinessException {
		String result = HttpClientUtils.postRequest(URL, getParam("1079", entityToMap(null)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}
	@Test
	public void s1078() throws BusinessException {
		String result = HttpClientUtils.postRequest(URL, getParam("1079", entityToMap(null)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}
	@Test
	public void s1077() throws BusinessException {
		AgentApply apply = new AgentApply();
		apply.setAgentType(1);
		apply.setEmail("123@qq.com");
		apply.setEnterpriseName("舜凯");
		apply.setLinkman("笑话");
		apply.setTelephone("18612100102");
		String result = HttpClientUtils.postRequest(URL, getParam("1077", entityToMap(null)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}
	

	@Test
	public void s1080() throws BusinessException {
		S1080RequestEntity entity = new S1080RequestEntity();
//		entity.setDeviceType(deviceType);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1080", entityToMap(entity)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}

	@Test
	public void s1081() throws BusinessException {
		PageSearchEntity entity = new PageSearchEntity();
//		entity.setDeviceType(deviceType);
		entity.setCustomerId(1);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1081", entityToMap(entity)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}
	

	@Test
	public void s1083() throws BusinessException {
		S1004RequestEntity entity = new S1004RequestEntity();
		entity.setCustomerId(1);
		entity.setCellphone("18612100102");
		entity.setOpenId("1234567890");
		entity.setSmsCode("8090");
		
		String result = HttpClientUtils.postRequest(URL, getParam("1083", entityToMap(entity)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}

	@Test
	public void s1084() throws BusinessException {
		S1084RequestEntity entity = new S1084RequestEntity();
		entity.setCustomerId(1);
		entity.setOpenId("1234567890");
		
		String result = HttpClientUtils.postRequest(URL, getParam("1084", entityToMap(entity)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}
	@Test
	public void s1091() throws BusinessException {
		S1091RequestEntity entity = new S1091RequestEntity();
		entity.setCustomerId(1);
		entity.setAmount(950.00);
		entity.setOrderId("Q20215369973422");
		entity.setShopId(1);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1091", entityToMap(entity)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}
	
}
