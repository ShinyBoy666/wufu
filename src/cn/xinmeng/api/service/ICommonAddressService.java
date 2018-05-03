package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.example.CommonAddressExample;

/**
 * 接口：ICommonAddressService
 * @author jiangyong.tan
 * 描述：客户常用地址表
 * @date 2016-01-24 14:38:49
 */
public interface ICommonAddressService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CommonAddress record);
    
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
	public int updateByPrimaryKey(CommonAddress record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CommonAddress selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CommonAddressExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CommonAddress> selectByExample(CommonAddressExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CommonAddress> selectByExample(int currentPage, int limit,CommonAddressExample example);
    
    /**
     * 更新常用地址
     * @author jiangyong.tan
     * @date 2016年2月18日 下午1:54:15
     * @param commonAddress
     * @return
     */
	public Integer updateCommonAddress(CommonAddress commonAddress);
	
	/**
	 *  修改默认地址
	 * @author jiangyong.tan
	 * @date 2016年2月18日 下午2:07:14
	 * @param id
	 * @param customerId
	 * @return
	 */
	public Integer updateDefault(Integer id, Integer customerId);
	
	/**
	 * 客户下地址置成非默认（除notId地址外）
	 * @param notId
	 * @param customerId
	 * @return
	 */
	public boolean setNotDefaultAddress(Integer notId,Integer customerId);
	
	/**
	 * 查询默认地址（没有默认地址，返回其中一个地址）
	 * @param customerId
	 * @return
	 */
	public CommonAddress queryDefaultAddress(Integer customerId);
}