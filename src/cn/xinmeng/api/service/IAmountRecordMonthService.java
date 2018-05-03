package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.AmountRecordMonth;
import cn.xinmeng.api.entity.auto.example.AmountRecordMonthExample;
import java.util.List;

/**
 * 接口：IAmountRecordMonthService
 * 描述：客户账户金额记录表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:08
 */
public interface IAmountRecordMonthService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(AmountRecordMonth record);
    
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
	public int updateByPrimaryKey(AmountRecordMonth record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public AmountRecordMonth selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(AmountRecordMonthExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<AmountRecordMonth> selectByExample(AmountRecordMonthExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<AmountRecordMonth> selectByExample(int currentPage, int limit,AmountRecordMonthExample example);
}