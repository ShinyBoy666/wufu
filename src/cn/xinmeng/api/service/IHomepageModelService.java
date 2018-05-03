package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.HomepageModel;
import cn.xinmeng.api.entity.auto.example.HomepageModelExample;
import java.util.List;

/**
 * 接口：IHomepageModelService
 * 描述：主页配置模板表
 * @author jiangyong.tan
 * @date 2016-03-24 16:38:23
 */
public interface IHomepageModelService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HomepageModel record);
    
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
	public int updateByPrimaryKey(HomepageModel record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageModel selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HomepageModelExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageModel> selectByExample(HomepageModelExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HomepageModel> selectByExample(int currentPage, int limit,HomepageModelExample example);
}