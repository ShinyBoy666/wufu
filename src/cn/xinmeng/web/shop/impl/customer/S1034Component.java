package cn.xinmeng.web.shop.impl.customer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.biz.CouponApplyBiz;
import cn.xinmeng.api.service.ICategoryService;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1034RequestEntity;
import cn.xinmeng.web.shop.entity.customer.S1034ResponseEntity;

/**
 * 查询店铺可领取优惠券列表
 * @param 
 * @ClassName: S1033Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1034Component")
public class S1034Component extends BaseService {
	
	@Resource
	private ICouponApplyService couponApplyService;
	@Resource
	private ICouponService couponService;
	@Resource
	private ICategoryService categoryService;
	@Resource
	private IShopInfoService shopInfoService;
	
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1034RequestEntity entity = parseRequertParam(data, S1034RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getShopId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}
		//返回分页实体
		PageInfoEntity<S1034ResponseEntity> resPage = new PageInfoEntity<S1034ResponseEntity>(entity.getCurrentPage(),entity.getLimit());

		//返回数据实体
		List<S1034ResponseEntity> resList = new ArrayList<S1034ResponseEntity>();
		
		Integer totalCount = couponApplyService.searchCouponApplyCount(entity.getShopId());
		if(totalCount > 0){
			List<CouponApplyBiz> list = couponApplyService.searchCouponApplyList(entity.getCurrentPage(), entity.getLimit(), entity.getShopId());
			
			List<Integer> cIds = new ArrayList<Integer>();//分类id
			
			//获取分类id集合，品牌id集合
			for (CouponApplyBiz biz : list) {
				//获取分类id
				if(biz.getCategoryId() != 0){
					cIds.add(biz.getCategoryId());
				}
			}

			Map<Integer, String> categoryMap = categoryService.searchCategoryNameByIds(cIds);

			Map<Integer,ShopInfo> shopMap = new HashMap<Integer, ShopInfo>();
			for (CouponApplyBiz biz : list) {
				S1034ResponseEntity res = new S1034ResponseEntity();
				CloneUtils.copyEntity(biz, res);
				//获取分类id
				String description = "";
				if(biz.getOrderMoney() > 0){
					description = MessageFormat.format("满{0}可用,", biz.getOrderMoney());
				}
				if(categoryMap.containsKey(biz.getCategoryId())){
					res.setDescription(description+categoryMap.get(biz.getCategoryId())+"专用");
				}else{
					res.setDescription(description+"全场通用");
				}
				//判断该优惠券是否已经领过
				if(!Utils.isEmpty(entity.getCustomerId())){
					res.setReceive(couponService.receiveCoupon(request.getLoginShopId(), entity.getCustomerId(), biz.getId()));
				}else{
					res.setReceive(true);
				}
				Integer useShopId = biz.getUseShopId();
				res.setUseShopId(useShopId);
				if(shopMap.containsKey(useShopId)){
					ShopInfo shopInfo = shopMap.get(useShopId);
					if(shopInfo != null){
						res.setUseShopName(shopInfo.getShopLogo());
						res.setUseShopLogo(shopInfo.getShopLogo());
						shopMap.put(useShopId, shopInfo);
					}
				}else{
					ShopInfo shopInfo = shopInfoService.queryShopInfoById(useShopId,"shop_name,shop_logo");
					if(shopInfo != null){
						res.setUseShopName(shopInfo.getShopLogo());
						res.setUseShopLogo(shopInfo.getShopLogo());
						shopMap.put(useShopId, shopInfo);
					}
				}
				resList.add(res);
			}
		}
		resPage.setList(resList);
		resPage.setTotalRecord(totalCount);
		return getAppResponseEntity(resPage);
	}
	
	
}
