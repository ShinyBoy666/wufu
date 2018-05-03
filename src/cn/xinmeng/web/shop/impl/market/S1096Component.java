package cn.xinmeng.web.shop.impl.market;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.ShopActivityConfig;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.ShopActivityConfigExample;
import cn.xinmeng.api.enums.QuickOrderTypeEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopActivityConfigService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1096ResponseEntity;

/**
 * 优惠买单 活动详情
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1096Component")
public class S1096Component extends BaseService {
	
	@Resource
	private IShopActivityConfigService shopActivityConfigService;
	
	@Resource
	private ICouponApplyService couponApplyService;
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Resource
	private IRedisService redisService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		Map<String, List<S1096ResponseEntity>> result = new HashMap<String,List<S1096ResponseEntity>>();
		result.put("randomList", getList(QuickOrderTypeEnum.RANDOM.key()));
		result.put("fullreduceList", getList(QuickOrderTypeEnum.FULLREDUCE.key()));
		result.put("saleList", getList(QuickOrderTypeEnum.SALE.key()));
		result.put("couponList", getList(QuickOrderTypeEnum.COUPON.key()));
		return getAppResponseEntity(result);
	}
	
	private List<S1096ResponseEntity> getList(String type){
		List<S1096ResponseEntity> result = new ArrayList<S1096ResponseEntity>();
		List<Integer> shopIds = new ArrayList<Integer>();
		if(QuickOrderTypeEnum.COUPON.key().equals(type)){
			List<S1096ResponseEntity> list = couponApplyService.queryActivityCoupons(1,3,null);
			if(!Utils.isEmpty(list)){
				for (S1096ResponseEntity responseEntity : list) {
					shopIds.add(responseEntity.getShopId());
				}
				Map<Integer,ShopInfo> shopMap = shopInfoService.searchShopInfoByShopIds(shopIds, "");
				for (S1096ResponseEntity responseEntity : list) {
					ShopInfo shopInfo = shopMap.get(responseEntity.getShopId());
					if(shopInfo != null && StateEnum.EFFECTION.key().equals(shopInfo.getState()+"")){
						responseEntity.setShopLogo(shopInfo.getShopLogo());
						responseEntity.setShopName(shopInfo.getShopName());
						
						StringBuffer sb = new StringBuffer("");
						if(!Utils.isEmpty(shopInfo.getDistrictId())){
							Region region = redisService.getRegion(shopInfo.getDistrictId());
							if(region != null){
								if(Utils.isEmpty(region.getCityName())){
									sb.append(region.getProvinceName());
								}else{
									sb.append(region.getCityName());
								}
								if(Utils.isEmpty(region.getAreaName())){
									sb.append(region.getRegionName());
								}else{
									sb.append(region.getAreaName());
								}
							}
						}
						sb.append(shopInfo.getShopAddress());
						responseEntity.setShopAddress(sb.toString());
						result.add(responseEntity);
					}
				}
			}
		}else{
			String tmp;
			ShopActivityConfigExample example = new ShopActivityConfigExample();
			example.setOrderByClause(" id desc ");
			ShopActivityConfigExample.Criteria criteria = example.createCriteria();
			if(QuickOrderTypeEnum.RANDOM.key().equals(type)){
				criteria.andCanRandomEqualTo(1);
				tmp = "买单立减：最高减{0}，最低减{1}";
			}else if(QuickOrderTypeEnum.FULLREDUCE.key().equals(type)){
				criteria.andCanFullReduceEqualTo(1);
				tmp = "满{0}减{1}";
			}else if(QuickOrderTypeEnum.SALE.key().equals(type)){
				criteria.andCanSaleEqualTo(1);
				tmp = "折扣买单：买单即打{0}折";
			}else{
				return result;
			}
			List<ShopActivityConfig> list = shopActivityConfigService.selectByExample(1, 3, example);
			if(!Utils.isEmpty(list)){
				for (ShopActivityConfig shopActivityConfig : list) {
					shopIds.add(shopActivityConfig.getShopId());
				}
				Map<Integer,ShopInfo> shopMap = shopInfoService.searchShopInfoByShopIds(shopIds, "");
				
				for (ShopActivityConfig shopActivityConfig : list) {
					ShopInfo shopInfo = shopMap.get(shopActivityConfig.getShopId());
					if(shopInfo != null && StateEnum.EFFECTION.key().equals(shopInfo.getState()+"")){
						S1096ResponseEntity responseEntity = new S1096ResponseEntity();
						responseEntity.setShopLogo(shopInfo.getShopLogo());
						responseEntity.setShopName(shopInfo.getShopName());
						
						StringBuffer sb = new StringBuffer("");
						if(!Utils.isEmpty(shopInfo.getDistrictId())){
							Region region = redisService.getRegion(shopInfo.getDistrictId());
							if(region != null){
								if(Utils.isEmpty(region.getCityName())){
									sb.append(region.getProvinceName());
								}else{
									sb.append(region.getCityName());
								}
								if(Utils.isEmpty(region.getAreaName())){
									sb.append(region.getRegionName());
								}else{
									sb.append(region.getAreaName());
								}
							}
						}
						sb.append(shopInfo.getShopAddress());
						responseEntity.setShopAddress(sb.toString());
						responseEntity.setShopId(shopActivityConfig.getShopId());
						if(QuickOrderTypeEnum.RANDOM.key().equals(type)){
							responseEntity.setRemark(MessageFormat.format(tmp, shopActivityConfig.getMaxMoney(), shopActivityConfig.getMinMoney()));
						}else if(QuickOrderTypeEnum.FULLREDUCE.key().equals(type)){
							StringBuffer str = new StringBuffer("优惠活动：");
							if(!Utils.isEmpty(shopActivityConfig.getReduceMoney()) && !Utils.isEmpty(shopActivityConfig.getFullMoney())){
								String [] reduceMoneys = shopActivityConfig.getReduceMoney().split("\\|");
								String[] fullMoneys = shopActivityConfig.getFullMoney().split("\\|");
								if(reduceMoneys.length > 0 && fullMoneys.length == reduceMoneys.length){
									for (int i = 0; i < fullMoneys.length; i++) {
										if(i > 0){
											str.append(",");
										}
										str.append(MessageFormat.format(tmp, fullMoneys[i], reduceMoneys[i]));
									}
								}
							}
							responseEntity.setRemark(str.toString());
						}else if(QuickOrderTypeEnum.SALE.key().equals(type)){
							responseEntity.setRemark(MessageFormat.format(tmp, UtilMoney.divideToDouble(shopActivityConfig.getSale(), 10)));
						}
						result.add(responseEntity);
					}
				}
			}
		}
		return result;
	}
}
