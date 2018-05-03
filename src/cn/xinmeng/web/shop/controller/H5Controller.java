package cn.xinmeng.web.shop.controller;


import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.NoticeReader;
import cn.xinmeng.api.entity.auto.ShopApply;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.Sms;
import cn.xinmeng.api.enums.ShopImageTypeEnum;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.INoticeReaderService;
import cn.xinmeng.api.service.INoticeService;
import cn.xinmeng.api.service.IProductDetailInfoService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopApplyService;
import cn.xinmeng.api.service.IShopImageService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExBaseEnum;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.user.S1000RequestEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;

import com.pay.common.PayFinal;

@Controller
public class H5Controller {
	
	@Resource
	private IProductDetailInfoService productDetailInfoService;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private INoticeService noticeService;
	@Resource
	private INoticeReaderService noticeReaderService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private ISmsService smsService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private IRedisService redisService;
	@Resource
	private IShopImageService shopImageService;
	@Resource
	private IShopApplyService shopApplyService;
	
	@RequestMapping(value="/App/ProductDetail")
	public String productDetatil(@RequestParam("id")Integer id,Model model){
		if(!Utils.isEmpty(id)){
			model.addAttribute("productDetatil", redisService.getProductDetailInfo(id));
			model.addAttribute("product", redisService.getProductInfo(id));
		}
		return "/productDetatil"; 
	}

	@RequestMapping(value="/App/Notice")
	public String notice(@RequestParam("id")Integer id,Model model,@RequestParam("c")Integer c,@RequestParam("flag")boolean flag){
		if(!Utils.isEmpty(id)){
			noticeService.readNotice(id);
			if(!Utils.isEmpty(c)){
				NoticeReader noticeReader = new NoticeReader();
				noticeReader.setNoticeId(id);
				noticeReader.setCustomerId(c);
				noticeReader.setCreateTime(new Date());
				noticeReader.setCreateUser("api");
				noticeReaderService.add(noticeReader);
			}
			model.addAttribute("notice", noticeService.selectByPrimaryKey(id));
		}
		model.addAttribute("flag", flag);
		return "/notice"; 
	}
	@RequestMapping(value="/pages/{s}/share")
	public String share(Model model,@RequestParam("c")Integer c,@PathVariable("s")Integer s){
		if(!Utils.isEmpty(c) && !Utils.isEmpty(s)){
			model.addAttribute("shop", shopInfoService.selectByPrimaryKey(s));
			model.addAttribute("user", customerService.selectByPrimaryKey(c));
		}
		return "/share"; 
	}
	

	
	@RequestMapping(value="/entershop")
	public String getShopInfo(Model model,@RequestParam("id")Integer id) throws IOException{
		LogManager.info(this.getClass(),"线程id：{}，参数为：{}", Thread.currentThread().getId(),id);
		Map<String,Object> map = new HashMap<String,Object>();
		ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(id);
		if(!Utils.isEmpty(shopInfo)){
			String shopBossImage = shopImageService.queryShopInfoImage(shopInfo.getId(), ShopImageTypeEnum.BOSS);
			if(Utils.isEmpty(shopBossImage)){
				shopBossImage = shopInfo.getShopLogo();
			}
			map.put("shopName", shopInfo.getShopName());
			map.put("shopDescription", shopInfo.getShopDescription());
			map.put("shopLogo", shopInfo.getShopLogo());
			map.put("shopBossImage",shopBossImage );
		}
		map.put("id",id);
		model.addAttribute("shopInfo", map);
		return "/entershop";
	}
	
