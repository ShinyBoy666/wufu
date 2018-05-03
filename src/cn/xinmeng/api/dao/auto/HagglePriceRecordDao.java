package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.HagglePriceRecord;
import cn.xinmeng.api.entity.auto.example.HagglePriceRecordExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：HagglePriceRecordDao
 * 描述：砍价活动价格记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:02
 */
public interface HagglePriceRecordDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HagglePriceRecordExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(HagglePriceRecordExample example);
    
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
    public int insert(HagglePriceRecord record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<HagglePriceRecord> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HagglePriceRecord> selectByExample(HagglePriceRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<HagglePriceRecord> selectByExample(RowBounds rowBounds,HagglePriceRecordExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HagglePriceRecord selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") HagglePriceRecord record, @Param("example") HagglePriceRecordExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") HagglePriceRecord record, @Param("example") HagglePriceRecordExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(HagglePriceRecord record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HagglePriceRecord record);
}