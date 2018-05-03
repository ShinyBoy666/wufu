package cn.xinmeng.shop;

import org.junit.Test;

import cn.xinmeng.base.Base;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;
import cn.xinmeng.web.shop.entity.product.S1007RequestEntity;

public class ProductTest extends Base{

	//商品列表
	@Test
	public void s1006() {
		S1006RequestEntity entity = new S1006RequestEntity();
		entity.setCurrentPage(1);
		entity.setLimit(5);
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1006", entityToMap(entity)));
		System.out.println(result);
	}

	//商品列表
	@Test
	public void s1062() {
		S1006RequestEntity entity = new S1006RequestEntity();
		entity.setCurrentPage(1);
		entity.setLimit(5);
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1062", entityToMap(entity)));
		System.out.println(result);
	}
	
	//商品列表
	@Test
	public void s1007() {
		S1007RequestEntity entity = new S1007RequestEntity();
		entity.setShopId(1);
		entity.setProductId(100000);
		String result = HttpClientUtils.postRequest(URL, getParam("1007", entityToMap(entity)));
		System.out.println(result);
	}

	//ba
	@Test
	public void s1061() {
		RequestBaseEntity entity = new RequestBaseEntity();
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1061", entityToMap(entity)));
		System.out.println(result);
	}

	//ba
	@Test
	public void s1063() {
		S1006RequestEntity entity = new S1006RequestEntity();
		entity.setCurrentPage(1);
		entity.setLimit(5);
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1063", entityToMap(entity)));
		System.out.println(result);
	}
}
