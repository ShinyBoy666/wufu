package cn.xinmeng.web.shop.impl.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.ProductImage;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.example.CollectionExample;
import cn.xinmeng.api.entity.auto.example.ProductCommentExample;
import cn.xinmeng.api.entity.auto.example.ProductImageExample;
import cn.xinmeng.api.enums.ProductStateEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICollectionService;
import cn.xinmeng.api.service.IProductCommentService;
import cn.xinmeng.api.service.IProductDetailInfoService;
import cn.xinmeng.api.service.IProductImageService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.product.S1007RequestEntity;
import cn.xinmeng.web.shop.entity.vo.ProductInfoDetailVo;
import cn.xinmeng.web.shop.entity.vo.ProductPriceVo;

/**
 * 
 * <p class="detail">商品详情</p>
 * 
 * @param 
 * @ClassName: S1007Component 
 * @version V1.0  @date 2016年2月19日 下午4:47:30 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1007Component")
public class S1007Component extends BaseService {
	
	@Resource
	private IProductInfoService productInfoService;
	
	@Resource
	private IProductPriceService productPriceService;
	
	@Resource
	private IProductImageService productImageService;
	
	@Resource
	private IProductCommentService productCommentService;
	
	@Resource
	private ICollectionService collectionService;
	
	@Resource
	private IShopInfoService shopInfoService;
	
	@Resource
	private IProductDetailInfoService productDetailInfoService;
	
	@Resource
	private ICartService cartService;
	
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
		Integer shopId = request.getLoginShopId();
		if(!Utils.isEmpty(requestEntity.getShopId())){
			shopId = requestEntity.getShopId();
		}
		//查询商品信息
		ProductInfo productInfo = productInfoService.selectByProductId(requestEntity.getProductId());
		if(productInfo == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCTINFO_NOT_EXITS);
		}
		ProductInfoDetailVo detail = new ProductInfoDetailVo();
		CloneUtils.cloneEntity(productInfo, detail);
		//商品状态
		if(!ProductStateEnum.STATE_SHELVE.key().equals(productInfo.getState()+"")){
			
			detail.setProductStateValue("上架");
		}else{
			detail.setProductState(2);
			detail.setProductStateValue("下架");
		}
		detail.setProductState(productInfo.getState());
		detail.setProductStateValue(ProductStateEnum.keyToValue(productInfo.getState()+""));
		detail.setImageUrl(Utils.getImageUrl(detail.getImageUrl(),""));
		detail.setShopName(shopInfoService.queryShopNameByShopId(request.getSourceShopId()));
		String productDetailUrl = HelperPropertie.getValue("local.url");
		if(!Utils.isEmpty(productDetailUrl)){
			productDetailUrl = productDetailUrl +"/App/ProductDetail?id="+productInfo.getProductId();
		}
		detail.setProductDetailUrl(productDetailUrl);
		List<ProductPriceVo> priceList = new ArrayList<ProductPriceVo>();
		//查询商品价格信息
		List<ProductPrice> list = productPriceService.selectByProductId(productInfo.getProductId());
		if(!Utils.isEmpty(list)){
			List<Integer> ids = new ArrayList<Integer>(); 
			for (ProductPrice productPrice : list) {
				ProductPriceVo productPriceVo = new ProductPriceVo();
				CloneUtils.cloneEntity(productPrice, productPriceVo);
				productPriceVo.setVipPrice(UtilMoney.subtractToDouble(productPrice.getRetailPrice(), productPrice.getProfitFirst()));
				priceList.add(productPriceVo);
				ids.add(productPrice.getId());
			}
			ProductImageExample imgExample = new ProductImageExample();
			ProductImageExample.Criteria imgCriteria = imgExample.createCriteria();
			imgCriteria.andProductPriceIdIn(ids);
			imgCriteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
			imgExample.setOrderByClause("sort desc,id desc");
			//查询商品图片集合
			List<ProductImage> imgList = productImageService.selectByExample(imgExample);
			Map<Integer, List<String>> imgMap = new HashMap<Integer, List<String>>();
			if(!Utils.isEmpty(imgList)){
				for (ProductImage productImage : imgList) {
					List<String> imgs = imgMap.get(productImage.getProductPriceId());
					if(imgs == null){
						imgs = new ArrayList<String>();
					}
					imgs.add(Utils.getImageUrl(productImage.getImageUrl(),""));
					imgMap.put(productImage.getProductPriceId(), imgs);
				}
			}
			
			for (ProductPriceVo p : priceList) {
				List<String> imgs = imgMap.get(p.getId());
				if(imgs == null){
					imgs = new ArrayList<String>();
					imgs.add(detail.getImageUrl());
				}
				p.setImageUrlList(imgs);
			}
		}
		ProductCommentExample example = new ProductCommentExample();
		ProductCommentExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productInfo.getProductId());
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		//detail.setCommentCount(productCommentService.countByExample(example));
		detail.setCommentCount(0);
		detail.setProductPriceList(priceList);
		if(!Utils.isEmpty(requestEntity.getCustomerId())){
			//客户是否收藏商品
			CollectionExample collectionExample = new CollectionExample();
			CollectionExample.Criteria collectionCriteria = collectionExample.createCriteria();
			collectionCriteria.andCustomerIdEqualTo(requestEntity.getCustomerId());
			collectionCriteria.andObjectTypeEqualTo(1);
			collectionCriteria.andObjectIdEqualTo(detail.getProductId()+"");
			if(collectionService.countByExample(collectionExample) > 0){
				detail.setIsCollection(true);
			}
		}
		if("wap".equals(request.getSource())){
			ProductDetailInfo productDetailInfo = productDetailInfoService.selectByProductId(requestEntity.getProductId());
			if(productDetailInfo != null){
				detail.setDescription(productDetailInfo.getDescription());
			}
			if(!Utils.isEmpty(requestEntity.getCustomerId())){
				detail.setCartCount(cartService.searchCartProductCount(requestEntity.getCustomerId(),shopId));
			}
		}
		detail.setShareUrl(HelperPropertie.getValue("local.url")+"pages/"+shopId+"/productdetail.html?pid="+detail.getProductId());
		return getAppResponseEntity(detail);
	}
}
