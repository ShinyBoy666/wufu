package cn.xinmeng.web.shop.manager;

import javax.servlet.http.HttpServletRequest;

import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.IService;

/**
 * App 远程服务调用接口
 * @author jiangyong.tan
 *
 */
public abstract class IAppShopManager extends IService{
	/**
	 * 公共秘钥
	 */
	public static final String PM = "wufu@2016";
	
	/**
	 * 调用服务功能
	 * @param request 客户端请求残烛
	 * @return AppResponseEntity 服务端响应参数
	 */
	public abstract AppResponseEntity callServer(AppRequestEntity request,HttpServletRequest httpServletRequest); 
}
