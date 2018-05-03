package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICustomerFeedbackService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1027RequestEntity;

/**
 * 客户反馈 新增（wap）
 * @param 
 * @ClassName: S1059Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1059Component")
public class S1059Component extends BaseService {
	
	@Resource
	private ICustomerFeedbackService customerFeedbackService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1027RequestEntity entity = parseRequertParam(data, S1027RequestEntity.class);
		
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getFromType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_FEEDBACK_SOURCE_IS);
		}else if(Utils.isEmpty(entity.getReplyContent())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_FEEDBACK_CONTEXT_IS);
		}else {
			if(customerFeedbackService.insert(entity) > 0){
				return getAppResponseEntity(true);
			}else {
				return getAppResponseEntity(false);
			}
		}
	}
	
	
}
