package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ProductClickLog;
import cn.xinmeng.api.entity.auto.example.ProductClickLogExample;
import java.util.List;

/**
 * 接口：IProductClickLogService
 * 描述：商品点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:23
 */
public interface IProductClickLogService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductClickLog record);
    
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
	public int updateByPrimaryKey(ProductClickLog record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductClickLog selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductClickLogExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductClickLog> selectByExample(ProductClickLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ProductClickLog> selectByExample(int currentPage, int limit,ProductClickLogExample example);
}