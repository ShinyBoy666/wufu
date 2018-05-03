package cn.xinmeng.shop;

import org.junit.Test;

import cn.xinmeng.base.Base;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.shop.entity.market.S1091RequestEntity;
import cn.xinmeng.web.shop.entity.quickorder.S1084RequestEntity;
import cn.xinmeng.web.shop.entity.quickorder.S1093RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1004RequestEntity;

public class QuickTest extends Base{

	/**
	 * openid绑定手机
	 * @throws BusinessException
	 */
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

	//优惠购买列表
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
		entity.setOrderId("Q20215369973422");
		entity.setShopId(1);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1091", entityToMap(entity)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}

	//优惠买单
	@Test
	public void s1093() throws BusinessException {
		S1093RequestEntity entity = new S1093RequestEntity();
		entity.setCustomerId(1);
		entity.setOpenId("1234567890");
		entity.setShopId(1);
		entity.setOrderType(2);
		entity.setTotalAmount(900);
		entity.setDiscountAmount(5);
		entity.setPayType(1);
		entity.setOrderFrom(1);
		
		String result = HttpClientUtils.postRequest(URL, getParam("1093", entityToMap(entity)));
		System.out.println(result);
		System.out.println(FastJsonUtils.bean2JsonFormat(FastJsonUtils.json2Bean(result, AppResponseEntity.class)));
	}
	
}
