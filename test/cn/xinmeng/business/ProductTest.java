package cn.xinmeng.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import cn.xinmeng.OrderHelper;
import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.ProductImage;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.service.IProductDetailInfoService;
import cn.xinmeng.api.service.IProductImageService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.api.service.IProductPriceService;
import cn.xinmeng.base.BaseTest;

public class ProductTest extends BaseTest {
	
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IProductPriceService productPriceService;
	@Resource
	private IProductImageService productImageService;
	@Resource
	private IProductDetailInfoService productDetailInfoService;
	
	@Test
	public void addProduct() {
		String context = OrderHelper.readTxtFile("/Users/tanjiangyong/product.txt");
		List<String> listProductName = OrderHelper.getProductName(context);
		List<String> listProductPrice = OrderHelper.getProductPrice(context);
		List<String> listProductInfnImage = OrderHelper.getProductInfoImage(context);
		List<List<String>> listProductImage = OrderHelper.getProductImage(context);
		
		Date curr = new Date();
		String api="api";
		
		for (int i = 0; i < listProductImage.size(); i++) {
			Integer productId = 100000+i;
			String productName = listProductName.get(i);
			String imageUrl = listProductInfnImage.get(i);
			List<String> imageUrlList = listProductImage.get(i);
			Double price = Double.parseDouble(listProductPrice.get(i).trim());
			ProductInfo productInfo = new ProductInfo();
			productInfo.setBuyCount(100);
			productInfo.setCategoryId(33);
			productInfo.setCreateTime(curr);
			productInfo.setCreateUser(api);
			productInfo.setHot(1);
			productInfo.setImageUrl(imageUrl);
			productInfo.setIsDelivery(1);
			productInfo.setMarketPrice(price);
			productInfo.setMetaKeywords(productName);
			productInfo.setPraiseCount(100);
			productInfo.setProductId(productId);
			productInfo.setProductIntroduction(productName);
			productInfo.setProductName(productName);
			productInfo.setRetailPrice(price);
			productInfo.setShopId(1);
			productInfo.setSort(1);
			productInfo.setState(3);//上架
			productInfo.setUpdateTime(curr);
			productInfo.setUpdateUser(api);
			productInfo.setViewCount(100000);
			productInfo.setVipPrice(price-7);
			productInfoService.add(productInfo);
			
			ProductDetailInfo detail = new ProductDetailInfo();
			detail.setCreateTime(curr);
			detail.setCreateUser(api);
			detail.setDescription(productName);
			detail.setProductId(productId);
			detail.setSpecifications(productName);
			detail.setUpdateTime(curr);
			detail.setUpdateUser(api);
			productDetailInfoService.add(detail);
			
			ProductPrice productPrice = new ProductPrice();
			productPrice.setBarCode(productId+"");
			productPrice.setCreateTime(curr);
			productPrice.setCreateUser(api);
			productPrice.setMarketPrice(price);
			productPrice.setProductId(productId);
			productPrice.setProfitFirst(1.00);
			productPrice.setProfitSecond(2.00);
			productPrice.setProfitThird(7.00);
			productPrice.setQuantity(100000);
			productPrice.setRetailPrice(price);
			productPrice.setScore(0);
			productPrice.setShopId(1);
			productPrice.setSku("|默认|");
			productPrice.setUpdateTime(curr);
			productPrice.setUpdateUser(api);
			productPriceService.add(productPrice);
			
			if(imageUrlList != null && imageUrlList.size() > 0){
				for (String s : imageUrlList) {
					ProductPrice p = productPriceService.queryProductPrice(productId, "|默认|");
					ProductImage image = new ProductImage();
					image.setCreateTime(curr);
					image.setCreateUser(api);
					image.setImageUrl(s);
					image.setProductPriceId(p.getId());
					image.setSort(2);
					image.setState(2);
					productImageService.add(image);
				}
			}
			
		}
	}

