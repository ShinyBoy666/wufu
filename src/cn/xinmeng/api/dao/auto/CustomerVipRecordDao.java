package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.CustomerVipRecord;
import cn.xinmeng.api.entity.auto.example.CustomerVipRecordExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：CustomerVipRecordDao
 * 描述：会员开通记录表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:53
 */
public interface CustomerVipRecordDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerVipRecordExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(CustomerVipRecordExample example);
    
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
    public int insert(CustomerVipRecord record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<CustomerVipRecord> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerVipRecord> selectByExample(CustomerVipRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<CustomerVipRecord> selectByExample(RowBounds rowBounds,CustomerVipRecordExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerVipRecord selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") CustomerVipRecord record, @Param("example") CustomerVipRecordExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") CustomerVipRecord record, @Param("example") CustomerVipRecordExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(CustomerVipRecord record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerVipRecord record);
}