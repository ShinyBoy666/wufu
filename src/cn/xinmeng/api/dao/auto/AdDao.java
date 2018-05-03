package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.Ad;
import cn.xinmeng.api.entity.auto.example.AdExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：AdDao
 * 描述：广告管理
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:58
 */
public interface AdDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(AdExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(AdExample example);
    
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
    public int insert(Ad record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<Ad> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Ad> selectByExample(AdExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<Ad> selectByExample(RowBounds rowBounds,AdExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Ad selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(Ad record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Ad record);
}