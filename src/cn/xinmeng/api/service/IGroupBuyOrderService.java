package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.GroupBuyOrder;
import cn.xinmeng.api.entity.auto.example.GroupBuyOrderExample;
import java.util.List;

/**
 * 接口：IGroupBuyOrderService
 * 描述：团购订单表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
public interface IGroupBuyOrderService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GroupBuyOrder record);
    
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
	public int updateByPrimaryKey(GroupBuyOrder record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GroupBuyOrder selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(GroupBuyOrderExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GroupBuyOrder> selectByExample(GroupBuyOrderExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GroupBuyOrder> selectByExample(int currentPage, int limit,GroupBuyOrderExample example);
}