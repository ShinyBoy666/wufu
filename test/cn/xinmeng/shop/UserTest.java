package cn.xinmeng.shop;

import org.junit.Test;

import cn.xinmeng.base.Base;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.web.shop.entity.base.S1064RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1000RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1001RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1002RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1003RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1004RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1005RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1043RequestEntity;
import cn.xinmeng.web.shop.entity.user.S1048RequestEntity;

public class UserTest extends Base{

	//用户注册
	@Test
	public void s1000() {
		S1000RequestEntity entity = new S1000RequestEntity();
		entity.setCustomerId(0);
		entity.setInviteCode("");
		entity.setLoginName("18612100106");
		entity.setPassword(UtilMD5.MD5("123456"));
		entity.setSmsCode("666666");
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1000", entityToMap(entity)));
		System.out.println(result);
	}
	//用户登录
	@Test
	public void s1001() {
		S1001RequestEntity entity = new S1001RequestEntity();
		entity.setLoginName("18612100103");
		entity.setPassword(UtilMD5.MD5("123456"));
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1001", entityToMap(entity)));
		System.out.println(result);
	}
	//客户修改密码
	@Test
	public void s1002() {
		S1002RequestEntity entity = new S1002RequestEntity();
		entity.setCustomerId(22);
		entity.setPassword(UtilMD5.MD5("123456"));
		entity.setNewPassword(UtilMD5.MD5("123456"));
		String result = HttpClientUtils.postRequest(URL, getParam("1002", entityToMap(entity)));
		System.out.println(result);
	}
	//token登录
	@Test
	public void s1003() {
		S1003RequestEntity entity = new S1003RequestEntity();
		entity.setToken("c20a9e1d6cb74082a1130b2f2a0e053b");
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1003", entityToMap(entity)));
		System.out.println(result);
	}
	

	//手机验证码登录
	@Test
	public void s1004() {
		S1004RequestEntity entity = new S1004RequestEntity();
		entity.setCellphone("18612100102");
		entity.setSmsCode("666666");
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1004", entityToMap(entity)));
		System.out.println(result);
	}
	
	//验证手机号码是否已经注册
	@Test
	public void s1005() {
		S1005RequestEntity entity = new S1005RequestEntity();
		entity.setCellphone("18612100102");
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1005", entityToMap(entity)));
		System.out.println(result);
	}
	
	//验证手机号码是否已经注册
	@Test
	public void s1043() {
		S1043RequestEntity entity = new S1043RequestEntity();
		entity.setCellphone("18612100102");
		entity.setShopId(1);
		String result = HttpClientUtils.postRequest(URL, getParam("1043", entityToMap(entity)));
		System.out.println(result);
	}
	//验证手机号码是否已经注册
	@Test
	public void s1048() {
		S1048RequestEntity entity = new S1048RequestEntity();
		entity.setCellphone("18612100102");
		entity.setShopId(1);
		entity.setSmsCode("123456");
		entity.setNewPassword("123456");
		String result = HttpClientUtils.postRequest(URL, getParam("1048", entityToMap(entity)));
		System.out.println(result);
	}
	
	//验证手机号码是否已经注册
	@Test
	public void s1064() {
		S1064RequestEntity entity = new S1064RequestEntity();
		entity.setCellphone("18612100102");
		entity.setFromType(1);
		entity.setContent("测试");
		String result = HttpClientUtils.postRequest(URL, getParam("1064", entityToMap(entity)));
		System.out.println(result);
	}
}
