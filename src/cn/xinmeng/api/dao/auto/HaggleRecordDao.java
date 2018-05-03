package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.HaggleRecord;
import cn.xinmeng.api.entity.auto.example.HaggleRecordExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：HaggleRecordDao
 * 描述：砍价活动记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:03
 */
public interface HaggleRecordDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HaggleRecordExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(HaggleRecordExample example);
    
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
    public int insert(HaggleRecord record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<HaggleRecord> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HaggleRecord> selectByExample(HaggleRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<HaggleRecord> selectByExample(RowBounds rowBounds,HaggleRecordExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HaggleRecord selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") HaggleRecord record, @Param("example") HaggleRecordExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") HaggleRecord record, @Param("example") HaggleRecordExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(HaggleRecord record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HaggleRecord record);
}