package cn.xinmeng.web.shop.impl.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IProductService;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 公司产品信息
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1079Component")
public class S1079Component extends BaseService {

	@Resource
	private IProductService productService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		return getAppResponseEntity(productService.getSystemProduct());
	}
}
