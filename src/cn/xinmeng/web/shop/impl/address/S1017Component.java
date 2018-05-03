package cn.xinmeng.web.shop.impl.address;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CommonAddress;
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

/**
 * 删除 常用地址
 * @param 
 * @ClassName: S1017Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.address.S1017Component")
public class S1017Component extends BaseService {

	@Resource
	private ICommonAddressService commonAddressService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		CommonAddress address = parseRequertParam(data, CommonAddress.class);
		if(address == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(address.getId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_ADDRESS_ID);
		}else {
			if(commonAddressService.deleteByPrimaryKey(address.getId()) > 0){
				return getAppResponseEntity(true);
			}else{
				return getAppResponseEntity(false);
			}
		}
	}

}
