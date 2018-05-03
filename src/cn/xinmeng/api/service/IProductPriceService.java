package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.biz.ProductBasicInfo;
import cn.xinmeng.api.entity.auto.example.ProductPriceExample;

/**
 * 接口：IProductPriceService
 * @author jiangyong.tan
 * 描述：商品价格表
 * @date 2016-01-24 14:39:05
 */
public interface IProductPriceService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductPrice record);
    
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
	public int updateByPrimaryKey(ProductPrice record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductPrice selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductPriceExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductPrice> selectByExample(ProductPriceExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductPrice> selectByExample(int currentPage, int limit,ProductPriceExample example);
    
	/**
	 * 根据商品ID与sku查询商品价格信息
	 * @param productId
	 * @param skuValuesText
	 * @return
	 */
	public ProductPrice queryProductPrice(Integer productId,String skuValuesText);
	
	/**
	 * 根据商品ID与sku查询商品价格信息
	 * @param productId
	 * @param skuValuesText
	 * @param fieldList
	 * @return
	 */
	public ProductPrice queryProductPrice(Integer productId,String skuValuesText,String fieldList,Integer state);
	
	/**
	 *  查询商品零售价格
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午10:33:19
	 * @param productId
	 * @param skuValuesText
	 * @return
	 */
	public Double queryRetailPriceByProductId(Integer productId,String skuValuesText);
	
	/**
	 *  加减库存
	 * @author jiangyong.tan
	 * @date 2016年2月24日 下午1:47:51
	 * @param productBasicInfos
	 * @return
	 */
	public void addAndSubStock(List<ProductBasicInfo>  productBasicInfos);
	
	/**
     * 根据商品编号查询
     * @param productId
     * @return
     */
    public List<ProductPrice> selectByProductId(Integer productId);
}