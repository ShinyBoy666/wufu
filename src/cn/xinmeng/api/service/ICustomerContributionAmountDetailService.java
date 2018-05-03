package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerContributionAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerContributionAmountDetailExample;
import java.util.List;

/**
 * 接口：ICustomerContributionAmountDetailService
 * 描述：贡献值帐户流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:20:25
 */
public interface ICustomerContributionAmountDetailService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerContributionAmountDetail record);
    
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
	public int updateByPrimaryKey(CustomerContributionAmountDetail record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerContributionAmountDetail selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerContributionAmountDetailExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerContributionAmountDetail> selectByExample(CustomerContributionAmountDetailExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerContributionAmountDetail> selectByExample(int currentPage, int limit,CustomerContributionAmountDetailExample example);
}