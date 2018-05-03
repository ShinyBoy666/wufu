package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.Banner;
import cn.xinmeng.api.entity.auto.example.BannerExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：BannerDao
 * 描述：轮播图表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:58
 */
public interface BannerDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(BannerExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(BannerExample example);
    
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
    public int insert(Banner record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<Banner> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Banner> selectByExample(BannerExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<Banner> selectByExample(RowBounds rowBounds,BannerExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Banner selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(Banner record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Banner record);
}