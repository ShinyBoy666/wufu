package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.OrderProduct;
import cn.xinmeng.api.entity.auto.example.OrderProductExample;
import cn.xinmeng.web.shop.entity.order.vo.OrderProductVO;

/**
 * 接口：IOrderProductService
 * @author jiangyong.tan
 * 描述：订单商品表
 * @date 2016-01-24 14:39:01
 */
public interface IOrderProductService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderProduct record);

    /**
     * 添加数据
     * @param list
     * @return
     */
    public int addAll(List<OrderProduct> list);
    
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
	public int updateByPrimaryKey(OrderProduct record);

    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @return
     */
	public int updateByExampleSelective(OrderProduct record,OrderProductExample example);
	
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderProduct selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderProductExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderProduct> selectByExample(OrderProductExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<OrderProduct> selectByExample(int currentPage, int limit,OrderProductExample example);
    
    /**
	 * 根据订单，查询订单产品信息
	 * @param orderId
	 * @return
	 */
	public List<OrderProduct> queryOrderProductByOrderId(String orderId);
	
	/**
	 *  查询订单商品
	 * @author jiangyong.tan
	 * @date 2016年2月29日 下午4:51:52
	 * @param orderId
	 * @return
	 */
	public List<OrderProductVO> queryOrderProductVoByOrderId(String orderId);
	

	/**
	 * 获取订单商品id
	 * @param orderId
	 * @return
	 */
	public Integer getOrderProductId(String orderId);
	

	/**
	 * 获取商品信息
	 * @param orderId
	 * @return
	 */
	public OrderProduct getOrderProduct(String orderId,String fieldList);
	
}