package cn.xinmeng.common.context;

import org.springframework.context.ApplicationContext;


public class HelperSpringWeb {
	protected static ApplicationContext appContext;

	protected static void inint(){
		try {
			appContext = ApplicationContextHolder.getWebApplicationContext();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	protected static ApplicationContext getContext(){
		if(appContext == null){
			synchronized (HelperSpringWeb.class) {
				inint();
				return appContext;
			}
		}
		return appContext;
	}
	
	/**
	 * 
	 * <p>
	 * Description:根据 Class 类 来获取配置Bean <br />
	 * 对传入Class 的类名，首字母最小化取spring配置bean
	 * </p>
	 * 
	 * @author 王明明
	 * @version 0.1 2012-12-17
	 * @param clazz
	 * @return T
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getContext().getBean(clazz);
	}

	/**
	 * 
	 * <p>
	 * Description:根据spring 配置bean的 ID 来获取配置bean信息<br />
	 * </p>
	 * 
	 * @author 王明明
	 * @version 0.1 2012-12-17
	 * @param beanName
	 * @param clazz
	 * @return Object 返回Bean，获取后请强制转换为需要的类型
	 */
	public static <T> T getBean(String beanName,Class<T> clazz) {
		return (T)getContext().getBean(beanName,clazz);
	}
}
