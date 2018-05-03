package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.Agent;
import cn.xinmeng.api.entity.auto.example.AgentExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：AgentDao
 * 描述：代理商信息
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:40
 */
public interface AgentDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(AgentExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(AgentExample example);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
    
    /**
     * 添加数据（单个）
     * @param record
     * @return
     */
    public int insert(Agent record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<Agent> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Agent> selectByExample(AgentExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<Agent> selectByExample(RowBounds rowBounds,AgentExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Agent selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") Agent record, @Param("example") AgentExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") Agent record, @Param("example") AgentExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(Agent record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Agent record);
}