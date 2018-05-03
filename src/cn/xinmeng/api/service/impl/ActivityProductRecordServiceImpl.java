package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IActivityProductRecordService;
import cn.xinmeng.api.dao.auto.ActivityProductRecordDao;
import cn.xinmeng.api.entity.auto.ActivityProductRecord;
import cn.xinmeng.api.entity.auto.example.ActivityProductRecordExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：ActivityProductRecordServiceImpl
 * 描述：活动商品数量流水表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:04
 */
@Service("activityProductRecordService")
public class ActivityProductRecordServiceImpl implements IActivityProductRecordService {

    @Resource
	private ActivityProductRecordDao activityProductRecordDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ActivityProductRecord record){
    	return activityProductRecordDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return activityProductRecordDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ActivityProductRecord record){
		return activityProductRecordDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ActivityProductRecord selectByPrimaryKey(Integer id){
    	return activityProductRecordDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ActivityProductRecordExample example){
		return activityProductRecordDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ActivityProductRecord> selectByExample(ActivityProductRecordExample example){
    	return activityProductRecordDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ActivityProductRecord> selectByExample(int currentPage, int limit,ActivityProductRecordExample example){
        return activityProductRecordDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}