package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.JobHistory;
import cn.xinmeng.api.entity.auto.example.JobHistoryExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：JobHistoryDao
 * 描述：任务信息列表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:55
 */
public interface JobHistoryDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(JobHistoryExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(JobHistoryExample example);
    
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
    public int insert(JobHistory record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<JobHistory> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<JobHistory> selectByExample(JobHistoryExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<JobHistory> selectByExample(RowBounds rowBounds,JobHistoryExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public JobHistory selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") JobHistory record, @Param("example") JobHistoryExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") JobHistory record, @Param("example") JobHistoryExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(JobHistory record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(JobHistory record);
}