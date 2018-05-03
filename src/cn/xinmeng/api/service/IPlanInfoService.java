package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.PlanInfo;
import cn.xinmeng.api.entity.auto.example.PlanInfoExample;
import java.util.List;

/**
 * 接口：IPlanInfoService
 * 描述：计划信息列表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:56
 */
public interface IPlanInfoService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(PlanInfo record);
    
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
	public int updateByPrimaryKey(PlanInfo record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public PlanInfo selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(PlanInfoExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<PlanInfo> selectByExample(PlanInfoExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<PlanInfo> selectByExample(int currentPage, int limit,PlanInfoExample example);
}