package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.PageClickLog;
import cn.xinmeng.api.entity.auto.example.PageClickLogExample;
import java.util.List;

/**
 * 接口：IPageClickLogService
 * 描述：页面点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:23
 */
public interface IPageClickLogService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(PageClickLog record);
    
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
	public int updateByPrimaryKey(PageClickLog record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public PageClickLog selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(PageClickLogExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<PageClickLog> selectByExample(PageClickLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<PageClickLog> selectByExample(int currentPage, int limit,PageClickLogExample example);
}