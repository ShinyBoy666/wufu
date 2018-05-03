package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerCashbackAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerCashbackAmountDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerCashbackAmountDetailDao
 * 描述：返现账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:23
 */
public interface CustomerCashbackAmountDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerCashbackAmountDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerCashbackAmountDetailExample example);
    
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
    public int insert(CustomerCashbackAmountDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerCashbackAmountDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerCashbackAmountDetail> selectByExample(CustomerCashbackAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerCashbackAmountDetail> selectByExample(RowBounds rowBounds,CustomerCashbackAmountDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerCashbackAmountDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerCashbackAmountDetail record, @Param("example") CustomerCashbackAmountDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerCashbackAmountDetail record, @Param("example") CustomerCashbackAmountDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerCashbackAmountDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerCashbackAmountDetail record);
}