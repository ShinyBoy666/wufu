package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerAmountDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerAmountDetailDao
 * 描述：现金账户金额流水表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:48
 */
public interface CustomerAmountDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerAmountDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerAmountDetailExample example);
    
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
    public int insert(CustomerAmountDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerAmountDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerAmountDetail> selectByExample(CustomerAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerAmountDetail> selectByExample(RowBounds rowBounds,CustomerAmountDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerAmountDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerAmountDetail record, @Param("example") CustomerAmountDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerAmountDetail record, @Param("example") CustomerAmountDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerAmountDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerAmountDetail record);
}