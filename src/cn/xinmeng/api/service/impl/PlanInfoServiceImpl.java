package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.PlanInfoDao;
import cn.xinmeng.api.entity.auto.PlanInfo;
import cn.xinmeng.api.entity.auto.example.PlanInfoExample;
import cn.xinmeng.api.service.IPlanInfoService;

/**
 * 业务层：PlanInfoServiceImpl
 * @author jiangyong.tan
 * 描述：计划信息列表
 * @date 2016-01-24 14:38:55
 */
@Service("planInfoService")
public class PlanInfoServiceImpl implements IPlanInfoService {

    @Resource
	private PlanInfoDao planInfoDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(PlanInfo record){
    	return planInfoDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return planInfoDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(PlanInfo record){
		return planInfoDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public PlanInfo selectByPrimaryKey(Integer id){
    	return planInfoDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(PlanInfoExample example){
		return planInfoDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<PlanInfo> selectByExample(PlanInfoExample example){
    	return planInfoDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<PlanInfo> selectByExample(int currentPage, int limit,PlanInfoExample example){
        return planInfoDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}