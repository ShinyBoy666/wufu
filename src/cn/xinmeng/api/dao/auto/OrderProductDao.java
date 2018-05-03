package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.OrderProduct;
import cn.xinmeng.api.entity.auto.example.OrderProductExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：OrderProductDao
 * 描述：订单商品表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:09
 */
public interface OrderProductDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderProductExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(OrderProductExample example);
    
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
    public int insert(OrderProduct record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<OrderProduct> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderProduct> selectByExample(OrderProductExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<OrderProduct> selectByExample(RowBounds rowBounds,OrderProductExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderProduct selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(OrderProduct record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderProduct record);
}