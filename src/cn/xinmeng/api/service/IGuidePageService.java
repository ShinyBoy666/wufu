package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.GuidePage;
import cn.xinmeng.api.entity.auto.example.GuidePageExample;
import java.util.List;

/**
 * 接口：IGuidePageService
 * 描述：用户引导页
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:20
 */
public interface IGuidePageService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GuidePage record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GuidePage record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GuidePage selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(GuidePageExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GuidePage> selectByExample(GuidePageExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GuidePage> selectByExample(int currentPage, int limit,GuidePageExample example);
}