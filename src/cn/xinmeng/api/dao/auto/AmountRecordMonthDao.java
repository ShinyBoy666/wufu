package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.AmountRecordMonth;
import cn.xinmeng.api.entity.auto.example.AmountRecordMonthExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：AmountRecordMonthDao
 * 描述：客户账户金额记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:46
 */
public interface AmountRecordMonthDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(AmountRecordMonthExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(AmountRecordMonthExample example);
    
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
    public int insert(AmountRecordMonth record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<AmountRecordMonth> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<AmountRecordMonth> selectByExample(AmountRecordMonthExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<AmountRecordMonth> selectByExample(RowBounds rowBounds,AmountRecordMonthExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public AmountRecordMonth selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") AmountRecordMonth record, @Param("example") AmountRecordMonthExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") AmountRecordMonth record, @Param("example") AmountRecordMonthExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(AmountRecordMonth record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(AmountRecordMonth record);
}