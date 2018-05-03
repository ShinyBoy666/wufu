package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.MutualFundPoolDetail;
import cn.xinmeng.api.entity.auto.example.MutualFundPoolDetailExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：MutualFundPoolDetailDao
 * 描述：互助基金池账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:07
 */
public interface MutualFundPoolDetailDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(MutualFundPoolDetailExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(MutualFundPoolDetailExample example);
    
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
    public int insert(MutualFundPoolDetail record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<MutualFundPoolDetail> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<MutualFundPoolDetail> selectByExample(MutualFundPoolDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<MutualFundPoolDetail> selectByExample(RowBounds rowBounds,MutualFundPoolDetailExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public MutualFundPoolDetail selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") MutualFundPoolDetail record, @Param("example") MutualFundPoolDetailExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") MutualFundPoolDetail record, @Param("example") MutualFundPoolDetailExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(MutualFundPoolDetail record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(MutualFundPoolDetail record);
}