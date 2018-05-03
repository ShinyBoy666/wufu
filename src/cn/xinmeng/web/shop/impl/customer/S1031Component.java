package cn.xinmeng.web.shop.impl.customer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.biz.CouponBiz;
import cn.xinmeng.api.enums.ShopImageTypeEnum;
import cn.xinmeng.api.service.ICategoryService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.IShopImageService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1031RequestEntity;
import cn.xinmeng.web.shop.enums.ShowCouponEnum;

/**
 * 我的优惠券列表
 * @param 
 * @ClassName: S1031Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1031Component")
public class S1031Component extends BaseService {
	
	@Resource
	private ICouponService couponService;
	@Resource
	private ICategoryService categoryService;
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private IShopImageService shopImageService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1031RequestEntity entity = parseRequertParam(data, S1031RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}

		//返回分页
		PageInfoEntity<CouponBiz> resPage = new PageInfoEntity<CouponBiz>(entity.getCurrentPage(),entity.getLimit());
		//返回数据
		List<CouponBiz> resList = new ArrayList<CouponBiz>();
		
		/**
		 * 查询我的优惠券列表
		 */
		Integer customerId = entity.getCustomerId();
		Integer state = entity.getCouponState();
		
		
		//查询数据
		Integer totalCount = couponService.searchMyCouponCount(request.getLoginShopId(), customerId, state);
		if(totalCount > 0){
			List<CouponBiz> list = couponService.searchMyCouponList(entity.getCurrentPage(),entity.getLimit(),request.getLoginShopId(), customerId, state);
			
			List<Integer> cIds = new ArrayList<Integer>();//分类id
			List<Integer> bIds = new ArrayList<Integer>();//品牌id
			
			//获取分类id集合，品牌id集合
			for (CouponBiz biz : list) {
				//获取分类id
				if(biz.getCategoryId() != 0){
					cIds.add(biz.getCategoryId());
				}
				if(biz.getBrandId() != 0){
					bIds.add(biz.getBrandId());
				}
			}

			Map<Integer, String> categoryMap = categoryService.searchCategoryNameByIds(cIds);
			Map<Integer,ShopInfo> shopMap = new HashMap<Integer, ShopInfo>();
			Map<Integer,String> bossImageMap = new HashMap<Integer, String>();
			Date now = new Date();
			for (CouponBiz res : list) {
				//获取分类id
				String description = "";
				if("wap".equals(request.getSource())){
					description = "消费立减"+res.getCouponMoney()+"元";
					if(!Utils.isEmpty(res.getOrderMoney())){
						description += "（满"+res.getOrderMoney()+"可用）";
					}
					String canUseDay = res.getCanUseDay();
					String canUseHour = res.getCanUseHour();
					if(!Utils.isEmpty(canUseDay) && Utils.isEmpty(canUseHour)){
						description += "（ 可用周期："+Utils.getCanUseDay(canUseDay)+"） ";
					}else if(Utils.isEmpty(canUseDay) && !Utils.isEmpty(canUseHour)){
						description += "（ 可用时间："+Utils.getCanUseHour(canUseHour)+"）  ";
					}else if(!Utils.isEmpty(canUseDay) && !Utils.isEmpty(canUseHour)){
						description += "（ 可用周期："+Utils.getCanUseDay(canUseDay)+"，可用时间："+Utils.getCanUseHour(canUseHour)+"） ";
					}
				}else{
					if(res.getOrderMoney() > 0){
						description = MessageFormat.format("满{0}可用,", res.getOrderMoney());
					}
					if(categoryMap.containsKey(res.getCategoryId())){
						description += categoryMap.get(res.getCategoryId())+"专用";
					}else{
						description += "全场通用"; 
					}
				}
				res.setDescription(description);
				
				if(Utils.isEmpty(state)){
					if(res.getState() == 3){
						res.setState(2);
					}else {
						if(res.getState() == 2 && DateUtil.compareDate(res.getEndTime(), now)){
							res.setState(1);
						}else{
							res.setState(3);
						}
					}
				}else{
					res.setState(state);
				}
				
				res.setStateValue(ShowCouponEnum.keyToValue(res.getState()+""));
				Integer useShopId = res.getUseShopId();
				res.setUseShopId(useShopId);
				if(!shopMap.containsKey(useShopId)){
					shopMap.put(useShopId,  shopInfoService.queryShopInfoById(useShopId,"shop_name,shop_logo"));
				}
				ShopInfo shopInfo = shopMap.get(useShopId);
				if(shopInfo != null){
					res.setUseShopName(shopInfo.getShopName());
					res.setUseShopLogo(shopInfo.getShopLogo());
				}else{
					res.setUseShopName("");
					res.setUseShopLogo("");
				}
				if(!bossImageMap.containsKey(useShopId)){
					bossImageMap.put(useShopId, Utils.getImageUrl(shopImageService.queryShopInfoImage(useShopId, ShopImageTypeEnum.BOSS),"?400*400"));
				}
				String bossImage = bossImageMap.get(useShopId);
				if(bossImage != null){
					res.setShopBossImage(bossImage);
				}else{
					res.setShopBossImage("");
				}
				
				resList.add(res);
			}
			resPage.setList(resList);
		}
		resPage.setTotalRecord(totalCount);
		return getAppResponseEntity(resPage);
	}
