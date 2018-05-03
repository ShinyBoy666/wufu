package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IGuidePageService;
import cn.xinmeng.api.dao.auto.GuidePageDao;
import cn.xinmeng.api.entity.auto.GuidePage;
import cn.xinmeng.api.entity.auto.example.GuidePageExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：GuidePageServiceImpl
 * 描述：用户引导页
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:20
 */
@Service("guidePageService")
public class GuidePageServiceImpl implements IGuidePageService {

    @Resource
	private GuidePageDao guidePageDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GuidePage record){
    	return guidePageDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return guidePageDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GuidePage record){
		return guidePageDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GuidePage selectByPrimaryKey(Integer id){
    	return guidePageDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(GuidePageExample example){
		return guidePageDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GuidePage> selectByExample(GuidePageExample example){
    	return guidePageDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GuidePage> selectByExample(int currentPage, int limit,GuidePageExample example){
        return guidePageDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}