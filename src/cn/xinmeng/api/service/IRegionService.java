package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.example.RegionExample;
import java.util.List;

/**
 * 接口：IRegionService
 * 描述：行政信息表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:24
 */
public interface IRegionService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Region record);
    
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
	public int updateByPrimaryKey(Region record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Region selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(RegionExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Region> selectByExample(RegionExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<Region> selectByExample(int currentPage, int limit,RegionExample example);
}