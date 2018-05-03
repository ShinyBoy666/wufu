package cn.xinmeng.web.base.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.monitor.FlowMonitor;

public class WebMaxRequestInterceptor implements HandlerInterceptor{

	@Resource
	FlowMonitor flowMonitor;
	
	 /** 
     * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放 
     */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		flowMonitor.release();
	}
	
	/** 
     * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在 
     * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。 
     */ 
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

    /** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在 
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		if(flowMonitor.entry() == false){
			// TODO Auto-generated method stub
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			AppResponseEntity entity = new AppResponseEntity();
			entity.setMessage("请求繁忙，请稍后再试...");
			response.getOutputStream().write(FastJsonUtils.bean2Json(entity).getBytes("UTF-8"));
			return false;
		}
		return true;
	}

}
