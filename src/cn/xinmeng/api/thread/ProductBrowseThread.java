package cn.xinmeng.api.thread;

import cn.xinmeng.common.util.LogManager;

/**
 * 商品浏览量
 */
public class ProductBrowseThread implements Runnable{

	String productId;
	
	
	public ProductBrowseThread(String productId){
		this.productId = productId;
	}
	
	
	@Override
	public void run() {
		try {
			
		} catch (Exception ex) {
			LogManager.error(this.getClass(),"线程【ProductBrowseThread】异常，productId:"+productId,ex);
			
		}
	}

}
