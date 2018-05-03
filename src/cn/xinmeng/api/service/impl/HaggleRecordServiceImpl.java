package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IHaggleRecordService;
import cn.xinmeng.api.dao.auto.HaggleRecordDao;
import cn.xinmeng.api.entity.auto.HaggleRecord;
import cn.xinmeng.api.entity.auto.example.HaggleRecordExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：HaggleRecordServiceImpl
 * 描述：砍价活动记录表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:08
 */
@Service("haggleRecordService")
public class HaggleRecordServiceImpl implements IHaggleRecordService {

    @Resource
	private HaggleRecordDao haggleRecordDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HaggleRecord record){
    	return haggleRecordDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return haggleRecordDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HaggleRecord record){
		return haggleRecordDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HaggleRecord selectByPrimaryKey(Integer id){
    	return haggleRecordDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(HaggleRecordExample example){
		return haggleRecordDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HaggleRecord> selectByExample(HaggleRecordExample example){
    	return haggleRecordDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HaggleRecord> selectByExample(int currentPage, int limit,HaggleRecordExample example){
        return haggleRecordDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}