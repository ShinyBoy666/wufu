package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerScoreDetail;
import cn.xinmeng.api.entity.auto.example.CustomerScoreDetailExample;
import java.util.List;

/**
 * 接口：ICustomerScoreDetailService
 * 描述：积分帐户流水表
 * @author jiangyong.tan
 * @date 2016-10-19 17:53:52
 */
public interface ICustomerScoreDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerScoreDetail record);
    
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
	public int updateByPrimaryKey(CustomerScoreDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerScoreDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerScoreDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerScoreDetail> selectByExample(CustomerScoreDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerScoreDetail> selectByExample(int currentPage, int limit,CustomerScoreDetailExample example);
}