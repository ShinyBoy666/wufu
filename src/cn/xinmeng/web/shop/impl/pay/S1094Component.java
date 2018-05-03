package cn.xinmeng.web.shop.impl.pay;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.constant.ConstantSystem;
import cn.xinmeng.api.entity.auto.CustomerRecharge;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.service.ICustomerRechargeService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.quickorder.S1084ResponseEntity;
import cn.xinmeng.web.shop.entity.quickorder.S1094RequestEntity;

/**
 * 根据支付单号查询订单
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.pay.S1094Component")
public class S1094Component extends BaseService{

	@Resource
	private ICustomerRechargeService customerRechargeService;
	
	@Resource
	private IQuickOrderService quickOrderService;
	
	@Resource
	private IShopInfoService shopInfoService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		
		S1094RequestEntity entity = parseRequertParam(data, S1094RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getRechargeId())){
			throw new NullException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_PAYMENT_ID);
		}
		
		if(!Utils.isEmpty(entity.getRechargeId()) && entity.getRechargeId().startsWith(ConstantSystem.PAYMENT_NO_QUICK_PREFIX)) {
			CustomerRecharge recharge = customerRechargeService.searchByRechargeId(entity.getRechargeId());
			QuickOrder quickOrder = quickOrderService.queryByOrderId(recharge.getOrderId());
			if(quickOrder != null){
				S1084ResponseEntity res = new S1084ResponseEntity();
				CloneUtils.copyEntity(quickOrder, res);
				ShopInfo shopInfo = shopInfoService.queryShopInfoById(quickOrder.getShopId(),"shop_logo,shop_name");
				if(shopInfo != null){
					res.setShopName(shopInfo.getShopName());
					res.setShopLogo(shopInfo.getShopLogo());
				}else{
					res.setShopName("");
					res.setShopLogo("");
				}
				return getAppResponseEntity(res);
			}
		}
		throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
	}
	
}
