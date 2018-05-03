package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerFeedbackChild;
import cn.xinmeng.api.entity.auto.example.CustomerFeedbackChildExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerFeedbackChildDao
 * 描述：客户意见反馈子表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:50
 */
public interface CustomerFeedbackChildDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerFeedbackChildExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerFeedbackChildExample example);
    
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
    public int insert(CustomerFeedbackChild record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerFeedbackChild> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerFeedbackChild> selectByExample(CustomerFeedbackChildExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerFeedbackChild> selectByExample(RowBounds rowBounds,CustomerFeedbackChildExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerFeedbackChild selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerFeedbackChild record, @Param("example") CustomerFeedbackChildExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerFeedbackChild record, @Param("example") CustomerFeedbackChildExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerFeedbackChild record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerFeedbackChild record);
}