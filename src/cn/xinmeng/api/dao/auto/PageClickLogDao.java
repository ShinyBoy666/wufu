package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.PageClickLog;
import cn.xinmeng.api.entity.auto.example.PageClickLogExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：PageClickLogDao
 * 描述：页面点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:23
 */
public interface PageClickLogDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(PageClickLogExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(PageClickLogExample example);
    
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
    public int insert(PageClickLog record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<PageClickLog> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<PageClickLog> selectByExample(PageClickLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<PageClickLog> selectByExample(RowBounds rowBounds,PageClickLogExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public PageClickLog selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") PageClickLog record, @Param("example") PageClickLogExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") PageClickLog record, @Param("example") PageClickLogExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(PageClickLog record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(PageClickLog record);
}