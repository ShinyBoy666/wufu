package cn.xinmeng.web.shop.impl.market;

import java.text.MessageFormat;
import java.util.ArrayList;
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
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.market.S1038RequestEntity;
import cn.xinmeng.web.shop.entity.market.S1096ResponseEntity;

/**
 * 优惠买单 店铺列表
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.market.S1038Component")
public class S1038Component extends BaseService {
	
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
		S1038RequestEntity entity = parseRequertParam(data, S1038RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),"查询类型不能为空...");
		}
		return getAppResponseEntity(getList(entity));
		
	}
	
	private PageInfoEntity<S1096ResponseEntity> getList(S1038RequestEntity entity){
		//返回分页数据
		PageInfoEntity<S1096ResponseEntity> resPage = new PageInfoEntity<S1096ResponseEntity>();
		List<S1096ResponseEntity> resList = new ArrayList<S1096ResponseEntity>();
		Integer totalCount = 0;
		//返回列表数据
		resPage.setCurrentPage(entity.getCurrentPage());
		resPage.setLimit(entity.getLimit());
		List<Integer> shopIds = shopInfoService.queryShopIdsByShopName(entity.getShopName());
		if(!Utils.isEmpty(entity.getShopName()) && shopIds.size() == 0){
			resPage.setTotalRecord(totalCount);
			resPage.setList(resList);
			return resPage;
		}
		
		if(QuickOrderTypeEnum.COUPON.key().equals(entity.getType())){
			totalCount = couponApplyService.queryActivityCouponsCount(shopIds);
			if(totalCount > 0){
				List<S1096ResponseEntity> list = couponApplyService.queryActivityCoupons(entity.getCurrentPage(),entity.getLimit(),shopIds);
				if(!Utils.isEmpty(list)){
					shopIds.clear();
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
							resList.add(responseEntity);
						}
					}
				}
			}
		}else{
			String tmp;
			ShopActivityConfigExample example = new ShopActivityConfigExample();
			ShopActivityConfigExample.Criteria criteria = example.createCriteria();
			if(!Utils.isEmpty(shopIds)){
				criteria.andShopIdIn(shopIds);
			}
			if(QuickOrderTypeEnum.RANDOM.key().equals(entity.getType())){
				criteria.andCanRandomEqualTo(1);
				tmp = "买单立减：最高减{0}，最低减{1}";
			}else if(QuickOrderTypeEnum.FULLREDUCE.key().equals(entity.getType())){
				criteria.andCanFullReduceEqualTo(1);
				tmp = "满{0}减{1}";
			}else if(QuickOrderTypeEnum.SALE.key().equals(entity.getType())){
				criteria.andCanSaleEqualTo(1);
				tmp = "折扣买单：买单即打{0}折";
			}else{
				resPage.setTotalRecord(totalCount);
				resPage.setList(resList);
				return resPage;
			}
			example.setOrderByClause(" id desc ");
			
			totalCount = shopActivityConfigService.countByExample(example);
			
			if(totalCount > 0){
				List<ShopActivityConfig> list = shopActivityConfigService.selectByExample(entity.getCurrentPage(), entity.getLimit(), example);
				if(!Utils.isEmpty(list)){
					shopIds.clear();
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
							if(QuickOrderTypeEnum.RANDOM.key().equals(entity.getType())){
								responseEntity.setRemark(MessageFormat.format(tmp, shopActivityConfig.getMaxMoney(), shopActivityConfig.getMinMoney()));
							}else if(QuickOrderTypeEnum.FULLREDUCE.key().equals(entity.getType())){
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
							}else if(QuickOrderTypeEnum.SALE.key().equals(entity.getType())){
								responseEntity.setRemark(MessageFormat.format(tmp, UtilMoney.divideToDouble(shopActivityConfig.getSale(), 10)));
							}
							resList.add(responseEntity);
						}
					}
				}
			}
		}
		resPage.setTotalRecord(totalCount);
		resPage.setList(resList);
		return resPage;
	}
}
