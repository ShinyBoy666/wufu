package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CustomerVipRecord;
import cn.xinmeng.api.entity.auto.example.CustomerVipRecordExample;
import java.util.List;

/**
 * 接口：ICustomerVipRecordService
 * 描述：会员开通记录表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:10
 */
public interface ICustomerVipRecordService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerVipRecord record);
    
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
	public int updateByPrimaryKey(CustomerVipRecord record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerVipRecord selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerVipRecordExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerVipRecord> selectByExample(CustomerVipRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerVipRecord> selectByExample(int currentPage, int limit,CustomerVipRecordExample example);
}