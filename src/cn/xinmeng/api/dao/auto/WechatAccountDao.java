package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.WechatAccount;
import cn.xinmeng.api.entity.auto.example.WechatAccountExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：WechatAccountDao
 * 描述：客户微信信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:54
 */
public interface WechatAccountDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(WechatAccountExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(WechatAccountExample example);
    
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
    public int insert(WechatAccount record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<WechatAccount> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<WechatAccount> selectByExample(WechatAccountExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<WechatAccount> selectByExample(RowBounds rowBounds,WechatAccountExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public WechatAccount selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") WechatAccount record, @Param("example") WechatAccountExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") WechatAccount record, @Param("example") WechatAccountExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(WechatAccount record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(WechatAccount record);
}