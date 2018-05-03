package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.HaggleActivity;
import cn.xinmeng.api.entity.auto.example.HaggleActivityExample;
import java.util.List;

/**
 * 接口：IHaggleActivityService
 * 描述：砍价活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
public interface IHaggleActivityService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HaggleActivity record);
    
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
	public int updateByPrimaryKey(HaggleActivity record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HaggleActivity selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HaggleActivityExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HaggleActivity> selectByExample(HaggleActivityExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HaggleActivity> selectByExample(int currentPage, int limit,HaggleActivityExample example);
}