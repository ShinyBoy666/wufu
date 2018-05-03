package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.MutualFundPoolDetail;
import cn.xinmeng.api.entity.auto.example.MutualFundPoolDetailExample;
import java.util.List;

/**
 * 接口：IMutualFundPoolDetailService
 * 描述：互助基金池账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:07
 */
public interface IMutualFundPoolDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(MutualFundPoolDetail record);
    
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
	public int updateByPrimaryKey(MutualFundPoolDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public MutualFundPoolDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(MutualFundPoolDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<MutualFundPoolDetail> selectByExample(MutualFundPoolDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<MutualFundPoolDetail> selectByExample(int currentPage, int limit,MutualFundPoolDetailExample example);
}