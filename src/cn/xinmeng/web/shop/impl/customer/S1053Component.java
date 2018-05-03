package cn.xinmeng.web.shop.impl.customer;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Coupon;
import cn.xinmeng.api.enums.CouponStateEnum;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.common.enums.ex.ExCouponEnum;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1053RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1053ResponseEntity;

/**
 * 兑换优惠券
 * @param 
 * @ClassName: S1053Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1053Component")
public class S1053Component extends BaseService {
	
	@Resource
	private ICouponService couponService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1053RequestEntity entity = parseRequertParam(data, S1053RequestEntity.class);
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		Coupon coupon = couponService.queryCouponByCouponCode(entity.getCouponCode());
		if(coupon == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NOTEXISTS_COUPONID);
		}
		if(CouponStateEnum.UNUSED_POINT.key().equals(coupon.getState()+"") == false){
			//已被领用
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_USE);
		}
		Date curr = new Date();
		if(DateUtil.compareDate(curr, coupon.getEndTime())){
			//优惠券已经过期
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_OVER);
		}
		if(couponService.converCoupon(entity.getCustomerId(),request.getLoginShopId(), entity.getCouponCode()) == false){
			//修改失败
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
		S1053ResponseEntity res = new S1053ResponseEntity();
		CloneUtils.copyEntity(coupon, res);
		return getAppResponseEntity(res);
	}
	
	
}
