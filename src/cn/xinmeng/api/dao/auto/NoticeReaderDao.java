package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.NoticeReader;
import cn.xinmeng.api.entity.auto.example.NoticeReaderExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：NoticeReaderDao
 * 描述：消息用户读取记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:22
 */
public interface NoticeReaderDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(NoticeReaderExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(NoticeReaderExample example);
    
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
    public int insert(NoticeReader record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<NoticeReader> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<NoticeReader> selectByExample(NoticeReaderExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<NoticeReader> selectByExample(RowBounds rowBounds,NoticeReaderExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public NoticeReader selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") NoticeReader record, @Param("example") NoticeReaderExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") NoticeReader record, @Param("example") NoticeReaderExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(NoticeReader record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(NoticeReader record);
}