	@Test
	public void addProductXiongzhao() {
		String context = OrderHelper.readTxtFile("/Users/tanjiangyong/xiongzhao.txt");
		List<String> listProductName = OrderHelper.getProductName(context);
		List<String> listProductPrice = OrderHelper.getProductPrice(context);
		List<String> listProductInfnImage = OrderHelper.getProductInfoImage(context);
		List<List<String>> listProductImage = OrderHelper.getProductImage(context);
		
		Date curr = new Date();
		String api="api";
		
		for (int i = 0; i < listProductImage.size(); i++) {
			Integer productId = 300000+i;
			String productName = listProductName.get(i);
			String imageUrl = listProductInfnImage.get(i);
			List<String> imageUrlList = listProductImage.get(i);
			Double price = Double.parseDouble(listProductPrice.get(i).trim());
			ProductInfo productInfo = new ProductInfo();
			productInfo.setBuyCount(100);
			productInfo.setCategoryId(2016);
			productInfo.setCreateTime(curr);
			productInfo.setCreateUser(api);
			productInfo.setHot(1);
			productInfo.setImageUrl(imageUrl);
			productInfo.setIsDelivery(1);
			productInfo.setMarketPrice(price);
			productInfo.setMetaKeywords(productName);
			productInfo.setPraiseCount(100);
			productInfo.setProductId(productId);
			productInfo.setProductIntroduction(productName);
			productInfo.setProductName(productName);
			productInfo.setRetailPrice(price);
			productInfo.setShopId(1);
			productInfo.setSort(1);
			productInfo.setState(3);//上架
			productInfo.setUpdateTime(curr);
			productInfo.setUpdateUser(api);
			productInfo.setViewCount(100000);
			productInfo.setVipPrice(price-7);
			productInfoService.add(productInfo);
			
			ProductDetailInfo detail = new ProductDetailInfo();
			detail.setCreateTime(curr);
			detail.setCreateUser(api);
			detail.setDescription(productName);
			detail.setProductId(productId);
			detail.setSpecifications(productName);
			detail.setUpdateTime(curr);
			detail.setUpdateUser(api);
			productDetailInfoService.add(detail);
			
			ProductPrice productPrice = new ProductPrice();
			productPrice.setBarCode(productId+"");
			productPrice.setCreateTime(curr);
			productPrice.setCreateUser(api);
			productPrice.setMarketPrice(price);
			productPrice.setProductId(productId);
			productPrice.setProfitFirst(1.00);
			productPrice.setProfitSecond(2.00);
			productPrice.setProfitThird(7.00);
			productPrice.setQuantity(100000);
			productPrice.setRetailPrice(price);
			productPrice.setScore(0);
			productPrice.setShopId(1);
			productPrice.setSku("|默认|");
			productPrice.setUpdateTime(curr);
			productPrice.setUpdateUser(api);
			productPriceService.add(productPrice);
			
			if(imageUrlList != null && imageUrlList.size() > 0){
				for (String s : imageUrlList) {
					ProductPrice p = productPriceService.queryProductPrice(productId, "|默认|");
					ProductImage image = new ProductImage();
					image.setCreateTime(curr);
					image.setCreateUser(api);
					image.setImageUrl(s);
					image.setProductPriceId(p.getId());
					image.setSort(2);
					image.setState(2);
					productImageService.add(image);
				}
			}
			
		}
	}
	@Test
	public void addProductMianmo() {
		String context = OrderHelper.readTxtFile("/Users/tanjiangyong/mianmo.txt");
		List<String> listProductName = OrderHelper.getProductName(context);
		List<String> listProductPrice = OrderHelper.getProductPrice(context);
		List<String> listProductInfnImage = OrderHelper.getProductInfoImage(context);
		
		Date curr = new Date();
		String api="api";
		
		for (int i = 0; i < listProductName.size(); i++) {
			Integer productId = 200000+i;
			String productName = listProductName.get(i);
			String imageUrl = listProductInfnImage.get(i);
			Double price = Double.parseDouble(listProductPrice.get(i).trim());
			ProductInfo productInfo = new ProductInfo();
			productInfo.setBuyCount(100);
			productInfo.setCategoryId(86);
			productInfo.setCreateTime(curr);
			productInfo.setCreateUser(api);
			productInfo.setHot(1);
			productInfo.setImageUrl(imageUrl);
			productInfo.setIsDelivery(1);
			productInfo.setMarketPrice(price);
			productInfo.setMetaKeywords(productName);
			productInfo.setPraiseCount(100);
			productInfo.setProductId(productId);
			productInfo.setProductIntroduction(productName);
			productInfo.setProductName(productName);
			productInfo.setRetailPrice(price);
			productInfo.setShopId(1);
			productInfo.setSort(1);
			productInfo.setState(3);//上架
			productInfo.setUpdateTime(curr);
			productInfo.setUpdateUser(api);
			productInfo.setViewCount(100000);
			productInfo.setVipPrice(price-7);
			productInfoService.add(productInfo);
			
			ProductDetailInfo detail = new ProductDetailInfo();
			detail.setCreateTime(curr);
			detail.setCreateUser(api);
			detail.setDescription(productName);
			detail.setProductId(productId);
			detail.setSpecifications(productName);
			detail.setUpdateTime(curr);
			detail.setUpdateUser(api);
			productDetailInfoService.add(detail);
			
			ProductPrice productPrice = new ProductPrice();
			productPrice.setBarCode(productId+"");
			productPrice.setCreateTime(curr);
			productPrice.setCreateUser(api);
			productPrice.setMarketPrice(price);
			productPrice.setProductId(productId);
			productPrice.setProfitFirst(1.00);
			productPrice.setProfitSecond(2.00);
			productPrice.setProfitThird(7.00);
			productPrice.setQuantity(100000);
			productPrice.setRetailPrice(price);
			productPrice.setScore(0);
			productPrice.setShopId(1);
			productPrice.setSku("|默认|");
			productPrice.setUpdateTime(curr);
			productPrice.setUpdateUser(api);
			productPriceService.add(productPrice);
			
			ProductPrice p = productPriceService.queryProductPrice(productId, "|默认|");
			ProductImage image = new ProductImage();
			image.setCreateTime(curr);
			image.setCreateUser(api);
			image.setImageUrl(imageUrl);
			image.setProductPriceId(p.getId());
			image.setSort(2);
			image.setState(2);
			productImageService.add(image);
			
		}
	}
}
