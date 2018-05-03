package cn.xinmeng.web.shop.impl.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Category;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICategoryService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1050ResponseEntity;
import cn.xinmeng.web.shop.entity.vo.CategoryVo;

/**
 * 查询店铺所有商品分类
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1054Component")
public class S1054Component extends BaseService {
	
	@Resource
	private ICategoryService categoryService;
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Resource
	private ICartService cartService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		RequestBaseEntity requestEntity = parseRequertParam(data, RequestBaseEntity.class);
		/**
		 * 非空验证
		 */
		if(requestEntity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if (Utils.isEmpty(requestEntity.getShopId())) {
			throw new NullException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}
		ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(requestEntity.getShopId());
		//商品类别层级1、一级2、二级3、三级
		int productCategoryLevel = 3;
		if(shopInfo != null  && !Utils.isEmpty(shopInfo.getProductCategoryLevel())){
			productCategoryLevel = shopInfo.getProductCategoryLevel();
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("productCategoryLevel", productCategoryLevel);
		if(!Utils.isEmpty(requestEntity.getCustomerId())){
			result.put("cartCount", cartService.searchCartProductCount(requestEntity.getCustomerId(),requestEntity.getShopId()));
		}
		if(productCategoryLevel == 1){
			result.put("list", getCategoryList1(requestEntity.getShopId()));
		}else if (productCategoryLevel == 2) {
			result.put("list", getCategoryList2(requestEntity.getShopId()));
		}else {
			result.put("list", getCategoryList3(requestEntity.getShopId()));
		}
		return getAppResponseEntity(result);
	}
	
	/**
	 * 一级分类
	 * @param shopId
	 * @return
	 */
	private Object getCategoryList1(Integer shopId){
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		List<Category> list = categoryService.searchCategory(3, null, null, shopId);
		if(!Utils.isEmpty(list)){
			for (Category category : list) {
				CategoryVo categoryVo = new CategoryVo();
				CloneUtils.copyEntity(category, categoryVo);
				categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?200_200"));
				result.add(categoryVo);
			}
		}
		return result;
	}

	/**
	 * 二级分类
	 * @param shopId
	 * @return
	 */
	private Object getCategoryList2(Integer shopId){
		List<Category> list1 = categoryService.searchCategory(1, null, null, shopId);
		List<S1050ResponseEntity> result = new ArrayList<S1050ResponseEntity>();
		if(!Utils.isEmpty(list1)){
			Map<Integer, List<CategoryVo>> mapLevel = new HashMap<Integer, List<CategoryVo>>();
			List<Category> list3 = categoryService.searchCategory(3, null, null, shopId);
			if(!Utils.isEmpty(list3)){
				for (Category category : list3) {
					List<CategoryVo> categoryVos = mapLevel.get(category.getFirstId());
					if(categoryVos == null){
						categoryVos = new ArrayList<CategoryVo>();
					}
					CategoryVo categoryVo = new CategoryVo();
					CloneUtils.copyEntity(category, categoryVo);
					categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?200_200"));
					categoryVos.add(categoryVo);
					mapLevel.put(category.getFirstId(), categoryVos);
				}
			}
			for (Category category : list1) {
				S1050ResponseEntity categoryVo = new S1050ResponseEntity();
				CloneUtils.copyEntity(category, categoryVo);
				categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?200_200"));
				if(mapLevel.containsKey(categoryVo.getId())){
					categoryVo.setList(mapLevel.get(categoryVo.getId()));
				}else{
					categoryVo.setList(new ArrayList<CategoryVo>());
				}
				result.add(categoryVo);
			}
		}
		return result;
	}
	
	/**
	 * 三级分类
	 * @param shopId
	 * @return
	 */
	private Object getCategoryList3(Integer shopId){
		List<Category> list1 = categoryService.searchCategory(1, null, null, shopId);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(!Utils.isEmpty(list1)){
			
			Map<Integer, List<CategoryVo>> mapLevel3 = new HashMap<Integer, List<CategoryVo>>();
			List<Category> list3 = categoryService.searchCategory(3, null, null, shopId);
			if(!Utils.isEmpty(list3)){
				for (Category category : list3) {
					List<CategoryVo> categoryVos = mapLevel3.get(category.getSecondId());
					if(categoryVos == null){
						categoryVos = new ArrayList<CategoryVo>();
					}
					CategoryVo categoryVo = new CategoryVo();
					CloneUtils.copyEntity(category, categoryVo);
					categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?200_200"));
					categoryVos.add(categoryVo);
					mapLevel3.put(category.getSecondId(), categoryVos);
				}
			}
			list3.clear();
			
			Map<Integer, List<S1050ResponseEntity>> mapLevel2 = new HashMap<Integer, List<S1050ResponseEntity>>();
			List<Category> list2 = categoryService.searchCategory(2, null, null, shopId);
			if(!Utils.isEmpty(list2)){
				for (Category category : list2) {
					List<S1050ResponseEntity> categoryVos = mapLevel2.get(category.getFirstId());
					if(categoryVos == null){
						categoryVos = new ArrayList<S1050ResponseEntity>();
					}
					S1050ResponseEntity categoryVo = new S1050ResponseEntity();
					CloneUtils.copyEntity(category, categoryVo);
					categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?200_200"));
					if(mapLevel3.containsKey(categoryVo.getId())){
						categoryVo.setList(mapLevel3.get(categoryVo.getId()));
					}else{
						categoryVo.setList(new ArrayList<CategoryVo>());
					}
					categoryVos.add(categoryVo);
					mapLevel2.put(category.getFirstId(), categoryVos);
				}
			}
			for (Category category : list1) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("id", category.getId());
				m.put("categoryName", category.getCategoryName());
				m.put("categoryDescription", category.getCategoryDescription());
				m.put("ico", Utils.getImageUrl(category.getIco(),"?200_200"));
				m.put("level", category.getLevel());
				if(mapLevel2.containsKey(category.getId())){
					m.put("list", mapLevel2.get(category.getId()));
				}else{
					m.put("list", new ArrayList<S1050ResponseEntity>());
				}
				result.add(m);
			}
		}
		return result;
	}
}
