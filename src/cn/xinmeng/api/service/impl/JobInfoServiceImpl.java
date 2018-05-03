package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.JobInfoDao;
import cn.xinmeng.api.entity.auto.JobInfo;
import cn.xinmeng.api.entity.auto.example.JobInfoExample;
import cn.xinmeng.api.service.IJobInfoService;

/**
 * 业务层：JobInfoServiceImpl
 * 描述：任务信息列表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:10
 */
@Service("jobInfoService")
public class JobInfoServiceImpl implements IJobInfoService {

    @Resource
	private JobInfoDao jobInfoDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(JobInfo record){
    	return jobInfoDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return jobInfoDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(JobInfo record){
		return jobInfoDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public JobInfo selectByPrimaryKey(Integer id){
    	return jobInfoDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(JobInfoExample example){
		return jobInfoDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<JobInfo> selectByExample(JobInfoExample example){
    	return jobInfoDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<JobInfo> selectByExample(int currentPage, int limit,JobInfoExample example){
        return jobInfoDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}