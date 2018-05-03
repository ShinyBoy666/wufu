package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ShopAccountConfig;
import cn.xinmeng.api.entity.auto.example.ShopAccountConfigExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ShopAccountConfigDao
 * 描述：店铺账户配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:25
 */
public interface ShopAccountConfigDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopAccountConfigExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ShopAccountConfigExample example);
    
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
    public int insert(ShopAccountConfig record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ShopAccountConfig> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopAccountConfig> selectByExample(ShopAccountConfigExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ShopAccountConfig> selectByExample(RowBounds rowBounds,ShopAccountConfigExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopAccountConfig selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ShopAccountConfig record, @Param("example") ShopAccountConfigExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ShopAccountConfig record, @Param("example") ShopAccountConfigExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ShopAccountConfig record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopAccountConfig record);
}