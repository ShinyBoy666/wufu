package cn.xinmeng.web.shop.impl.user;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.ClassLoaderUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 版本升级
 * @param 
 * @ClassName: S1049Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1049Component")
public class S1049Component extends BaseService {
	
	@SuppressWarnings("unchecked")
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Map<String, Map<String, String>> versionMap = new HashMap<String, Map<String,String>>();
		String path = ClassLoaderUtil.getClassPath() + "version/Version.xml";
		try {
			File f = new File(path);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			for (Element element : elements) {
				List<Element> attributes = element.elements();
				Map<String, String> map  = new HashMap<String, String>();
				for (Element e : attributes) {
					map.put(e.getName(), e.getText());
				}
				versionMap.put(element.getName(), map);
			}
		} catch (Exception e) {
			LogManager.debug(this.getClass(),"versionPath"+path);
			throw new BusinessException(LogManager.getLogger(this.getClass()),"读取Version.xml错误");
		}
		return getAppResponseEntity(versionMap);
	}
	
	
}
