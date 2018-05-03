package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.ICheatRecordService;
import cn.xinmeng.api.dao.auto.CheatRecordDao;
import cn.xinmeng.api.entity.auto.CheatRecord;
import cn.xinmeng.api.entity.auto.example.CheatRecordExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：CheatRecordServiceImpl
 * 描述：优惠买单作弊记录表
 * @author jiangyong.tan
 * @date 2016-08-16 10:49:55
 */
@Service("cheatRecordService")
public class CheatRecordServiceImpl implements ICheatRecordService {

    @Resource
	private CheatRecordDao cheatRecordDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CheatRecord record){
    	return cheatRecordDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return cheatRecordDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CheatRecord record){
		return cheatRecordDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CheatRecord selectByPrimaryKey(Integer id){
    	return cheatRecordDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CheatRecordExample example){
		return cheatRecordDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CheatRecord> selectByExample(CheatRecordExample example){
    	return cheatRecordDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CheatRecord> selectByExample(int currentPage, int limit,CheatRecordExample example){
        return cheatRecordDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}