package cn.xinmeng.web.shop.impl.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.example.ProductDetailInfoExample;
import cn.xinmeng.api.service.IProductDetailInfoService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1007RequestEntity;

/**
 * 
 * <p class="detail">商品图文详情 </p>
 * 
 * @param 
 * @ClassName: S1042Component 
 * @version V1.0  @date 2016年3月1日 上午11:13:25 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1042Component")
public class S1042Component extends BaseService {
	
	@Resource
	private IProductDetailInfoService productDetailInfoService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		S1007RequestEntity requestEntity = parseRequertParam(data, S1007RequestEntity.class);
		/**
		 * 非空验证
		 */
		if(requestEntity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if (Utils.isEmpty(requestEntity.getProductId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCTID_IS_NULL);
		}
		ProductDetailInfoExample example = new ProductDetailInfoExample();
		ProductDetailInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(requestEntity.getProductId());
		List<ProductDetailInfo> list = productDetailInfoService.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return getAppResponseEntity(list.get(0).getSpecifications());
		}
		return getAppResponseEntity("");
	}
	
}
