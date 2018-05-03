package cn.xinmeng.web.shop.impl.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Category;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.CategoryExample;
import cn.xinmeng.api.enums.StateEnum;
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
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1039RequestEntity;
import cn.xinmeng.web.shop.entity.product.S1050ResponseEntity;
import cn.xinmeng.web.shop.entity.vo.CategoryVo;

/**
 * 
 * <p class="detail">商品分类列表  </p>
 * 
 * @param 
 * @ClassName: S1039Component 
 * @version V1.0  @date 2016年2月24日 上午9:43:06 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1039Component")
public class S1039Component extends BaseService {
	
	@Resource
	private ICategoryService categoryService;
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		S1039RequestEntity requestEntity = parseRequertParam(data, S1039RequestEntity.class);
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
		Map<String, Object> object = new HashMap<String, Object>();
		object.put("productCategoryLevel", productCategoryLevel);
		if(productCategoryLevel == 1){
			List<S1050ResponseEntity> result = new ArrayList<S1050ResponseEntity>();
			S1050ResponseEntity responseEntity = new S1050ResponseEntity();
			List<CategoryVo> categoryVos = new ArrayList<CategoryVo>();
			List<Category> list = categoryService.searchCategory(3, null, null, requestEntity.getShopId());
			if(!Utils.isEmpty(list)){
				for (Category category : list) {
					CategoryVo categoryVo = new CategoryVo();
					CloneUtils.copyEntity(category, categoryVo);
					categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?100_100"));
					categoryVos.add(categoryVo);
				}
			}
			responseEntity.setList(categoryVos);
			responseEntity.setCategoryName("");
			result.add(responseEntity);
			object.put("list",result);
		}else{
			object.put("list", getCategoryList(requestEntity));
		}
		return getAppResponseEntity(object);
	}
	
	private Object getCategoryList(S1039RequestEntity requestEntity){
		List<CategoryVo> result = new ArrayList<CategoryVo>();  
		CategoryExample example = new CategoryExample();
		CategoryExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(requestEntity.getShopId());
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		if(!Utils.isEmpty(requestEntity.getLevel())){
			criteria.andLevelEqualTo(requestEntity.getLevel());
			if(!Utils.isEmpty(requestEntity.getPid())){
				if(requestEntity.getLevel() == 2){
					criteria.andFirstIdEqualTo(requestEntity.getPid());
				}else if(requestEntity.getLevel() == 3){
					criteria.andSecondIdEqualTo(requestEntity.getPid());
				}
			}
		}
		example.setOrderByClause("sort desc,id desc");
		List<Category> list = categoryService.selectByExample(example);
		if(!Utils.isEmpty(list)){
			for (Category category : list) {
				CategoryVo categoryVo = new CategoryVo();
				CloneUtils.copyEntity(category, categoryVo);
				categoryVo.setIco(Utils.getImageUrl(categoryVo.getIco(),"?100_100"));
				result.add(categoryVo);
			}
		}
		return result;
	}
}
