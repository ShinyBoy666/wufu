package cn.xinmeng.web.shop.impl.base;

import java.text.MessageFormat;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.common.util.http.HttpClient;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.base.S1100RequestEntity;

/**
 * 微信获取session_key
 * S1100Component
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1100Component")
public class S1100Component extends BaseService {
	
	@Resource
	private IRedisService redisService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1100RequestEntity entity = parseRequertParam(data, S1100RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCode())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),"code为空");
		}
		try {
			String result = HttpClient.getInstance().doPost(MessageFormat.format("https://api.weixin.qq.com/sns/jscode2session?appid=wx0d03cb12604b9d15&secret=51f18f2d6b9d7646eb5363b95880a097&js_code={0}&grant_type=authorization_code", entity.getCode()), null);
			if(!Utils.isEmpty(result)){
				Map<String, String> map = FastJsonUtils.json2Bean(result, Map.class);
				if(map != null && !Utils.isEmpty(map.get("openid")) && !Utils.isEmpty(map.get("session_key"))){
					String key = Utils.UUID();
					redisService.set(key, FastJsonUtils.bean2JsonAll(map), 30*24*3600);
					return getAppResponseEntity(key);
				}
			}
			LogManager.error(this.getClass(), MessageFormat.format("微信获取session_key异常,code={0},result={1}", entity.getCode() , result));
		} catch (Exception e) {
			LogManager.error(this.getClass(), MessageFormat.format("微信获取session_key异常,code={0}", entity.getCode()), e);
		}
		throw new BusinessException(LogManager.getLogger(this.getClass()),"获取失败");
	}
	
}
