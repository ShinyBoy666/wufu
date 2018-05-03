package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.OrderRemind;
import cn.xinmeng.api.entity.auto.example.OrderRemindExample;
import java.util.List;

/**
 * 接口：IOrderRemindService
 * 描述：订单提醒表
 * @author jiangyong.tan
 * @date 2016-04-12 14:42:29
 */
public interface IOrderRemindService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderRemind record);
    
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
	public int updateByPrimaryKey(OrderRemind record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderRemind selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderRemindExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderRemind> selectByExample(OrderRemindExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<OrderRemind> selectByExample(int currentPage, int limit,OrderRemindExample example);
}