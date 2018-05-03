package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.HomepageSettingDao;
import cn.xinmeng.api.entity.auto.ActivityProduct;
import cn.xinmeng.api.entity.auto.FlashPurchaseActivity;
import cn.xinmeng.api.entity.auto.HomepageModel;
import cn.xinmeng.api.entity.auto.HomepageSetting;
import cn.xinmeng.api.entity.auto.example.HomepageModelExample;
import cn.xinmeng.api.entity.auto.example.HomepageSettingExample;
import cn.xinmeng.api.enums.ActivityTypeEnum;
import cn.xinmeng.api.enums.HomepageStateEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IActivityProductService;
import cn.xinmeng.api.service.IFlashPurchaseActivityService;
import cn.xinmeng.api.service.IHomepageModelService;
import cn.xinmeng.api.service.IHomepageSettingProductService;
import cn.xinmeng.api.service.IHomepageSettingService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.vo.ActivityVo;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingParentVo;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingVo;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

/**
 * 业务层：HomepageSettingServiceImpl
 * @author jiangyong.tan
 * 描述：主页配置表
 * @date 2016-01-24 14:38:57
 */
@Service("homepageSettingService")
public class HomepageSettingServiceImpl implements IHomepageSettingService {

    @Resource
	private HomepageSettingDao homepageSettingDao;
    @Resource
    private IProductInfoService productInfoService;
    @Resource
	private IHomepageModelService homepageModelService;
    @Resource
    private IHomepageSettingProductService homepageSettingProductService;
    @Resource
    private IFlashPurchaseActivityService flashPurchaseActivityService;
    @Resource
    private IActivityProductService activityProductService;
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HomepageSetting record){
    	return homepageSettingDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return homepageSettingDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HomepageSetting record){
		return homepageSettingDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageSetting selectByPrimaryKey(Integer id){
    	return homepageSettingDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(HomepageSettingExample example){
		return homepageSettingDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageSetting> selectByExample(HomepageSettingExample example){
    	return homepageSettingDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<HomepageSetting> selectByExample(int currentPage, int limit,HomepageSettingExample example){
        return homepageSettingDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     * 
     * @param shopId
     * @return
     */
    public List<HomepageSettingParentVo> getHomepageList(Integer shopId){
		List<HomepageSettingParentVo> result = new ArrayList<HomepageSettingParentVo>();
		
		HomepageModelExample modelExample = new HomepageModelExample();
		HomepageModelExample.Criteria modelCriteria = modelExample.createCriteria();
		modelExample.setOrderByClause("id desc");
		modelCriteria.andShopIdEqualTo(shopId);
		modelCriteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		List<HomepageModel> modelList = homepageModelService.selectByExample(modelExample);
		if(!Utils.isEmpty(modelList)){
			HomepageSettingExample example = new HomepageSettingExample();
			HomepageSettingExample.Criteria criteria = example.createCriteria();
			example.setOrderByClause("sort desc,id desc");
			criteria.andShopIdEqualTo(shopId);
			criteria.andModelIdEqualTo(modelList.get(0).getId());
			criteria.andStateEqualTo(Integer.valueOf(HomepageStateEnum.EFFECTION.key()));
			List<HomepageSetting> list = selectByExample(example);
			if(!Utils.isEmpty(list)){
				List<ProductInfoVo> defaultP = new ArrayList<ProductInfoVo>();
				Map<Integer, List<HomepageSettingVo>> map = new HashMap<Integer, List<HomepageSettingVo>>();
				for (HomepageSetting homepageSetting : list) {
					List<ProductInfoVo> productInfoVos = null;//prodInfoService.selectProductInfoVoByModulId(homepageSetting.getId());
					if(homepageSetting.getShowType() == null || homepageSetting.getShowType() != 8){
						if(!(homepageSetting.getType() != null && homepageSetting.getType() == 1 && !Utils.isEmpty(homepageSetting.getLinkUrl()))){
							productInfoVos = productInfoService.selectProductInfoVoByModulId(homepageSetting.getId());
						}
					}
					if(!Utils.isEmpty(productInfoVos)){
						for (ProductInfoVo productInfoVo : productInfoVos) {
							if(!Utils.isEmpty(homepageSetting.getShowType()) && homepageSetting.getShowType() == 7){
								productInfoVo.setImageUrl(Utils.getImageUrl(productInfoVo.getImageUrl(),"?400_400"));
							}else{
								productInfoVo.setImageUrl(Utils.getImageUrl(productInfoVo.getImageUrl(),"?300_300"));
							}
						}
					}
					
					if(Utils.isEmpty(homepageSetting.getParentId())){
						HomepageSettingParentVo h = new HomepageSettingParentVo();
						//复制属性
						CloneUtils.copyEntity(homepageSetting, h);
						if(Utils.isEmpty(productInfoVos)){
							h.setProductInfos(defaultP);
						}else{
							h.setProductInfos(productInfoVos);
						}
						result.add(h);
					}else{
						ActivityVo activityVo = new ActivityVo();
						if(!Utils.isEmpty(homepageSetting.getShowType()) && homepageSetting.getShowType() == 8){
							Integer id = homepageSettingProductService.selectProductIdByModulId(homepageSetting.getId());
							if(id != null){
								FlashPurchaseActivity activity = flashPurchaseActivityService.selectByPrimaryKey(id);
								if(activity != null){
									CloneUtils.copyEntity(activity, activityVo);
									
									List<ActivityProduct> listActivityProduct = activityProductService.selectByExample(activity.getId(), Integer.parseInt(ActivityTypeEnum.SECKILL.key()));
									if(!Utils.isEmpty(listActivityProduct)){
										activityVo.setActivityProductNum(listActivityProduct.size());
										if(activityVo.getActivityProductNum() == 1){
											activityVo.setProductPriceId(listActivityProduct.get(0).getProductPriceId());
											activityVo.setProductId(listActivityProduct.get(0).getProductId());
										}
									}
								}
							}
							activityVo.setActivityType(Integer.parseInt(ActivityTypeEnum.SECKILL.key()));
							activityVo.setImageUrl(homepageSetting.getImgUrl());
						}
						List<HomepageSettingVo> homepageSettingVos = map.get(homepageSetting.getParentId());
						if(homepageSettingVos == null){
							homepageSettingVos = new ArrayList<HomepageSettingVo>();
						}
						HomepageSettingVo h = new HomepageSettingVo();
						//复制属性
						CloneUtils.copyEntity(homepageSetting, h);
						if(Utils.isEmpty(productInfoVos)){
							h.setProductInfos(defaultP);
						}else{
							h.setProductInfos(productInfoVos);
						}
						h.setActivity(activityVo);
						homepageSettingVos.add(h);
						map.put(homepageSetting.getParentId(), homepageSettingVos);
					}
				}
				for (HomepageSettingParentVo h : result) {
					if(map.containsKey(h.getId())){
						List<HomepageSettingVo> homepageSettingVos = map.get(h.getId());
//						String [] size = null;
//						if(!Utils.isEmpty(h.getShowType())){
//							switch (h.getShowType()) {
//							case 2:
//								size = new String[]{"?320_320","?320_320"};
//								break;
//							case 3:
//								size = new String[]{"?320_320","?320_160","?320_160"};							
//								break;
//							case 4:
//								size = new String[]{"?320_320","?320_160","?160_160","?160_160"};
//								break;
//							case 5:
//								size = new String[]{"?320_320","?160_160","?160_160","?160_160","?160_160"};
//								break;
//							}
//							if(size != null && size.length == homepageSettingVos.size()){
//								for (int i = 0; i < size.length; i++) {
//									HomepageSettingVo homepageSettingVo = homepageSettingVos.get(i);
//									homepageSettingVo.setImgUrl(Utils.getImageUrl(homepageSettingVo.getImgUrl(),size[i]));
//								}
//							}
//						}
						h.setList(homepageSettingVos);
					}else{
						List<HomepageSettingVo> defaultH = new ArrayList<HomepageSettingVo>();
						if(!Utils.isEmpty(h.getShowType()) && h.getShowType() == 1){
//							h.setImgUrl(Utils.getImageUrl(h.getImgUrl(),"?640_210"));
							HomepageSettingVo homepageSettingVo = new HomepageSettingVo();
							//复制属性
							CloneUtils.copyEntity(h,homepageSettingVo);
							defaultH.add(homepageSettingVo);
							h.setProductInfos(defaultP);
						}
						h.setList(defaultH);
					}
				}
			}
		}
		return result;
	}
}