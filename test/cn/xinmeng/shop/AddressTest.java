package cn.xinmeng.shop;

import org.junit.Test;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.base.Base;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.web.shop.entity.address.S1015RequestEntity;
import cn.xinmeng.web.shop.entity.address.S1016RequestEntity;

public class AddressTest extends Base{

	//新增 常用地址
	@Test
	public void s1013() {
		CommonAddress entity = new CommonAddress();
		entity.setCustomerId(22);
		entity.setAddressType(1);
		entity.setCityId(1);
		entity.setDistrictId(1);
		entity.setProvinceId(1);
		entity.setRecipientAddress("白马湖2栋601");
		entity.setRecipientName("小花");
		entity.setRecipientPhone("18611110000");
		String result = HttpClientUtils.postRequest(URL, getParam("1013", entityToMap(entity)));
		System.out.println(result);
	}
	//新增 常用地址
	@Test
	public void s1060() {
		CommonAddress entity = new CommonAddress();
		entity.setCustomerId(22);
		entity.setAddressType(1);
		entity.setCityId(1);
		entity.setDistrictId(1);
		entity.setProvinceId(1);
		entity.setRecipientAddress("白马湖2栋601");
		entity.setRecipientName("小花");
		entity.setRecipientPhone("18611110000");
		String result = HttpClientUtils.postRequest(URL, getParam("1060", entityToMap(entity)));
		System.out.println(result);
	}
	//修改常用地址
	@Test
	public void s1014() {
		CommonAddress entity = new CommonAddress();
		entity.setId(1);
		entity.setCustomerId(22);
		entity.setAddressType(1);
		entity.setCityId(1);
		entity.setDistrictId(1);
		entity.setProvinceId(1);
		entity.setRecipientAddress("白马湖2栋601");
		entity.setRecipientName("小红");
		entity.setRecipientPhone("18611110000");
		String result = HttpClientUtils.postRequest(URL, getParam("1014", entityToMap(entity)));
		System.out.println(result);
	}
	//常用客户地址列表
	@Test
	public void s1015() {
		S1015RequestEntity entity = new S1015RequestEntity();
		entity.setCustomerId(22);
		entity.setCurrentPage(1);
		entity.setLimit(2);
		String result = HttpClientUtils.postRequest(URL, getParam("1015", entityToMap(entity)));
		System.out.println(result);
	}
	//设置默认地址
	@Test
	public void s1016() {
		S1016RequestEntity entity = new S1016RequestEntity();
		entity.setId(3);
		entity.setCustomerId(22);
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1016", entityToMap(entity)));
		System.out.println(result);
	}
	

	//删除地址
	@Test
	public void s1017() {
		CommonAddress entity = new CommonAddress();
		entity.setId(7);
		entity.setCustomerId(22);
		String result = HttpClientUtils.postRequest(URL, getParam("1017", entityToMap(entity)));
		System.out.println(result);
	}
	
}
