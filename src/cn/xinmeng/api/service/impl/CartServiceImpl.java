package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CartDao;
import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.biz.CartLine;
import cn.xinmeng.api.entity.auto.example.CartExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICartService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CartServiceImpl
 * @author jiangyong.tan
 * 描述：购物车表
 * @date 2016-01-24 15:01:04
 */
@Service("cartService")
public class CartServiceImpl implements ICartService {

    @Resource
	private CartDao cartDao;
    @Resource
    private IProductInfoService productInfoService;
    @Resource
    private IProductPriceService productPriceService;
    @Resource
    private ICustomerService customerService;
    
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Cart record){
    	return cartDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return cartDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByIds(List<Integer> ids){
    	CartExample example = new CartExample();
    	CartExample.Criteria criteria = example.createCriteria();
    	criteria.andIdIn(ids);
    	return cartDao.deleteByExample(example);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Cart record){
		return cartDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Cart selectByPrimaryKey(Integer id){
    	return cartDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CartExample example){
		return cartDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Cart> selectByExample(CartExample example){
    	return cartDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Cart> selectByExample(int currentPage, int limit,CartExample example){
        return cartDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     * 修改购物车商品数量
     * @author jiangyong.tan
     * @date 2016年2月18日 下午2:10:52
     * @param id
     * @param num
     * @return
     */
	public Integer updateNumById(Integer id, Integer num) {
		Cart cart = new Cart();
		cart.setId(id);
		cart.setProductNumber(num);
		return cartDao.updateSelectiveByPrimaryKey(cart);
	}
	
	
	
	/**
	 * 查询购物车信息
	 * @author jiangyong.tan
	 * @date 2016年2月19日 下午2:24:46
	 * @param carIds
	 * @param productInfoFlag
	 * @param productPriceFlag
	 * @return
	 */
	public List<CartLine> selectCartByIds(List<Integer> carIds,Integer customerId,boolean productInfoFlag,boolean productPriceFlag){
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(carIds);
		criteria.andCustomerIdEqualTo(customerId);
		List<Cart> list = cartDao.selectByExample(example);
		List<CartLine> cartLineList = new ArrayList<CartLine>();
		if(list != null && list.size() > 0){
//			boolean isNumber = customerService.isMember(customerId);
			for (Cart cart : list) {
				CartLine cartLine =  new CartLine();
				CloneUtils.cloneEntity(cart, cartLine);
				//查询商品信息
				if(productInfoFlag){
					String fieldList = "category_id,state,Is_Delivery";
					ProductInfo productInfo = productInfoService.queryProductInfoByProductId(cart.getProductId(),fieldList);
					if(productInfo != null){
						cartLine.setCategoryId(productInfo.getCategoryId());
						cartLine.setProductState(productInfo.getState());
						cartLine.setIsDelivery(productInfo.getIsDelivery());
					}
				}
				//查询商品价格信息
				if(productPriceFlag){
					String fieldList = "retail_price,id,profit_first,profit_second,profit_third,quantity";
					ProductPrice productPrice = productPriceService.queryProductPrice(cart.getProductId(), cart.getSku(), fieldList,Integer.valueOf(StateEnum.EFFECTION.key()));
					if(productPrice != null){
//						if(isNumber){
//							cartLine.setBuyPrice(UtilMoney.subtractToDouble(productPrice.getRetailPrice(), productPrice.getProfitFirst()));
//						}else{
//							cartLine.setBuyPrice(productPrice.getRetailPrice());
//						}
						cartLine.setBuyPrice(productPrice.getRetailPrice());
						cartLine.setPriceId(productPrice.getId());
						cartLine.setProfitFirst(productPrice.getProfitFirst());
						cartLine.setProfitSecond(productPrice.getProfitSecond());
						cartLine.setProfitThird(productPrice.getProfitThird());
						cartLine.setQuantity(productPrice.getQuantity());
					}
				}
				cartLineList.add(cartLine);
			}
		}
		return cartLineList;
	}
	

	/**
	 * 查询购物车信息
	 * @author jiangyong.tan
	 * @date 2016年2月19日 下午2:24:46
	 * @param carIds
	 * @param productInfoFlag
	 * @param productPriceFlag
	 * @return
	 */
	public List<CartLine> selectCartByProductId(Integer productId,String sku,Integer customerId,Integer productNumber){
//		boolean isNumber = customerService.isMember(customerId);
		CartLine cartLine =  new CartLine();
		//查询商品信息
		String fieldList = "category_id,state,is_Delivery";
		ProductInfo productInfo = productInfoService.queryProductInfoByProductId(productId,fieldList);
		if(productInfo == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCTINFO_NOT_EXITS);
		}
		cartLine.setCategoryId(productInfo.getCategoryId());
		cartLine.setProductState(productInfo.getState());
		cartLine.setIsDelivery(productInfo.getIsDelivery());
		//查询商品价格信息
		fieldList = "retail_price,id,profit_first,profit_second,profit_third,quantity";
		ProductPrice productPrice = productPriceService.queryProductPrice(productId, sku, fieldList,Integer.valueOf(StateEnum.EFFECTION.key()));
		if(productPrice == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExProductEnum.PRODUCTPRICE_NOT_EXITS);
		}
//		if(isNumber){
//			cartLine.setBuyPrice(UtilMoney.subtractToDouble(productPrice.getRetailPrice(), productPrice.getProfitFirst()));
//		}else{
//			cartLine.setBuyPrice(productPrice.getRetailPrice());
//		}
		cartLine.setBuyPrice(productPrice.getRetailPrice());
		cartLine.setProductId(productId);
		cartLine.setCustomerId(customerId);
		cartLine.setSku(sku);
		cartLine.setProductNumber(productNumber);
		cartLine.setPriceId(productPrice.getId());
		cartLine.setProfitFirst(productPrice.getProfitFirst());
		cartLine.setProfitSecond(productPrice.getProfitSecond());
		cartLine.setProfitThird(productPrice.getProfitThird());
		cartLine.setQuantity(productPrice.getQuantity());
		List<CartLine> list = new ArrayList<CartLine>();
		list.add(cartLine);
		return list;
	}
	
	
	/**
	 *  查询购物车商品数量
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:27:45
	 * @param customerId
	 * @return
	 */
	public Integer searchCartProductCount(Integer customerId,Integer shopId){
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		example.setFieldList("IFNULL(SUM(product_number),0) as product_number");
		criteria.andCustomerIdEqualTo(customerId);
		
		List<Cart> list = cartDao.selectByExample(example);
		if(!Utils.isEmpty(list) && !Utils.isEmpty(list.get(0).getProductNumber())){
			return list.get(0).getProductNumber();
		}
		return 0;
	}
	
	/**
	 * 购物车信息
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午10:25:09
	 * @param cartIds
	 * @return
	 */
	public List<Cart> searchCartByCartIds(List<Integer> cartIds){
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(cartIds);
		return cartDao.selectByExample(example);
	}
	
	
	/**
	 *  查询店铺商品ID
	 * @author jiangyong.tan
	 * @date 2016年2月26日 下午4:43:05
	 * @param customerId
	 * @param productId
	 * @return
	 */
	public Cart queryCartByProductId(Integer customerId,Integer shopId,Integer productId,String sku){
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(customerId);
		criteria.andProductIdEqualTo(productId);
//		criteria.andShopIdEqualTo(shopId);
		criteria.andSkuEqualTo(sku);
		List<Cart> list = cartDao.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}