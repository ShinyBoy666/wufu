package cn.xinmeng.web.shop.impl.quickorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerDetail;
import cn.xinmeng.api.entity.auto.ShopActivityConfig;
import cn.xinmeng.api.entity.auto.example.QuickOrderExample;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.enums.QuickOrderTypeEnum;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerDetailService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IShopActivityConfigService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1092RequestEntity;
import cn.xinmeng.web.shop.entity.quickorder.S1092ResponseEntity;
import cn.xinmeng.web.shop.entity.user.vo.CustomerUser;
import cn.xinmeng.web.shop.entity.vo.OrderCouponVo;

/**
 * 优惠买单，获取商户支持的优惠支付方式
 * @param 
 * @ClassName: S1092Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.quickorder.S1092Component")
public class S1092Component extends BaseService {

	@Resource
	private IShopActivityConfigService shopActivityConfigService;
	
	@Resource
	private ICustomerService customerService;
	
	@Resource
	private ICouponService couponService;
	
	@Resource
	private ISystemConfigService systemConfigService;
	
	@Resource
	private ICustomerDetailService customerDetailService;
	@Resource
	private IQuickOrderService quickOrderService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1092RequestEntity entity = parseRequertParam(data, S1092RequestEntity.class);
		
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}else if(Utils.isEmpty(entity.getOpenId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_OPEN_ID);
		}else if(Utils.isEmpty(entity.getOrderMoney())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NULL_TOTAL_AMOUNT);
		}
		
		S1092ResponseEntity result = new S1092ResponseEntity();
		
		QuickOrderExample example = new QuickOrderExample();
		QuickOrderExample.Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(entity.getOpenId());
		criteria.andShopIdEqualTo(entity.getShopId());
		criteria.andPayStateEqualTo(Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
		criteria.andDiscountAmountGreaterThan(0.00);
		criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getStandardDate(DateUtil.customDateToStr(new Date(), "yyyy-MM-dd 00:00:00"), "yyyy-MM-dd HH:mm:ss"));
		
		Integer count = quickOrderService.countByExample(example);
		result.setOrderCount(count);
		
		ShopActivityConfig config = shopActivityConfigService.queryByShopId(entity.getShopId());
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if(config != null){
			if(config.getCanRandom() == 1 && config.getMinMoney() > 0 && config.getMaxMoney() >= config.getMinMoney() ){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type", QuickOrderTypeEnum.RANDOM.key());
				map.put("name", QuickOrderTypeEnum.RANDOM.value());
				map.put("minMoney", config.getMinMoney());
				map.put("maxMoney", config.getMaxMoney());
				map.put("randomMoneys", Utils.randomAmount);
				result.setAdContent("满"+Utils.randomAmount+"立减");
				list.add(map);
			}
			
			if(config.getCanFullReduce() == 1 && !Utils.isEmpty(config.getReduceMoney()) && !Utils.isEmpty(config.getFullMoney())){
				String [] reduceMoneys = config.getReduceMoney().split("\\|");
				String[] fullMoneys = config.getFullMoney().split("\\|");
				if(reduceMoneys.length > 0 && fullMoneys.length == reduceMoneys.length){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("type", QuickOrderTypeEnum.FULLREDUCE.key());
					map.put("name", QuickOrderTypeEnum.FULLREDUCE.value());
					map.put("reduceMoneys", reduceMoneys);
					map.put("fullMoneys", fullMoneys);
					list.add(map);
				}
			}
			
			if(config.getCanSale() == 1 && config.getSale() > 0 && config.getSale() < 100){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type", QuickOrderTypeEnum.SALE.key());
				map.put("name", QuickOrderTypeEnum.SALE.value());
				map.put("sale", config.getSale());
				list.add(map);
			}
		}
		
		Customer customer = customerService.queryCustomerByOpenId(entity.getOpenId(), "");
		CustomerUser user= new CustomerUser();
		if(customer != null){
			List<OrderCouponVo> couponList = couponService.newOrderCouponApplyList(customer.getId(),entity.getShopId(), entity.getOrderMoney());
			if(!Utils.isEmpty(couponList)){
				List<OrderCouponVo> couponVos = new ArrayList<OrderCouponVo>();
				for (OrderCouponVo orderCouponVo : couponList) {
					if(Utils.isUseCoupon(orderCouponVo.getCanUseDay(), orderCouponVo.getCanUseHour()) == false){
						continue;
					}
					couponVos.add(orderCouponVo);
				}
				
				if(couponVos.size() > 0){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("type", QuickOrderTypeEnum.COUPON.key());
					map.put("name", QuickOrderTypeEnum.COUPON.value());
					map.put("list", couponVos);
					list.add(map);
				}
			}
			
//			if(couponService.searchMyCouponCount(entity.getShopId(), customer.getId(), 2) > 0){
//				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("type", QuickOrderTypeEnum.COUPON.key());
//				map.put("name", QuickOrderTypeEnum.COUPON.value());
//				list.add(map);
//			}
			if(systemConfigService.notNumberBalancePay(customer)){
				result.setAmount(customer.getCashAmount());
			}
			result.setCustomerId(customer.getId());
			
			
			CloneUtils.copyEntity(customer, user);
			user.setAccountDeduct(systemConfigService.notNumberBalancePay(customer));
			user.setHeadSculpture(Utils.getImageUrl(user.getHeadSculpture(),"?300_300"));
			CustomerDetail customerDetail = customerDetailService.getCustomerDetail(customer.getId(), "realname,identity_Card");
			if(!Utils.isEmpty(customerDetail)){
				user.setRealyname(customerDetail.getRealname());
				user.setIdentityCard(customerDetail.getIdentityCard());
			}
		}
		result.setCustomer(user);
		result.setList(list);
		return getAppResponseEntity(result);
	}

	
}
