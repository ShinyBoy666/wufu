package cn.xinmeng.web.shop.impl.address;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 新增 常用地址
 * @param 
 * @ClassName: S1013Component 
 * @version V1.0  
 * @date 2016年2月18日 上午11:54:06 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.address.S1013Component")
public class S1013Component extends BaseService{
	
	@Resource
	private ICommonAddressService commonAddressService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		CommonAddress address = parseRequertParam(data, CommonAddress.class);
		if(address == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(address.getCustomerId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(address.getRecipientName())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_RECIPIENT_NAME);
		}else if(Utils.isEmpty(address.getRecipientPhone())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_RECIPIENT_PHONE);
		}else if(Utils.isEmpty(address.getProvinceId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_PROVINCE_ID);
		}else if(Utils.isEmpty(address.getCityId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CITY_ID);
		}else if(Utils.isEmpty(address.getDistrictId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_DISTRICT_ID);
		}else if(Utils.isEmpty(address.getRecipientAddress())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_TOWN);
		}else{
			address.setCreateUser(Utils.createUser);
			if(commonAddressService.add(address) > 0){
				return getAppResponseEntity(true);
			}else{
				return getAppResponseEntity(false);
			}
		}
	}
	

}
