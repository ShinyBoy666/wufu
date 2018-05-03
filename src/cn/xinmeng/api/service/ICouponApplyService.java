package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.CouponApply;
import cn.xinmeng.api.entity.auto.biz.CouponApplyBiz;
import cn.xinmeng.api.entity.auto.example.CouponApplyExample;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCouponVo;
import cn.xinmeng.web.shop.entity.market.S1096ResponseEntity;
import cn.xinmeng.web.shop.entity.market.S1097RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1098RequestEntity;
import cn.xinmeng.web.shop.entity.vo.CouponVo;

/**
 * 接口：ICouponApplyService
 * @author jiangyong.tan
 * 描述：优惠券申请表
 * @date 2016-01-24 14:38:56
 */
public interface ICouponApplyService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CouponApply record);
    
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
	public int updateByPrimaryKey(CouponApply record);
	
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
	public int updateSelectiveByPrimaryKey(CouponApply record);
	
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CouponApply selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CouponApplyExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CouponApply> selectByExample(CouponApplyExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CouponApply> selectByExample(int currentPage, int limit,CouponApplyExample example);
    
    /**
     * 查询店铺可领取优惠券 
     * @author jiangyong.tan
     * @date 2016年2月23日 上午11:54:51
     * @param shopId
     * @return
     */
    public List<CouponApply> searchCouponApplyByShopId(Integer shopId);
    
    /**
     *  查询店铺可领取优惠券
     * @author jiangyong.tan
     * @date 2016年2月23日 下午3:24:03
     * @param shopId
     * @return
     */
    public List<ShopCouponVo> searchShopCouponByShopId(Integer shopId);
    

	/**
	 * 店铺优惠券
	 * @param rowBounds
	 * @param shopId
	 * @return
	 */
	public List<CouponApplyBiz> searchCouponApplyList(int currentPage, int limit,Integer shopId);
	

	/**
	 * 店铺优惠券
	 * @param shopId
	 * @return
	 */
	public Integer searchCouponApplyCount(Integer shopId);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(CouponApply record,CouponApplyExample example);
    
    /**
	 * 优惠买单 活动详情
	 * @return
	 */
    public Integer queryActivityCouponsCount(List<Integer> shopIds);
	public List<S1096ResponseEntity> queryActivityCoupons(int currentPage, int limit,List<Integer> shopIds);
	
	/**
	 * 付款后查询优惠券
	 * @param amount
	 * @param customerId
	 * @return
	 */
	public List<CouponVo> searchCouponApplyList(Double amount,S1097RequestEntity entity);
	
	/**
	 * 优惠劵列表
	 * @param entity
	 * @return
	 */
	public PageInfoEntity<CouponVo> searchCouponApplyList(S1098RequestEntity entity);
}