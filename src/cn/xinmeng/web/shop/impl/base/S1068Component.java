package cn.xinmeng.web.shop.impl.base;

import org.springframework.stereotype.Component;

import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.base.S1068RequestEntity;

/**
 * 更新个推id
 * @param 
 * @ClassName: S1068Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1068Component")
public class S1068Component extends BaseService {
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1068RequestEntity entity = parseRequertParam(data, S1068RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		
		return getAppResponseEntity(false);
	}
	
	
}
