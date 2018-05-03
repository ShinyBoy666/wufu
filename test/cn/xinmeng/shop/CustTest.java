package cn.xinmeng.shop;

import org.junit.Test;

import cn.xinmeng.base.Base;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.web.shop.entity.customer.S1027RequestEntity;

public class CustTest extends Base{

	//用户注册
	@Test
	public void s1059() {
		S1027RequestEntity entity = new S1027RequestEntity();
		entity.setCustomerId(24);
		entity.setReplyContent("反馈");
		entity.setFromType(4);
		String result = HttpClientUtils.postRequest(URL, getParam("1059", entityToMap(entity)));
		System.out.println(result);
	}
}
