package cn.xinmeng.web.shop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.controller.BaseController;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.shop.manager.IAppShopManager;

/**
 * 调用App Service 服务功能
 * @author jiangyong.tan
 *
 */
@Controller
@RequestMapping("/api")
public class AppShopController extends BaseController {
	
	@Resource
	private IAppShopManager appShopManager;
	
	
	@RequestMapping("/test.htm")
	public String show(ModelAndView model){
		System.out.println("跳转至：shop/test.ftl");
		return "shop/test";
	}
	/**
	 * Description 调用App Service 服务功能
	 * @author jiangyong.tan
	 * @version 0.1  2015-07-02 13:24:56
	 * @return ModelMap
	 */
	@ResponseBody
	@RequestMapping(value="/api.htm",method = RequestMethod.POST)
	public AppResponseEntity shopkeeperApp(AppRequestEntity request,HttpServletRequest httpServletRequest){
		LogManager.debug(this.getClass(),"调用 api 服务功能...");
		LogManager.info(this.getClass(), "ip:"+Utils.getHostIp(httpServletRequest));
		return appShopManager.callServer(request,httpServletRequest);
	}
	
	
	@RequestMapping(value="/sub.htm",method = RequestMethod.POST)
	@ResponseBody
	public AppResponseEntity sub(AppRequestEntity request,HttpServletRequest httpServletRequest) throws IOException{
		try {
			LogManager.info(this.getClass(), "ip:"+Utils.getHostIp(httpServletRequest));
			if(request == null){
				return new AppResponseEntity();
			}
			StringBuilder sb = new StringBuilder();
			sb.append(IAppShopManager.PM); // 公共秘钥
			sb.append(request.getCode()); // 服务号
			sb.append(request.getImei()); // 手机串号
			sb.append(request.getData()); //　请求数据
			sb.append(request.getSource()); //　请求来源
			sb.append(request.getToken()); //　token
			sb.append(request.getTimestamp()); //　时间戳  毫秒
			sb.append(request.getSourceShopId());
			sb.append(request.getLoginShopId());
			request.setMak(UtilMD5.MD5(sb));
			return appShopManager.callServer(request, httpServletRequest);
		} catch (Exception e) {
			AppResponseEntity res = new AppResponseEntity();
			res.setMessage(e.getMessage());
			res.setSuccess(0);
			return res;
		}
	}
}
