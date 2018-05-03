package cn.xinmeng.web.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class ManagerController extends BaseController{
	
	@RequestMapping("/head.htm")
	public ModelAndView head(ModelAndView model){
		System.out.println("跳转至：main/index");
		return new ModelAndView("main/head");
	}
	
	@RequestMapping("/menu.htm")
	public ModelAndView menu(ModelAndView model){
		System.out.println("跳转至：main/index");
		return new ModelAndView("main/menu");
	}
	@RequestMapping("/index.htm")
	public ModelAndView index(ModelAndView model){
		System.out.println("跳转至：main/index");
		return new ModelAndView("main/index");
	}
	
	@RequestMapping("/welcome.htm")
	public ModelAndView welcome(ModelAndView model){
		System.out.println("跳转至：main/welcome");
		return new ModelAndView("main/welcome");
	}
	
	@RequestMapping("/test.htm")
	public String show(ModelAndView model){
		System.out.println("跳转至：shop/test.ftl");
		return "view/test/test";
	}
}
