package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ShopPostageConfig;
import cn.xinmeng.api.entity.auto.example.ShopPostageConfigExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ShopPostageConfigDao
 * 描述：店铺邮费配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:28
 */
public interface ShopPostageConfigDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopPostageConfigExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ShopPostageConfigExample example);
    
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
    public int insert(ShopPostageConfig record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ShopPostageConfig> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopPostageConfig> selectByExample(ShopPostageConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ShopPostageConfig> selectByExample(RowBounds rowBounds,ShopPostageConfigExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopPostageConfig selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ShopPostageConfig record, @Param("example") ShopPostageConfigExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ShopPostageConfig record, @Param("example") ShopPostageConfigExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ShopPostageConfig record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopPostageConfig record);
}