package cn.xinmeng.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.BeanUtils;

public class CloneUtils {
	
	/**
	 * 克隆实体
	 * @param source
	 * @return
	 */
	public static <T> void cloneEntity(T source,T target){
		BeanUtils.copyProperties(source, target);
	}

	/**
	 * 克隆实体
	 * @param source
	 * @return
	 */
	public static Object cloneEntity(Object source){
		Object obj = new Object();
		BeanUtils.copyProperties(source, obj);
		return obj;
	}

	/**
	 * 拷贝实体
	 * @param source
	 * @param result
	 * @param notCloneparams
	 * @return
	 */
	public static <T> T copyEntity(T source,T result,String ... notCloneparams){
		if(source == null || result == null){
			return null;
		}
		BeanUtils.copyProperties(source, result,notCloneparams);
		return result;
	}

	/**
	 * 克隆Map
	 * @param data
	 * @return
	 */
	public static Map<String,Object> cloneMap(HashMap<String, Object> data){
		Map<String,Object> result = new HashMap<String,Object>();
		if(data == null || data.size() == 0){
			return result;
		}
		for (Iterator<String> keyItr = data.keySet().iterator(); keyItr.hasNext();) {    
			String key = keyItr.next().toString();
			result.put(key, data.get(key));
		}
		return result;
	}


}
