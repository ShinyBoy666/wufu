package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.SystemLogDao;
import cn.xinmeng.api.entity.auto.SystemLog;
import cn.xinmeng.api.entity.auto.example.SystemLogExample;
import cn.xinmeng.api.service.ISystemLogService;

/**
 * 业务层：SystemLogServiceImpl
 * @author jiangyong.tan
 * 描述：系统操作日志表
 * @date 2016-01-24 14:39:11
 */
@Service("systemLogService")
public class SystemLogServiceImpl implements ISystemLogService {

    @Resource
	private SystemLogDao systemLogDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemLog record){
    	return systemLogDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return systemLogDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SystemLog record){
		return systemLogDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemLog selectByPrimaryKey(Integer id){
    	return systemLogDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(SystemLogExample example){
		return systemLogDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemLog> selectByExample(SystemLogExample example){
    	return systemLogDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<SystemLog> selectByExample(int currentPage, int limit,SystemLogExample example){
        return systemLogDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}