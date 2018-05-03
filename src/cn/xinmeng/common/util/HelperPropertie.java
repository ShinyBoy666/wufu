package cn.xinmeng.common.util;

import java.util.HashMap;
import java.util.Map;

import cn.xinmeng.common.context.HelperSpringWeb;
import cn.xinmeng.common.entity.IEntity;
@SuppressWarnings("unchecked")
public final class HelperPropertie implements IEntity{
	
	private static final long serialVersionUID = 5182262539767912108L;
	
	private static Map<String,String> map = null;
	
	private static Map<String,String> getMap(){
		if(map == null){
			synchronized(HelperPropertie.class){
				if(map == null){
					map = HelperSpringWeb.getBean("HelperPropertie",Map.class);
				}
			}
		}
		return map == null?new HashMap<String,String>():map;
	}
	
	public static String getValue(String key){
		return getMap().get(key);
	}
}
