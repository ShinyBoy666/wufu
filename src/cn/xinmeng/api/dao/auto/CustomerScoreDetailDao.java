package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerScoreDetail;
import cn.xinmeng.api.entity.auto.example.CustomerScoreDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerScoreDetailDao
 * 描述：积分帐户流水表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:52
 */
public interface CustomerScoreDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerScoreDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerScoreDetailExample example);
    
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
    public int insert(CustomerScoreDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerScoreDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerScoreDetail> selectByExample(CustomerScoreDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerScoreDetail> selectByExample(RowBounds rowBounds,CustomerScoreDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerScoreDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerScoreDetail record, @Param("example") CustomerScoreDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerScoreDetail record, @Param("example") CustomerScoreDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerScoreDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerScoreDetail record);
}