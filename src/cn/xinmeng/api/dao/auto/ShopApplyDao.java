package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ShopApply;
import cn.xinmeng.api.entity.auto.example.ShopApplyExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ShopApplyDao
 * 描述：s_shop_apply
 * @author jiangyong.tan
 * @date 2016-12-20 15:34:35
 */
public interface ShopApplyDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopApplyExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ShopApplyExample example);
    
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
    public int insert(ShopApply record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ShopApply> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopApply> selectByExample(ShopApplyExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ShopApply> selectByExample(RowBounds rowBounds,ShopApplyExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopApply selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ShopApply record, @Param("example") ShopApplyExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ShopApply record, @Param("example") ShopApplyExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ShopApply record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopApply record);
}