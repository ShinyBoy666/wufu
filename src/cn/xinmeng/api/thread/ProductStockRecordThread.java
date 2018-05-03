package cn.xinmeng.api.thread;

import java.util.Date;
import java.util.List;

import cn.xinmeng.api.entity.auto.ProductQuantityRecord;
import cn.xinmeng.api.entity.auto.biz.ProductBasicInfo;
import cn.xinmeng.api.service.IProductQuantityRecordService;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;

/**
 * 商品浏览量
 */
public class ProductStockRecordThread implements Runnable{


	private IProductQuantityRecordService productQuantityRecordService;
	List<ProductBasicInfo> productBasicInfos;
	
	public ProductStockRecordThread(
			IProductQuantityRecordService productQuantityRecordService,
			List<ProductBasicInfo> productBasicInfos){
		this.productQuantityRecordService = productQuantityRecordService;
		this.productBasicInfos = productBasicInfos;
	}
	
	
	@Override
	public void run() {
		try {
			if(productBasicInfos != null && productBasicInfos.size() > 0){
				for (ProductBasicInfo basicInfo : productBasicInfos) {
					ProductQuantityRecord productPriceDetail=new ProductQuantityRecord();
					productPriceDetail.setProductId(basicInfo.getProductId());
					productPriceDetail.setSku(basicInfo.getSku());
					productPriceDetail.setProductPriceId(basicInfo.getPriceId());
					//原实际库存量
					productPriceDetail.setOldActualQuantity(basicInfo.getOldActualQuantity());
					if(basicInfo.getOperateType()==1){
						//更改的实际库存量
						productPriceDetail.setChangeActualQuantity(basicInfo.getActualProductNumber());
						productPriceDetail.setNowActualQuantity(basicInfo.getOldActualQuantity()+basicInfo.getActualProductNumber());
						//变动类型
						productPriceDetail.setChangeType(basicInfo.getChangeType());
					}else{
						//更改的实际库存量
						productPriceDetail.setChangeActualQuantity(basicInfo.getActualProductNumber());
						//更改好的实际库存量
						productPriceDetail.setNowActualQuantity(basicInfo.getOldActualQuantity()-basicInfo.getActualProductNumber());
						//变动类型
						productPriceDetail.setChangeType(basicInfo.getChangeType());
					}
					
					productPriceDetail.setRemark(basicInfo.getRemark());
					if(basicInfo.getOrderId() == null){
						productPriceDetail.setOrderId("");
					}else{
						productPriceDetail.setOrderId(basicInfo.getOrderId());
					}
					productPriceDetail.setCreateUser("api");
					productPriceDetail.setCreateTime(new Date());
					productQuantityRecordService.add(productPriceDetail);
				}
			}
		} catch (Exception ex) {
			LogManager.error(this.getClass(),"线程【ProductStockRecordThread】异常，productBasicInfos:"+FastJsonUtils.bean2Json(productBasicInfos),ex);
			
		}
	}

}
