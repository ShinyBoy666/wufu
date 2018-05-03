package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CouponApplyDao;
import cn.xinmeng.api.dao.ex.ExCouponDao;
import cn.xinmeng.api.entity.auto.CouponApply;
import cn.xinmeng.api.entity.auto.biz.CouponApplyBiz;
import cn.xinmeng.api.entity.auto.example.CouponApplyExample;
import cn.xinmeng.api.enums.CouponApplyStateEnum;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCouponVo;
import cn.xinmeng.web.shop.entity.market.S1096ResponseEntity;
import cn.xinmeng.web.shop.entity.market.S1097RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1098RequestEntity;
import cn.xinmeng.web.shop.entity.vo.CouponVo;

/**
 * 业务层：CouponApplyServiceImpl
 * 描述：优惠券申请表
 * @author jiangyong.tan
 * @date 2016-03-25 14:55:55
 */
@Service("couponApplyService")
public class CouponApplyServiceImpl implements ICouponApplyService {

    @Resource
	private CouponApplyDao couponApplyDao;
    @Resource
    private ExCouponDao exCouponDao;
    @Resource
    private IRedisService redisService;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CouponApply record){
    	return couponApplyDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return couponApplyDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CouponApply record){
		return couponApplyDao.updateByPrimaryKey(record);
	}

	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
	public int updateSelectiveByPrimaryKey(CouponApply record){
		return couponApplyDao.updateSelectiveByPrimaryKey(record);
	}
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CouponApply selectByPrimaryKey(Integer id){
    	return couponApplyDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CouponApplyExample example){
		return couponApplyDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CouponApply> selectByExample(CouponApplyExample example){
    	return couponApplyDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CouponApply> selectByExample(int currentPage, int limit,CouponApplyExample example){
        return couponApplyDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    /**
     * 查询店铺可领取优惠券 
     * @author jiangyong.tan
     * @date 2016年2月23日 上午11:54:51
     * @param shopId
     * @return
     */
    public List<CouponApply> searchCouponApplyByShopId(Integer shopId){
    	Date currDate = DateUtil.now();
    	CouponApplyExample example = new CouponApplyExample();
    	CouponApplyExample.Criteria criteria = example.createCriteria();
    	criteria.andShopIdEqualTo(shopId);
//    	criteria.andCouponTypeEqualTo(Integer.valueOf(CouponApplyTypeEnum.ELECTRONIC.key()));//电子券
//    	List<Integer> states = new ArrayList<Integer>();
//		states.add(Integer.valueOf(CouponApplyStateEnum.VALID.key()));
//		states.add(Integer.valueOf(CouponApplyStateEnum.GROW.key()));
//		criteria.andStateIn(states);//有效
    	criteria.andStateEqualTo(Integer.valueOf(CouponApplyStateEnum.GROW.key()));
    	criteria.andEndTimeGreaterThan(currDate);//在有效期内
    	return couponApplyDao.selectByExample(example);
    }

    /**
     *  查询店铺可领取优惠券
     * @author jiangyong.tan
     * @date 2016年2月23日 下午3:24:03
     * @param shopId
     * @return
     */
    public List<ShopCouponVo> searchShopCouponByShopId(Integer shopId){
    	List<CouponApply> list = searchCouponApplyByShopId(shopId);
    	List<ShopCouponVo> resList = new ArrayList<ShopCouponVo>();
    	if(list != null && list.size() > 0){
        	for (CouponApply CouponApply : list) {
        		ShopCouponVo shopCoupon =  new ShopCouponVo();
        		shopCoupon.setBeginTime(CouponApply.getBeginTime());
        		shopCoupon.setCouponMoney(CouponApply.getCouponMoney());
        		shopCoupon.setCouponName(CouponApply.getCouponName());
        		shopCoupon.setEndTime(CouponApply.getEndTime());
        		shopCoupon.setDescription(CouponApply.getRemark());
        		shopCoupon.setId(CouponApply.getId());
        		shopCoupon.setShopId(CouponApply.getShopId());
        		resList.add(shopCoupon);
    		}
    	}
    	return resList;
    }
    

	/**
	 * 店铺优惠券
	 * @param rowBounds
	 * @param shopId
	 * @return
	 */
	public List<CouponApplyBiz> searchCouponApplyList(int currentPage, int limit,Integer shopId){
		return exCouponDao.searchCouponApplyList(new RowBounds(currentPage, limit), shopId);
	}
	

	/**
	 * 店铺优惠券
	 * @param shopId
	 * @return
	 */
	public Integer searchCouponApplyCount(Integer shopId){
		return exCouponDao.searchCouponApplyCount(shopId);
	}

	@Override
	public int updateByExampleSelective(CouponApply record,
			CouponApplyExample example) {
		return couponApplyDao.updateByExampleSelective(record, example);
	}

	@Override
	public Integer queryActivityCouponsCount(List<Integer> shopIds) {
		return exCouponDao.queryActivityCouponsCount(shopIds);
	}
	
	@Override
	public List<S1096ResponseEntity> queryActivityCoupons(int currentPage, int limit,List<Integer> shopIds) {
		return exCouponDao.queryActivityCoupons(new RowBounds(currentPage, limit), shopIds);
	}

	@Override
	public List<CouponVo> searchCouponApplyList(Double amount,
			S1097RequestEntity entity) {
		List<CouponVo> result = new ArrayList<CouponVo>();
		double [] amounts = {100,50,20,10,5,1};
		for (double i : amounts) {
			if(amount >= i){
				Double quotient = Math.floor(UtilMoney.divideToDouble(amount, i));
				//查询优惠劵
				List<CouponVo> list = exCouponDao.queryCouponApplyList(entity, quotient.intValue(), i);
				if(!Utils.isEmpty(list)){
					result.addAll(list);
					amount = UtilMoney.subtractToDouble(amount,list.size()*i);
				}
			}
		}
		return result;
	}

	@Override
	public PageInfoEntity<CouponVo> searchCouponApplyList(S1098RequestEntity entity) {
		PageInfoEntity<CouponVo> res = new PageInfoEntity<CouponVo>();
		List<CouponVo> resList = new ArrayList<CouponVo>();
		int totalCount = exCouponDao.searchCouponApplyCountNew(entity);
		if(totalCount > 0){
			resList.addAll(exCouponDao.searchCouponApplyListNew(new RowBounds(entity.getCurrentPage(), entity.getLimit()), entity));
		}
		res.setCurrentPage(entity.getCurrentPage());
		res.setLimit(entity.getLimit());
		res.setList(resList);
		res.setTotalRecord(totalCount);
		return res;
	}

}