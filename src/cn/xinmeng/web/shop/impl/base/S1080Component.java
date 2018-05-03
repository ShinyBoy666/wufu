package cn.xinmeng.web.shop.impl.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Ad;
import cn.xinmeng.api.entity.auto.example.AdExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IAdService;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.base.S1080RequestEntity;
import cn.xinmeng.web.shop.entity.base.S1080ResponseEntity;

/**
 * 广告
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1080Component")
public class S1080Component extends BaseService {

	@Resource
	private IAdService adService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1080RequestEntity entity = parseRequertParam(data, S1080RequestEntity.class);
		Date curr = new Date();
		AdExample example = new AdExample();
		example.setOrderByClause("sort desc,id desc");
		AdExample.Criteria criteria = example.createCriteria();
		criteria.andBeginTimeLessThan(curr);
		criteria.andEndTimeGreaterThan(curr);
		List<Integer> devictTypeList = new ArrayList<Integer>();
		List<Integer> shopIdList = new ArrayList<Integer>();
		shopIdList.add(0);
		devictTypeList.add(0);
		if(!Utils.isEmpty(entity)){
			if(!Utils.isEmpty(entity.getShopId())){
				shopIdList.add(entity.getShopId());
			}
			if(!Utils.isEmpty(entity.getDeviceType())){
				devictTypeList.add(entity.getDeviceType());
			}
		}
		criteria.andDeviceTypeIn(devictTypeList);
		criteria.andShopIdIn(shopIdList);
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		List<Ad> list = adService.selectByExample(1,1,example);
		if(!Utils.isEmpty(list)){
			S1080ResponseEntity res = new S1080ResponseEntity();
			CloneUtils.copyEntity(list.get(0), res);
			return getAppResponseEntity(res);
		}
		return getAppResponseEntity(null);
	}
}
