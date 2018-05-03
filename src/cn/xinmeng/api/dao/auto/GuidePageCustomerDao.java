package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.GuidePageCustomer;
import cn.xinmeng.api.entity.auto.example.GuidePageCustomerExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：GuidePageCustomerDao
 * 描述：用户引导记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:21
 */
public interface GuidePageCustomerDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(GuidePageCustomerExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(GuidePageCustomerExample example);
    
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
    public int insert(GuidePageCustomer record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<GuidePageCustomer> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GuidePageCustomer> selectByExample(GuidePageCustomerExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<GuidePageCustomer> selectByExample(RowBounds rowBounds,GuidePageCustomerExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GuidePageCustomer selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") GuidePageCustomer record, @Param("example") GuidePageCustomerExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") GuidePageCustomer record, @Param("example") GuidePageCustomerExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(GuidePageCustomer record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GuidePageCustomer record);
}