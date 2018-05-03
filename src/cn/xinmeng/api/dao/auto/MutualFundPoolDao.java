package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.MutualFundPool;
import cn.xinmeng.api.entity.auto.example.MutualFundPoolExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：MutualFundPoolDao
 * 描述：互助基金池
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:06
 */
public interface MutualFundPoolDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(MutualFundPoolExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(MutualFundPoolExample example);
    
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
    public int insert(MutualFundPool record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<MutualFundPool> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<MutualFundPool> selectByExample(MutualFundPoolExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<MutualFundPool> selectByExample(RowBounds rowBounds,MutualFundPoolExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public MutualFundPool selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") MutualFundPool record, @Param("example") MutualFundPoolExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") MutualFundPool record, @Param("example") MutualFundPoolExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(MutualFundPool record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(MutualFundPool record);
}