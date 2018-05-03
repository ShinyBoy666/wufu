package cn.xinmeng.web.shop.impl.base;

import java.util.Map;

import org.springframework.stereotype.Component;

import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.HttpClientUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 微信 生成JS-SDK权限验证的签名
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1076Component")
public class S1076Component extends BaseService {

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Map<String, Object> map = parseRequertParam(data,Map.class);
		if(!Utils.isEmpty(map) && map.containsKey("url")){
			return getAppResponseEntity(HttpClientUtils.postRequest("http://wx.51shunkai.com/api/WxApi/ShareInfoConfigure?url="+map.get("url"), null));
		}
		throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
	}
}
