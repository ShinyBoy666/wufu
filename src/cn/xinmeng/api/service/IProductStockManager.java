package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.biz.CartLine;
import cn.xinmeng.api.entity.auto.biz.ProductBasicInfo;

/**
 * 接口：IProductStockService
 * @author jiangyong.tan
 * 描述：商品库存
 * @date 2016-01-24 14:38:48
 */
public interface IProductStockManager {
	
	/**
	 *  加减库存（第三方调用）
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午1:47:51
	 * @param productBasicInfos
	 * @return
	 */
	public void addAndSubStock(List<ProductBasicInfo>  productBasicInfos);
	
	/**
	 *  加库存（java项目，内部调用）
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午2:28:02
	 * @param cartList
	 */
	public void addStock(List<CartLine> cartList,Integer changeType);
	
	/**
	 *  减库存（java项目，内部调用）
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午2:28:02
	 * @param cartList
	 */
	public void subStock(List<CartLine> cartList,Integer changeType);
}
