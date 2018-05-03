package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ButtonClickLog;
import cn.xinmeng.api.entity.auto.example.ButtonClickLogExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ButtonClickLogDao
 * 描述：按钮点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:19
 */
public interface ButtonClickLogDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ButtonClickLogExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ButtonClickLogExample example);
    
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
    public int insert(ButtonClickLog record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ButtonClickLog> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ButtonClickLog> selectByExample(ButtonClickLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ButtonClickLog> selectByExample(RowBounds rowBounds,ButtonClickLogExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ButtonClickLog selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ButtonClickLog record, @Param("example") ButtonClickLogExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ButtonClickLog record, @Param("example") ButtonClickLogExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ButtonClickLog record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ButtonClickLog record);
}