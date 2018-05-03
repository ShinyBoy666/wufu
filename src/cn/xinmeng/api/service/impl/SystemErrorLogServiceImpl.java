package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.SystemErrorLogDao;
import cn.xinmeng.api.entity.auto.SystemErrorLog;
import cn.xinmeng.api.entity.auto.example.SystemErrorLogExample;
import cn.xinmeng.api.service.ISystemErrorLogService;

/**
 * 业务层：SystemErrorLogServiceImpl
 * @author jiangyong.tan
 * 描述：系统异常日志表
 * @date 2016-01-24 14:39:11
 */
@Service("systemErrorLogService")
public class SystemErrorLogServiceImpl implements ISystemErrorLogService {

    @Resource
	private SystemErrorLogDao systemErrorLogDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemErrorLog record){
    	return systemErrorLogDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return systemErrorLogDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SystemErrorLog record){
		return systemErrorLogDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemErrorLog selectByPrimaryKey(Integer id){
    	return systemErrorLogDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(SystemErrorLogExample example){
		return systemErrorLogDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemErrorLog> selectByExample(SystemErrorLogExample example){
    	return systemErrorLogDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<SystemErrorLog> selectByExample(int currentPage, int limit,SystemErrorLogExample example){
        return systemErrorLogDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}