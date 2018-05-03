package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ProductCommentReply;
import cn.xinmeng.api.entity.auto.example.ProductCommentReplyExample;
import java.util.List;

/**
 * 接口：IProductCommentReplyService
 * 描述：评论回复表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:15
 */
public interface IProductCommentReplyService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductCommentReply record);
    
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
	public int updateByPrimaryKey(ProductCommentReply record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductCommentReply selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductCommentReplyExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductCommentReply> selectByExample(ProductCommentReplyExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ProductCommentReply> selectByExample(int currentPage, int limit,ProductCommentReplyExample example);
}