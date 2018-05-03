package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Coupon;
import cn.xinmeng.api.entity.auto.biz.CouponBiz;
import cn.xinmeng.api.entity.auto.example.CouponExample;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCustCouponVo;
import cn.xinmeng.web.shop.entity.vo.DiscountAmountVo;
import cn.xinmeng.web.shop.entity.vo.OrderCouponVo;

/**
 * 接口：ICouponService
 * @author jiangyong.tan
 * 描述：优惠券表
 * @date 2016-01-24 14:38:56
 */
public interface ICouponService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Coupon record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Coupon record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Coupon selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CouponExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Coupon> selectByExample(CouponExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Coupon> selectByExample(int currentPage, int limit,CouponExample example);
    
    /**
     * 查询店铺可用优惠券
     * @author jiangyong.tan
     * @date 2016年2月23日 下午1:55:14
     * @param shopId
     * @param customerId
     * @param shopCarts
     * @return
     */
    public List<ShopCustCouponVo> searchCouponByShopId(Integer useShopId,Integer shopId,Integer customerId,List<ShopCartVo> shopCarts);
    
    /**
     *  查询我的所有可用优惠券
     * @author jiangyong.tan
     * @date 2016年2月23日 下午2:24:34
     * @param shopId
     * @return
     */
    public List<Coupon> searchCouponByshopId(Integer shopId,Integer customerId);
    
    /**
     * 查询我的优惠券列表
     * @author jiangyong.tan
     * @date 2016年2月24日 上午9:06:18
     * @param couponCondition
     * @return
     */
    public List<CouponBiz> searchMyCouponList(Integer currentPage,Integer limit,Integer shopId,Integer customerId,Integer state);
    
    /**
     * 查询我的优惠券列表
     * @author jiangyong.tan
     * @date 2016年2月24日 上午9:15:57
     * @param couponCondition
     * @return
     */
    public Integer searchMyCouponCount(Integer shopId,Integer customerId,Integer state);
    
    /**
     * 查询优惠券信息
     * @param couponCode
     * @return
     */
    public Coupon queryCouponByCouponCode(String couponCode);
    
    /**
     *  使用优惠券
     * @author jiangyong.tan
     * @date 2016年2月25日 上午9:55:26
     * @param coupon
     * @return
     */
    public Integer useCoupon(Coupon coupon);
    
    /**
     * 兑换优惠券
     * @param couponCode
     * @return
     */
    public boolean converCoupon(Integer customerId,Integer shopId,String couponCode);
    

    /**
     * app领取优惠券
     * @param coupon
     * @return
     */
    public boolean addCoupon(Coupon coupon);
    

    /**
     * 配额后：优惠券领取
     * @param coupon
     * @return
     */
    public Integer newAddCoupon(Coupon coupon,String orderId);
    

    /**
     * 商城：优惠券领取
     * @param coupon
     * @return
     */
    public Integer shopAddCoupon(Coupon coupon);

	/**
	 * 是否能够领取优惠券
	 * @param shopId
	 * @param customerId
	 * @param applyId
	 * @return
	 */
	public boolean receiveCoupon(Integer loginShopId,Integer customerId,Integer applyId);
	
	/**
	 * 优惠买单，优惠券发放面额
	 * @return
	 */
	public DiscountAmountVo getDiscountAmountVo(String orderId,Double amount,Integer customerId);
	
	/**
	 * 查询优惠券已经领取多少张
	 * @param applyId
	 * @param customerId
	 * @return
	 */
	public Integer queryCouponReceiveNumber(Integer applyId,Integer customerId);
	
	/**
	 * 优惠买单：订单确认页，优惠券查询
	 * @param customerId
	 * @param orderMoney
	 * @return
	 */
	public List<OrderCouponVo> newOrderCouponApplyList(Integer customerId,Integer shopId,Double orderMoney);
	
	/**
	 * 优惠劵使用
	 * @param couponCode 优惠劵code，多个以|间隔
	 * @param customerId 客户编号
	 * @param orderAmount 订单金额
	 * @param useShopId 使用店铺id
	 * @return 
	 */
	public double useCoupon(String couponCode,int customerId,double orderAmount,int useShopId);
	
	/**
	 * 查询已经领取优惠券数量
	 * @param applyId
	 * @return
	 */
	public Integer gethaveUseCoupon(Integer applyId);
	
	/**
	 * 领取优惠劵
	 * @param coupon
	 * @param orderId
	 * @return
	 */
	public Integer addCoupon(Coupon coupon,String orderId);
	
	/**
	 * 发放优惠劵
	 * @param customerId
	 * @param shopId
	 * @param couponapplyId
	 * @param num
	 * @param messageType
	 * @return
	 */
	public String addCouponList(Integer customerId,Integer shopId,Integer couponapplyId,Integer num,Integer messageType);
}