package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerDetail;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICustomerDetailService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.user.S1003RequestEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;

/**
 * token登录
 * @param 
 * @ClassName: S1003Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1003Component")
public class S1003Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private ICustomerDetailService customerDetailService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private ICartService cartService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1003RequestEntity entity = parseRequertParam(data, S1003RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getToken())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_TOKEN);
		}
		String token = entity.getToken();
		//根据token查询客户信息
		Customer customer = customerService.queryCustomerByToken(token);
		if(customer == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		//修改token
		customer.setToken(customerService.updateToken(customer.getId(), token));
		CustomerUser resEntity= new CustomerUser();
		CloneUtils.copyEntity(customer, resEntity);
		resEntity.setAccountDeduct(systemConfigService.notNumberBalancePay(customer));
		resEntity.setHeadSculpture(Utils.getImageUrl(resEntity.getHeadSculpture(),"?300_300"));
		CustomerDetail customerDetail = customerDetailService.getCustomerDetail(customer.getId(), "realname,identity_Card");
		if(!Utils.isEmpty(customerDetail)){
			resEntity.setRealyname(customerDetail.getRealname());
			resEntity.setIdentityCard(customerDetail.getIdentityCard());
		}
		if(entity.getSearchCartCount()){
			resEntity.setCartCount(cartService.searchCartProductCount(customer.getId(),customer.getShopId()));
		}
		//返回
		return getAppResponseEntity(resEntity);
	}
	
	
}
