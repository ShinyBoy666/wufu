package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ShopImage;
import cn.xinmeng.api.entity.auto.example.ShopImageExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ShopImageDao
 * 描述：门店图片表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:27
 */
public interface ShopImageDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopImageExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ShopImageExample example);
    
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
    public int insert(ShopImage record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ShopImage> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopImage> selectByExample(ShopImageExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ShopImage> selectByExample(RowBounds rowBounds,ShopImageExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopImage selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ShopImage record, @Param("example") ShopImageExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ShopImage record, @Param("example") ShopImageExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ShopImage record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopImage record);
}