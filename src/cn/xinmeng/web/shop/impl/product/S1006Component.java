package cn.xinmeng.web.shop.impl.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;

/**
 * 
 * <p class="detail">商品列表</p>
 * 
 * @param 
 * @ClassName: S1006Component 
 * @version V1.0  @date 2016年2月19日 下午4:47:30 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1006Component")
public class S1006Component extends BaseService {
	
	@Resource
	private IProductInfoService productInfoService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		S1006RequestEntity requestEntity = parseRequertParam(data, S1006RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(requestEntity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}
//		List<BrandVo> result = new ArrayList<BrandVo>();  
//		ProductInfoExample example = new ProductInfoExample();
//		ProductInfoExample.Criteria criteria = example.createCriteria();
//		criteria.andShopIdEqualTo(loginShopId);
//		criteria.andStateEqualTo(2);
//		criteria.andCategoryIdEqualTo(value);
//		criteria.andBrandIdEqualTo(value);
		return getAppResponseEntity(productInfoService.selectProductInfoList(requestEntity));
	}
}
