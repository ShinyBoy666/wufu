package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.GroupBuy;
import cn.xinmeng.api.entity.auto.example.GroupBuyExample;
import java.util.List;

/**
 * 接口：IGroupBuyService
 * 描述：团购活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:06
 */
public interface IGroupBuyService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GroupBuy record);
    
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
	public int updateByPrimaryKey(GroupBuy record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GroupBuy selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(GroupBuyExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GroupBuy> selectByExample(GroupBuyExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GroupBuy> selectByExample(int currentPage, int limit,GroupBuyExample example);
}