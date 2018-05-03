package cn.xinmeng.web.shop.impl.address;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.address.S1016RequestEntity;

/**
 * 常用地址设为默认
 * @param 
 * @ClassName: S1016Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:32:17 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.address.S1016Component")
public class S1016Component extends BaseService {

	@Resource
	private ICommonAddressService commonAddressService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1016RequestEntity entity =  parseRequertParam(data, S1016RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_ADDRESS_ID);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else{
			if(commonAddressService.updateDefault(entity.getId(),entity.getCustomerId()) > 0){
				return getAppResponseEntity(true);
			}else{
				return getAppResponseEntity(false);
			}
		}
	}



}
