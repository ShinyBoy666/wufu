package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
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
import cn.xinmeng.web.shop.entity.customer.S1026RequestEntity;

/**
 * 修改个人资料
 * @param 
 * @ClassName: S1026Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1026Component")
public class S1026Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1026RequestEntity entity = parseRequertParam(data, S1026RequestEntity.class);
		
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getNickname()) && Utils.isEmpty(entity.getHeadSculpture()) && Utils.isEmpty(entity.getSex())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}
		
		Customer customer = new Customer();
		customer.setId(entity.getCustomerId());
		
		if(!Utils.isEmpty(entity.getHeadSculpture())){
			customer.setHeadSculpture(entity.getHeadSculpture());
		}
		if(!Utils.isEmpty(entity.getNickname())){
			customer.setNickname(entity.getNickname());
		}
		if(!Utils.isEmpty(entity.getSex())){
			customer.setSex(entity.getSex());
		}
		
		if(customerService.updateSelectiveByPrimaryKey(customer) > 0){
			return getAppResponseEntity(true);
		}else{
			return getAppResponseEntity(false);
		}
	}
	
	
}
