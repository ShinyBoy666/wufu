package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IPageClickLogService;
import cn.xinmeng.api.dao.auto.PageClickLogDao;
import cn.xinmeng.api.entity.auto.PageClickLog;
import cn.xinmeng.api.entity.auto.example.PageClickLogExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：PageClickLogServiceImpl
 * 描述：页面点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:23
 */
@Service("pageClickLogService")
public class PageClickLogServiceImpl implements IPageClickLogService {

    @Resource
	private PageClickLogDao pageClickLogDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(PageClickLog record){
    	return pageClickLogDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return pageClickLogDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(PageClickLog record){
		return pageClickLogDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public PageClickLog selectByPrimaryKey(Integer id){
    	return pageClickLogDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(PageClickLogExample example){
		return pageClickLogDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<PageClickLog> selectByExample(PageClickLogExample example){
    	return pageClickLogDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<PageClickLog> selectByExample(int currentPage, int limit,PageClickLogExample example){
        return pageClickLogDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}