package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.api.entity.auto.biz.CartLine;
import cn.xinmeng.api.entity.auto.example.CartExample;

/**
 * 接口：ICartService
 * @author jiangyong.tan
 * 描述：购物车表
 * @date 2016-01-24 15:01:04
 */
public interface ICartService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Cart record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	

    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByIds(List<Integer> ids);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Cart record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Cart selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CartExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Cart> selectByExample(CartExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Cart> selectByExample(int currentPage, int limit,CartExample example);
    
    /**
     * 修改购物车商品数量
     * @author jiangyong.tan
     * @date 2016年2月18日 下午2:10:52
     * @param id
     * @param num
     * @return
     */
	public Integer updateNumById(Integer id, Integer num);
	
	/**
	 * 查询购物车信息
	 * @author jiangyong.tan
	 * @date 2016年2月19日 下午2:24:46
	 * @param cartIds
	 * @param productInfoFlag
	 * @param productPriceFlag
	 * @return
	 */
	public List<CartLine> selectCartByIds(List<Integer> cartIds,Integer customerId,boolean productInfoFlag,boolean productPriceFlag);
	
	/**
	 *  查询购物车商品数量
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:27:45
	 * @param customerId
	 * @return
	 */
	public Integer searchCartProductCount(Integer customerId,Integer loginShopId);
	
	/**
	 * 购物车信息
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午10:25:09
	 * @param cartIds
	 * @return
	 */
	public List<Cart> searchCartByCartIds(List<Integer> cartIds);
	
	/**
	 *  查询店铺商品ID
	 * @author jiangyong.tan
	 * @date 2016年2月26日 下午4:43:05
	 * @param customerId
	 * @param productId
	 * @param sku
	 * @return
	 */
	public Cart queryCartByProductId(Integer customerId,Integer shopId,Integer productId,String sku);
	
	/**
	 * 查询购物车信息
	 * @author jiangyong.tan
	 * @date 2016年2月19日 下午2:24:46
	 * @param carIds
	 * @param productInfoFlag
	 * @param productPriceFlag
	 * @return
	 */
	public List<CartLine> selectCartByProductId(Integer productId,String sku,Integer customerId,Integer productNumber);
}