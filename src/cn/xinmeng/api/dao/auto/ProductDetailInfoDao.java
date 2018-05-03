package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.example.ProductDetailInfoExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ProductDetailInfoDao
 * 描述：商品详细信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:16
 */
public interface ProductDetailInfoDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductDetailInfoExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ProductDetailInfoExample example);
    
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
    public int insert(ProductDetailInfo record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ProductDetailInfo> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductDetailInfo> selectByExample(ProductDetailInfoExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ProductDetailInfo> selectByExample(RowBounds rowBounds,ProductDetailInfoExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductDetailInfo selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ProductDetailInfo record, @Param("example") ProductDetailInfoExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ProductDetailInfo record, @Param("example") ProductDetailInfoExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ProductDetailInfo record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductDetailInfo record);
}