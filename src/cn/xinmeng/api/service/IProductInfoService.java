package cn.xinmeng.api.service;

import java.util.List;
import java.util.Map;

import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.example.ProductInfoExample;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

/**
 * 接口：IProductInfoService
 * @author jiangyong.tan
 * 描述：商品基础信息表
 * @date 2016-01-24 14:39:05
 */
public interface IProductInfoService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductInfo record);
    
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
	public int updateByPrimaryKey(ProductInfo record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductInfo selectByPrimaryKey(Integer id);
    
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductInfo selectByProductId(Integer productId);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductInfoExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductInfo> selectByExample(ProductInfoExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductInfo> selectByExample(int currentPage, int limit,ProductInfoExample example);
    
    /**
	 * 查询商品信息
	 * @author jiangyong.tan
	 * @date 2015年11月17日 下午3:27:17
	 * @param productId
	 * @return
	 */
	public ProductInfo queryProductInfoByProductId(Integer productId);
    
    /**
	 * 查询商品信息
	 * @author jiangyong.tan
	 * @date 2015年11月17日 下午3:27:17
	 * @param productId
	 * @return
	 */
	public ProductInfo queryProductInfoByProductId(Integer productId,String fieldList);
	
	/**
	 * 
	 * <p class="detail"> 根据modulId查询商品集合 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午4:11:26
	 * @param modulId
	 * @return
	 */
	public List<ProductInfoVo> selectProductInfoVoByModulId(Integer modulId);
	
	/**
	 * 
	 * <p class="detail"> 商品列表 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月25日 上午10:08:38
	 * @param entity
	 * @return
	 */
	public PageInfoEntity<ProductInfoVo> selectProductInfoList(S1006RequestEntity entity);
	

	/**
	 * 云商城
	 * @param entity
	 * @return
	 */
	public PageInfoEntity<ProductInfoVo> selectHotProductInfoList(S1006RequestEntity entity);
	
	/**
	 *  查询商品店铺ID
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午10:47:35
	 * @param productIds
	 * @return
	 */
	public Map<Integer,Integer> queryShopIdByProductId(List<Integer> productIds);
	
	/**
	 * 查询商品是否需要发货
	 * @param productIds
	 * @return
	 */
	public boolean queryProductInfoIsDelivery(List<Integer> productIds);

	/**
	 * 查询商品是否需要填写身份证
	 * @param productIds
	 * @return
	 */
	public boolean queryProductInfoRealyname(List<Integer> productIds);
	

	/**
	 * 查询商品是否需要发货
	 * @param productIds
	 * @return
	 */
	public Integer queryProductInfoIsDelivery(Integer productId);
}