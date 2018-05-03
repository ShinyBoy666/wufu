package cn.xinmeng.base;

import java.util.HashMap;
import java.util.Map;

import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.UtilMD5;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.shop.manager.IAppShopManager;

public class Base {
//	protected String URL = "http://localhost:8080/api/api.htm";
	protected String URL = "http://wap.51shunkai.com/api/api.htm";
//	protected String URL = "http://139.214.220.74:8004/api/api.htm";
	
	
	@SuppressWarnings("unchecked")
	protected static Map<String,Object> entityToMap(Object entity){
		String jsonStr = FastJsonUtils.bean2Json(entity);
		return FastJsonUtils.json2Bean(jsonStr, Map.class);
	}

	@SuppressWarnings("unchecked")
	protected static Map<String,String> entityToMapStr(Object entity){
		String jsonStr = FastJsonUtils.bean2Json(entity);
		return FastJsonUtils.json2Bean(jsonStr, Map.class);
	}
	
	protected static Map<String, String> getParam(String code, Map<String, Object> data) {
		AppRequestEntity entity = new AppRequestEntity();
		entity.setCode(code);
		entity.setImei("864181027234767");
		entity.setData(FastJsonUtils.bean2Json(data));
		entity.setSource("PC");
		entity.setToken("123456");
		entity.setTimestamp(123456789);
		entity.setSourceShopId(1);
		entity.setLoginShopId(1);
		
		StringBuilder sb = new StringBuilder();
		sb.append(IAppShopManager.PM); // 公共秘钥
		sb.append(entity.getCode()); // 服务号
		sb.append(entity.getImei()); // 手机串号
		sb.append(entity.getData()); //　请求数据
		sb.append(entity.getSource()); //　请求来源
		sb.append(entity.getToken()); //　token
		sb.append(entity.getTimestamp()); //　时间戳  毫秒
		sb.append(entity.getSourceShopId());
		sb.append(entity.getLoginShopId());
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("code", code);
		param.put("imei", entity.getImei());
		param.put("data", entity.getData());
		param.put("source",entity.getSource());
		param.put("token", entity.getToken());
		param.put("timestamp", entity.getTimestamp()+"");
		param.put("sourceShopId", entity.getSourceShopId()+"");
		param.put("loginShopId", entity.getLoginShopId()+"");
		
		param.put("mak", UtilMD5.MD5(sb));
		System.out.println(FastJsonUtils.bean2Json(param));
		return param;
	}
}
