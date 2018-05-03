package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Collection;
import cn.xinmeng.api.service.ICollectionService;
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
 * 
 * <p class="detail">客户收藏/取消收藏 </p>
 * 
 * @param 
 * @ClassName: S1041Component 
 * @version V1.0  @date 2016年2月25日 下午3:14:23 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1041Component")
public class S1041Component extends BaseService {
	
	@Resource
	private ICollectionService collectionService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Collection entity = parseRequertParam(data, Collection.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getObjectId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_COLLECT_ID_IS_NULL);
		}else if(Utils.isEmpty(entity.getObjectType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_COLLECT_TYPE_IS_NULL);
		}
		Integer shopId = request.getLoginShopId();
//		if(!Utils.isEmpty(entity.getShopId())){
//			shopId = entity.getShopId();
//		}
		entity.setShopId(shopId);
		return getAppResponseEntity(collectionService.insertOrDelete(entity));
	}
	
	
}
