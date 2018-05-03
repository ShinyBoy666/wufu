package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerComplain;
import cn.xinmeng.api.entity.auto.example.CustomerComplainExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerComplainDao
 * 描述：用户投诉
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:49
 */
public interface CustomerComplainDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerComplainExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerComplainExample example);
    
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
    public int insert(CustomerComplain record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerComplain> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerComplain> selectByExample(CustomerComplainExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerComplain> selectByExample(RowBounds rowBounds,CustomerComplainExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerComplain selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerComplain record, @Param("example") CustomerComplainExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerComplain record, @Param("example") CustomerComplainExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerComplain record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerComplain record);
}