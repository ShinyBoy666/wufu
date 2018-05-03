package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.OrderHandleDetail;
import cn.xinmeng.api.entity.auto.example.OrderHandleDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：OrderHandleDetailDao
 * 描述：订单处理记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:09
 */
public interface OrderHandleDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(OrderHandleDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(OrderHandleDetailExample example);
    
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
    public int insert(OrderHandleDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<OrderHandleDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderHandleDetail> selectByExample(OrderHandleDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<OrderHandleDetail> selectByExample(RowBounds rowBounds,OrderHandleDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderHandleDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") OrderHandleDetail record, @Param("example") OrderHandleDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") OrderHandleDetail record, @Param("example") OrderHandleDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(OrderHandleDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderHandleDetail record);
}