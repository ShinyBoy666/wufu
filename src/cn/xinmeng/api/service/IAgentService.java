package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.Agent;
import cn.xinmeng.api.entity.auto.example.AgentExample;
import java.util.List;

/**
 * 接口：IAgentService
 * 描述：代理商信息
 * @author jiangyong.tan
 * @date 2016-05-21 13:34:44
 */
public interface IAgentService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Agent record);
    
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
	public int updateByPrimaryKey(Agent record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Agent selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(AgentExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Agent> selectByExample(AgentExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<Agent> selectByExample(int currentPage, int limit,AgentExample example);
}