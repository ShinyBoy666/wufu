package cn.xinmeng.web.shop.impl.market;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1098RequestEntity;

/**
 * 优惠劵列表
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1098Component")
public class S1098Component extends BaseService {

	@Resource
	private ICouponApplyService couponApplyService;
	
	@Resource
	private IQuickOrderService quickOrderService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1098RequestEntity entity = parseRequertParam(data, S1098RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getOrderId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_ID);
		}
		QuickOrder order = quickOrderService.queryByOrderId(entity.getOrderId());
		if(order != null && UtilMoney.compareTo(order.getTotalAmount(), order.getReceiveCouponAmount()) > 0){
			entity.setOrderMoney(UtilMoney.subtractToDouble(order.getTotalAmount(), order.getReceiveCouponAmount()));
		}
		return getAppResponseEntity(couponApplyService.searchCouponApplyList(entity));
	}
}
