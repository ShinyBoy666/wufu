package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ProductQuantityRecord;
import cn.xinmeng.api.entity.auto.example.ProductQuantityRecordExample;
import java.util.List;

/**
 * 接口：IProductQuantityRecordService
 * 描述：商品数量流水记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:18
 */
public interface IProductQuantityRecordService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductQuantityRecord record);
    
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
	public int updateByPrimaryKey(ProductQuantityRecord record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductQuantityRecord selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductQuantityRecordExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductQuantityRecord> selectByExample(ProductQuantityRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ProductQuantityRecord> selectByExample(int currentPage, int limit,ProductQuantityRecordExample example);
}