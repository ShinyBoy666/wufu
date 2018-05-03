package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.biz.SystemProduct;

public interface IProductService {
	
	/**
	 * 获取系统产品配置
	 * @return
	 */
	public SystemProduct getSystemProduct();
}
