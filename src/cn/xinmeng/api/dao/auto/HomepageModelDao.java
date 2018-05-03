package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.HomepageModel;
import cn.xinmeng.api.entity.auto.example.HomepageModelExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：HomepageModelDao
 * 描述：主页配置模板表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:03
 */
public interface HomepageModelDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HomepageModelExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(HomepageModelExample example);
    
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
    public int insert(HomepageModel record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<HomepageModel> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageModel> selectByExample(HomepageModelExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<HomepageModel> selectByExample(RowBounds rowBounds,HomepageModelExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageModel selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") HomepageModel record, @Param("example") HomepageModelExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") HomepageModel record, @Param("example") HomepageModelExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(HomepageModel record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HomepageModel record);
}