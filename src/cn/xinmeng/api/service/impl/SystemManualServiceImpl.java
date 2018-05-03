package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.SystemManualDao;
import cn.xinmeng.api.entity.auto.SystemManual;
import cn.xinmeng.api.entity.auto.example.SystemManualExample;
import cn.xinmeng.api.service.ISystemManualService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：SystemManualServiceImpl
 * 描述：系统操作手册
 * @author jiangyong.tan
 * @date 2016-04-21 15:36:59
 */
@Service("systemManualService")
public class SystemManualServiceImpl implements ISystemManualService {

    @Resource
	private SystemManualDao systemManualDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemManual record){
    	return systemManualDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return systemManualDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SystemManual record){
		return systemManualDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemManual selectByPrimaryKey(Integer id){
    	return systemManualDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(SystemManualExample example){
		return systemManualDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemManual> selectByExample(SystemManualExample example){
    	return systemManualDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<SystemManual> selectByExample(int currentPage, int limit,SystemManualExample example){
        return systemManualDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    /**
     * 查询内容id
     * @param id
     * @return
     */
    public String queryContentById(Integer id){
    	if(Utils.isEmpty(id)){
    		return "";
    	}
    	SystemManual manual = selectByPrimaryKey(id);
    	if(Utils.isEmpty(manual)){
    		return "";
    	}
    	return manual.getContent();
    }
}