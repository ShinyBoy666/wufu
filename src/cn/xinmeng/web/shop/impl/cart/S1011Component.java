package cn.xinmeng.web.shop.impl.cart;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.CartExample;
import cn.xinmeng.api.enums.ProductStateEnum;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICouponApplyService;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IProductImageService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.cart.S1011RequestEntity;
import cn.xinmeng.web.shop.entity.cart.S1011ResponseEntity;
import cn.xinmeng.web.shop.entity.cart.vo.ShopCartVo;

/**
 * 购物车列表 
 * @param 
 * @ClassName: S1011Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:47:55 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.cart.S1011Component")
public class S1011Component extends BaseService {

	@Resource
	private ICartService cartService;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IProductPriceService productPriceService;
	@Resource
	private ICouponService couponService;
	@Resource
	private IShopInfoService shopInfoService;
	@Resource
	private ICouponApplyService couponApplyService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IProductImageService productImageService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1011RequestEntity entity = parseRequertParam(data, S1011RequestEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}else{
			//组装分页信息
			PageInfoEntity<S1011ResponseEntity> res = new PageInfoEntity<S1011ResponseEntity>(); 
			//返回数据
			List<S1011ResponseEntity> list = new ArrayList<S1011ResponseEntity>();
			//查询购物车列表
			CartExample example = new CartExample();
			CartExample.Criteria criteria = example.createCriteria();
			criteria.andCustomerIdEqualTo(entity.getCustomerId());
			Integer shopId = request.getLoginShopId();
//			criteria.andShopIdEqualTo(shopId);
			//总条数
			int totalCount = cartService.countByExample(example);
			if(totalCount > 0){
				example.setOrderByClause(" id desc ");
				List<Cart> listCart = cartService.selectByExample(entity.getCurrentPage(),entity.getLimit(),example);
				//组装购物列表，以及商品和商品价格信息
				if(!Utils.isEmpty(listCart)){
					List<ShopCartVo> shopCartList = new ArrayList<ShopCartVo>();
					for (Cart cart : listCart) {
						ShopCartVo shopCart = new ShopCartVo();
						shopCart.setProductNumber(cart.getProductNumber());
						shopCart.setSku(cart.getSku());
						shopCart.setAddCartTime(cart.getCreateTime());
						shopCart.setProductId(cart.getProductId());
						shopCart.setId(cart.getId());
						
						//查询商品信息
						String productFieldList = "product_name,image_url,shop_id,state";
						ProductInfo productInfo = productInfoService.queryProductInfoByProductId(cart.getProductId(),productFieldList);
						if(productInfo != null){
							shopCart.setProductName(productInfo.getProductName());
							shopCart.setImageUrl(productInfo.getImageUrl());//默认是商品信息图片，正确是商品价格sku对应的图片
							shopCart.setShopId(productInfo.getShopId());
						}
						
						//查询商品价格信息
						String priceFieldList = "id,retail_price,profit_third,quantity";
						ProductPrice productPrice = productPriceService.queryProductPrice(cart.getProductId(), cart.getSku(),priceFieldList,null);
						if(productPrice != null){
							shopCart.setRetailPrice(productPrice.getRetailPrice());
							shopCart.setQuantity(productPrice.getQuantity());
							List<String> imageUrl = productImageService.queryProductImage(productPrice.getId());
							if(!Utils.isEmpty(imageUrl)){
								shopCart.setImageUrl(imageUrl.get(0));
							}
						}
						shopCart.setImageUrl(Utils.getImageUrl(shopCart.getImageUrl(),"?300_300"));
						//商品状态
						if(ProductStateEnum.STATE_SHELVE.key().equals(productInfo.getState()+"")){
							shopCart.setProductState(1);
							shopCart.setProductStateValue("上架");
							if(cart.getProductNumber() > productPrice.getQuantity()){
								shopCart.setProductState(3);
								shopCart.setProductStateValue("库存不够");
							}
						}else{
							shopCart.setProductState(2);
							shopCart.setProductStateValue("下架");
						}
						//保存店铺购物车
						shopCartList.add(shopCart);
					}
					
					S1011ResponseEntity resEntity = new S1011ResponseEntity();
					resEntity.setShopId(shopId);	//店铺ID
					ShopInfo shopInfo = shopInfoService.queryShopInfoById(shopId, "id,shop_name,shop_logo");
					if(shopInfo != null){
						resEntity.setShopName(shopInfo.getShopName());	//店铺名称
						resEntity.setShopLogo(shopInfo.getShopLogo());//log
					}
					resEntity.setEndAddCartTime(listCart.get(0).getCreateTime());	//店铺最后一次加入购物车时间
					resEntity.setShopCarts(shopCartList);//店铺购物车列表
					list.add(resEntity);
				}
			}
			res.setList(list);
			res.setCurrentPage(entity.getCurrentPage());
			res.setLimit(entity.getLimit());
			res.setTotalRecord(totalCount);
			return getAppResponseEntity(res);
		}
	}
	

}
