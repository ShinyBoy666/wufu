package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ProductComment;
import cn.xinmeng.api.entity.auto.example.ProductCommentExample;
import java.util.List;

/**
 * 接口：IProductCommentService
 * 描述：商品评论表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:14
 */
public interface IProductCommentService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductComment record);
    
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
	public int updateByPrimaryKey(ProductComment record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductComment selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductCommentExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductComment> selectByExample(ProductCommentExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ProductComment> selectByExample(int currentPage, int limit,ProductCommentExample example);
}