//	public AppResponseEntity callServer(AppRequestEntity request,String data){
//		S1031RequestEntity entity = parseRequertParam(data, S1031RequestEntity.class);
//		
//		if(entity == null){
//			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
//		}else if(Utils.isEmpty(entity.getShopId())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
//		}
//
//		//返回分页
//		PageInfoEntity<S1031ResponseEntity> resPage = new PageInfoEntity<S1031ResponseEntity>(entity.getCurrentPage(),entity.getLimit());
//		//返回数据
//		List<S1031ResponseEntity> resList = new ArrayList<S1031ResponseEntity>();
//		
//		/**
//		 * 查询我的优惠券列表
//		 */
//		Integer customerId = entity.getCustomerId();
//		Integer state = entity.getCouponState();
//		
//		
//		//查询数据
//		Integer totalCount = couponService.searchMyCouponCount(request.getLoginShopId(), customerId, state);
//		if(totalCount > 0){
//			List<CouponBiz> list = couponService.searchMyCouponList(entity.getCurrentPage(),entity.getLimit(),request.getLoginShopId(), customerId, state);
//			
//			List<Integer> cIds = new ArrayList<Integer>();//分类id
//			List<Integer> bIds = new ArrayList<Integer>();//品牌id
//			
//			//获取分类id集合，品牌id集合
//			for (CouponBiz biz : list) {
//				//获取分类id
//				if(biz.getCategoryId() != 0){
//					cIds.add(biz.getCategoryId());
//				}
//				if(biz.getBrandId() != 0){
//					bIds.add(biz.getBrandId());
//				}
//			}
//
//			Map<Integer, String> categoryMap = categoryService.searchCategoryNameByIds(cIds);
//			Map<Integer,ShopInfo> shopMap = new HashMap<Integer, ShopInfo>();
//			Date now = new Date();
//			for (CouponBiz biz : list) {
//				S1031ResponseEntity res = new S1031ResponseEntity();
//				CloneUtils.copyEntity(biz, res);
//				//获取分类id
//				String description = "";
//				if(biz.getOrderMoney() > 0){
//					description = MessageFormat.format("满{0}可用,", biz.getOrderMoney());
//				}
//				if(categoryMap.containsKey(biz.getCategoryId())){
//					res.setDescription(description+categoryMap.get(biz.getCategoryId())+"专用");
//				}else{
//					res.setDescription(description+"全场通用");
//				}
//				if(Utils.isEmpty(state)){
//					if(biz.getState() == 3){
//						res.setState(2);
//					}else {
//						if(biz.getState() == 2 && DateUtil.compareDate(biz.getEndTime(), now)){
//							res.setState(1);
//						}else{
//							res.setState(3);
//						}
//					}
//				}else{
//					res.setState(state);
//				}
//				
//				res.setStateValue(ShowCouponEnum.keyToValue(res.getState()+""));
//				Integer useShopId = biz.getUseShopId();
//				res.setUseShopId(useShopId);
//				if(shopMap.containsKey(useShopId)){
//					ShopInfo shopInfo = shopMap.get(useShopId);
//					if(shopInfo != null){
//						res.setUseShopName(shopInfo.getShopName());
//						res.setUseShopLogo(shopInfo.getShopLogo());
//						shopMap.put(useShopId, shopInfo);
//					}
//				}else{
//					ShopInfo shopInfo = shopInfoService.queryShopInfoById(useShopId,"shop_name,shop_logo");
//					if(shopInfo != null){
//						res.setUseShopName(shopInfo.getShopName());
//						res.setUseShopLogo(shopInfo.getShopLogo());
//						shopMap.put(useShopId, shopInfo);
//					}
//					
//				}
//				resList.add(res);
//			}
//			resPage.setList(resList);
//		}
//		resPage.setTotalRecord(totalCount);
//		return getAppResponseEntity(resPage);
//	}
	
	
}
