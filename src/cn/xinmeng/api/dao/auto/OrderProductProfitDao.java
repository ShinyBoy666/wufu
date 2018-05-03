package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.OrderProductProfit;
import cn.xinmeng.api.entity.auto.example.OrderProductProfitExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：OrderProductProfitDao
 * 描述：订单商品利润分配信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:10
 */
public interface OrderProductProfitDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderProductProfitExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(OrderProductProfitExample example);
    
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
    public int insert(OrderProductProfit record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<OrderProductProfit> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderProductProfit> selectByExample(OrderProductProfitExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<OrderProductProfit> selectByExample(RowBounds rowBounds,OrderProductProfitExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderProductProfit selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") OrderProductProfit record, @Param("example") OrderProductProfitExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") OrderProductProfit record, @Param("example") OrderProductProfitExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(OrderProductProfit record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderProductProfit record);
}