	@RequestMapping(value="/register")
	@ResponseBody
	public Map<String, Object> register(Model model,S1000RequestEntity entity){
		LogManager.info(this.getClass(),"线程id：{}，参数为：{}", Thread.currentThread().getId(),FastJsonUtils.bean2Json(entity));
		Map<String, Object> result = new HashMap<String, Object>();
		Integer success = 0;
		if(entity == null){
			result.put("message", ExRequestEnum.REQUEST_DATA.value());
		}else if(Utils.isEmpty(entity.getLoginName())){
			result.put("message", ExCustomerEnum.EX_NULL_LOGINNAME.value());
		}else if(Utils.isEmpty(entity.getSmsCode())){
			result.put("message", ExBaseEnum.EX_NULL_SMS_CODE.value());
		}else if(Utils.isEmpty(entity.getShopId())){
			result.put("message", ExShopEnum.EX_SHOPID_NULL.value());
		}else{
			Customer customer = customerService.queryCustomerByCellphone(entity.getLoginName(), null,entity.getShopId());
			if(customer == null){
				boolean flag = false;
				String vCodeAlmighty = HelperPropertie.getValue("sms.verifyCode.almighty");
				// 若输入的是万能验证码，验证有效
				if(entity.getSmsCode().equals(vCodeAlmighty.trim())){
					flag = true;
				}else{
					//验证码是否正确
					Sms sms = smsService.querySmsByPhone(entity.getLoginName(), entity.getSmsCode());
					if(sms == null){
						result.put("message", ExBaseEnum.EX_NOTEXIS_SMS_CODE.value());
					}else{
						//验证码有效时间
						int validTime = Integer.valueOf(HelperPropertie.getValue("time.valid.smsCode"));
						if(Utils.surplusTime(sms.getCreateTime(), validTime) <= 0){
							result.put("message", ExBaseEnum.EX_ERROR_SMS_CODE.value());
						}else{
							flag = true;
						}
					}
				}
				if(flag){
					customer = customerService.registerUser(entity.getLoginName(), Utils.default_password,entity.getShopId(), entity.getInviteCode(),entity.getImei(),null);
					success = 1;
				}
			}else{
				String name = null;
				if(!Utils.isEmpty(customer.getRecommendCustomerId())){
					name = customerService.queryCustomerNameById(customer.getRecommendCustomerId());
				}
				if(Utils.isEmpty(name)){
					result.put("message", "您的手机号已被注册过"); 
				}else {
					result.put("message", MessageFormat.format("您已经被{0}邀请", name));
				}
				success = 2;
			}
			if(success != 0){
				CustomerUser customerVo = new CustomerUser();
				CloneUtils.copyEntity(customer, customerVo);
				customerVo.setAccountDeduct(systemConfigService.notNumberBalancePay(customer));
				result.put("user", customerVo);
			}
		}
		result.put("success", success);
		return result; 
	}
	
	@RequestMapping(value="/pages/{shopId:[0-9]+}/{page}.html")
	@ResponseBody
	public void pages(HttpServletRequest request,HttpServletResponse response,@PathVariable("page")String page){
		try {
			request.getRequestDispatcher("/pages/"+page+".html").forward(request,response);
		} catch (Exception e) {
			LogManager.info(this.getClass(),"线程id：{}，参数为：{}", Thread.currentThread().getId(),page);
		}
	}
	
	@RequestMapping(value="/pages/{shopId:[0-9]+}/find/{page}.html")
	@ResponseBody
	public void findPages(HttpServletRequest request,HttpServletResponse response,@PathVariable("page")String page){
		try {
			request.getRequestDispatcher("/pages/find/"+page+".html").forward(request,response);
		} catch (Exception e) {
			LogManager.info(this.getClass(),"线程id：{}，参数为：{}", Thread.currentThread().getId(),page);
		}
	}
	

	@RequestMapping(value="/h5/test.htm")
	public String dispatcher(Model model) throws IOException{
		model.addAttribute("result","test");
		return "/ajax";
	}
	
	@RequestMapping(value="/shopApply")
	@ResponseBody
	public String shopApply(Model model,String linkman,String telephone,String remark,String code){
		try {
			if(Utils.isEmpty(code)){
				return "验证码为空";
			}else if(Utils.isEmpty(linkman)){
				return "姓名为空";
			}else if(Utils.isEmpty(telephone)){
				return "手机号为空";
			}else{
				ShopApply shopApply = new ShopApply();
				shopApply.setLinkman(linkman);
				shopApply.setTelephone(telephone);
				shopApply.setRemark(remark);
				shopApply.setCreateTime(new Date());
				shopApply.setCreateUser("api");
				shopApply.setState(1);
				String vCodeAlmighty = HelperPropertie.getValue("sms.verifyCode.almighty");
				// 若输入的是万能验证码，验证有效
				if(code.equals(vCodeAlmighty.trim())){
					shopApplyService.add(shopApply);
					return PayFinal.success;
				}else{
					//验证码是否正确
					Sms sms = smsService.querySmsByPhone(telephone, code);
					if(sms == null){
						return "验证码错误";
					}else{
						//验证码有效时间
						int validTime = Integer.valueOf(HelperPropertie.getValue("time.valid.smsCode"));
						if(Utils.surplusTime(sms.getCreateTime(), validTime) <= 0){
							return ExBaseEnum.EX_ERROR_SMS_CODE.value();
						}else{
							shopApplyService.add(shopApply);
							return PayFinal.success;
						}
					}
				}
				
			}
		} catch (Exception e) {
			LogManager.error(this.getClass(),"shopApply异常,参数：linkman={},telephone={},remark={},code={}", e, linkman,telephone,remark,code);
			return "系统异常";
		}
	}
}
