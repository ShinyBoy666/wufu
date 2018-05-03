package cn.xinmeng.shop;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.base.Base;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.web.shop.entity.cart.S1009RequestEntity;
import cn.xinmeng.web.shop.entity.cart.S1010RequestEntity;
import cn.xinmeng.web.shop.entity.cart.S1011RequestEntity;
import cn.xinmeng.web.shop.entity.cart.S1012RequestEntity;

public class CartTest extends Base{

	//购物车新增
	@Test
	public void s1008() {
		Cart entity = new Cart();
		entity.setCustomerId(22);
		entity.setProductId(103014);
		entity.setProductNumber(1);
		entity.setSku("|冰爽活炭|");
		String result = HttpClientUtils.postRequest(URL, getParam("1008", entityToMap(entity)));
		System.out.println(result);
	}
	
	//修改购物车数量
	@Test
	public void s1009() {
		S1009RequestEntity entity = new S1009RequestEntity();
		entity.setCustomerId(22);
		entity.setId(1);
		entity.setProductNumber(5);
		String result = HttpClientUtils.postRequest(URL, getParam("1009", entityToMap(entity)));
		System.out.println(result);
	}

	//删除购物车
	@Test
	public void s1010() {
		S1010RequestEntity entity = new S1010RequestEntity();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		entity.setCustomerId(22);
		entity.setCartIds(list);
		String result = HttpClientUtils.postRequest(URL, getParam("1010", entityToMap(entity)));
		System.out.println(result);
	}
	
	//购物车列表
	@Test
	public void s1011() {
		S1011RequestEntity entity = new S1011RequestEntity();
		entity.setCustomerId(22);
		entity.setId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1011", entityToMap(entity)));
		System.out.println(result);
	}
	
	//购物车商品数量
	@Test
	public void s1012() {
		S1012RequestEntity entity = new S1012RequestEntity();
		entity.setCustomerId(22);
		entity.setId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1012", entityToMap(entity)));
		System.out.println(result);
	}
}
