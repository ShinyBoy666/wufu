package cn.xinmeng.web.shop.impl.address;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.example.CommonAddressExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IRegionService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.address.S1015RequestEntity;
import cn.xinmeng.web.shop.entity.address.S1015ResponseEntity;

/**
 * 常用地址列表
 * @param 
 * @ClassName: S1015Component 
 * @version V1.0  
 * @date 2016年2月18日 上午11:51:27 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.address.S1015Component")
public class S1015Component extends BaseService {

	@Resource
	private ICommonAddressService commonAddressService;
	@Resource
	private IRegionService regionService;
	@Resource
	private IRedisService redisService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1015RequestEntity entity = parseRequertParam(data, S1015RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else{
			Integer isDefault = Utils.isDefaultAddress(entity.getIsDefault(), true);
			//返回分页
			PageInfoEntity<S1015ResponseEntity> resPage = new PageInfoEntity<S1015ResponseEntity>();
			//返回数据
			List<S1015ResponseEntity> resList = new ArrayList<S1015ResponseEntity>();
			
			/**
			 * 查询客户地址列表
			 */
			CommonAddressExample example = new CommonAddressExample();
			example.setOrderByClause("Is_Default desc,id desc");
			CommonAddressExample.Criteria criteria = example.createCriteria();
			criteria.andCustomerIdEqualTo(entity.getCustomerId());
			if(StateEnum.EFFECTION.key().equals(isDefault+"")){
				criteria.andIsDefaultEqualTo(Integer.parseInt(StateEnum.EFFECTION.key()));
			}
			
			int totalCount = commonAddressService.countByExample(example);
			
			List<CommonAddress> list  = null;
			
			//如果查询默认，没有默认地址，取第一条数据
			if(StateEnum.EFFECTION.key().equals(isDefault+"") 
					&& totalCount == 0){
				example.clear();
				CommonAddressExample.Criteria criteria1 = example.createCriteria();
				criteria1.andCustomerIdEqualTo(entity.getCustomerId());
				list = commonAddressService.selectByExample(entity.getCurrentPage(), 1, example);
			}else if(totalCount > 0){
				list = commonAddressService.selectByExample(entity.getCurrentPage(), entity.getLimit(), example);
				
			}
			
			/**
			 * 地址列表数据，组装省，市，去信息
			 */
			if(!Utils.isEmpty(list)){
				for (CommonAddress a : list) {
					Region region = redisService.getRegion(a.getDistrictId());
					S1015ResponseEntity responseEntity = new S1015ResponseEntity();
					CloneUtils.copyEntity(a, responseEntity);
					responseEntity.setIsDefault(Utils.isDefaultAddress(a.getIsDefault(),false));
					if(region != null){
						responseEntity.setProvinceName(region.getProvinceName());
						if(Utils.isEmpty(region.getCityName())){
							responseEntity.setCityName(region.getAreaName());
						}else{
							responseEntity.setCityName(region.getCityName());
						}
						responseEntity.setDistrictName(region.getRegionName());
					}
					resList.add(responseEntity);
				}
			}
			resPage.setList(resList);
			resPage.setCurrentPage(entity.getCurrentPage());
			resPage.setLimit(entity.getLimit());
			resPage.setTotalRecord(totalCount);
			return getAppResponseEntity(resPage);
		}
	}

	
}
