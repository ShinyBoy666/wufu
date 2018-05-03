package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.MutualFundPool;
import cn.xinmeng.api.entity.auto.example.MutualFundPoolExample;
import java.util.List;

/**
 * 接口：IMutualFundPoolService
 * 描述：互助基金池
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:06
 */
public interface IMutualFundPoolService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(MutualFundPool record);
    
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
	public int updateByPrimaryKey(MutualFundPool record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public MutualFundPool selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(MutualFundPoolExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<MutualFundPool> selectByExample(MutualFundPoolExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<MutualFundPool> selectByExample(int currentPage, int limit,MutualFundPoolExample example);
}