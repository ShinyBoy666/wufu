package cn.xinmeng.web.shop.impl.product;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Collection;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.example.CollectionExample;
import cn.xinmeng.api.entity.auto.example.ProductInfoExample;
import cn.xinmeng.api.service.ICollectionService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.entity.PageSearchEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

/**
 * 
 * <p class="detail">关注商品列表 </p>
 * 
 * @param 
 * @ClassName: S1040Component 
 * @version V1.0  @date 2016年3月1日 上午10:45:40 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1040Component")
public class S1040Component extends BaseService {
	
	@Resource
	private IProductInfoService productInfoService;
	
	@Resource
	private ICollectionService collectionService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		PageSearchEntity requestEntity = parseRequertParam(data, PageSearchEntity.class);
		/**
		 * 非空验证
		 */
		if(requestEntity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(requestEntity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(requestEntity.getShopId())){
			shopId = requestEntity.getShopId();
		}
		//查询用户收藏集合
		CollectionExample example = new CollectionExample();
		CollectionExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(shopId);
		criteria.andCustomerIdEqualTo(requestEntity.getCustomerId());
		criteria.andObjectTypeEqualTo(1);//商品
		//example.setOrderByClause("id desc");
		List<ProductInfoVo> list = new ArrayList<ProductInfoVo>();
		PageInfoEntity<ProductInfoVo> pageInfoEntity = new PageInfoEntity<ProductInfoVo>(requestEntity.getCurrentPage(),requestEntity.getLimit());
		int count = collectionService.countByExample(example);
		if(count > 0){
			List<Collection> collections = collectionService.selectByExample(requestEntity.getCurrentPage(), requestEntity.getLimit(), example);
			if(!Utils.isEmpty(collections)){
				List<Integer> productIds = new ArrayList<Integer>();
				for (Collection collection : collections) {
					if(!Utils.isEmpty(collection.getObjectId())){
						productIds.add(Integer.parseInt(collection.getObjectId()));
					}
				}
				if(productIds.size() > 0){
					//查询商品信息
					ProductInfoExample productInfoExample = new ProductInfoExample();
					ProductInfoExample.Criteria productInfocCriteria = productInfoExample.createCriteria();
					productInfocCriteria.andProductIdIn(productIds);
					List<ProductInfo> productInfos = productInfoService.selectByExample(productInfoExample);
					if(!Utils.isEmpty(productInfos)){
						for (ProductInfo productInfo : productInfos) {
							ProductInfoVo productInfoVo = new ProductInfoVo();
							CloneUtils.cloneEntity(productInfo, productInfoVo);
							productInfoVo.setImageUrl(Utils.getImageUrl(productInfoVo.getImageUrl(),"?400_400"));
							list.add(productInfoVo);
						}
					}
				}
			}
		}
		pageInfoEntity.setTotalRecord(count);
		pageInfoEntity.setList(list);
		return getAppResponseEntity(pageInfoEntity);
	}
	
}
