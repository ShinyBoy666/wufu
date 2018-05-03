package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CheatRecord;
import cn.xinmeng.api.entity.auto.example.CheatRecordExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CheatRecordDao
 * 描述：优惠买单作弊记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:08
 */
public interface CheatRecordDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CheatRecordExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CheatRecordExample example);
    
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
    public int insert(CheatRecord record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CheatRecord> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CheatRecord> selectByExample(CheatRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CheatRecord> selectByExample(RowBounds rowBounds,CheatRecordExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CheatRecord selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CheatRecord record, @Param("example") CheatRecordExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CheatRecord record, @Param("example") CheatRecordExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CheatRecord record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CheatRecord record);
}