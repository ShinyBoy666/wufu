package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.SearchKeywordDao;
import cn.xinmeng.api.entity.auto.SearchKeyword;
import cn.xinmeng.api.entity.auto.example.SearchKeywordExample;
import cn.xinmeng.api.service.ISearchKeywordService;

/**
 * 业务层：SearchKeywordServiceImpl
 * @author jiangyong.tan
 * 描述：搜索关键字表
 * @date 2016-01-24 14:39:09
 */
@Service("searchKeywordService")
public class SearchKeywordServiceImpl implements ISearchKeywordService {

    @Resource
	private SearchKeywordDao searchKeywordDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SearchKeyword record){
    	return searchKeywordDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return searchKeywordDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SearchKeyword record){
		return searchKeywordDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SearchKeyword selectByPrimaryKey(Integer id){
    	return searchKeywordDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(SearchKeywordExample example){
		return searchKeywordDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SearchKeyword> selectByExample(SearchKeywordExample example){
    	return searchKeywordDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<SearchKeyword> selectByExample(int currentPage, int limit,SearchKeywordExample example){
        return searchKeywordDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}