package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ProductDetailInfo;
import cn.xinmeng.api.entity.auto.example.ProductDetailInfoExample;
import java.util.List;

/**
 * 接口：IProductDetailInfoService
 * @author jiangyong.tan
 * 描述：商品详细信息表
 * @date 2016-01-24 14:39:05
 */
public interface IProductDetailInfoService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductDetailInfo record);
    
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
	public int updateByPrimaryKey(ProductDetailInfo record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductDetailInfo selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductDetailInfoExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductDetailInfo> selectByExample(ProductDetailInfoExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductDetailInfo> selectByExample(int currentPage, int limit,ProductDetailInfoExample example);
    
    /**
     * 根据商品id查询详情
     * @param productId
     * @return
     */
    public ProductDetailInfo selectByProductId(Integer productId);
}