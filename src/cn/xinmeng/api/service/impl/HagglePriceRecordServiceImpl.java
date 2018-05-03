package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IHagglePriceRecordService;
import cn.xinmeng.api.dao.auto.HagglePriceRecordDao;
import cn.xinmeng.api.entity.auto.HagglePriceRecord;
import cn.xinmeng.api.entity.auto.example.HagglePriceRecordExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：HagglePriceRecordServiceImpl
 * 描述：砍价活动价格记录表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
@Service("hagglePriceRecordService")
public class HagglePriceRecordServiceImpl implements IHagglePriceRecordService {

    @Resource
	private HagglePriceRecordDao hagglePriceRecordDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HagglePriceRecord record){
    	return hagglePriceRecordDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return hagglePriceRecordDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HagglePriceRecord record){
		return hagglePriceRecordDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HagglePriceRecord selectByPrimaryKey(Integer id){
    	return hagglePriceRecordDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(HagglePriceRecordExample example){
		return hagglePriceRecordDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HagglePriceRecord> selectByExample(HagglePriceRecordExample example){
    	return hagglePriceRecordDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HagglePriceRecord> selectByExample(int currentPage, int limit,HagglePriceRecordExample example){
        return hagglePriceRecordDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}