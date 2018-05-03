package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerContributionAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerContributionAmountDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerContributionAmountDetailDao
 * 描述：贡献值帐户流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:25
 */
public interface CustomerContributionAmountDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerContributionAmountDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerContributionAmountDetailExample example);
    
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
    public int insert(CustomerContributionAmountDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerContributionAmountDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerContributionAmountDetail> selectByExample(CustomerContributionAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerContributionAmountDetail> selectByExample(RowBounds rowBounds,CustomerContributionAmountDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerContributionAmountDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerContributionAmountDetail record, @Param("example") CustomerContributionAmountDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerContributionAmountDetail record, @Param("example") CustomerContributionAmountDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerContributionAmountDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerContributionAmountDetail record);
}