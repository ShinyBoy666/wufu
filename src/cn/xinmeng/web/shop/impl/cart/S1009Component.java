package cn.xinmeng.web.shop.impl.cart;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.cart.S1009RequestEntity;

/**
 * 修改购物车商品数量
 * @param 
 * @ClassName: S1009Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:39:53 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.cart.S1009Component")
public class S1009Component extends BaseService {

	@Resource
	private ICartService cartService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1009RequestEntity entity = parseRequertParam(data, S1009RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CARTID_IS);
		}else if(Utils.isEmpty(entity.getProductNumber())){
			throw new BusinessException(LogManager.getLogger(getClass()),ExProductEnum.PRODUCT_NUMBER_NULL);
		}else{
			if(cartService.updateNumById(entity.getId(), entity.getProductNumber()) > 0){
				return getAppResponseEntity(true);
			}else{
				return getAppResponseEntity(false);
			}
		}
	}


}
