package cn.xinmeng.common.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring-applicationContext的持有者，供系统内 便捷使用
 * */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	private static volatile ApplicationContext context;
	
	private static final Object lock = new Object();
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		synchronized (lock) {
	        context = applicationContext;
        }
	}

	public static ApplicationContext getWebApplicationContext() {
		return (ApplicationContext) context;
	}
	
}
