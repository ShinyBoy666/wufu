package cn.xinmeng.web.shop.impl.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IBannerService;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 轮播图
 * @author tanjiangyong
 *
 */
@Component ("cn.xinmeng.web.shop.impl.shop.S1061Component")
public class S1061Component extends BaseService {

	@Resource
	private IBannerService bannerService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		
		return getAppResponseEntity(bannerService.selectBannerVo(0, 1));
	
	}
}
