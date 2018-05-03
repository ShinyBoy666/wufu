package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.AgentApply;
import cn.xinmeng.api.entity.auto.example.AgentApplyExample;
import java.util.List;

/**
 * 接口：IAgentApplyService
 * 描述：代理商申请
 * @author jiangyong.tan
 * @date 2016-05-18 17:04:42
 */
public interface IAgentApplyService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(AgentApply record);
    
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
	public int updateByPrimaryKey(AgentApply record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public AgentApply selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(AgentApplyExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<AgentApply> selectByExample(AgentApplyExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<AgentApply> selectByExample(int currentPage, int limit,AgentApplyExample example);
}