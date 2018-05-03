package cn.xinmeng.web.shop.impl.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Category;
import cn.xinmeng.api.entity.auto.example.CategoryExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICategoryService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1050RequestEntity;
import cn.xinmeng.web.shop.entity.product.S1050ResponseEntity;
import cn.xinmeng.web.shop.entity.vo.CategoryVo;

/**
 * 
 * <p class="detail">查询一级商品分类下的所有分类 </p>
 * 
 * @param 
 * @ClassName: S1050Component 
 * @version V1.0  @date 2016年2月24日 上午9:43:06 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1050Component")
public class S1050Component extends BaseService {
	
	@Resource
	private ICategoryService categoryService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		S1050RequestEntity requestEntity = parseRequertParam(data, S1050RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(requestEntity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if (Utils.isEmpty(requestEntity.getShopId())) {
			throw new NullException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_SHOPID_NULL);
		}else if (Utils.isEmpty(requestEntity.getId())) {
			throw new NullException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_CATEGORY_ID);
		}
		List<S1050ResponseEntity> result = new ArrayList<S1050ResponseEntity>();
		if(!Utils.isEmpty(requestEntity.getProductCategoryLevel()) && requestEntity.getProductCategoryLevel() == 2){
			S1050ResponseEntity responseEntity = new S1050ResponseEntity();
			List<CategoryVo> categoryVos = new ArrayList<CategoryVo>();
			List<Category> list = categoryService.searchCategory(3, null, requestEntity.getId(), requestEntity.getShopId());
			if(!Utils.isEmpty(list)){
				for (Category category : list) {
					CategoryVo categoryVo = new CategoryVo();
					CloneUtils.copyEntity(category, categoryVo);
					categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?200_200"));
					categoryVos.add(categoryVo);
				}
			}
			responseEntity.setList(categoryVos);
			responseEntity.setCategoryName("");
			result.add(responseEntity);
		}else{
			getCategoryList(requestEntity,result);
		}
		return getAppResponseEntity(result);
	}
	
	private void getCategoryList(S1050RequestEntity requestEntity,List<S1050ResponseEntity> result){
		List<Integer> levelList = new ArrayList<Integer>();
		levelList.add(2);
		levelList.add(3);
		
		CategoryExample example = new CategoryExample();
		CategoryExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(requestEntity.getShopId());
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		criteria.andFirstIdEqualTo(requestEntity.getId());
		criteria.andLevelIn(levelList);
		
		example.setOrderByClause("sort desc,id desc");
		List<Category> list = categoryService.selectByExample(example);
		if(!Utils.isEmpty(list)){
			Map<Integer, List<CategoryVo>> map = new HashMap<Integer, List<CategoryVo>>();
			for (Category category : list) {
				if(category.getLevel() == 2){
					S1050ResponseEntity responseEntity = new S1050ResponseEntity();
					CloneUtils.copyEntity(category, responseEntity);
					result.add(responseEntity);
				}else{
					List<CategoryVo> categoryVos = map.get(category.getSecondId());
					if(categoryVos == null){
						categoryVos = new ArrayList<CategoryVo>();
					}
					CategoryVo categoryVo = new CategoryVo();
					CloneUtils.copyEntity(category, categoryVo);
					categoryVos.add(categoryVo);
					map.put(category.getSecondId(), categoryVos);
				}
			}
			if(map.size() > 0){
				for (S1050ResponseEntity responseEntity : result) {
					List<CategoryVo> categoryVos = map.get(responseEntity.getId());
					if(categoryVos == null){
						categoryVos = new ArrayList<CategoryVo>();
					}
					responseEntity.setList(categoryVos);
				}
			}
		}
	}
}
