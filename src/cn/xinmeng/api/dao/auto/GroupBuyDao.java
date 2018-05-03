package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.GroupBuy;
import cn.xinmeng.api.entity.auto.example.GroupBuyExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：GroupBuyDao
 * 描述：团购活动表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:01
 */
public interface GroupBuyDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(GroupBuyExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(GroupBuyExample example);
    
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
    public int insert(GroupBuy record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<GroupBuy> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GroupBuy> selectByExample(GroupBuyExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<GroupBuy> selectByExample(RowBounds rowBounds,GroupBuyExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GroupBuy selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") GroupBuy record, @Param("example") GroupBuyExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") GroupBuy record, @Param("example") GroupBuyExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(GroupBuy record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GroupBuy record);
}