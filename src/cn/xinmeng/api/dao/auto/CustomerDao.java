package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.example.CustomerExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerDao
 * 描述：客户基本信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:47
 */
public interface CustomerDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerExample example);
    
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
    public int insert(Customer record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<Customer> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Customer> selectByExample(CustomerExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<Customer> selectByExample(RowBounds rowBounds,CustomerExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Customer selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(Customer record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Customer record);
}