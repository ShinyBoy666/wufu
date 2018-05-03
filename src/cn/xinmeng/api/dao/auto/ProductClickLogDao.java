package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ProductClickLog;
import cn.xinmeng.api.entity.auto.example.ProductClickLogExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ProductClickLogDao
 * 描述：商品点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:23
 */
public interface ProductClickLogDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductClickLogExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ProductClickLogExample example);
    
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
    public int insert(ProductClickLog record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ProductClickLog> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductClickLog> selectByExample(ProductClickLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ProductClickLog> selectByExample(RowBounds rowBounds,ProductClickLogExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductClickLog selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ProductClickLog record, @Param("example") ProductClickLogExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ProductClickLog record, @Param("example") ProductClickLogExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ProductClickLog record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductClickLog record);
}