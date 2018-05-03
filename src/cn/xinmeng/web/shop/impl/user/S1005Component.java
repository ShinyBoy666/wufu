package cn.xinmeng.web.shop.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.user.S1005RequestEntity;

/**
 * 验证手机是否存在
 * @param 
 * @ClassName: S1005Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.user.S1005Component")
public class S1005Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1005RequestEntity entity = parseRequertParam(data, S1005RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCellphone())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_LOGINNAME);
		}
		return getAppResponseEntity(customerService.existsUser(entity.getCellphone(),request.getLoginShopId()));
	}
	
	
}
