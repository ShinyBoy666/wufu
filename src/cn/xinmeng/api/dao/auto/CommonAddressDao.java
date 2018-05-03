package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.example.CommonAddressExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CommonAddressDao
 * 描述：客户常用地址表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:47
 */
public interface CommonAddressDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CommonAddressExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CommonAddressExample example);
    
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
    public int insert(CommonAddress record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CommonAddress> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CommonAddress> selectByExample(CommonAddressExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CommonAddress> selectByExample(RowBounds rowBounds,CommonAddressExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CommonAddress selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CommonAddress record, @Param("example") CommonAddressExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CommonAddress record, @Param("example") CommonAddressExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CommonAddress record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CommonAddress record);
}