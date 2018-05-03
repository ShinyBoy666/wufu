package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.SystemManual;
import cn.xinmeng.api.entity.auto.example.SystemManualExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：SystemManualDao
 * 描述：系统操作手册
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:30
 */
public interface SystemManualDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SystemManualExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(SystemManualExample example);
    
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
    public int insert(SystemManual record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<SystemManual> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemManual> selectByExample(SystemManualExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<SystemManual> selectByExample(RowBounds rowBounds,SystemManualExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemManual selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") SystemManual record, @Param("example") SystemManualExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") SystemManual record, @Param("example") SystemManualExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(SystemManual record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SystemManual record);
}