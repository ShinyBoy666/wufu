package cn.xinmeng.shop;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.xinmeng.api.entity.auto.Coupon;
import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.base.Base;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.common.util.encrypt.Base64Utils;
import cn.xinmeng.web.base.entity.PageSearchEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.shop.entity.customer.S1025RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1026RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1027RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1031RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1033RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1034RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1044RequestEntity;
import cn.xinmeng.web.shop.entity.order.vo.OrderCartVo;
import cn.xinmeng.web.shop.entity.pay.S1024RequestEntity;

public class AccountTest extends Base{

	//账户明细
	@Test
	public void s1024() {
		S1024RequestEntity entity = new S1024RequestEntity();
		entity.setCustomerId(22);
		entity.setShopId(1);
		entity.setPaymentType(2);
		String result = HttpClientUtils.postRequest(URL, getParam("1024", entityToMap(entity)));
		System.out.println(result);
	}

	//头像上传
	@Test
	public void s1025() throws Exception {
		S1025RequestEntity entity = new S1025RequestEntity();
		String base64 = Base64Utils.encode(Base64Utils.fileToByte("D:/s.png"));
		entity.setCustomerId(22);
		entity.setShopId(1);
		entity.setBase64String(base64);
		String result = HttpClientUtils.postRequest(URL, getParam("1025", entityToMap(entity)));
		System.out.println(result);
	}

	//修改个人资料
	@Test
	public void s1026() throws Exception {
		S1026RequestEntity entity = new S1026RequestEntity();
		entity.setCustomerId(22);
		entity.setShopId(1);
		entity.setHeadSculpture("头像");
		entity.setSex(2);
		entity.setNickname("校长");
		String result = HttpClientUtils.postRequest(URL, getParam("1026", entityToMap(entity)));
		System.out.println(result);
	}

	//客户反馈
	@Test
	public void s1027() throws Exception {
		S1027RequestEntity entity = new S1027RequestEntity();
		entity.setCustomerId(22);
		entity.setAppVeision("1.1.0");
		entity.setSystemVersion("sys1.1.0");
		entity.setFromType(1);
		entity.setImei("imei-1213");
		entity.setReplyContent("系统还不错，没有bug");
		String result = HttpClientUtils.postRequest(URL, getParam("1027", entityToMap(entity)));
		System.out.println(result);
	}

	//客户反馈
	@Test
	public void s1028() throws Exception {
		RequestBaseEntity entity = new RequestBaseEntity();
		entity.setCustomerId(22);
		String result = HttpClientUtils.postRequest(URL, getParam("1028", entityToMap(entity)));
		System.out.println(result);
	}

	//充值
	@Test
	public void s1029() throws Exception {
		CustomerRecharge entity = new CustomerRecharge();
		entity.setCustomerId(22);
		entity.setRechareFrom(1);
		entity.setRechargeType(1);
		entity.setAmount(100.00);
		String result = HttpClientUtils.postRequest(URL, getParam("1029", entityToMap(entity)));
		System.out.println(result);
	}
	

	//我的优惠券列表
	@Test
	public void s1031() throws Exception {
		S1031RequestEntity entity = new S1031RequestEntity();
		entity.setCustomerId(23);
		entity.setCouponState(1);
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1031", entityToMap(entity)));
		System.out.println(result);
	}

	//领取优惠券（添加）
	@Test
	public void s1032() throws Exception {
		Coupon entity = new Coupon();
		entity.setCustomerId(23);
		entity.setShopId(1);
		entity.setCouponCode("XVTP7RMQ");
		entity.setCouponApplyId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1032", entityToMap(entity)));
		System.out.println(result);
	}


	//下单，查询可用优惠券
	@Test
	public void s1033() throws Exception {
		S1033RequestEntity entity = new S1033RequestEntity();
		entity.setCustomerId(23);
		entity.setShopId(1);
		List<Integer> cartIds = new ArrayList<Integer>();
		cartIds.add(135);
		cartIds.add(137);
		entity.setCartIds(cartIds);
		String result = HttpClientUtils.postRequest(URL, getParam("1033", entityToMap(entity)));
		System.out.println(result);
	}

	//店铺可领取优惠券列表
	@Test
	public void s1034() throws Exception {
		S1034RequestEntity entity = new S1034RequestEntity();
		entity.setCustomerId(22);
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1034", entityToMap(entity)));
		System.out.println(result);
	}

	//获取购物车优惠券，邮费信息
	@Test
	public void s1044() throws Exception {
		S1044RequestEntity entity = new S1044RequestEntity();
		entity.setCustomerId(22);
		entity.setShopId(1);
		List<OrderCartVo> orderCarts = new ArrayList<OrderCartVo>();
		OrderCartVo vo = new OrderCartVo();
		vo.setShopId(1);
		List<Integer> list = new ArrayList<Integer>();
		list.add(26);
		vo.setCartIds(list);
		
		orderCarts.add(vo);
		entity.setOrderCarts(orderCarts);
		String result = HttpClientUtils.postRequest(URL, getParam("1044", entityToMap(entity)));
		System.out.println(result);
	}

	//账户明细
	@Test
	public void s1051() {
		RequestBaseEntity entity = new RequestBaseEntity();
		entity.setCustomerId(23);
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1051", entityToMap(entity)));
		System.out.println(result);
	}

	//账户明细
	@Test
	public void s1052() {
		PageSearchEntity entity = new PageSearchEntity();
		entity.setCustomerId(22);
		entity.setShopId(1);
		entity.setCurrentPage(1);
		entity.setLimit(10);
		String result = HttpClientUtils.postRequest(URL, getParam("1052", entityToMap(entity)));
		System.out.println(result);
	}
}
