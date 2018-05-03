package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerReport;
import cn.xinmeng.api.entity.auto.example.CustomerReportExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerReportDao
 * 描述：客户报表统计
 * @author jiangyong.tan
 * @date 2016-11-17 20:43:21
 */
public interface CustomerReportDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerReportExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerReportExample example);
    
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
    public int insert(CustomerReport record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerReport> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerReport> selectByExample(CustomerReportExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerReport> selectByExample(RowBounds rowBounds,CustomerReportExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerReport selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerReport record, @Param("example") CustomerReportExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerReport record, @Param("example") CustomerReportExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerReport record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerReport record);
}