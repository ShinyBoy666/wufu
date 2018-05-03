package cn.xinmeng.web.shop.impl.address;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.example.RegionExample;
import cn.xinmeng.api.service.IRegionService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.vo.RegionVo;

/**
 * 查询区域 
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.address.S1057Component")
public class S1057Component extends BaseService {

	@Resource
	private IRegionService regionService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else{
			List<RegionVo> result = new ArrayList<RegionVo>(); 
			
			RegionExample example = new RegionExample();
			example.setOrderByClause("sort desc,id");
			RegionExample.Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(entity.getId());
			List<Region> list = regionService.selectByExample(example);
			if(!Utils.isEmpty(list)){
				for (Region region : list) {
					RegionVo regionVo = new RegionVo();
					CloneUtils.cloneEntity(region, regionVo);
					result.add(regionVo);
				}
			}
			return  getAppResponseEntity(result);
		}
	}
}
