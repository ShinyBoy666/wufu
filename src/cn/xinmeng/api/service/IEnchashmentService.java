package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Enchashment;
import cn.xinmeng.api.entity.auto.example.EnchashmentExample;
import cn.xinmeng.api.enums.AccountTypeEnum;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.base.S1081ResponseEntity;

/**
 * 接口：IEnchashmentService
 * @author jiangyong.tan
 * 描述：客户提现记录表
 * @date 2016-01-24 14:38:52
 */
public interface IEnchashmentService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Enchashment record);
    
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
	public int updateByPrimaryKey(Enchashment record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Enchashment selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(EnchashmentExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Enchashment> selectByExample(EnchashmentExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Enchashment> selectByExample(int currentPage, int limit,EnchashmentExample example);
    

    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public PageInfoEntity<S1081ResponseEntity> selectByExample(int currentPage, int limit,Integer customerId,AccountTypeEnum accountTypeEnum);
    
    /**
     * 查询店铺审核中金额
     * @param shopId
     * @return
     */
    public Double queryEnchashment(Integer shopId,AccountTypeEnum accountTypeEnum);
}