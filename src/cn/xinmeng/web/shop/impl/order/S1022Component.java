package cn.xinmeng.web.shop.impl.order;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.api.service.IOrderSubimtService;
import cn.xinmeng.api.service.IPaymentService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExPaymentEnum;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.order.S1022RequestEntity;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;

/**
 * 快速下单
 * @param 
 * @ClassName: S1022Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.order.S1022Component")
public class S1022Component extends BaseService {

	@Resource
	private IOrderSubimtService orderSubimtService;
	@Resource
	private IPaymentService paymentService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1022RequestEntity entity = parseRequertParam(data, S1022RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(PaymentGatewayEnum.exist(String.valueOf(entity.getOnlinePayType())) == false 
				&& (entity.isAccountDeduct() == false)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExPaymentEnum.EX_NULL_PAY_WAY);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else if(Utils.isEmpty(entity.getAddressId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_RECIPIENT_ADDRESS);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getProductId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCTID);
		}else if(Utils.isEmpty(entity.getProductNumber())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CART_NUMBER);
		}else if(!Utils.isEmpty(entity.getActivityType()) && Utils.isEmpty(entity.getProductPriceId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCTPRICEID);
		}else if(Utils.isEmpty(entity.getActivityType()) && Utils.isEmpty(entity.getSku())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_PRODUCT_SKU);
		}
		
		//减库存，下订单
		PayOrderBiz payOrderBiz = orderSubimtService.fastSubmitOrderMain(entity, request.getSourceShopId(), request.getLoginShopId());
		
		//账户扣款与支付
		try {
			return getAppResponseEntity(paymentService.payOrder(payOrderBiz,request.getSource(),request.getLoginShopId(),request.getIp()));
		} catch (Exception e) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_PAY_FAILD_CREATE_ORDER);
		}
	}
	
	
}
