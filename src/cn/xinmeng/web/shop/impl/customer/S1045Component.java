package cn.xinmeng.web.shop.impl.customer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.CustomerExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1045ResponseEntity;
import cn.xinmeng.web.shop.entity.vo.CustomerVo;

/**
 * 
 * <p class="detail">推广 </p>
 * 
 * @param 
 * @ClassName: S1045Component 
 * @version V1.0  @date 2016年2月29日 上午11:20:05 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1045Component")
public class S1045Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		//查询店铺信息
		ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(shopId);
		if(shopInfo == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_NOTEXISTS_SHOP);
		}
		//查询店铺信息
		Customer myself = customerService.selectByPrimaryKey(entity.getCustomerId());
		if(myself == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		S1045ResponseEntity result = new S1045ResponseEntity();
		String httpLocal = HelperPropertie.getValue("local.url");
		result.setUrl(httpLocal+"pages/"+shopId+"/share?c="+entity.getCustomerId());
		
		if(!Utils.isEmpty(myself.getHeadSculpture())){
			result.setHeadSculpture(myself.getHeadSculpture());
		}else {
			result.setHeadSculpture(shopInfo.getShopLogo());
		}
		result.setHeadSculpture(Utils.getImageUrl(result.getHeadSculpture(),"?300_300"));
		result.setRemark(MessageFormat.format("{0}邀请您加入{1}，舜凯云商让生活购物更轻松！",myself.getNickname(),shopInfo.getShopName()));
		
		List<CustomerVo> list = new ArrayList<CustomerVo>();
		
		//查询最近推荐的好友
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andRecommendCustomerIdEqualTo(entity.getCustomerId());
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		example.setOrderByClause("id desc");
		List<Customer> customers = customerService.selectByExample(1,4,example);
		if(!Utils.isEmpty(customers)){
			for (Customer customer : customers) {
				CustomerVo customerVo = new CustomerVo();
				CloneUtils.cloneEntity(customer, customerVo);
				customerVo.setHeadSculpture(Utils.getImageUrl(customerVo.getHeadSculpture(),"?300_300"));
				list.add(customerVo);
			}
		}
		result.setList(list);
		return getAppResponseEntity(result);
	}
	
	
}
