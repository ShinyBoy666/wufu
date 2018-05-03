package cn.xinmeng.api.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CouponDao;
import cn.xinmeng.api.dao.ex.ExCouponDao;
import cn.xinmeng.api.dao.ex.ExOrderDao;
import cn.xinmeng.api.entity.auto.Category;
import cn.xinmeng.api.entity.auto.Coupon;
import cn.xinmeng.api.entity.auto.CouponApply;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.SystemErrorLog;
import cn.xinmeng.api.entity.auto.biz.CouponBiz;
import cn.xinmeng.api.entity.auto.example.CouponExample;
import cn.xinmeng.api.enums.CouponApplyStateEnum;
import cn.xinmeng.api.enums.CouponStateEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICategoryService;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.api.service.ISystemErrorLogService;
import cn.xinmeng.common.enums.ex.ExCouponEnum;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExOrderEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCustCouponVo;
import cn.xinmeng.web.shop.entity.vo.DiscountAmountVo;
import cn.xinmeng.web.shop.entity.vo.OrderCouponVo;

/**
 * 业务层：CouponServiceImpl
 * @author jiangyong.tan
 * 描述：优惠券表
 * @date 2016-01-24 14:38:56
 */
@Service("couponService")
public class CouponServiceImpl implements ICouponService {

    @Resource
	private CouponDao couponDao;
    @Resource
    private ExCouponDao exCouponDao;
    @Resource
    private ExOrderDao exOrderDao;
    @Resource
    private ICouponApplyService couponApplyService;
    
