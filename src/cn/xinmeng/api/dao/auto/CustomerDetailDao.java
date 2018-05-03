package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerDetail;
import cn.xinmeng.api.entity.auto.example.CustomerDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerDetailDao
 * 描述：客户详细信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:49
 */
public interface CustomerDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerDetailExample example);
    
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
    public int insert(CustomerDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerDetail> selectByExample(CustomerDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerDetail> selectByExample(RowBounds rowBounds,CustomerDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerDetail record, @Param("example") CustomerDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerDetail record, @Param("example") CustomerDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerDetail record);
}