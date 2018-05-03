package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.SystemErrorLog;
import cn.xinmeng.api.entity.auto.example.SystemErrorLogExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：SystemErrorLogDao
 * 描述：系统异常日志表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:29
 */
public interface SystemErrorLogDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SystemErrorLogExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(SystemErrorLogExample example);
    
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
    public int insert(SystemErrorLog record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<SystemErrorLog> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemErrorLog> selectByExample(SystemErrorLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<SystemErrorLog> selectByExample(RowBounds rowBounds,SystemErrorLogExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemErrorLog selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") SystemErrorLog record, @Param("example") SystemErrorLogExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") SystemErrorLog record, @Param("example") SystemErrorLogExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(SystemErrorLog record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SystemErrorLog record);
}