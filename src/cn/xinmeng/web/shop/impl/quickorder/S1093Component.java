package cn.xinmeng.web.shop.impl.quickorder;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.service.IOrderSubimtService;
import cn.xinmeng.api.service.IPaymentService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.quickorder.S1093RequestEntity;

/**
 * 优惠买单，创建订单
 * @param 
 * @ClassName: S1093Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.quickorder.S1093Component")
public class S1093Component extends BaseService {
	
	@Resource
	private IOrderSubimtService orderSubimtService;
	
	@Resource
	private IPaymentService paymentService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1093RequestEntity entity = parseRequertParam(data, S1093RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getOpenId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_OPEN_ID);
		}else if(entity.getTotalAmount() <= 0 || entity.getDiscountAmount() < 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()),"支付金额错误...");
		}else if(Utils.isEmpty(entity.getOrderFrom())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_ORDER_FROM);
//		}else if(Utils.isEmpty(entity.getOrderType()) || !QuickOrderTypeEnum.exist(entity.getOrderType()+"")){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum);
		}else if(Utils.isEmpty(entity.getPayType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_PAYMENT_TYPE);
		}else if(entity.getPayType() == 1 && Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		/**
		 * 创建订单
		 */
		QuickOrder order = orderSubimtService.quickOrderSumbit(entity);
		
		return getAppResponseEntity(paymentService.payQuickOrder(order, request.getSource(), entity.getShopId(), request.getIp(),entity.getCustomerId()));
	}
}
