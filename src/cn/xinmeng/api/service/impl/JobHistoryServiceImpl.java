package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.JobHistoryDao;
import cn.xinmeng.api.entity.auto.JobHistory;
import cn.xinmeng.api.entity.auto.example.JobHistoryExample;
import cn.xinmeng.api.service.IJobHistoryService;

/**
 * 业务层：JobHistoryServiceImpl
 * 描述：任务信息列表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:10
 */
@Service("jobHistoryService")
public class JobHistoryServiceImpl implements IJobHistoryService {

    @Resource
	private JobHistoryDao jobHistoryDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(JobHistory record){
    	return jobHistoryDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return jobHistoryDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(JobHistory record){
		return jobHistoryDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public JobHistory selectByPrimaryKey(Integer id){
    	return jobHistoryDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(JobHistoryExample example){
		return jobHistoryDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<JobHistory> selectByExample(JobHistoryExample example){
    	return jobHistoryDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<JobHistory> selectByExample(int currentPage, int limit,JobHistoryExample example){
        return jobHistoryDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}