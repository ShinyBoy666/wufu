package cn.xinmeng.api.dao.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.xinmeng.api.entity.auto.biz.CouponApplyBiz;
import cn.xinmeng.api.entity.auto.biz.CouponBiz;
import cn.xinmeng.web.shop.entity.market.S1096ResponseEntity;
import cn.xinmeng.web.shop.entity.market.S1097RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1098RequestEntity;
import cn.xinmeng.web.shop.entity.vo.CouponVo;
import cn.xinmeng.web.shop.entity.vo.OrderCouponVo;

public interface ExCouponDao {
	
	/**
	 * 查询我的所有优惠券
	 * @author jiangyong.tanO
	 * @date 2016年2月23日 上午10:22:22
	 * @param shopIds
	 * @return
	 */
	public List<CouponBiz> searchMyCouponByShopId(@Param("shopId")Integer shopId,@Param("customerId")Integer customerId);
	
	
	/**
	 * 我的优惠券列表
	 * @author jiangyong.tan
	 * @date 2016年2月23日 下午6:43:02
	 * @param couponCondition
	 * @return
	 */
	public List<CouponBiz> searchMyCouponList(RowBounds rowBounds,@Param("shopId")Integer shopId,@Param("customerId")Integer customerId,@Param("state")Integer state);
	
	/**
	 *  我的优惠券总数
	 * @author jiangyong.tan
	 * @date 2016年2月23日 下午6:42:46
	 * @param couponCondition
	 * @return
	 */
	public Integer searchMyCouponCount(@Param("shopId")Integer shopId,@Param("customerId")Integer customerId,@Param("state")Integer state);
	
	/**
	 * 领取优惠券数量＋1
	 * @param id
	 * @return
	 */
	public Integer couponReceiveNumberAdd(@Param("id")Integer id);
	
	/**
	 * 店铺优惠券
	 * @param rowBounds
	 * @param shopId
	 * @return
	 */
	public List<CouponApplyBiz> searchCouponApplyList(RowBounds rowBounds,@Param("shopId")Integer shopId);
	

	/**
	 * 店铺优惠券
	 * @param shopId
	 * @return
	 */
	public Integer searchCouponApplyCount(@Param("shopId")Integer shopId);
	
	/**
	 * 查询优惠券领取的张数
	 * @param customerId
	 * @param couponMoney
	 * @return
	 */
	public Integer queryCustomerHaveCount(@Param("customerId")Integer customerId,@Param("couponMoney")Double couponMoney);

	/**
	 * 优惠买单：订单确认页，优惠券查询
	 * @param customerId
	 * @param orderMoney
	 * @return
	 */
	public List<OrderCouponVo> newOrderCouponApplyList(@Param("customerId")Integer customerId,@Param("shopId")Integer shopId,@Param("orderMoney")Double orderMoney);
	
	/**
	 * 优惠买单 活动详情
	 * @return
	 */
	public Integer queryActivityCouponsCount(@Param("shopIds")List<Integer> shopIds);
	public List<S1096ResponseEntity> queryActivityCoupons(RowBounds rowBounds,@Param("shopIds")List<Integer> shopIds);
	
	/**
	 * 下单成功查询优惠劵
	 * @param customerId
	 * @param limit
	 * @param couponMoney
	 * @return
	 */
	public List<CouponVo> queryCouponApplyList(@Param("entity")S1097RequestEntity entity,@Param("limit")Integer limit,@Param("couponMoney")Double couponMoney);
	
	/**
	 * 优惠买单，优惠劵列表
	 * @param entity
	 * @return
	 */
	public Integer searchCouponApplyCountNew(@Param("entity")S1098RequestEntity entity);
	
	/**
	 * 优惠买单，优惠劵列表
	 * @param entity
	 * @return
	 */
	public List<CouponVo> searchCouponApplyListNew(RowBounds rowBounds,@Param("entity")S1098RequestEntity entity);
}
