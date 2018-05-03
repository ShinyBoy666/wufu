package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IHaggleActivityService;
import cn.xinmeng.api.dao.auto.HaggleActivityDao;
import cn.xinmeng.api.entity.auto.HaggleActivity;
import cn.xinmeng.api.entity.auto.example.HaggleActivityExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：HaggleActivityServiceImpl
 * 描述：砍价活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
@Service("haggleActivityService")
public class HaggleActivityServiceImpl implements IHaggleActivityService {

    @Resource
	private HaggleActivityDao haggleActivityDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HaggleActivity record){
    	return haggleActivityDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return haggleActivityDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HaggleActivity record){
		return haggleActivityDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HaggleActivity selectByPrimaryKey(Integer id){
    	return haggleActivityDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(HaggleActivityExample example){
		return haggleActivityDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HaggleActivity> selectByExample(HaggleActivityExample example){
    	return haggleActivityDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HaggleActivity> selectByExample(int currentPage, int limit,HaggleActivityExample example){
        return haggleActivityDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}