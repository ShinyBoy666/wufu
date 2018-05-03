package cn.xinmeng.common.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.common.enums.IEnum;
import cn.xinmeng.common.util.encrypt.AES128Utils;
import cn.xinmeng.common.util.http.HttpClient;

public class UtilGetui{
	
	/**
	 * 推送通知
	 * @param cid 推送人 多个逗号间隔
	 * @param appId 个推配置appID
	 * @param title 标题
	 * @param areaCode 区域code
	 * @param description 描述
	 * @param code 推送给客户端的类型
	 * @param obj 推送给客户端的参数
	 * @param messageType 推销类型
	 * @return
	 */
	public static boolean send(String cid,String appId,String title,String areaCode,String description,String code,Map<String, Object> obj,GetuiTypeEnum messageType){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Code", code);
			map.put("Data", obj);
			Map<String, String> parameter = new HashMap<String, String>();
			parameter.put("code", messageType.key());
			parameter.put("content", FastJsonUtils.bean2Json(map));
			parameter.put("title", title);
			parameter.put("description", description);
			parameter.put("areacode", areaCode);
			parameter.put("appID", appId);
			parameter.put("cid", cid);
			
			Map<String, Map<String, String>> param = new HashMap<String, Map<String, String>>();
			param.put("parameter", parameter);
			HttpClient httpClient= HttpClient.getInstance();
			String url = HelperPropertie.getValue("getui.url");
			String aesKey = AES128Utils.getSecretKey(HelperPropertie.getValue("getui.aesKey"));
			String str = new String(Base64.encodeBase64(AES128Utils.encrypt(FastJsonUtils.bean2Json(param).getBytes("utf-8"), aesKey)));
			String result = httpClient.doPost(url,str);
			if(!Utils.isEmpty(result)){
				Map<String, Object> resMap = FastJsonUtils.json2Bean(result, Map.class);
				if(!Utils.isEmpty(resMap) && "success".equals(resMap.get("code"))){
					return true;
				}
			}
			LogManager.info(UtilGetui.class,"推送失败:result"+result);
		} catch (Exception e) {
			e.printStackTrace();
			LogManager.error(UtilGetui.class,"推送异常", e);
		}
		return false;
	}
	
	/**
	 * 推送类型：
	 * 单用户推送-001;多用户推送-002;区域推送-003;
	 */
	public enum GetuiTypeEnum implements IEnum{
		/**
		 * 单用户推送
		 */
		SINGLE("001","单用户推送"),
		/**
		 * 多用户推送
		 */
		LIST("002","多用户推送"),
		/**
		 * 区域推送
		 */
		AREA("003","区域推送")
		;
		private GetuiTypeEnum(String key,String value){
			this.key = key;
			this.value = value;
		}
		private String key;
		private String value;
		@Override
		public String value() {
			return this.value;
		}

		@Override
		public String key() {
			return this.key;
		}

		@Override
		public IEnum parseValue(Object... params) {
			return setValue(MessageFormat.format(value, params));
		}

		@Override
		public IEnum setValue(String value) {
			this.value = value;
			return this;
		}
		/**
		 * 校验是否存在
		 * @param value
		 * @return
		 */
		public static boolean exist(String value){
			boolean exist = false;
			for (PaymentStateEnum state : PaymentStateEnum.values()) {
				if(state.key().equals(value)){
					exist = true; 
					break;
				}
			}
			return exist;
		}
		/**
		 * 通过 key 获取 value
		 * @param key
		 * @return
		 */
		public static String keyToValue(String key){
			for (PaymentStateEnum item : PaymentStateEnum.values()) {
				if(item.key().equals(key)){
					return item.value();
				}
			}
			return "";
		}
	}
	
}
