package cn.xinmeng.web.shop.impl.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.enums.AccountTypeEnum;
import cn.xinmeng.api.service.IEnchashmentService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageSearchEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 提现记录列表
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1081Component")
public class S1081Component extends BaseService {

	@Resource
	private IEnchashmentService enchashmentService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		PageSearchEntity entity = parseRequertParam(data, PageSearchEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		return getAppResponseEntity(enchashmentService.selectByExample(entity.getCurrentPage(), entity.getLimit(), entity.getCustomerId(),AccountTypeEnum.USER));
	}
}
