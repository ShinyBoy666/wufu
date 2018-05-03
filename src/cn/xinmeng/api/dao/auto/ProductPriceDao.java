package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ProductPrice;
import cn.xinmeng.api.entity.auto.example.ProductPriceExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ProductPriceDao
 * 描述：商品价格表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:17
 */
public interface ProductPriceDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductPriceExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ProductPriceExample example);
    
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
    public int insert(ProductPrice record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ProductPrice> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductPrice> selectByExample(ProductPriceExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ProductPrice> selectByExample(RowBounds rowBounds,ProductPriceExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductPrice selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ProductPrice record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductPrice record);
}