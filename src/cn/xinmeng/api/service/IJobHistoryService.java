package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.JobHistory;
import cn.xinmeng.api.entity.auto.example.JobHistoryExample;
import java.util.List;

/**
 * 接口：IJobHistoryService
 * 描述：任务信息列表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:10
 */
public interface IJobHistoryService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(JobHistory record);
    
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
	public int updateByPrimaryKey(JobHistory record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public JobHistory selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(JobHistoryExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<JobHistory> selectByExample(JobHistoryExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<JobHistory> selectByExample(int currentPage, int limit,JobHistoryExample example);
}