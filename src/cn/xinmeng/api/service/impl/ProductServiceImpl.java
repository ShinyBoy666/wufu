package cn.xinmeng.api.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.entity.auto.biz.ProductVersion;
import cn.xinmeng.api.entity.auto.biz.SystemProduct;
import cn.xinmeng.api.service.IProductService;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.ClassLoaderUtil;
import cn.xinmeng.common.util.LogManager;

@Service("productService")
public class ProductServiceImpl implements IProductService {

	/**
	 * 获取系统产品配置
	 * @return
	 */
	@SuppressWarnings("all")
	public SystemProduct getSystemProduct(){
		SystemProduct product = new SystemProduct();
		List<ProductVersion> systemProduct = new ArrayList<ProductVersion>();
		List<ProductVersion> activityProduct = new ArrayList<ProductVersion>();
		
		String path = ClassLoaderUtil.getClassPath() + "config/product.xml";
		try {
			File f = new File(path);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			List<Element> e1 = root.elements();
			for (Element e2 : e1) {
				List<Element> e3 = e2.elements();
				for (Element e4 : e3) {
					List<Element> e5 = e4.elements();
					ProductVersion version = new ProductVersion();
					version.setId(Integer.valueOf(e5.get(0).getText()));
					version.setName(e5.get(1).getText());
					version.setContent(e5.get(2).getText());
					version.setPrice(Double.parseDouble(e5.get(3).getText()));
					if("SystemProduct".equalsIgnoreCase(e2.getName())){
						systemProduct.add(version);
					}else if("ActivityProduct".equalsIgnoreCase(e2.getName())){
						activityProduct.add(version);
					}
				}
			}
		} catch (Exception e) {
			LogManager.debug(this.getClass(),"product"+path);
			throw new BusinessException(LogManager.getLogger(this.getClass()),"读取product.xml错误");
		}
		product.setActivityProduct(activityProduct);
		product.setSystemProduct(systemProduct);
		return product;
	}
}
