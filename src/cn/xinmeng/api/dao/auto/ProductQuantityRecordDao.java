package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ProductQuantityRecord;
import cn.xinmeng.api.entity.auto.example.ProductQuantityRecordExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ProductQuantityRecordDao
 * 描述：商品数量流水记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:18
 */
public interface ProductQuantityRecordDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductQuantityRecordExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ProductQuantityRecordExample example);
    
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
    public int insert(ProductQuantityRecord record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ProductQuantityRecord> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductQuantityRecord> selectByExample(ProductQuantityRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ProductQuantityRecord> selectByExample(RowBounds rowBounds,ProductQuantityRecordExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductQuantityRecord selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ProductQuantityRecord record, @Param("example") ProductQuantityRecordExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ProductQuantityRecord record, @Param("example") ProductQuantityRecordExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ProductQuantityRecord record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductQuantityRecord record);
}