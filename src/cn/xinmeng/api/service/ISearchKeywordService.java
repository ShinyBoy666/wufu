package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.SearchKeyword;
import cn.xinmeng.api.entity.auto.example.SearchKeywordExample;
import java.util.List;

/**
 * 接口：ISearchKeywordService
 * 描述：搜索关键字表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:25
 */
public interface ISearchKeywordService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SearchKeyword record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(SearchKeyword record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SearchKeyword selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SearchKeywordExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SearchKeyword> selectByExample(SearchKeywordExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<SearchKeyword> selectByExample(int currentPage, int limit,SearchKeywordExample example);
}