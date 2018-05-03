package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.Cart;
import cn.xinmeng.api.entity.auto.example.CartExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CartDao
 * 描述：购物车表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:07
 */
public interface CartDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CartExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CartExample example);
    
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
    public int insert(Cart record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<Cart> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Cart> selectByExample(CartExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<Cart> selectByExample(RowBounds rowBounds,CartExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Cart selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(Cart record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Cart record);
}