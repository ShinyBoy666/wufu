package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.HomepageSetting;
import cn.xinmeng.api.entity.auto.example.HomepageSettingExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：HomepageSettingDao
 * 描述：主页配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:04
 */
public interface HomepageSettingDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HomepageSettingExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(HomepageSettingExample example);
    
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
    public int insert(HomepageSetting record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<HomepageSetting> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageSetting> selectByExample(HomepageSettingExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<HomepageSetting> selectByExample(RowBounds rowBounds,HomepageSettingExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageSetting selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") HomepageSetting record, @Param("example") HomepageSettingExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") HomepageSetting record, @Param("example") HomepageSettingExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(HomepageSetting record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HomepageSetting record);
}