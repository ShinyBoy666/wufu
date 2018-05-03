package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.ProductImage;
import cn.xinmeng.api.entity.auto.example.ProductImageExample;

/**
 * 接口：IProductImageService
 * @author jiangyong.tan
 * 描述：商品图片表
 * @date 2016-01-24 14:39:05
 */
public interface IProductImageService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductImage record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductImage record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductImage selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductImageExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductImage> selectByExample(ProductImageExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductImage> selectByExample(int currentPage, int limit,ProductImageExample example);
    
    /**
     * 查询商品价格图片
     * @param productId
     * @param sku
     * @return
     */
    public List<String> queryProductImage(Integer priceId);
    
    /**
     * 查询商品图片
     * @param listPriceId
     * @return
     */
    public List<String> queryProductImage(List<Integer> listPriceId);
}