    @Resource
    private IProductInfoService productInfoService;
	@Resource
	private ICategoryService categoryService;
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private IRedisService redisService;
	@Resource
    private ICustomerService customerService;
	@Resource
	private IQuickOrderService quickOrderService;
	@Resource
	private ISystemErrorLogService systemErrorLogService;
	
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Coupon record){
    	return couponDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return couponDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Coupon record){
		return couponDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Coupon selectByPrimaryKey(Integer id){
    	return couponDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CouponExample example){
		return couponDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Coupon> selectByExample(CouponExample example){
    	return couponDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Coupon> selectByExample(int currentPage, int limit,CouponExample example){
        return couponDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    

    /**
     * 查询店铺可用优惠券
     * @author jiangyong.tan
     * @date 2016年2月23日 下午1:55:14
     * @param shopId
     * @param customerId
     * @param shopCarts
     * @return
     */
    public List<ShopCustCouponVo> searchCouponByShopId(Integer useShopId,Integer shopId,Integer customerId,List<ShopCartVo> shopCarts){

		List<Integer> cartCategoryIds = new ArrayList<Integer>();
		Map<Integer,Double> cartCategory = new HashMap<Integer,Double>();//分类的总金额
		Double totalAmount = 0.00;//购物车总金额
		
    	/**
		 * 第二步：获取购物车，商品分类ID与品牌ID，并对应的总金额
		 */
		for (ShopCartVo shopCart : shopCarts) {
			ProductInfo productInfo = productInfoService.queryProductInfoByProductId(shopCart.getProductId());
			if(productInfo != null){
				Integer categoryId = productInfo.getCategoryId();
				
				Double productAmount = UtilMoney.multiplyToDouble(shopCart.getRetailPrice(),shopCart.getProductNumber());
				
				totalAmount = UtilMoney.addToDouble(totalAmount, productAmount);
				cartCategoryIds.add(categoryId);
				if(cartCategory.containsKey(categoryId)){
					Double amount = cartCategory.get(categoryId);
					cartCategory.put(categoryId, UtilMoney.addToDouble(amount, productAmount));
				}else{
					cartCategory.put(categoryId,productAmount);
				}
			}
		}
		
		/**
		 * 第三步：查询三级分类所对应的二级，一级，并对应金额
		 */
		if(!Utils.isEmpty(cartCategoryIds)){
			List<Category> categorieList = categoryService.searchCategoryByIds(cartCategoryIds);
			for (Category category : categorieList) {
				Integer categoryId = category.getId();
				Integer secondId = category.getSecondId();
				Integer firstId = category.getFirstId();
				if(!cartCategory.containsKey(secondId)){
					Double amount = cartCategory.get(categoryId);
					cartCategory.put(secondId, amount);
				} 
				if(!cartCategory.containsKey(firstId)){
					Double amount = cartCategory.get(categoryId);
					cartCategory.put(firstId, amount);
				}
			}
		}
		
		/**
		 * 第四步：查询我的所有优惠券
		 */
		List<CouponBiz> list = exCouponDao.searchMyCouponByShopId(shopId,customerId);
		Map<String,Map<Integer,Double>> cList = new HashMap<String,Map<Integer,Double>>();
		Map<String,Map<Integer,Double>> bList = new HashMap<String,Map<Integer,Double>>();
		Map<String,Map<String,Double>> allList = new HashMap<String,Map<String,Double>>();
		
		for (CouponBiz couponBiz : list) {
			if(couponBiz.getCategoryId() != 0){
				Map<Integer,Double> cIds = new HashMap<Integer,Double>();//我的优惠券：分类ID
				cIds.put(couponBiz.getCategoryId(),couponBiz.getOrderMoney());
				cList.put(couponBiz.getCouponCode(), cIds);
			}else if(couponBiz.getBrandId() != 0){
				Map<Integer,Double> bIds = new HashMap<Integer,Double>();//我的优惠券：品牌ID
				bIds.put(couponBiz.getBrandId(),couponBiz.getOrderMoney());
				bList.put(couponBiz.getCouponCode(), bIds);
			}else{
				Map<String,Double> allIds = new HashMap<String,Double>();//我的优惠券：全场通用
				allIds.put(couponBiz.getCouponCode(),couponBiz.getOrderMoney());
				allList.put(couponBiz.getCouponCode(), allIds);
			}
		}
		
		/**
		 * 第五步：计算满足优惠券的金额
		 * 全场通用：只要订单金额 > 优惠券订单金额，则需要显示
		 * 分类优惠：有该分类的优惠券，且该分类的商品总金额 > 优惠券金额
		 * 品牌优惠：有该品牌的优惠券，且该品牌的商品总金额 > 优惠券金额
		 */
		Map<String,String> use = new HashMap<String, String>();//键，优惠券编码，值：优惠券编码
		List<Integer> cUseIds = new ArrayList<Integer>();//可用的分类ID
		if(allList.size() > 0){
			for (Entry<String, Map<String, Double>> map : allList.entrySet()) {
				String couponCode = map.getKey();
				//全场通用优惠券
				 for (Map.Entry<String, Double> entry : map.getValue().entrySet()) {
					 Double value = entry.getValue();
					 if(totalAmount >= value){
						 use.put(couponCode, couponCode);
					 }
				}
			}
		}
		if(cList.size() > 0){
			//分类优惠券
			for (Entry<String, Map<Integer, Double>> map : cList.entrySet()) {
				String couponCode = map.getKey();
				 for (Map.Entry<Integer, Double> entry : map.getValue().entrySet()) {
					 Integer key = entry.getKey();
					 Double value = entry.getValue();
					 if(!cartCategory.containsKey(key)){
						continue; 
					 }
					 if(cartCategory.get(key) >= value){
						 use.put(couponCode, couponCode);
						 cUseIds.add(key);
					 }
				}
			}
		}
		
		/**
		 * 第六步：为第六步查询分类的名称，品牌的名称
		 */
		Map<Integer, String> categorieMap = new HashMap<Integer, String>();
		Map<Integer,String> brandMap = new HashMap<Integer, String>();
		if(!Utils.isEmpty(cUseIds)){
			List<Category> categorieList = categoryService.searchCategoryByIds(cUseIds);
			if(!Utils.isEmpty(categorieList)){
				for (Category category : categorieList) {
					categorieMap.put(category.getId(), category.getCategoryName());
				}
			}
		}
		
		/**
		 * 第七步：返回可用优惠券列表
		 */
		List<ShopCustCouponVo> resList = new ArrayList<ShopCustCouponVo>();
		Map<Integer,String> shopMap = new HashMap<Integer, String>();
		for (CouponBiz couponBiz : list) {
			String couponCode = couponBiz.getCouponCode();
			if(use.containsKey(couponCode)){
				ShopCustCouponVo shopCust = new ShopCustCouponVo();
				String description = "";
				if(couponBiz.getOrderMoney() > 0){
					description = MessageFormat.format("满{0}可用,", couponBiz.getOrderMoney());
				}
				if(brandMap.containsKey(couponBiz.getBrandId())){
					couponBiz.setDescription(description+brandMap.get(couponBiz.getBrandId())+"专用");
				}else if(categorieMap.containsKey(couponBiz.getCategoryId())){
					couponBiz.setDescription(description+categorieMap.get(couponBiz.getCategoryId())+"专用");
				}else{
					couponBiz.setDescription(description+"全场通用");
				}
				CloneUtils.copyEntity(couponBiz, shopCust);
				Integer tempUseShopId = couponBiz.getUseShopId();
				if(shopMap.containsKey(tempUseShopId)){
					shopCust.setUseShopName(shopMap.get(tempUseShopId));
				}else{
					String shopName = shopInfoService.queryShopNameByShopId(tempUseShopId);
					shopCust.setUseShopName(shopName);
					shopMap.put(useShopId, shopName);
				}
				resList.add(shopCust);
			}
		}
    	return resList;
    }
    
    /**
     *  查询我的所有可用优惠券
     * @author jiangyong.tan
     * @date 2016年2月23日 下午2:24:34
     * @param shopId
     * @return
     */
    public List<Coupon> searchCouponByshopId(Integer shopId,Integer customerId){
    	CouponExample example = new CouponExample();
    	CouponExample.Criteria criteria = example.createCriteria();
    	criteria.andShopIdEqualTo(shopId);
    	criteria.andCustomerIdEqualTo(customerId);
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	criteria.andEndTimeLessThan(new Date());
    	return couponDao.selectByExample(example);
    }
    
    
    /**
     * 查询我的优惠券列表
     * @author jiangyong.tan
     * @date 2016年2月24日 上午9:15:57
     * @param couponCondition
     * @return
     */
    public Integer searchMyCouponCount(Integer shopId,Integer customerId,Integer state){
    	return exCouponDao.searchMyCouponCount(shopId, customerId, state);
    }
    
    /**
     * 查询我的优惠券列表
     * @author jiangyong.tan
     * @date 2016年2月24日 上午9:06:18
     * @param couponCondition
     * @return
     */
    public List<CouponBiz> searchMyCouponList(Integer currentPage,Integer limit,Integer shopId,Integer customerId,Integer state){
    	return exCouponDao.searchMyCouponList(new RowBounds(currentPage, limit), shopId, customerId, state);
    }
    
    /**
     *  使用优惠券
     * @author jiangyong.tan
     * @date 2016年2月25日 上午9:55:26
     * @param coupon
     * @return
     */
    public Integer useCoupon(Coupon coupon){
    	coupon.setUseTime(new Date());
    	coupon.setState(Integer.valueOf(CouponStateEnum.USE.key()));
    	return couponDao.updateByPrimaryKey(coupon);
    }
    
    /**
     * 查询优惠券信息
     * @param couponCode
     * @return
     */
    public Coupon queryCouponByCouponCode(String couponCode){
    	CouponExample example = new CouponExample();
    	CouponExample.Criteria criteria = example.createCriteria();
    	criteria.andCouponCodeEqualTo(couponCode);
    	List<Coupon> list = couponDao.selectByExample(example);
    	if(!Utils.isEmpty(list)){
    		return list.get(0);
    	}
    	return null;
    }

    /**
     * 兑换优惠券
     * @param couponCode
     * @return
     */
    public boolean converCoupon(Integer customerId,Integer shopId,String couponCode){
    	CouponExample example = new CouponExample();
    	CouponExample.Criteria criteria = example.createCriteria();
    	criteria.andCouponCodeEqualTo(couponCode);
    	criteria.andStateEqualTo(Integer.valueOf(CouponStateEnum.UNUSED_POINT.key()));
    	List<Coupon> list = selectByExample(example);
    	if(!Utils.isEmpty(list)){
    		Coupon coupon = list.get(0);
    		if(exCouponDao.couponReceiveNumberAdd(coupon.getCouponApplyId()) == 0){
    			//领取人数过多，请从新领取
    			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
    		}
    	}
    	
    	Coupon coupon = new Coupon();
    	coupon.setState(Integer.valueOf(CouponStateEnum.USED_POINT.key()));
    	coupon.setCustomerId(customerId);
    	if(couponDao.updateByExampleSelective(coupon, example) > 0){
    		//兑换
    		return true;
    	}
    	return false;
    }
    

    /**
     * app领取优惠券
     * @param coupon
     * @return
     */
    public boolean addCoupon(Coupon coupon){

		//查询领取优惠信息
		CouponApply couponapply = couponApplyService.selectByPrimaryKey(coupon.getCouponApplyId());
		if(couponapply == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NOTEXISTS_COUPONID);
		}
		Date curr = new Date();

		if(DateUtil.compareDate(curr, couponapply.getEndTime())){
			//优惠券已经过期
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_OVER);
		}
		
		//判断上否领取
		CouponExample couponExample = new CouponExample();
		CouponExample.Criteria couponCriteria = couponExample.createCriteria();
		couponCriteria.andShopIdEqualTo(coupon.getShopId());
		couponCriteria.andCustomerIdEqualTo(coupon.getCustomerId());
		couponCriteria.andCouponApplyIdEqualTo(couponapply.getId());
		List<Integer> stateList = new ArrayList<Integer>();
		stateList.add(2);//已经领用
		stateList.add(3);//已经使用
		couponCriteria.andStateIn(stateList);
		if(countByExample(couponExample) > 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_MAX_HAVE);
		}
		
		//是否预生成1、否2、是
		if(couponapply.getIsCreate() == 1){
			if(exCouponDao.couponReceiveNumberAdd(couponapply.getId()) == 0){
				//领取人数过多，请从新领取
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
			//需要生成coupon数据

			//组装固定数据
			coupon.setState(Integer.valueOf(CouponStateEnum.USED_POINT.key()));
			coupon.setCouponCode(Utils.inviteCode(8));
			coupon.setCouponMoney(couponapply.getCouponMoney());
			coupon.setCouponType(couponapply.getCouponType());//
			coupon.setAddTime(curr);
			coupon.setBeginTime(couponapply.getBeginTime());
			coupon.setEndTime(couponapply.getEndTime());
			coupon.setOrderMoney(couponapply.getOrderMoney());
			if(couponapply.getExpiresModel() == 2){
				coupon.setBeginTime(couponapply.getBeginTime());
				coupon.setEndTime(DateUtil.addDay(couponapply.getBeginTime(), couponapply.getExpiresDays()));
			}
			add(coupon);
		}else{
			//修改coupon数据
			CouponExample example = new CouponExample();
			CouponExample.Criteria criteria = example.createCriteria();
			criteria.andCouponApplyIdEqualTo(coupon.getCouponApplyId());
			criteria.andStateEqualTo(Integer.valueOf(CouponStateEnum.UNUSED_POINT.key()));
			criteria.andEndTimeGreaterThan(curr);
			List<Coupon> list = couponDao.selectByExample(example);
			if(list == null || list.size() == 0){
				//已被领完
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
			Coupon cou = list.get(0);
			if(converCoupon(coupon.getCustomerId(), coupon.getShopId(), cou.getCouponCode()) == false){
				//领取人数过多，请从新领取
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
			
		}
    	return true;
    }
    /**
     * 配额后：领取优惠券(1-领取成功，2-已经领完，3-现领张数达到)
     * @param coupon
     * @return
     */
    public Integer newAddCoupon(Coupon coupon,String orderId){
    	
		//查询领取优惠信息
		CouponApply couponapply = couponApplyService.selectByPrimaryKey(coupon.getCouponApplyId());
		if(couponapply == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NOTEXISTS_COUPONID);
		}
		Date curr = new Date();

		if(DateUtil.compareDate(curr, couponapply.getEndTime())){
			//优惠券已经过期
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_OVER);
		}
		//金额不对不能领取
		if(!Utils.amountMap.containsKey(couponapply.getCouponMoney())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
		//优惠券金额数量，是否已经领完
		DiscountAmountVo vo = redisService.getDiscountAmountVo(orderId,coupon.getCustomerId());
		if(Utils.isEmpty(vo)){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
		if(Utils.getCouponLeft(vo, couponapply.getCouponMoney()) < 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
		Customer customer = customerService.selectByPrimaryKey(coupon.getCustomerId());
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		QuickOrder order = quickOrderService.queryByOrderId(orderId);
		if(order == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_NOTEXIST_ORDER);
		}
		//验证是否是当前用户
		if(!order.getOpenId().equals(customer.getOpenId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExRequestEnum.REQUEST_ERROR);
		}
		
		if(!Utils.isEmpty(couponapply.getMaxGetNumber())){
			//判断上否领取
			CouponExample couponExample = new CouponExample();
			CouponExample.Criteria couponCriteria = couponExample.createCriteria();
			couponCriteria.andCustomerIdEqualTo(coupon.getCustomerId());
			couponCriteria.andCouponApplyIdEqualTo(couponapply.getId());
			List<Integer> stateList = new ArrayList<Integer>();
			stateList.add(2);//已经领用
			stateList.add(3);//已经使用
			couponCriteria.andStateIn(stateList);
			if(countByExample(couponExample) >= couponapply.getMaxGetNumber()){
				return 3;
			}
		}
		
		//是否预生成1、否2、是
		if(couponapply.getIsCreate() == 1){
			if(exCouponDao.couponReceiveNumberAdd(couponapply.getId()) == 0){
				//已领完
				return 2;
			}
			//需要生成coupon数据

			//组装固定数据
			coupon.setState(Integer.valueOf(CouponStateEnum.USED_POINT.key()));
			coupon.setCouponCode(Utils.inviteCode(8));
			coupon.setCouponMoney(couponapply.getCouponMoney());
			coupon.setCouponType(couponapply.getCouponType());//
			coupon.setAddTime(curr);
			coupon.setBeginTime(couponapply.getBeginTime());
			coupon.setEndTime(couponapply.getEndTime());
			coupon.setOrderMoney(couponapply.getOrderMoney());
			if(couponapply.getExpiresModel() == 2){
				coupon.setBeginTime(couponapply.getBeginTime());
				coupon.setEndTime(DateUtil.addDay(couponapply.getBeginTime(), couponapply.getExpiresDays()));
			}
			add(coupon);
		}else{
			//修改coupon数据
			CouponExample example = new CouponExample();
			CouponExample.Criteria criteria = example.createCriteria();
			criteria.andCouponApplyIdEqualTo(coupon.getCouponApplyId());
			criteria.andStateEqualTo(Integer.valueOf(CouponStateEnum.UNUSED_POINT.key()));
			criteria.andEndTimeGreaterThan(curr);
			List<Coupon> list = couponDao.selectByExample(example);
			if(list == null || list.size() == 0){
				//已被领完
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
			Coupon cou = list.get(0);
			if(converCoupon(coupon.getCustomerId(), coupon.getShopId(), cou.getCouponCode()) == false){
				//领取人数过多，请从新领取
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
		}
		/** 修改优惠买单 已领取优惠劵金额 */
		if(exOrderDao.updateQuickOrderReceiveCouponAmount(orderId, couponapply.getCouponMoney()) > 0){
			//缓存数量-1
			redisService.setDiscountAmountVo(vo, orderId);
			return 1;
		}else{
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
    }
    
    /**
     * 商城：优惠券领取
     * @param coupon
     * @return
     */
    public Integer shopAddCoupon(Coupon coupon){
    	
		//查询领取优惠信息
		CouponApply couponapply = couponApplyService.selectByPrimaryKey(coupon.getCouponApplyId());
		if(couponapply == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NOTEXISTS_COUPONID);
		}
		Date curr = new Date();

		if(DateUtil.compareDate(curr, couponapply.getEndTime())){
			//优惠券已经过期
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_OVER);
		}
		//优惠券金额数量，是否已经领完
		Integer receiveNumber = queryCouponReceiveNumber(couponapply.getId(), coupon.getCustomerId());
		if(receiveNumber >= couponapply.getMaxGetNumber()){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_MAX_HAVE);
		}
		//判断上否领取
		CouponExample couponExample = new CouponExample();
		CouponExample.Criteria couponCriteria = couponExample.createCriteria();
		couponCriteria.andShopIdEqualTo(coupon.getShopId());
		couponCriteria.andCustomerIdEqualTo(coupon.getCustomerId());
		couponCriteria.andCouponApplyIdEqualTo(couponapply.getId());
		List<Integer> stateList = new ArrayList<Integer>();
		stateList.add(2);//已经领用
		stateList.add(3);//已经使用
		couponCriteria.andStateIn(stateList);
		if(countByExample(couponExample) > couponapply.getMaxGetNumber()){
			return 3;
		}
		
		//是否预生成1、否2、是
		if(couponapply.getIsCreate() == 1){
			if(exCouponDao.couponReceiveNumberAdd(couponapply.getId()) == 0){
				//已领完
				return 2;
			}
			//需要生成coupon数据

			//组装固定数据
			coupon.setState(Integer.valueOf(CouponStateEnum.USED_POINT.key()));
			coupon.setCouponCode(Utils.inviteCode(8));
			coupon.setCouponMoney(couponapply.getCouponMoney());
			coupon.setCouponType(couponapply.getCouponType());//
			coupon.setAddTime(curr);
			coupon.setBeginTime(couponapply.getBeginTime());
			coupon.setEndTime(couponapply.getEndTime());
			coupon.setOrderMoney(couponapply.getOrderMoney());
			if(couponapply.getExpiresModel() == 2){
				coupon.setBeginTime(couponapply.getBeginTime());
				coupon.setEndTime(DateUtil.addDay(couponapply.getBeginTime(), couponapply.getExpiresDays()));
			}
			add(coupon);
		}else{
			//修改coupon数据
			CouponExample example = new CouponExample();
			CouponExample.Criteria criteria = example.createCriteria();
			criteria.andCouponApplyIdEqualTo(coupon.getCouponApplyId());
			criteria.andStateEqualTo(Integer.valueOf(CouponStateEnum.UNUSED_POINT.key()));
			criteria.andEndTimeGreaterThan(curr);
			List<Coupon> list = couponDao.selectByExample(example);
			if(list == null || list.size() == 0){
				//已被领完
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
			Coupon cou = list.get(0);
			if(converCoupon(coupon.getCustomerId(), coupon.getShopId(), cou.getCouponCode()) == false){
				//领取人数过多，请从新领取
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
		}
    	return 1;
    }


	/**
	 * 是否能够领取优惠券
	 * @param shopId
	 * @param customerId
	 * @param applyId
	 * @return
	 */
	public boolean receiveCoupon(Integer loginShopId,Integer customerId,Integer applyId){
    	CouponExample example = new CouponExample();
    	CouponExample.Criteria criteria = example.createCriteria();
    	criteria.andShopIdEqualTo(loginShopId);
    	criteria.andCustomerIdEqualTo(customerId);
    	criteria.andCouponApplyIdEqualTo(applyId);
    	if(couponDao.countByExample(example) > 0){
    		return false;
    	}
		return true;
	}
	
	/**
	 * 优惠买单，优惠券发放面额
	 * @return
	 */
	public DiscountAmountVo getDiscountAmountVo(String orderId,Double amount,Integer customerId){
		DiscountAmountVo res = new DiscountAmountVo();
		if(Utils.isEmpty(amount) || Utils.isEmpty(orderId)){
			return res;
		}
		List<Double> amountList = new ArrayList<Double>();
		double [] amounts = {100,50,20,10,5,1};
		for (double i : amounts) {
			if(amount >= i){
				Double quotient = Math.floor(UtilMoney.divideToDouble(amount, i));
				
				int count = exCouponDao.queryCustomerHaveCount(customerId, i);//本次最多可领取的优惠券张数
				if(count > 0){
					if(count > quotient){
						count = quotient.intValue();
					}
					if(i == 100){
						res.setOneHundred(count);
					}else if(i == 50){
						res.setFifty(count);
					}else if(i == 20){
						res.setTwenty(count);
					}else if(i == 10){
						res.setTen(count);
					}else if(i == 5){
						res.setFive(count);
					}else if(i == 1){
						res.setOne(count);
					}
					amount = UtilMoney.subtractToDouble(amount,count*i);
					amountList.add(i);
				}
			}
		}
//		//计算100元优惠券可以领取多少张
//		if(amount >= 100){
//			Double oneHundred = Math.floor(UtilMoney.divideToDouble(amount, 100));
//			Integer youCountCoupon = couponApplyService.countCouponByAmount(100.00);//系统可领取该金额优惠券张数
//			Integer haveCountcoupon = exCouponDao.queryCustomerHaveCount(customerId, 100.00);//已经领取该金额优惠券张数
//			Integer count = UtilMoney.integerToZero(youCountCoupon) - UtilMoney.integerToZero(haveCountcoupon);//本次最多可领取的优惠券张数
//			if(count > 0){
//				if(count > oneHundred){
//					res.setOneHundred(oneHundred.intValue());
//					amount = UtilMoney.subtractToDouble(amount,oneHundred*100);
//				}else{
//					res.setOneHundred(count);
//					amount = UtilMoney.subtractToDouble(amount,count*100);
//				}
//				amountList.add(100.00);
//			}
//		}
//		//计算50元优惠券可以领取多少张
//		if(amount >= 50){
//			Double fifty = Math.floor(UtilMoney.divideToDouble(amount, 50));
//			Integer youCountCoupon = couponApplyService.countCouponByAmount(50.00);//系统可领取该金额优惠券张数
//			Integer haveCountcoupon = exCouponDao.queryCustomerHaveCount(customerId, 50.00);//已经领取该金额优惠券张数
//			Integer count = UtilMoney.integerToZero(youCountCoupon) - UtilMoney.integerToZero(haveCountcoupon);//本次最多可领取的优惠券张数
//			if(count > 0){
//				if(count > fifty){
//					res.setFifty(fifty.intValue());
//					amount = UtilMoney.subtractToDouble(amount,fifty*50);
//				}else{
//					res.setFifty(count);
//					amount = UtilMoney.subtractToDouble(amount,count*50);
//				}
//				amountList.add(50.00);
//			}
//		}
//		//计算20元优惠券可以领取多少张
//		if(amount >= 20){
//			Double twenty = Math.floor(UtilMoney.divideToDouble(amount, 20));
//			Integer youCountCoupon = couponApplyService.countCouponByAmount(20.00);//系统可领取该金额优惠券张数
//			Integer haveCountcoupon = exCouponDao.queryCustomerHaveCount(customerId, 20.00);//已经领取该金额优惠券张数
//			Integer count = UtilMoney.integerToZero(youCountCoupon) - UtilMoney.integerToZero(haveCountcoupon);//本次最多可领取的优惠券张数
//			if(count > 0){
//				if(count > twenty){
//					res.setTwenty(twenty.intValue());
//					amount = UtilMoney.subtractToDouble(amount,twenty*20);
//				}else{
//					res.setTwenty(count);
//					amount = UtilMoney.subtractToDouble(amount,count*20);
//				}
//				amountList.add(20.00);
//			}
//		}
//		//计算10元优惠券可以领取多少张
//		if(amount >= 10){
//			Double ten = Math.floor(UtilMoney.divideToDouble(amount, 10));
//			Integer youCountCoupon = couponApplyService.countCouponByAmount(10.00);//系统可领取该金额优惠券张数
//			Integer haveCountcoupon = exCouponDao.queryCustomerHaveCount(customerId, 10.00);//已经领取该金额优惠券张数
//			Integer count = UtilMoney.integerToZero(youCountCoupon) - UtilMoney.integerToZero(haveCountcoupon);//本次最多可领取的优惠券张数
//			if(count > 0){
//				if(count > ten){
//					res.setTen(ten.intValue());
//					amount = UtilMoney.subtractToDouble(amount,ten*10);
//				}else{
//					res.setTen(count);
//					amount = UtilMoney.subtractToDouble(amount,count*10);
//				}
//				amountList.add(10.00);
//			}
//		}
//		//计算5元优惠券可以领取多少张
//		if(amount >= 5){
//			Double five = Math.floor(UtilMoney.divideToDouble(amount, 5));
//			Integer youCountCoupon = couponApplyService.countCouponByAmount(5.00);//系统可领取该金额优惠券张数
//			Integer haveCountcoupon = exCouponDao.queryCustomerHaveCount(customerId, 5.00);//已经领取该金额优惠券张数
//			Integer count = UtilMoney.integerToZero(youCountCoupon) - UtilMoney.integerToZero(haveCountcoupon);//本次最多可领取的优惠券张数
//			if(count > 0){
//				if(count > five){
//					res.setFive(five.intValue());
//					amount = UtilMoney.subtractToDouble(amount,five*5);
//				}else{
//					res.setFive(count);
//					amount = UtilMoney.subtractToDouble(amount,count*5);
//				}
//				amountList.add(5.00);
//			}
//		}
//		//计算1元优惠券可以领取多少张
//		if(amount >= 1){
//			Double one = Math.floor(UtilMoney.divideToDouble(amount, 1));
//			Integer youCountCoupon = couponApplyService.countCouponByAmount(1.00);//系统可领取该金额优惠券张数
//			Integer haveCountcoupon = exCouponDao.queryCustomerHaveCount(customerId, 1.00);//已经领取该金额优惠券张数
//			Integer count = UtilMoney.integerToZero(youCountCoupon) - UtilMoney.integerToZero(haveCountcoupon);//本次最多可领取的优惠券张数
//			if(count > 0){
//				if(count > one){
//					res.setOne(one.intValue());
//					amount = UtilMoney.subtractToDouble(amount,one*1);
//				}else{
//					res.setOne(count);
//					amount = UtilMoney.subtractToDouble(amount,count*1);
//				}
//				amountList.add(1.00);
//			}
//		}
		res.setAmountList(amountList);
		return res;
	}

	/**
	 * 查询优惠券已经领取多少张
	 * @param applyId
	 * @param coustomerId
	 * @return
	 */
	public Integer queryCouponReceiveNumber(Integer applyId,Integer customerId){
		CouponExample example = new CouponExample();
		CouponExample.Criteria criteria = example.createCriteria();
		criteria.andStateNotEqualTo(1);
		criteria.andCustomerIdEqualTo(customerId);
		criteria.andCouponApplyIdEqualTo(applyId);
		return couponDao.countByExample(example);
	}

	/**
	 * 优惠买单：订单确认页，优惠券查询
	 * @param customerId
	 * @param orderMoney
	 * @return
	 */
	public List<OrderCouponVo> newOrderCouponApplyList(Integer customerId,Integer shopId,Double orderMoney){
		return exCouponDao.newOrderCouponApplyList(customerId, shopId,orderMoney);
	}

	@Override
	public double useCoupon(String couponCode, int customerId,double orderAmount, int useShopId) {
		Date now = new Date();//当前日期
		String [] couponCodes = couponCode.split("\\|");
		CouponExample example = new CouponExample();
    	CouponExample.Criteria criteria = example.createCriteria();
    	criteria.andCouponCodeIn(new ArrayList<String>(Arrays.asList(couponCodes)));
    	criteria.andShopIdEqualTo(useShopId);
    	criteria.andCustomerIdEqualTo(customerId);
    	criteria.andStateEqualTo(2);
    	criteria.andBeginTimeLessThanOrEqualTo(now);
    	criteria.andEndTimeGreaterThanOrEqualTo(now);
    	//查询优惠卷信息
    	List<Coupon> list = couponDao.selectByExample(example);
		if(Utils.isEmpty(list) || list.size() != couponCodes.length){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON);
		}
		
		int applyId = list.get(0).getCouponApplyId();
		for (int i = 1; i < couponCodes.length; i++) {
			if(applyId != list.get(i).getCouponApplyId()){
				throw new BusinessException(LogManager.getLogger(this.getClass()),"不同种类优惠劵不允许叠加使用...");
			}
		}
		CouponApply couponApply = couponApplyService.selectByPrimaryKey(applyId);
		if(couponApply == null){//优惠卷申请信息
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON);
		}
		if(!Utils.isEmpty(couponApply.getMaxUseNumber())){//叠加张数条件
			if(list.size() > couponApply.getMaxUseNumber()){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_MAX_USE_NUMBER);
			}
		}
		if(!Utils.isEmpty(couponApply.getCanUseDay())){//使用日期条件
			int week = now.getDay();
			if(week == 0){week = 7;}
			if(!couponApply.getCanUseDay().contains(week + "")){
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_ORDER_AMOUNT);
			}
		}
		if(!Utils.isEmpty(couponApply.getCanUseHour())){//使用时间段条件
			String [] useHour = couponApply.getCanUseHour().split("\\|");
			if(useHour != null  && useHour.length == 2){
				String pattern = "yyyy-MM-dd HH:mm";
				String nowStr = DateUtil.formatDate(now, "yyyy-MM-dd ");
				Date beginDate = DateUtil.formatDate(nowStr+useHour[0], pattern);
				Date endDate = DateUtil.formatDate(nowStr+useHour[1], pattern);
				if(DateUtil.compareDate(beginDate, now) || DateUtil.compareDate(now, endDate)){
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_ORDER_AMOUNT);
				}
			}
		}
		
		
//		List<Integer> applyIds = new ArrayList<Integer>();
//		for (Coupon coupon : list) {
//			applyIds.add(coupon.getCouponApplyId());
//		}
//		List<Integer> applyStates = new ArrayList<Integer>();
//		applyStates.add(Integer.valueOf(CouponApplyStateEnum.GROW.key()));
//		applyStates.add(Integer.valueOf(CouponApplyStateEnum.VALID.key()));
//		CouponApplyExample couponApplyExample = new CouponApplyExample();
//    	CouponApplyExample.Criteria couponApplyCriteria = couponApplyExample.createCriteria();
//    	couponApplyCriteria.andIdIn(applyIds);
//    	couponApplyCriteria.andStateIn(applyStates);//有效
//    	//查询优惠卷申请信息
//		List<CouponApply> couponapplyList = couponApplyService.selectByExample(couponApplyExample);
//		if(Utils.isEmpty(couponapplyList)){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON);
//		}
//		Map<Integer, CouponApply> couponapplyMap = new HashMap<Integer, CouponApply>();
//		for (CouponApply couponApply : couponapplyList) {
//			couponapplyMap.put(couponApply.getId(), couponApply);
//		}
//		Map<Integer, Integer> useCountMap = new HashMap<Integer,Integer>();
		//判断优惠劵是否满足使用条件
		
		double couponAmount = 0;
		for (Coupon coupon : list) {
//			CouponApply couponApply = couponapplyMap.get(coupon.getCouponApplyId());
//			if(couponApply == null){//优惠卷申请信息
//				throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON);
//			}
//			if(!Utils.isEmpty(couponApply.getMaxUseNumber())){//叠加张数条件
//				Integer useCount = useCountMap.get(couponApply.getId());
//				if(useCount == null){useCount=0;}
//				useCount += 1;
//				if(useCount > couponApply.getMaxUseNumber()){
//					throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_MAX_USE_NUMBER);
//				}
//				useCountMap.put(couponApply.getId(), useCount);
//			}
//			if(!Utils.isEmpty(couponApply.getCanUseDay())){//使用日期条件
//				int week = now.getDay();
//				if(week == 0){week = 7;}
//				if(!couponApply.getCanUseDay().contains(week + "")){
//					throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_ORDER_AMOUNT);
//				}
//			}
//			if(!Utils.isEmpty(couponApply.getCanUseHour())){//使用时间段条件
//				String [] useHour = couponApply.getCanUseHour().split("\\|");
//				if(useHour != null  && useHour.length == 2){
//					String pattern = "yyyy-MM-dd HH:mm";
//					String nowStr = DateUtil.formatDate(now, "yyyy-MM-dd ");
//					Date beginDate = DateUtil.formatDate(nowStr+useHour[0], pattern);
//					Date endDate = DateUtil.formatDate(nowStr+useHour[1], pattern);
//					if(DateUtil.compareDate(beginDate, now) || DateUtil.compareDate(now, endDate)){
//						throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_ORDER_AMOUNT);
//					}
//				}
//			}
			//品牌条件 TODO
			//分类条件 TODO
			
			if(UtilMoney.compareTo(coupon.getOrderMoney(), orderAmount) > 0){//金额条件
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_ORDER_AMOUNT);
			}
			orderAmount = UtilMoney.subtractToDouble(orderAmount, coupon.getCouponMoney());
			
			couponAmount = UtilMoney.addToDouble(couponAmount, coupon.getCouponMoney());
		}
		
		Coupon record = new Coupon();
		record.setUseTime(now);
		record.setState(Integer.valueOf(CouponStateEnum.USE.key()));
		//使用优惠劵
		if(couponDao.updateByExampleSelective(record, example) == couponCodes.length){
			return couponAmount;
		}
		throw new BusinessException(LogManager.getLogger(this.getClass()),ExOrderEnum.EX_ERROR_COUPON_USE);
	}
	
	/**
	 * 查询已经领取优惠券数量
	 * @param applyId
	 * @return
	 */
	public Integer gethaveUseCoupon(Integer applyId){
		if(Utils.isEmpty(applyId)){
			return 0;
		}
		CouponExample example = new CouponExample();
		CouponExample.Criteria criteria = example.createCriteria();
		criteria.andCouponApplyIdEqualTo(applyId);
		criteria.andStateEqualTo(3);//已使用
		return couponDao.countByExample(example);
	}

	@Override
	public Integer addCoupon(Coupon coupon, String orderId) {
		//查询领取优惠信息
		CouponApply couponapply = couponApplyService.selectByPrimaryKey(coupon.getCouponApplyId());
		if(couponapply == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NOTEXISTS_COUPONID);
		}
		Date curr = new Date();
		if(DateUtil.compareDate(curr, couponapply.getEndTime())){
			//优惠券已经过期
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_OVER);
		}
		//金额不对不能领取
		if(!Utils.amountMap.containsKey(couponapply.getCouponMoney())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
		if(!Utils.isEmpty(couponapply.getMaxGetNumber())){
			//判断上否领取
			CouponExample couponExample = new CouponExample();
			CouponExample.Criteria couponCriteria = couponExample.createCriteria();
			couponCriteria.andCustomerIdEqualTo(coupon.getCustomerId());
			couponCriteria.andCouponApplyIdEqualTo(couponapply.getId());
			List<Integer> stateList = new ArrayList<Integer>();
			stateList.add(2);//已经领用
			stateList.add(3);//已经使用
			couponCriteria.andStateIn(stateList);
			if(countByExample(couponExample) >= couponapply.getMaxGetNumber()){
				return 3;
			}
		}
		
		//是否预生成1、否2、是
		if(couponapply.getIsCreate() == 1){
			if(exCouponDao.couponReceiveNumberAdd(couponapply.getId()) == 0){
				//已领完
				return 2;
			}
			//需要生成coupon数据

			//组装固定数据
			coupon.setState(Integer.valueOf(CouponStateEnum.USED_POINT.key()));
			coupon.setCouponCode(Utils.inviteCode(8));
			coupon.setCouponMoney(couponapply.getCouponMoney());
			coupon.setCouponType(couponapply.getCouponType());//
			coupon.setAddTime(curr);
			coupon.setBeginTime(couponapply.getBeginTime());
			coupon.setEndTime(couponapply.getEndTime());
			coupon.setOrderMoney(couponapply.getOrderMoney());
			if(couponapply.getExpiresModel() == 2){
				coupon.setBeginTime(couponapply.getBeginTime());
				coupon.setEndTime(DateUtil.addDay(couponapply.getBeginTime(), couponapply.getExpiresDays()));
			}
			add(coupon);
		}else{
			//修改coupon数据
			CouponExample example = new CouponExample();
			CouponExample.Criteria criteria = example.createCriteria();
			criteria.andCouponApplyIdEqualTo(coupon.getCouponApplyId());
			criteria.andStateEqualTo(Integer.valueOf(CouponStateEnum.UNUSED_POINT.key()));
			criteria.andEndTimeGreaterThan(curr);
			List<Coupon> list = couponDao.selectByExample(example);
			if(list == null || list.size() == 0){
				//已被领完
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
			Coupon cou = list.get(0);
			if(converCoupon(coupon.getCustomerId(), coupon.getShopId(), cou.getCouponCode()) == false){
				//领取人数过多，请从新领取
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
			}
		}
		/** 修改优惠买单 已领取优惠劵金额 */
		if(exOrderDao.updateQuickOrderReceiveCouponAmount(orderId, couponapply.getCouponMoney()) > 0){
			return 1;
		}else{
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCouponEnum.EX_NECK_NOTHAVE);
		}
	}
	
	@Override
	public String addCouponList(Integer customerId,Integer shopId, Integer couponapplyId,
			Integer num, Integer messageType) {
		String message = null;
		try {
			//查询优惠劵申请记录
			CouponApply couponapply = couponApplyService.selectByPrimaryKey(couponapplyId);
			if(couponapply == null){
				message = "优惠劵申请信息不存在";
			}else if (!CouponApplyStateEnum.GROW.key().equals(couponapply.getState()+"")) {
				message = "优惠劵申请信息未通过";
			}else if (couponapply.getCouponMoney() <= 0) {
				message = "优惠劵申请信息不正确";
			}else if (couponapply.getShopId().intValue() != shopId.intValue()) {
				message = "优惠劵店铺信息不正确";
			}else {
				Date date = new Date();
				List<Coupon> list = new ArrayList<Coupon>();
				for (int i = 0; i < num; i++) {
					Coupon coupon=new Coupon();
					
					coupon.setShopId(shopId);
					coupon.setCouponType(2);  //电子优惠券
					coupon.setCouponApplyId(couponapply.getId());
					coupon.setCouponCode(Utils.inviteCode(8));//生成优惠码
					coupon.setCouponMoney(couponapply.getCouponMoney());  //优惠券金额
					coupon.setOrderMoney(couponapply.getOrderMoney());//使用要求
					coupon.setCustomerId(customerId);
					coupon.setAddTime(date);
					coupon.setUseTime(date);
					coupon.setBeginTime(date);//开始时间
					coupon.setEndTime(DateUtil.add(date,Calendar.DATE, 90));//结束时间
					coupon.setState(2); //已领用
					coupon.setCreateTime(date);
					list.add(coupon);
					//批量添加优惠劵信息
				}
				couponDao.insertBatch(list);
				//发送消息
				if(messageType != null){
					//TODO
				}
			}
			
		} catch (Exception e) {
			message = Utils.exceptionConvertStr(e);
		}
		if(!Utils.isEmpty(message)){
			try {
				SystemErrorLog errorLog = new SystemErrorLog();
				errorLog.setPri(10);
				errorLog.setActionType(1);
				errorLog.setDescription("批量添加优惠劵");
				errorLog.setErrorInformation(message);
				errorLog.setRunCommand(MessageFormat.format("参数：customerId={0}，couponapplyId={1}，num={2}，messageType={3}，shopId={4}", customerId,couponapplyId,num,messageType,shopId));
				errorLog.setInformed(0);
				errorLog.setPlatform(1);
				errorLog.setIp("0.0.0.0");
				systemErrorLogService.add(errorLog);
			} catch (Exception e1) {
				LogManager.error(this.getClass(),"批量添加优惠劵异常",e1);
			}
		}
		return message;
	}
}