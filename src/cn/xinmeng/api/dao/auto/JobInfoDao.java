package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.JobInfo;
import cn.xinmeng.api.entity.auto.example.JobInfoExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：JobInfoDao
 * 描述：任务信息列表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:55
 */
public interface JobInfoDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(JobInfoExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(JobInfoExample example);
    
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
    public int insert(JobInfo record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<JobInfo> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<JobInfo> selectByExample(JobInfoExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<JobInfo> selectByExample(RowBounds rowBounds,JobInfoExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public JobInfo selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") JobInfo record, @Param("example") JobInfoExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") JobInfo record, @Param("example") JobInfoExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(JobInfo record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(JobInfo record);
}