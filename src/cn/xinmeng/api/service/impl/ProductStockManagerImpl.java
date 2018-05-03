package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.entity.auto.biz.CartLine;
import cn.xinmeng.api.entity.auto.biz.ProductBasicInfo;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.api.service.IProductQuantityRecordService;
import cn.xinmeng.api.service.IProductStockManager;
import cn.xinmeng.api.thread.ProductStockRecordThread;
import cn.xinmeng.common.interfaces.IOCallable;
import cn.xinmeng.common.util.Utils;
/**
 * 业务层：manager没有自动配置事物，
 * @author jiangyong.tan
 * 描述：商品库存
 * @date 2016-01-24 14:38:50
 */
@Service("productStockManager")
public class ProductStockManagerImpl implements IProductStockManager {

	@Resource
	private IProductPriceService productPriceService;
	@Resource
	private IProductQuantityRecordService productQuantityRecordService;
	@Resource
	private TaskExecutor productStockThreadPool;

	/**
	 *  加减库存
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午1:47:51
	 * @param productBasicInfos
	 * @return
	 */
	public void addAndSubStock(List<ProductBasicInfo>  productBasicInfos){
		productPriceService.addAndSubStock(productBasicInfos);
		//记录库存流水记录
		productStockThreadPool.execute(new ProductStockRecordThread(productQuantityRecordService,productBasicInfos));
	}

	/**
	 *  加库存（java项目，内部调用）
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午2:28:02
	 * @param cartList
	 */
	public void addStock(List<CartLine> cartList,final Integer changeType){
		addAndSubStock(
				Utils.converList(cartList,
						new IOCallable<CartLine, ProductBasicInfo>() {
					@Override
					public ProductBasicInfo exec(CartLine cartLine) {
						ProductBasicInfo prod = new ProductBasicInfo();
						prod.setPriceId(cartLine.getPriceId());
						prod.setOperateType(1); // 加库存
						prod.setProductId(cartLine.getProductId());
						prod.setActualProductNumber(cartLine.getProductNumber());
						prod.setCanSoldProductNumber(cartLine.getProductNumber());
						prod.setSku(cartLine.getSku());
						prod.setOrderId(cartLine.getOrderId());
						prod.setRemark(cartLine.getRemark()+" 加库存，数量："+cartLine.getProductNumber());
						prod.setChangeType(changeType); //用户下单减库存
						return prod;
					}
				}));
	}

	/**
	 *  减库存（java项目，内部调用）
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午2:28:02
	 * @param cartList
	 */
	public void subStock(List<CartLine> cartList,final Integer changeType){
		addAndSubStock(
				Utils.converList(cartList,
						new IOCallable<CartLine, ProductBasicInfo>() {
					@Override
					public ProductBasicInfo exec(CartLine cartLine) {
						ProductBasicInfo prod = new ProductBasicInfo();
						prod.setPriceId(cartLine.getPriceId());
						prod.setOperateType(2); // 减库存
						prod.setProductId(cartLine.getProductId());
						prod.setActualProductNumber(cartLine.getProductNumber());
						prod.setCanSoldProductNumber(cartLine.getProductNumber());
						prod.setSku(cartLine.getSku());
						prod.setOrderId(cartLine.getOrderId());
						prod.setRemark(cartLine.getRemark()+" 减库存，数量："+cartLine.getProductNumber());
						prod.setChangeType(changeType); //用户减库存
						return prod;
					}
				}));
	}
}
