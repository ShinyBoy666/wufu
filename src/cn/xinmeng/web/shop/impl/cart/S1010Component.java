package cn.xinmeng.web.shop.impl.cart;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.cart.S1010RequestEntity;

/**
 * 删除 购物车商品 
 * @param 
 * @ClassName: S1010Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:48:49 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.cart.S1010Component")
public class S1010Component extends BaseService {

	@Resource
	private ICartService cartService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1010RequestEntity entity = parseRequertParam(data, S1010RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCartIds())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CARTID_IS);
		}else {
			
			if(cartService.deleteByIds(entity.getCartIds()) > 0){
				return getAppResponseEntity(true);
			}else{
				return getAppResponseEntity(false);
			}
		}
	}

	
	
}
