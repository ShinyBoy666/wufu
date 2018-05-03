package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.OrderHandleDetail;
import cn.xinmeng.api.entity.auto.example.OrderHandleDetailExample;
import java.util.List;

/**
 * 接口：IOrderHandleDetailService
 * 描述：订单处理记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:09
 */
public interface IOrderHandleDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderHandleDetail record);
    
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
	public int updateByPrimaryKey(OrderHandleDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderHandleDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderHandleDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderHandleDetail> selectByExample(OrderHandleDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<OrderHandleDetail> selectByExample(int currentPage, int limit,OrderHandleDetailExample example);
}