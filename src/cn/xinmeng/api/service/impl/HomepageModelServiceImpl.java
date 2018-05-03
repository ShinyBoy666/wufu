package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.HomepageModelDao;
import cn.xinmeng.api.entity.auto.HomepageModel;
import cn.xinmeng.api.entity.auto.example.HomepageModelExample;
import cn.xinmeng.api.service.IHomepageModelService;

/**
 * 业务层：HomepageModelServiceImpl
 * 描述：主页配置模板表
 * @author jiangyong.tan
 * @date 2016-03-24 16:38:23
 */
@Service("homepageModelService")
public class HomepageModelServiceImpl implements IHomepageModelService {

    @Resource
	private HomepageModelDao homepageModelDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HomepageModel record){
    	return homepageModelDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return homepageModelDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HomepageModel record){
		return homepageModelDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageModel selectByPrimaryKey(Integer id){
    	return homepageModelDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(HomepageModelExample example){
		return homepageModelDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageModel> selectByExample(HomepageModelExample example){
    	return homepageModelDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HomepageModel> selectByExample(int currentPage, int limit,HomepageModelExample example){
        return homepageModelDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}