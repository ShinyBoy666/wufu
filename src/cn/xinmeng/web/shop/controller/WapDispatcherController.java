package cn.xinmeng.web.shop.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;
import cn.xinmeng.web.shop.manager.IAppShopManager;

@Controller
public class WapDispatcherController {
	
	/**  不需要验证登录的集合 */
	private static List<String> exclude;
	
	/**  需要验证登录的集合 */
//	private static List<String> include;
	/** 临时处理 TODO*/
	private static List<String> list;
	static{
		exclude = Arrays.asList(new String[]{"1000","1001","1003","1004","1005","1006","1007","1034","1035","1036","1037","1038","1039","1042","1043","1048","1049","1050","1052","1054","1055","1057","1061","1062","1063","1066","1069","1075","1076","1077","1078","1079","1083","1084","1085","1091","1092","1093","1094","1095","1101","1103","1105","1107","1117","1118","1121","1122"});
//		include = Arrays.asList(new String[]{"1002","1008","1009","1010","1011","1012","1013","1014","1015","1016","1017","1018","1019","1020","1021","","","","","","","","",""});
		
		list = Arrays.asList(new String[]{"1084","1085","1086","1087","1088","1089","1090","1091","1092","1093","1096","1097","1098","1099"});
	}
	
	@Resource
	private IAppShopManager appShopManager;
	
	@Resource
	private ICustomerService customerService;
	
	@RequestMapping(value="/dispatcher.htm")
	public String dispatcher(Model model,AppRequestEntity request,HttpServletRequest httpServletRequest,@RequestParam(value = "callback", required = false)String callback) throws IOException{
		AppResponseEntity result = new AppResponseEntity();
		try {
			LogManager.info(this.getClass(),"线程id：{}，【dispatcher】，参数为：{}", Thread.currentThread().getId(),FastJsonUtils.bean2Json(request));
			
			HttpSession session =  httpServletRequest.getSession();
			boolean flag = true;
			if(!list.contains(request.getCode())){
				int customerId = 0;
				if(!Utils.isEmpty(request.getToken())){
					Customer customer = customerService.queryCustomerByToken(request.getToken());
					if(customer != null){
						customerId = customer.getId();
					}
				}
				Map<String, Object> map = FastJsonUtils.json2Bean(request.getData(), Map.class);
				if(map == null){
					map = new HashMap<String, Object>();
				}
				map.put("customerId", customerId);
				request.setData(FastJsonUtils.bean2Json(map));
				
				if(!exclude.contains(request.getCode()) && customerId == 0){
//					CustomerUser user = (CustomerUser) session.getAttribute("userInfo");
//					if(user != null && !Utils.isEmpty(user.getId())){
//						Map<String, Object> map = FastJsonUtils.json2Bean(request.getData(), Map.class);
//						map.put("customerId", user.getId());
//						request.setData(FastJsonUtils.bean2Json(map));
//					}else {
//						flag = false;
//					}
					flag = false;
				}
			}
			if(flag){
				request.setSource("wap");
				request.setImei(Utils.getIpAddr(httpServletRequest));
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
				result = appShopManager.callServer(request, httpServletRequest);
				if("1001".equals(request.getCode()) && result.getData() instanceof CustomerUser){
					CustomerUser user = (CustomerUser) result.getData();
					session.setAttribute("userInfo", user);
				}
			}else {
				result.setMessage("您还未登陆，请登陆");
				result.setSuccess(3);
			}
			if("1025".equals(request.getCode())){
				String imageUrl = "";
				if(result.getData() != null && result.getData() instanceof Map){
					Map<String, Object> map = (Map<String, Object>) result.getData();
					if(!Utils.isEmpty(map.get("imageUrl"))){
						imageUrl = map.get("imageUrl")+"";
					}
				}
				model.addAttribute("result", imageUrl);
				return "/ajax";
			}
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			result.setSuccess(0);
		}
		model.addAttribute("result", callback+"("+FastJsonUtils.bean2JsonAll(result)+")");
		LogManager.info(this.getClass(),"线程id：{}，【dispatcher】，响应数据为：{}", Thread.currentThread().getId(),FastJsonUtils.bean2JsonAll(result));
		return "/ajax";
	}
	
}
