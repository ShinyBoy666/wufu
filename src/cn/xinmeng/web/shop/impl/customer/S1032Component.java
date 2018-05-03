package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Coupon;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.common.enums.ex.ExCouponEnum;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 优惠券添加
 * @param 
 * @ClassName: S1032Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1032Component")
public class S1032Component extends BaseService {
	
	@Resource
	private ICouponApplyService couponApplyService;
	@Resource
	private ICouponService couponService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Coupon entity = parseRequertParam(data, Coupon.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
//		}else if(Utils.isEmpty(entity.getUseShopId())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_USE_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getCouponApplyId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NULL_COUPONAPPLYID);
		}
		entity.setShopId(request.getLoginShopId());
		return getAppResponseEntity(couponService.addCoupon(entity));
	}
	
	
}
