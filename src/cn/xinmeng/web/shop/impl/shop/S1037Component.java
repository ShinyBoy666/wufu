package cn.xinmeng.web.shop.impl.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Banner;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.BannerExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IBannerService;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.INoticeService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.shop.S1037ResponseEntity;
import cn.xinmeng.web.shop.entity.vo.ActivityVo;
import cn.xinmeng.web.shop.entity.vo.BannerVo;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingParentVo;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingVo;

/**
 * 
 * <p class="detail">店铺首页 </p>
 * 
 * @param 
 * @ClassName: S1037Component 
 * @version V1.0  @date 2016年2月19日 下午4:47:30 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.shop.S1037Component")
public class S1037Component extends BaseService {
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Resource
	private IBannerService bannerService;
	
	@Resource
	private INoticeService noticeService;
	
	@Resource
	private IRedisService redisService;
	
	@Resource
	private ICartService cartService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		
		S1037ResponseEntity responseEntity = new S1037ResponseEntity();
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(entity) && !Utils.isEmpty(entity.getShopId())){
			shopId = entity.getShopId();
		}
		//查询店铺信息
		ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(shopId);
		if(shopInfo == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_NOTEXISTS_SHOP);
		}
		
		CloneUtils.cloneEntity(shopInfo, responseEntity);
		
		if(entity != null && !Utils.isEmpty(entity.getCustomerId())){
			//查询消息总数量
			Integer totalCount = noticeService.searchNoticeCount(entity.getCustomerId(), shopId);
			//查询消息已读数量
			Integer readCount = noticeService.searchNoticeReadCount(entity.getCustomerId(), shopId);
			responseEntity.setNoticeCount(totalCount-readCount);
			
			responseEntity.setCartCount(cartService.searchCartProductCount(entity.getCustomerId(),shopId));
		}
		//首页顶部图标
		responseEntity.setTopMenu(redisService.getHomePageTopIoc(shopId));
		//查询轮播图
		responseEntity.setBannerList(getBannerList(shopId, new Date()));
		//查询首页模块
		List<HomepageSettingParentVo> list = redisService.getHomepageSettingParentVo(shopId);
		List<HomepageSettingParentVo> result = new ArrayList<HomepageSettingParentVo>();
		Date now = new Date();
		for (HomepageSettingParentVo homepageSettingParentVo : list) {
			if(!Utils.isEmpty(homepageSettingParentVo.getShowType()) && homepageSettingParentVo.getShowType() == 8){
				if(Utils.isEmpty(homepageSettingParentVo.getList())){
					continue;
				}else{
					List<HomepageSettingVo> homepageSettingVos = new ArrayList<HomepageSettingVo>();
					for (HomepageSettingVo h : homepageSettingParentVo.getList()) {
						ActivityVo activity = h.getActivity();
						if(activity == null 
								|| !StateEnum.EFFECTION.key().equals(activity.getState()+"")
								|| activity.getShowTime() == null
								|| activity.getBeginTime() == null
								|| activity.getEndTime() == null
								|| DateUtil.compareDate(now, activity.getEndTime())
								|| DateUtil.compareDate(activity.getShowTime(), now)){
							continue;
						}
						homepageSettingVos.add(h);
					}
					if(homepageSettingVos.size() == 0){
						continue;
					}
					homepageSettingParentVo.setList(homepageSettingVos);
				}
			}
			result.add(homepageSettingParentVo);
		}
		responseEntity.setModulList(result);
		return getAppResponseEntity(responseEntity);
	}
	
	/**
	 * 
	 * <p class="detail"> 查询轮播图 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午3:03:21
	 * @param shopId
	 * @param now
	 * @return
	 */
	private List<BannerVo> getBannerList(Integer shopId,Date now){
		List<BannerVo> result = new ArrayList<BannerVo>();//返回集合
		
		BannerExample example = new BannerExample();
		BannerExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("sort desc,id desc");
		criteria.andShopIdEqualTo(shopId);
		criteria.andShowAreaEqualTo(1);
		criteria.andBeginTimeLessThanOrEqualTo(now);
		criteria.andEndTimeGreaterThanOrEqualTo(now);
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		List<Banner> list = bannerService.selectByExample(example);
		if(!Utils.isEmpty(list)){
			for (Banner banner : list) {
				BannerVo bannerVo = new BannerVo();
				//复制属性
				CloneUtils.copyEntity(banner, bannerVo);
//				bannerVo.setImageUrl(Utils.getImageUrl(bannerVo.getImageUrl(),"?640_320"));
				result.add(bannerVo);
			}
		}
		return result;
	}
	
}
