package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerExtensionAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerExtensionAmountDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerExtensionAmountDetailDao
 * 描述：推广资金账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:26
 */
public interface CustomerExtensionAmountDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerExtensionAmountDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerExtensionAmountDetailExample example);
    
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
    public int insert(CustomerExtensionAmountDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerExtensionAmountDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerExtensionAmountDetail> selectByExample(CustomerExtensionAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerExtensionAmountDetail> selectByExample(RowBounds rowBounds,CustomerExtensionAmountDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerExtensionAmountDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerExtensionAmountDetail record, @Param("example") CustomerExtensionAmountDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerExtensionAmountDetail record, @Param("example") CustomerExtensionAmountDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerExtensionAmountDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerExtensionAmountDetail record);
}