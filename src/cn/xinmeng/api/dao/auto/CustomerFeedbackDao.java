package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerFeedback;
import cn.xinmeng.api.entity.auto.example.CustomerFeedbackExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerFeedbackDao
 * 描述：客户意见反馈表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:50
 */
public interface CustomerFeedbackDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerFeedbackExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerFeedbackExample example);
    
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
    public int insert(CustomerFeedback record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerFeedback> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerFeedback> selectByExample(CustomerFeedbackExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerFeedback> selectByExample(RowBounds rowBounds,CustomerFeedbackExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerFeedback selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerFeedback record, @Param("example") CustomerFeedbackExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerFeedback record, @Param("example") CustomerFeedbackExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerFeedback record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerFeedback record);
}