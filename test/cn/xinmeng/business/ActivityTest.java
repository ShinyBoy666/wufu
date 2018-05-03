package cn.xinmeng.business;

import javax.annotation.Resource;

import org.junit.Test;

import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IOrderSubimtService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.base.BaseTest;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.web.shop.entity.order.S1022RequestEntity;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;

public class ActivityTest extends BaseTest {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private IRedisService redisService;
	@Resource
	private IOrderSubimtService orderSubimtService;
	
	@Test
	public void s1069() throws BusinessException {
		ActvityProductInfoBiz biz = redisService.getActvityProductInfoBiz(1, 1, 12,12);
		System.out.println(FastJsonUtils.bean2Json(biz));
	}

	@Test
	public void s1022() throws BusinessException {
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
		PayOrderBiz biz = orderSubimtService.fastSubmitOrderMain(entity, 1, 1);
		System.out.println(FastJsonUtils.bean2Json(biz));
	}
	

	@Test
	public void stest() throws BusinessException {
		System.out.println(redisService.updateActvityProductSoldNumber(1, 1, 12, 1,12));
	}
}
