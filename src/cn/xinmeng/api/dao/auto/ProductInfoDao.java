package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.example.ProductInfoExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ProductInfoDao
 * 描述：商品基础信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:17
 */
public interface ProductInfoDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductInfoExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ProductInfoExample example);
    
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
    public int insert(ProductInfo record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ProductInfo> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductInfo> selectByExample(ProductInfoExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ProductInfo> selectByExample(RowBounds rowBounds,ProductInfoExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductInfo selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ProductInfo record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductInfo record);
}