package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ProductCommentImage;
import cn.xinmeng.api.entity.auto.example.ProductCommentImageExample;
import java.util.List;

/**
 * 接口：IProductCommentImageService
 * 描述：商品评论图片表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:15
 */
public interface IProductCommentImageService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductCommentImage record);
    
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
	public int updateByPrimaryKey(ProductCommentImage record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductCommentImage selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductCommentImageExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductCommentImage> selectByExample(ProductCommentImageExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ProductCommentImage> selectByExample(int currentPage, int limit,ProductCommentImageExample example);
}