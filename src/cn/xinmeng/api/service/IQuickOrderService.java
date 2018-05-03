package cn.xinmeng.api.service;

import java.util.Date;
import java.util.List;

import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.biz.OrderTotalBiz;
import cn.xinmeng.api.entity.auto.example.QuickOrderExample;

/**
 * 接口：IQuickOrderService
 * 描述：优惠买单订单表
 * @author jiangyong.tan
 * @date 2016-06-17 19:55:01
 */
public interface IQuickOrderService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(QuickOrder record);
    
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
	public int updateByPrimaryKey(QuickOrder record);

	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
	public int updateSelectiveByPrimaryKey(QuickOrder record);
	
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public QuickOrder selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(QuickOrderExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<QuickOrder> selectByExample(QuickOrderExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<QuickOrder> selectByExample(int currentPage, int limit,QuickOrderExample example);
    
    /**
     * 根据订单编号查询
     * @param orderId
     * @return
     */
    public QuickOrder queryByOrderId(String orderId);
    
    /**
     * 查询订单数量
     * @param date
     * @return
     */
    public Integer queryOrderCount(Date date,Integer shopId);
    

	/**
	 * 查询优惠买单统计
	 * @param shopId
	 * @param payTime
	 * @return
	 */
	public OrderTotalBiz queryQuickOrderTotal(Integer shopId, Date payTime);
}